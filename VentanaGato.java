import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaGato extends JFrame{
	//private Tablero ticTacToe;
	
	public VentanaGato(){
		super("Gato 3D");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.ticTacToe=new Tablero();
		
		PanelGato panel=new PanelGato();
		this.add(panel);
		//this.add(new ControlesPPT(),BorderLayout.WEST);
		this.pack(); 
		
		int posX=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int posY=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((posX-this.getWidth())/2,(posY-this.getHeight())/2);
		
		this.setVisible(true); 
		
	}
	
	public static void main(String[] args){
		VentanaGato juego = new VentanaGato();
	}
}
