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

public class Tablero extends JFrame implements SerialPortEventListener,WindowListener{

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
	private boolean encendido,
					reiniciar;
	
	private PanelGato pg;

	
	public int getTurnos(){
		return this.turnosTotales;
	}

	public Tablero(){
		super("Gato 3D");
		this.initialize();
		this.encendido=false;
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
	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			if (currPortId.getName().equals(PORT_NAMES)) {
				portId = currPortId;
				break;
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),TIME_OUT);
			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}


//	public boolean pedirCoordenada(){
//		do{
//			int numTurno=1;
//			String jugada=null;
//
//			try{
//				do{
//					try{
//						if(numTurno == 2){
//							numTurno=1;
//							//jugada = JOptionPane.showInputDialog("Turno: "+turnosTotales+" | Jugador 2(X): Inserte las coordenadas donde deseas lanzar la jugada");
//						}
//						else{
//							//jugada = JOptionPane.showInputDialog("Turno: "+turnosTotales+" | Jugador 1(O): Inserte las coordenadas donde deseas lanzar la jugada");
//							numTurno=2;
//						}
//						this.coordenada = new StringTokenizer(jugada);
//						this.ejeX = Integer.valueOf(this.coordenada.nextToken()) - 1; // -1 porque para el jugador las coordenadas que inserte el jugador son 1,2 o 3
//						this.ejeY = Integer.valueOf(this.coordenada.nextToken()) - 1;   // pero en el arrego solo hay posiciones 0,1 y 2
//						this.ejeZ = Integer.valueOf(this.coordenada.nextToken()) - 1;
//						this.totalEjes = ejeX+ejeY+ejeZ; //Para evitar que salga fuera del rango de ejes y así evitar hacer un largo if, el maximo es 6 ya que 2+2+2
//
//						if(this.casillas[ejeX][ejeY][ejeZ].getDisponible()==true){
//							if(numTurno ==2){
//								this.casillas[ejeX][ejeY][ejeZ].setValor(Casilla.X);
//								
//
//								this.casillas[ejeX][ejeY][ejeZ].setDisponible(false);
//							}
//							else{
//								this.casillas[ejeX][ejeY][ejeZ].setValor(Casilla.O);
//								this.casillas[ejeX][ejeY][ejeZ].setDisponible(false);
//							}
//							
//						}
//						else{
//							if(numTurno ==2){
//								numTurno=1;
//							}
//							else{
//								numTurno=2;
//							}
//							JOptionPane.showMessageDialog(null, "La casilla esta ocupada, inserte otra porfavor");
//							this.turnosTotales=this.exceptionTurnos;
//						}
//
//					}
//					catch(NoSuchElementException e){
//						if(numTurno ==2){
//							numTurno=1;
//						}
//						else{
//							numTurno=2;
//						}
//						this.turnosTotales=this.exceptionTurnos;
//						JOptionPane.showMessageDialog(null,"Por favor inserte 3 coordenadas separadas por un espacio. Ej: x y z ");
//					}catch(NumberFormatException ex){
//						if(numTurno ==2){
//							numTurno=1;
//						}
//						else{
//							numTurno=2;
//						}
//						this.turnosTotales=this.exceptionTurnos;
//						JOptionPane.showMessageDialog(null,"Por favor inserte 3 numeros y no letras ");
//					}catch(ArrayIndexOutOfBoundsException ez){
//						if(numTurno ==2){
//							numTurno=1;
//						}
//						else{
//							numTurno=2;
//						}
//						this.turnosTotales=this.exceptionTurnos;
//						JOptionPane.showMessageDialog(null, "Inserte un numero del 1 al 3");
//					}
//					imprimeTablero();
//					if(empate()==true){ //al llamar el metodo dentro del if se ejecuta cuando se cumpla la condicion
//						int newGame= JOptionPane.showConfirmDialog(null, "¿Jugar otra vez?");
//						if(newGame==JOptionPane.YES_OPTION){	//Se reinicia el juego y sus variables
//							this.reiniciar=true;
//							this.totalEjes=0;
//							this.casillas=new Casilla[3][3][3];	//Se crea un nuevo tablero para volver a jugar
//							this.turnosTotales=1;
//							this.exceptionTurnos=0;
//							for(int i=0; i<3; i++){		//Se crea cada parte del tablero
//								for(int j=0; j<3; j++){
//									for(int k=0; k<3; k++){
//										this.casillas[i][j][k]=new Casilla(); 
//									}
//								}
//							}
//						}
//						else{
//							this.setVisible(false);
//							this.dispose();
//							this.reiniciar=false;
//						}
//						break;
//					}
//					else if(gano()==true){
//						int newGame= JOptionPane.showConfirmDialog(null, "¿Jugar otra vez?");
//						if(newGame==JOptionPane.YES_OPTION){	//Se reinicia el juego y sus variables
//							this.reiniciar=true;
//							this.totalEjes=0;
//							this.casillas=new Casilla[3][3][3];	//Se crea un nuevo tablero para volver a jugar
//							this.turnosTotales=1;
//							this.exceptionTurnos=0;
//							for(int i=0; i<3; i++){		//Se crea cada parte del tablero
//								for(int j=0; j<3; j++){
//									for(int k=0; k<3; k++){
//										this.casillas[i][j][k]=new Casilla(); 
//										
//									}
//								}
//							}
//						}
//						else{
//							this.setVisible(false);
//							this.dispose();
//							this.reiniciar=false;
//						}
//						break;
//					}
//
//					this.exceptionTurnos=this.turnosTotales;
//					this.turnosTotales++;
//
//				}while((this.totalEjes>=0 || this.totalEjes < 7));
//
//			}catch(NullPointerException e){
//				if(numTurno ==2){ //el else hace unTurno==2 por eso si cancela tecnicamente esta perdiendo jugador 1
//					JOptionPane.showMessageDialog(null,"El jugador 1 se ha rendido ¡Gana el jugador 2!");
////					this.setVisible(false);
////					this.dispose();
//					return false;
//				}
//				else{
//					JOptionPane.showMessageDialog(null, "El jugador 2 se ha rendido ¡Gana el jugador 1!");
////					this.setVisible(false);
////					this.dispose();
//					return false;
//				}
//			}
//		}while(this.reiniciar);
//		return false;
//	}

