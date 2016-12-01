/*	Ricardo Daniel Palma Mendoza A01226922 %33.33
 * 	David Medina Dow A01631918  %33.33
 *  Alejandro Delgado Medrano A01227074 %33.33 
 *	Clase: Tablero
 *	Fecha 21/11/2016
 */
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Tablero extends JFrame implements WindowListener{

	private Casilla[][][] casillas;
	private int turnosTotales;
	private int exceptionTurnos; //este hace que el contador no siga aumentando si el usuario cae en una excepción 
	//private static int[] prueba;

	private int ejeX, ejeY, ejeZ, totalEjes;
	private StringTokenizer coordenada;

	private SerialPort serialPort;
	private static final String PORT_NAMES="COM6"; // Windows
	private BufferedReader input;
	private OutputStream output;

	private static final int TIME_OUT = 2000;	/** Milliseconds to block while waiting for port open */
	private static final int DATA_RATE = 9600;  /** Default bits per second for COM port. */

	
	private PanelGato pg;

	
	public int getTurnos(){
		return this.turnosTotales;
	}

	public Tablero(){
		super("Gato 3D");

		this.pg=new PanelGato();
		this.add(pg);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int pantallaX=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int pantallaY=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((pantallaX-this.getWidth())/2, (pantallaY-this.getHeight())/2);
		this.setVisible(true);

		this.casillas=new Casilla[3][3][3];
		this.turnosTotales=1;
		this.exceptionTurnos=0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				for(int k=0; k<3; k++){
					this.casillas[i][j][k]=new Casilla(); 
				}
			}
		}
	}

	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}


	public static void main(String[] args){	
		Tablero gato3D = new Tablero();


	}
	@Override
	public void windowActivated(WindowEvent arg0) {

	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		try{
			this.output.close();
			this.input.close();
			this.close();
			System.exit(0);
		}
		catch(IOException ex){
			System.out.println(ex);
		}

	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


}