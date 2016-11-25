import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bargain extends JFrame{
	private double notaFinal;
	
	public Bargain(){
		super("I have come to bargain");
		this.notaFinal=notaFinal;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Dormammu poo = new Dormammu();
		
		this.add(poo);
		this.pack();
		this.setVisible(true);
		

	}
	
	public void timeLoop(){
		this.notaFinal=0;
		while(this.notaFinal<70){
			this.notaFinal=Double.valueOf(JOptionPane.showInputDialog("Inserte calificación final"));
		}
	}
	

	
	class Dormammu extends JPanel{
		private Image fondo;
		
		public Dormammu(){
			super();
			this.setPreferredSize(new Dimension(600,300));
			this.fondo=new ImageIcon("bb8.gif").getImage();
			int pantallaX =(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			int pantallaY =(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			
			this.setLocation((pantallaX-this.getWidth())/2,(pantallaY-this.getHeight())/2);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(this.fondo, 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	
	public static void main(String[] args){
		Bargain Salinas = new Bargain();
		Salinas.timeLoop();
	}
}
