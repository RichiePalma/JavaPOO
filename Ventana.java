import java.awt.BorderLayout;
//import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana() {
		super("Mi primer ventana en Java :'("); //Un JFrame es una ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit on close hace que cierre el programa en cuanto le des click al boton de cerrar.}
		MyPanel pd=new MyPanel(); //Mando referencia
		this.add(pd);
		this.add(new PanelControles(pd),BorderLayout.WEST); //Borderlayout para mover de posición en un frame que se divide por puntos cardinales
		this.pack(); //Que se ajuste al tamaño de lo que tiene
 		//this.setSize(800, 600); //Definir el tamaño de la ventana
 		int pantallaX=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
 		int pantallaY=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
 		this.setLocation((pantallaX-this.getWidth())/2,(pantallaY-this.getHeight())/2); //Para que quede en el centro
		this.setVisible(true); //Se recomienda que setVisible sea la ultima linea
		
		
	//Estudiar como se dibuja un rectangulo, un circulo/ovalo y una linea y como poner un boton en la ventana y darle funcionalidad
		//Generar un juego de gato tridimencional
	}
	
	/*public void paint(Graphics g){ //Recibe un Graphics y el metodo es paint solo cuando se dibuja sobre Frame
		super.paint(g);
		g.drawOval(0,0,150,150); //(x, y , largo, ancho) //x es equina superior izquierda
	}*/
	
	public static void main (String[] args){
		Ventana ventana =new Ventana();
	}

}
