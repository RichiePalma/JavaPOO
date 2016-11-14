import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGato extends JPanel{
	//private Tablero ticTacToe;

	public PanelGato(){
		super();
		this.setPreferredSize(new Dimension(800,300));
		//this.ticTacToe=ticTacToe;
		
	}
	
	public void paintComponent(Graphics g){
/*
 * Antes de pintar cada componente se establecio que cada casilla mide 50x50
 * Las lineas tienen de grueso 10px ya sea horizontal o vertical
 * Por conveniencia de aparencia, el "O" y "X" deberan de estar 10 px de diferencia en x & y 
 * Esto con el objetivo dee que no intercepten con las lineas del gato
 * Estos tambien tienen un tamaño de 30x30 pixeles
 */
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		//--Gato 1--
		g.fillRect(50, 100, 170, 10); //--
		g.fillRect(50, 160, 170, 10); //--
		g.fillRect(100, 50, 10, 170); // |
		g.fillRect(160, 50, 10, 170); //   |
		g.drawString("Gato 1", 115, 240);
		
		//--Gato 2--
		g.fillRect(310, 100, 170, 10);
		g.fillRect(310, 160, 170, 10);
		g.fillRect(360, 50, 10, 170);
		g.fillRect(420, 50, 10, 170);
		g.drawString("Gato 2", 375, 240);
		
		//--Gato 3--
		g.fillRect(570, 100, 170, 10);
		g.fillRect(570, 160, 170, 10);
		g.fillRect(620, 50, 10, 170);
		g.fillRect(680, 50, 10, 170);
		g.drawString("Gato 3", 635, 240);
		
		//Circulos
		g.setColor(Color.BLUE);
		g.drawOval(60, 60, 30, 30); //60 posicion + 30 px = 90px (10 menos que los 100px de las rayas)
		g.drawOval(120, 120, 30, 30);
		
		//Equis
			// primera linea (x1,y1,x2,y2) segunda linea (x2,y1,x1,y2)
		g.setColor(Color.RED);
		g.drawLine(60, 60, 90, 90);
		g.drawLine(90,60,60,90);
		
		g.drawLine(60, 120, 90, 150);
		g.drawLine(90,120,60,150);
		
		//g.fillRect(0,20,getWidth(),20);
		
	}
}
