import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class Espiral extends JFrame {

	public Espiral(){
		super("Prueba");
		setContentPane(new DrawPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	}

class DrawPanel extends JPanel{  //De esta manera juntas un JFrame y un JPanel en un solo archivo 
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.drawLine(330,250,210,350); //(xf,yf,xi,yi)
		g.drawLine(350,150,330,250);
		g.drawLine(280,60,350,150);
		g.drawLine(210,40,280,60);
		g.drawLine(120,70,210,40);
		g.drawLine(80,150,120,70);
		g.drawLine(130,230,80,150);
		g.drawLine(200,240,130,230);
		g.drawLine(260,200,200,240);
		g.drawLine(290,150,260,200);
		g.drawLine(250,100,290,150);
		g.drawLine(200,80,250,100);
		g.drawLine(140,110,200,80);
		g.drawLine(130,150,140,110);
		g.drawLine(150,180,130,150);
		g.drawLine(180,185,150,180);
		g.drawLine(200,170,180,185);
		g.drawLine(195,155,200,170);
	}
}

	public static void main(String[] args){
		Espiral esp = new Espiral();
	}

}