//	public boolean gano(){
//		for(int i=0; i<3;i++){ 
//			for(int j=0;j<3;j++){
//				//checa verticalmente
//				if(this.casillas[i][0][j].getDisponible()== false && this.casillas[i][1][j].getDisponible()==false && this.casillas[i][2][j].getDisponible()==false){
//					if(this.casillas[i][0][j].getValor() == this.casillas[i][1][j].getValor() && this.casillas[i][0][j].getValor()== this.casillas[i][2][j].getValor()){
//						if(this.casillas[i][0][j].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//
//					}
//				}
//				//Checa horizontalmente
//				else if(this.casillas[0][i][j].getDisponible()== false && this.casillas[1][i][j].getDisponible()==false&& this.casillas[2][i][j].getDisponible()==false){
//					if(this.casillas[0][i][j].getValor()== this.casillas[1][i][j].getValor()&& this.casillas[0][i][j].getValor()== this.casillas[2][i][j].getValor()){
//						if(this.casillas[0][i][j].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//
//					}
//				}
//				//Checa en tercera dimencion
//
//				else if(this.casillas[i][j][0].getDisponible()==false && this.casillas[i][j][1].getDisponible()==false&& this.casillas[i][j][2].getDisponible()==false){
//					if(this.casillas[i][j][0].getValor()== this.casillas[i][j][1].getValor()&& this.casillas[i][j][0].getValor()== this.casillas[i][j][2].getValor()){
//						if(this.casillas[i][j][0].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//				//Checa diagonal izquierda superior a derecha inferior
//				else if(this.casillas[0][0][i].getDisponible()==false&& this.casillas[1][1][i].getDisponible()==false && this.casillas[2][2][i].getDisponible()==false){
//					if(this.casillas[0][0][i].getValor()== this.casillas[1][1][i].getValor()&& this.casillas[0][0][i].getValor()== this.casillas[2][2][i].getValor()){
//						if(this.casillas[0][0][i].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//				//Checa diagonal derecha superior a izquierda inferior
//				else if(this.casillas[2][0][i].getDisponible() ==false&& this.casillas[1][1][i].getDisponible()==false && this.casillas[0][2][i].getDisponible()==false){
//					if(this.casillas[2][0][i].getValor() == this.casillas[1][1][i].getValor()&& this.casillas[2][0][i].getValor() == this.casillas[0][2][i].getValor()){
//						if(this.casillas[2][0][i].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//				//Checa horizontal de forma tridimensional
//				else if (this.casillas[0][i][0].getDisponible()==false&& this.casillas[1][i][1].getDisponible()==false && this.casillas[2][i][2].getDisponible()==false){
//					if (this.casillas[0][i][0].getValor()== this.casillas[1][i][1].getValor()&& this.casillas[0][i][0].getValor()== this.casillas[2][i][2].getValor()){
//						if(this.casillas[0][i][0].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//				//Checa vertical de forma tridimensional
//				else if(this.casillas[i][0][0].getDisponible()==false && this.casillas[i][1][1].getDisponible()==false && this.casillas[i][2][2].getDisponible()==false){
//					if(this.casillas[i][0][0].getValor()== this.casillas[i][1][1].getValor() && this.casillas[i][0][0].getValor()== this.casillas[i][2][2].getValor()){
//						if(this.casillas[i][0][0].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//				//Checa diagonal derecha superior a izquierda inferior de forma tridimencional
//				else if(this.casillas[2][0][0].getDisponible()==false&& this.casillas[1][1][1].getDisponible()==false && this.casillas[0][2][2].getDisponible()==false){
//					if(this.casillas[2][0][0].getValor()== this.casillas[1][1][1].getValor() && this.casillas[2][0][0].getValor()== this.casillas[0][2][2].getValor()){
//						if(this.casillas[2][0][0].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//				//Checa diagonal izquierda superior a derecha inferior de forma tridimencional
//				else if(this.casillas[0][0][0].getDisponible()==false && this.casillas[1][1][1].getDisponible()==false&& this.casillas[2][2][2].getDisponible()==false){
//					if(this.casillas[0][0][0].getValor()== this.casillas[1][1][1].getValor()&& this.casillas[1][1][1].getValor()== this.casillas[2][2][2].getValor()){
//						if(this.casillas[0][0][0].getValor()==true){
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 2(X)!");
//						}else{
//							JOptionPane.showMessageDialog(null, "¡Gana el Jugador 1(O)!");
//						}
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	public boolean empate(){
//		if(this.turnosTotales >= 27){
//			JOptionPane.showMessageDialog(null, "¡Han empatado!");
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
	
	public void imprimeTablero(){
		System.out.println("------------------------------ Turno: "+this.turnosTotales+"------------------------------");
		for(int i = 0; i<3; i++){ //[x][y][z]
			System.out.println(this.casillas[0][0][i]+" |"+this.casillas[1][0][i]+"|"+this.casillas[2][0][i] + "\n -----"); 
			//Imprime los ejes x en y=0 del i gato donde en este caso seran i = 3 gatos
			System.out.println(this.casillas[0][1][i]+" |"+this.casillas[1][1][i]+"|"+this.casillas[2][1][i] + "\n -----"); 
			//Ejes x en y=1 del i gato
			System.out.println(this.casillas[0][2][i]+" |"+this.casillas[1][2][i]+"|"+this.casillas[2][2][i]); 
			//ejes x en y=2 del i gato
			System.out.println(" "+"\n"+" ");
		}

	}

	public static void main(String[] args){	
		Tablero gato3D = new Tablero();
//		gato3D.pedirCoordenada();

	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

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
	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=input.readLine();
				//System.out.println("Lei de Arduino: "+inputLine);
				if(inputLine.equals("1"))
					this.encendido=true;
				else
				{
					this.encendido=false;
				}
				repaint();
			} catch (IOException e) {
				//System.err.println("error en serialEvent: "+e);
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.

	}
}