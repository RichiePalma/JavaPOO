import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension; 

public class MyPanel extends JPanel implements Runnable, MouseListener, MouseMotionListener{
	private int x,
	y;

	private boolean mover;
	private Image fondo;
	private String nombre; 
	private int xRect,
				yRect; 
	
	public MyPanel(){
		super();
		//this.pack(); //Tamaño del panel
		this.setPreferredSize(new Dimension(800,600));
		this.x=0;
		this.y=50; //50 para que no lo tape la base 
		this.xRect=this.yRect=50;
		this.nombre="Pocoyo";
		this.mover=false;
		this.fondo=new ImageIcon("universo-800x600.jpg").getImage();
		Thread hilo=new Thread(this); //¿Cual es el metodo run que va a ejecutar?
		hilo.start();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g){ //paint component para dibujar sobre el panel
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0,this.getWidth(),this.getHeight(), this); //Observer es el this
		this.pintaNave(g);
		this.pintaNombreYOTrasCosas(g);
	}
	//Lo dividió en metodos diferentes pintaNave y Nombreyotrascsas para que painComponen no quede gigante
	
	public void pintaNave(Graphics g){ 
		g.setColor(Color.ORANGE); //Todo lo que dibujemos de ahora en adelante se dibuja de este color
		g.fillOval(100+this.x, 500-this.y, 200, 100);
		g.setColor(Color.CYAN);
		g.fillArc(100+this.x,500-this.y,200,100,0,100); //Un angulo en este caso dentro del ovalo

		g.setColor(Color.BLACK);
		g.drawLine(150+this.x, 506-this.y, 150+this.x, 400-this.y);
		g.setColor(Color.RED);
		g.fillOval(100+this.x, 300-this.y, 100, 100);
	}

	public void pintaNombreYOTrasCosas(Graphics g){
		g.setColor(Color.BLACK);
		g.drawString("¡Vamos "+this.nombre+"!", 160+this.x, 550-this.y); //(String que quieres dibujar, punto inferior izquierdo al string a dibujar)
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 550, 800, 50);
		g.setColor(Color.GREEN);
		//g.fillRect(50, 50, 200, 60); de esta manera 50,50 serian absolutos y no se moveria
		g.fillRect(this.xRect,this.yRect, 200, 60);
	}
	public void run(){ //Va a mover la nave
		while(this.x<500){ //Que se detenga en el margen
			try{
				if(this.mover){
					this.x+=2; //Incremente 2 en lugar de 1 como y
					this.y++;
					this.repaint();
				}
				Thread.sleep(30); //Delay 50 milisegundos
				//Si pones Thread.sleep dentro del IF va a sobrecalentar la compu y no se va a ejecutar el .sleep entre ciclos
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
	
	public void setY(int y){
		this.y=y;
		this.repaint();
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { //click
		this.mover=true;

	}

	@Override
	public void mouseEntered(MouseEvent arg0) { 


	}

	@Override
	public void mouseExited(MouseEvent arg0) { //Mouse sale del panel


	}

	@Override
	public void mousePressed(MouseEvent arg0) { //Mientras este precionado


	}

	@Override
	public void mouseReleased(MouseEvent arg0) { 


	}

	@Override
	public void mouseDragged(MouseEvent e) { //Moviendo mouse por panel pero apretando el botón
		this.xRect=e.getX();
		this.yRect=e.getY();
		this.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) { //Mientras estes moviendo mouse por panel
		//System.out.println("Mouse moviendose en " +e.getX()+","+e.getY());
	}
}
