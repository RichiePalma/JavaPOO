import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class PanelGato extends JPanel implements SerialPortEventListener, ActionListener{

	JToggleButton casilla1,casilla2, casilla3,casilla4,casilla5,casilla6,casilla7,casilla8,casilla9,
	casilla10,casilla11,casilla12,casilla13,casilla14,casilla15,casilla16,casilla17,casilla18,
	casilla19,casilla20,casilla21,casilla22,casilla23,casilla24,casilla25,casilla26,casilla27;

	private Casilla[][][] casillas;
	public static Tablero tab;
	private int turnosTotales;
	private int exceptionTurnos; //este hace que el contador no siga aumentando si el usuario cae en una excepci鏮 
	//private static int[] prueba;

	private int ejeX, ejeY, ejeZ, totalEjes;
	private StringTokenizer coordenada;

	private SerialPort serialPort;
	private static final String PORT_NAMES="COM6"; // Windows
	private BufferedReader input;
	private OutputStream output;

	private static final int TIME_OUT = 2000;	/** Milliseconds to block while waiting for port open */
	private static final int DATA_RATE = 9600; /** Default bits per second for COM port. */

	private static final int GameMac = 0;  
	private boolean encendido,
	reiniciar;

	private String[] val;

	private static PanelGato pg;

	private int ac1, ac2, ac3, ac4, ac5, ac6, ac7, ac8, ac9, ac10, ac11, ac12, ac13, ac14, ac15,
	ac16, ac17, ac18, ac19, ac20, ac21, ac22, ac23, ac24, ac25, ac26, ac27,turno,dis1,dis2,dis3,dis4,dis5,dis6,dis7,
	dis8,dis9,dis10,dis11,dis12,dis13,dis14,dis15,dis16,dis17,dis18,dis19,dis20,dis21,dis22,dis23,dis24,dis25,dis26,dis27;

	private int wes=0;
	private int ans=6;

	public PanelGato(){
		super();
		this.initialize();
		this.setPreferredSize(new Dimension(800,300));
		this.setBackground(Color.WHITE);
		
		try {
			output.write(1);
			System.out.println("Se envio 0");
		} catch (IOException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
		this.ac1=this.ac2=this.ac3=this.ac4=this.ac5=this.ac6=this.ac7=this.ac8=this.ac9=0;
		this.ac10=this.ac11=this.ac12=this.ac13=this.ac14=this.ac15=this.ac16=this.ac17=this.ac18=0;
		this.ac19=this.ac20=this.ac21=this.ac22=this.ac23=this.ac24=this.ac25=this.ac26=this.ac27=0;

		this.dis1=this.dis2=this.dis3=this.dis4=this.dis5=this.dis6=this.dis7=this.dis8=this.dis9=this.dis10=1;
		this.dis11=this.dis12=this.dis13=this.dis14=this.dis15=this.dis16=this.dis17=this.dis18=this.dis19=1;
		this.dis20=this.dis21=this.dis22=this.dis23=this.dis24=this.dis25=this.dis26=this.dis27=1;

		this.turno=1;

		this.val = new String[27];

		//Primer Tablero
		this.casilla1=new JToggleButton("");
		this.casilla2=new JToggleButton("");
		this.casilla3=new JToggleButton("");
		this.casilla4=new JToggleButton("");
		this.casilla5=new JToggleButton("");
		this.casilla6=new JToggleButton("");
		this.casilla7=new JToggleButton("");
		this.casilla8=new JToggleButton("");
		this.casilla9=new JToggleButton("");
		//Segundo Tablero
		this.casilla10=new JToggleButton("");
		this.casilla11=new JToggleButton("");
		this.casilla12=new JToggleButton("");
		this.casilla13=new JToggleButton("");
		this.casilla14=new JToggleButton("");
		this.casilla15=new JToggleButton("");
		this.casilla16=new JToggleButton("");
		this.casilla17=new JToggleButton("");
		this.casilla18=new JToggleButton("");
		//Tercer Tablero
		this.casilla19=new JToggleButton("");
		this.casilla20=new JToggleButton("");
		this.casilla21=new JToggleButton("");
		this.casilla22=new JToggleButton("");
		this.casilla23=new JToggleButton("");
		this.casilla24=new JToggleButton("");
		this.casilla25=new JToggleButton("");
		this.casilla26=new JToggleButton("");
		this.casilla27=new JToggleButton("");

		this.casilla1.addActionListener(this);
		this.casilla2.addActionListener(this);
		this.casilla3.addActionListener(this);
		this.casilla4.addActionListener(this);
		this.casilla5.addActionListener(this);
		this.casilla6.addActionListener(this);
		this.casilla7.addActionListener(this);
		this.casilla8.addActionListener(this);
		this.casilla9.addActionListener(this);
		this.casilla10.addActionListener(this);
		this.casilla11.addActionListener(this);
		this.casilla12.addActionListener(this);
		this.casilla13.addActionListener(this);
		this.casilla14.addActionListener(this);
		this.casilla15.addActionListener(this);
		this.casilla16.addActionListener(this);
		this.casilla17.addActionListener(this);
		this.casilla18.addActionListener(this);
		this.casilla19.addActionListener(this);
		this.casilla20.addActionListener(this);
		this.casilla21.addActionListener(this);
		this.casilla22.addActionListener(this);
		this.casilla23.addActionListener(this);
		this.casilla24.addActionListener(this);
		this.casilla25.addActionListener(this);
		this.casilla26.addActionListener(this);
		this.casilla27.addActionListener(this);

		this.setLayout(null);
		//Primer Tablero
		this.casilla1.setBounds(50, 50, 50, 50);
		this.casilla2.setBounds(110, 50, 50, 50);
		this.casilla3.setBounds(170, 50, 50, 50);
		this.casilla4.setBounds(50,110,50,50);
		this.casilla5.setBounds(110,110,50,50);
		this.casilla6.setBounds(170,110,50,50);
		this.casilla7.setBounds(50,170,50,50);
		this.casilla8.setBounds(110,170,50,50);
		this.casilla9.setBounds(170,170,50,50);
		//Segundo Tablero
		this.casilla10.setBounds(310,50,50,50);
		this.casilla11.setBounds(370,50,50,50);
		this.casilla12.setBounds(430,50,50,50);
		this.casilla13.setBounds(310,110,50,50);
		this.casilla14.setBounds(370,110,50,50);
		this.casilla15.setBounds(430,110,50,50);
		this.casilla16.setBounds(310,170,50,50);
		this.casilla17.setBounds(370,170,50,50);
		this.casilla18.setBounds(430,170,50,50);
		//Tercer Tablero
		this.casilla19.setBounds(570,50,50,50);
		this.casilla20.setBounds(630,50,50,50);
		this.casilla21.setBounds(690,50,50,50);
		this.casilla22.setBounds(570,110,50,50);
		this.casilla23.setBounds(630,110,50,50);
		this.casilla24.setBounds(690,110,50,50);
		this.casilla25.setBounds(570,170,50,50);
		this.casilla26.setBounds(630,170,50,50);
		this.casilla27.setBounds(690,170,50,50);
		//Adders
		this.add(this.casilla1);
		this.add(this.casilla2);
		this.add(this.casilla3);
		this.add(this.casilla4);
		this.add(this.casilla5);
		this.add(this.casilla6);
		this.add(this.casilla7);
		this.add(this.casilla8);
		this.add(this.casilla9);
		this.add(this.casilla10);
		this.add(this.casilla11);
		this.add(this.casilla12);
		this.add(this.casilla13);
		this.add(this.casilla14);
		this.add(this.casilla15);
		this.add(this.casilla16);
		this.add(this.casilla17);
		this.add(this.casilla18);
		this.add(this.casilla19);
		this.add(this.casilla20);
		this.add(this.casilla21);
		this.add(this.casilla22);
		this.add(this.casilla23);
		this.add(this.casilla24);
		this.add(this.casilla25);
		this.add(this.casilla26);
		this.add(this.casilla27);

		if(wes==0){
			int x=0;
			while(x==0){
				ans = Integer.parseInt(JOptionPane.showInputDialog("Quieres jugar contra maquina (1 = si, 2= no)"));
				if((ans!=1)&&(ans!=2)){
					int GameMac= JOptionPane.showConfirmDialog(null, "Escoje 1 o 2");
				}
				x+=1;
			}
		}

	}

	public void paintComponent(Graphics g){
		/*
		 * Antes de pintar cada componente se establecio que cada casilla mide 50x50
		 * Las lineas tienen de grueso 10px ya sea horizontal o vertical
		 * Por conveniencia de aparencia, el "O" y "X" deberan de estar 10 px de diferencia en x & y 
		 * Esto con el objetivo dee que no intercepten con las lineas del gato
		 * Estos tambien tienen una dimension de 30x30 pixeles
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
			//serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		boolean firstWin=false;
		boolean secondWin=false;
		int gameOver = 0;

		if(this.turno==1){
			try {
				output.write(0);
				System.out.println("Se envio 1");
			} catch (IOException e1) {
				System.out.println(e1);
				e1.printStackTrace();
			}
		}
		else{
			try {
				output.write(1);
				System.out.println("Se envio 0");
			} catch (IOException e1) {
				System.out.println(e1);
				e1.printStackTrace();
			}
			
		}
		if((e.getSource() == this.casilla1)&&(this.turno==1)&&(this.dis1==1)){
			this.casilla1.setText("X");
			this.val[0]="X";
			if(this.val[0]=="X"&&this.val[1]=="X"&&this.val[2]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[3]=="X"&&this.val[6]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[4]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[9]=="X"&&this.val[18]=="X"){
				firstWin=true;
			}
			this.dis1=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla1)&&(this.turno==0)&&(this.dis1==1)){
			this.casilla1.setText("O");
			this.val[0]="O";
			if(this.val[0]=="O"&&this.val[1]=="O"&&this.val[2]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[3]=="O"&&this.val[6]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[4]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[9]=="O"&&this.val[18]=="O"){
				secondWin = true;
			}
			this.dis1=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla2)&&(this.turno==1)&&(this.dis2==1)){
			this.casilla2.setText("X");
			this.val[1]="X";
			if(this.val[0]=="X"&&this.val[1]=="X"&&this.val[2]=="X"){
				firstWin=true;
			}
			else if(this.val[1]=="X"&&this.val[4]=="X"&&this.val[7]=="X"){
				firstWin=true;
			}
			else if(this.val[1]=="X"&&this.val[10]=="X"&&this.val[19]=="X"){
				firstWin=true;
			}
			this.dis2=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla2)&&(this.turno==0)&&(this.dis2==1)){
			this.casilla2.setText("O");
			this.val[1]="O";
			if(this.val[0]=="O"&&this.val[1]=="O"&&this.val[2]=="O"){
				secondWin = true;
			}
			else if(this.val[1]=="O"&&this.val[4]=="O"&&this.val[7]=="O"){
				secondWin = true;
			}
			else if(this.val[1]=="O"&&this.val[10]=="O"&&this.val[19]=="O"){
				secondWin = true;
			}
			this.dis2=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla3)&&(this.turno==1)&&(this.dis3==1)){
			this.casilla3.setText("X");
			this.val[2]="X";
			if(this.val[0]=="X"&&this.val[1]=="X"&&this.val[2]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[5]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[4]=="X"&&this.val[6]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[11]=="X"&&this.val[20]=="X"){
				firstWin=true;
			}
			this.dis3=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla3)&&(this.turno==0)&&(this.dis3==1)){
			this.casilla3.setText("O");
			this.val[2]="O";
			if(this.val[0]=="O"&&this.val[1]=="O"&&this.val[2]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[5]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[4]=="O"&&this.val[6]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[11]=="O"&&this.val[20]=="O"){
				secondWin = true;
			}
			this.dis3=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla4)&&(this.turno==1)&&(this.dis4==1)){
			this.casilla4.setText("X");
			this.val[3]="X";
			if(this.val[3]=="X"&&this.val[4]=="X"&&this.val[5]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[3]=="X"&&this.val[6]=="X"){
				firstWin=true;
			}
			else if(this.val[3]=="X"&&this.val[12]=="X"&&this.val[21]=="X"){
				firstWin=true;
			}
			this.dis4=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla4)&&(this.turno==0)&&(this.dis4==1)){
			this.casilla4.setText("O");
			this.val[3]="O";
			if(this.val[3]=="O"&&this.val[4]=="O"&&this.val[5]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[3]=="O"&&this.val[6]=="O"){
				secondWin = true;
			}
			else if(this.val[3]=="O"&&this.val[12]=="O"&&this.val[21]=="O"){
				secondWin = true;
			}
			this.dis4=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla5)&&(this.turno==1)&&(this.dis5==1)){
			this.casilla5.setText("X");
			this.val[4]="X";
			if(this.val[3]=="X"&&this.val[4]=="X"&&this.val[5]=="X"){
				firstWin=true;
			}
			else if(this.val[1]=="X"&&this.val[4]=="X"&&this.val[7]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[4]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[4]=="X"&&this.val[6]=="X"){
				firstWin=true;
			}
			else if(this.val[4]=="X"&&this.val[13]=="X"&&this.val[22]=="X"){
				firstWin=true;
			}
			this.dis5=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla5)&&(this.turno==0)&&(this.dis5==1)){
			this.casilla5.setText("O");
			this.val[4]="O";
			if(this.val[3]=="O"&&this.val[4]=="O"&&this.val[5]=="O"){
				secondWin = true;
			}
			else if(this.val[1]=="O"&&this.val[4]=="O"&&this.val[7]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[4]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[4]=="O"&&this.val[6]=="O"){
				secondWin = true;
			}
			else if(this.val[4]=="O"&&this.val[13]=="O"&&this.val[22]=="O"){
				secondWin = true;
			}
			this.dis5=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla6)&&(this.turno==1)&&(this.dis6==1)){
			this.casilla6.setText("X");
			this.val[5]="X";
			if(this.val[3]=="X"&&this.val[4]=="X"&&this.val[5]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[5]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[5]=="X"&&this.val[14]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			this.dis6=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla6)&&(this.turno==0)&&(this.dis6==1)){
			this.casilla6.setText("O");
			this.val[5]="O";
			if(this.val[3]=="O"&&this.val[4]=="O"&&this.val[5]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[5]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[5]=="O"&&this.val[14]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			this.dis6=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla7)&&(this.turno==1)&&(this.dis7==1)){
			this.casilla7.setText("X");
			this.val[6]="X";
			if(this.val[6]=="X"&&this.val[7]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[3]=="X"&&this.val[6]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[4]=="X"&&this.val[6]=="X"){
				firstWin=true;
			}
			else if(this.val[6]=="X"&&this.val[15]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			this.dis7=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla7)&&(this.turno==0)&&(this.dis7==1)){
			this.casilla7.setText("O");
			this.val[6]="O";
			if(this.val[6]=="O"&&this.val[7]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[3]=="O"&&this.val[6]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[4]=="O"&&this.val[6]=="O"){
				secondWin = true;
			}
			else if(this.val[6]=="O"&&this.val[15]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			this.dis7=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla8)&&(this.turno==1)&&(this.dis8==1)){
			this.casilla8.setText("X");
			this.val[7]="X";
			if(this.val[6]=="X"&&this.val[7]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[1]=="X"&&this.val[4]=="X"&&this.val[7]=="X"){
				firstWin=true;
			}
			else if(this.val[7]=="X"&&this.val[16]=="X"&&this.val[25]=="X"){
				firstWin=true;
			}
			this.dis8=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla8)&&(this.turno==0)&&(this.dis8==1)){
			this.casilla8.setText("O");
			this.val[7]="O";
			if(this.val[6]=="O"&&this.val[7]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[1]=="O"&&this.val[4]=="O"&&this.val[7]=="O"){
				secondWin = true;
			}
			else if(this.val[7]=="O"&&this.val[16]=="O"&&this.val[25]=="O"){
				secondWin = true;
			}
			this.dis8=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla9)&&(this.turno==1)&&(this.dis9==1)){
			this.casilla9.setText("X");
			this.val[8]="X";
			if(this.val[6]=="X"&&this.val[7]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[5]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[4]=="X"&&this.val[8]=="X"){
				firstWin=true;
			}
			else if(this.val[8]=="X"&&this.val[17]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			this.dis9=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla9)&&(this.turno==0)&&(this.dis9==1)){
			this.casilla9.setText("O");
			this.val[8]="O";
			if(this.val[6]=="O"&&this.val[7]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[5]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[4]=="O"&&this.val[8]=="O"){
				secondWin = true;
			}
			else if(this.val[8]=="O"&&this.val[17]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			this.dis9=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla10)&&(this.turno==1)&&(this.dis10==1)){
			this.casilla10.setText("X");
			this.val[9]="X";
			if(this.val[9]=="X"&&this.val[10]=="X"&&this.val[11]=="X"){
				firstWin=true;
			}
			else if(this.val[9]=="X"&&this.val[12]=="X"&&this.val[15]=="X"){
				firstWin=true;
			}
			else if(this.val[9]=="X"&&this.val[13]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[9]=="X"&&this.val[18]=="X"){
				firstWin=true;
			}
			this.dis10=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla10)&&(this.turno==0)&&(this.dis10==1)){
			this.casilla10.setText("O");
			this.val[9]="O";
			if(this.val[9]=="O"&&this.val[10]=="O"&&this.val[11]=="O"){
				secondWin = true;
			}
			else if(this.val[9]=="O"&&this.val[12]=="O"&&this.val[15]=="O"){
				secondWin = true;
			}
			else if(this.val[9]=="O"&&this.val[13]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[9]=="O"&&this.val[18]=="O"){
				secondWin = true;
			}
			this.dis10=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla11)&&(this.turno==1)&&(this.dis11==1)){
			this.casilla11.setText("X");
			this.val[10]="X";
			if(this.val[9]=="X"&&this.val[10]=="X"&&this.val[11]=="X"){
				firstWin=true;
			}
			else if(this.val[10]=="X"&&this.val[13]=="X"&&this.val[16]=="X"){
				firstWin=true;
			}
			else if(this.val[1]=="X"&&this.val[10]=="X"&&this.val[19]=="X"){
				firstWin=true;
			}
			this.dis11=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla11)&&(this.turno==0)&&(this.dis11==1)){
			this.casilla11.setText("O");
			this.val[10]="O";
			if(this.val[9]=="O"&&this.val[10]=="O"&&this.val[11]=="O"){
				secondWin = true;
			}
			else if(this.val[10]=="O"&&this.val[13]=="O"&&this.val[16]=="O"){
				secondWin = true;
			}
			else if(this.val[1]=="O"&&this.val[10]=="O"&&this.val[19]=="O"){
				secondWin = true;
			}
			this.dis11=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla12)&&(this.turno==1)&&(this.dis12==1)){
			this.casilla12.setText("X");
			this.val[11]="X";
			if(this.val[9]=="X"&&this.val[10]=="X"&&this.val[11]=="X"){
				firstWin=true;
			}
			else if(this.val[11]=="X"&&this.val[14]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[11]=="X"&&this.val[13]=="X"&&this.val[15]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[11]=="X"&&this.val[20]=="X"){
				firstWin=true;
			}
			this.dis12=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla12)&&(this.turno==0)&&(this.dis12==1)){
			this.casilla12.setText("O");
			this.val[11]="O";
			if(this.val[9]=="O"&&this.val[10]=="O"&&this.val[11]=="O"){
				secondWin = true;
			}
			else if(this.val[11]=="O"&&this.val[14]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[11]=="O"&&this.val[13]=="O"&&this.val[15]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[11]=="O"&&this.val[20]=="O"){
				secondWin = true;
			}
			this.dis12=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla13)&&(this.turno==1)&&(this.dis13==1)){
			this.casilla13.setText("X");
			this.val[12]="X";
			if(this.val[12]=="X"&&this.val[13]=="X"&&this.val[14]=="X"){
				firstWin=true;
			}
			else if(this.val[9]=="X"&&this.val[12]=="X"&&this.val[15]=="X"){
				firstWin=true;
			}
			else if(this.val[3]=="X"&&this.val[12]=="X"&&this.val[21]=="X"){
				firstWin=true;
			}
			this.dis13=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla13)&&(this.turno==0)&&(this.dis13==1)){
			this.casilla13.setText("O");
			this.val[12]="O";
			if(this.val[12]=="O"&&this.val[13]=="O"&&this.val[14]=="O"){
				secondWin = true;
			}
			else if(this.val[9]=="O"&&this.val[12]=="O"&&this.val[15]=="O"){
				secondWin = true;
			}
			else if(this.val[3]=="O"&&this.val[12]=="O"&&this.val[21]=="O"){
				secondWin = true;
			}
			this.dis13=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla14)&&(this.turno==1)&&(this.dis14==1)){
			this.dis14=0;
			this.val[13]="X";
			if(this.val[12]=="X"&&this.val[13]=="X"&&this.val[14]=="X"){
				firstWin=true;
			}
			else if(this.val[10]=="X"&&this.val[13]=="X"&&this.val[16]=="X"){
				firstWin=true;
			}
			else if(this.val[9]=="X"&&this.val[13]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[11]=="X"&&this.val[13]=="X"&&this.val[15]=="X"){
				firstWin=true;
			}
			else if(this.val[4]=="X"&&this.val[13]=="X"&&this.val[22]=="X"){
				firstWin=true;
			}
			this.casilla14.setText("X");
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla14)&&(this.turno==0)&&(this.dis14==1)){
			this.casilla14.setText("O");
			this.val[13]="O";
			if(this.val[12]=="O"&&this.val[13]=="O"&&this.val[14]=="O"){
				secondWin = true;
			}
			else if(this.val[10]=="O"&&this.val[13]=="O"&&this.val[16]=="O"){
				secondWin = true;
			}
			else if(this.val[9]=="O"&&this.val[13]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[11]=="O"&&this.val[13]=="O"&&this.val[15]=="O"){
				secondWin = true;
			}
			else if(this.val[4]=="O"&&this.val[13]=="O"&&this.val[22]=="O"){
				secondWin = true;
			}
			this.dis14=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla15)&&(this.turno==1)&&(this.dis15==1)){
			this.casilla15.setText("X");
			this.val[14]="X";
			if(this.val[12]=="X"&&this.val[13]=="X"&&this.val[14]=="X"){
				firstWin=true;
			}
			else if(this.val[11]=="X"&&this.val[14]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[5]=="X"&&this.val[14]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			this.dis15=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla15)&&(this.turno==0)&&(this.dis15==1)){
			this.casilla15.setText("O");
			this.val[14]="O";
			if(this.val[12]=="O"&&this.val[13]=="O"&&this.val[14]=="O"){
				secondWin = true;
			}
			else if(this.val[11]=="O"&&this.val[14]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[5]=="O"&&this.val[14]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			this.dis15=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla16)&&(this.turno==1)&&(this.dis16==1)){
			this.casilla16.setText("X");
			this.val[15]="X";
			if(this.val[15]=="X"&&this.val[16]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[9]=="X"&&this.val[12]=="X"&&this.val[15]=="X"){
				firstWin=true;
			}
			else if(this.val[11]=="X"&&this.val[13]=="X"&&this.val[15]=="X"){
				firstWin=true;
			}
			else if(this.val[6]=="X"&&this.val[15]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			this.dis16=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla16)&&(this.turno==0)&&(this.dis16==1)){
			this.casilla16.setText("O");
			this.val[15]="O";
			if(this.val[15]=="O"&&this.val[16]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[9]=="O"&&this.val[12]=="O"&&this.val[15]=="O"){
				secondWin = true;
			}
			else if(this.val[11]=="O"&&this.val[13]=="O"&&this.val[15]=="O"){
				secondWin = true;
			}
			else if(this.val[6]=="O"&&this.val[15]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			this.dis16=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla17)&&(this.turno==1)&&(this.dis17==1)){
			this.casilla17.setText("X");
			this.val[16]="X";
			if(this.val[15]=="X"&&this.val[16]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[10]=="X"&&this.val[13]=="X"&&this.val[16]=="X"){
				firstWin=true;
			}
			this.dis17=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla17)&&(this.turno==0)&&(this.dis17==1)){
			this.casilla17.setText("O");
			this.val[16]="O";
			if(this.val[15]=="O"&&this.val[16]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[10]=="O"&&this.val[13]=="O"&&this.val[16]=="O"){
				secondWin = true;
			}
			this.dis17=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla18)&&(this.turno==1)&&(this.dis18==1)){
			this.casilla18.setText("X");
			this.val[17]="X";
			if(this.val[15]=="X"&&this.val[16]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[11]=="X"&&this.val[14]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[9]=="X"&&this.val[13]=="X"&&this.val[17]=="X"){
				firstWin=true;
			}
			else if(this.val[7]=="X"&&this.val[16]=="X"&&this.val[25]=="X"){
				firstWin=true;
			}
			else if(this.val[8]=="X"&&this.val[17]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			this.dis18=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla18)&&(this.turno==0)&&(this.dis18==1)){
			this.casilla18.setText("O");
			this.val[17]="O";
			if(this.val[15]=="O"&&this.val[16]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[11]=="O"&&this.val[14]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[9]=="O"&&this.val[13]=="O"&&this.val[17]=="O"){
				secondWin = true;
			}
			else if(this.val[7]=="O"&&this.val[16]=="O"&&this.val[25]=="O"){
				secondWin = true;
			}
			else if(this.val[8]=="O"&&this.val[17]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			this.dis18=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla19)&&(this.turno==1)&&(this.dis19==1)){
			this.casilla19.setText("X");
			this.val[18]="X";
			if(this.val[18]=="X"&&this.val[19]=="X"&&this.val[20]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[21]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[22]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[0]=="X"&&this.val[9]=="X"&&this.val[18]=="X"){
				firstWin=true;
			}
			this.dis19=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla19)&&(this.turno==0)&&(this.dis19==1)){
			this.dis19=0;
			this.val[18]="O";
			if(this.val[18]=="O"&&this.val[19]=="O"&&this.val[20]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[21]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[0]=="O"&&this.val[9]=="O"&&this.val[18]=="O"){
				secondWin = true;
			}
			this.casilla19.setText("O");
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla20)&&(this.turno==1)&&(this.dis20==1)){
			this.casilla20.setText("X");
			this.val[19]="X";
			if(this.val[18]=="X"&&this.val[19]=="X"&&this.val[20]=="X"){
				firstWin=true;
			}
			else if(this.val[19]=="X"&&this.val[22]=="X"&&this.val[25]=="X"){
				firstWin=true;
			}
			else if(this.val[1]=="X"&&this.val[10]=="X"&&this.val[19]=="X"){
				firstWin=true;
			}
			this.dis20=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla20)&&(this.turno==0)&&(this.dis20==1)){
			this.casilla20.setText("O");
			this.val[19]="O";
			if(this.val[18]=="O"&&this.val[19]=="O"&&this.val[20]=="O"){
				secondWin = true;
			}
			else if(this.val[19]=="O"&&this.val[22]=="O"&&this.val[25]=="O"){
				secondWin = true;
			}
			else if(this.val[1]=="O"&&this.val[10]=="O"&&this.val[19]=="O"){
				secondWin = true;
			}
			this.dis20=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla21)&&(this.turno==1)&&(this.dis21==1)){
			this.casilla21.setText("X");
			this.val[20]="X";
			if(this.val[18]=="X"&&this.val[19]=="X"&&this.val[20]=="X"){
				firstWin=true;
			}
			else if(this.val[20]=="X"&&this.val[23]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[20]=="X"&&this.val[22]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			else if(this.val[2]=="X"&&this.val[11]=="X"&&this.val[20]=="X"){
				firstWin=true;
			}
			this.dis21=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla21)&&(this.turno==0)&&(this.dis21==1)){
			this.casilla21.setText("O");
			this.val[20]="O";
			if(this.val[18]=="O"&&this.val[19]=="O"&&this.val[20]=="O"){
				secondWin = true;
			}
			else if(this.val[20]=="O"&&this.val[23]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[20]=="O"&&this.val[22]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			else if(this.val[2]=="O"&&this.val[11]=="O"&&this.val[20]=="O"){
				secondWin = true;
			}
			this.dis21=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla22)&&(this.turno==1)&&(this.dis22==1)){
			this.casilla22.setText("X");
			this.val[21]="X";
			if(this.val[21]=="X"&&this.val[22]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[21]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			else if(this.val[3]=="X"&&this.val[12]=="X"&&this.val[21]=="X"){
				firstWin=true;
			}
			this.dis22=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla22)&&(this.turno==0)&&(this.dis22==1)){
			this.casilla22.setText("O");
			this.val[21]="O";
			this.dis22=0;
			this.turno=1;
			if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[21]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			else if(this.val[3]=="O"&&this.val[12]=="O"&&this.val[21]=="O"){
				secondWin = true;
			}
			repaint();
		}
		if((e.getSource() == this.casilla23)&&(this.turno==1)&&(this.dis23==1)){
			this.casilla23.setText("X");
			this.val[22]="X";
			if(this.val[21]=="X"&&this.val[22]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			else if(this.val[19]=="X"&&this.val[22]=="X"&&this.val[25]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[22]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[22]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[4]=="X"&&this.val[13]=="X"&&this.val[22]=="X"){
				firstWin=true;
			}
			this.dis23=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla23)&&(this.turno==0)&&(this.dis23==1)){
			this.casilla23.setText("O");
			this.val[22]="O";
			if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			else if(this.val[19]=="O"&&this.val[22]=="O"&&this.val[25]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[4]=="O"&&this.val[13]=="O"&&this.val[22]=="O"){
				secondWin = true;
			}
			this.dis23=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla24)&&(this.turno==1)&&(this.dis24==1)){
			this.casilla24.setText("X");
			this.val[23]="X";
			if(this.val[21]=="X"&&this.val[22]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			else if(this.val[20]=="X"&&this.val[23]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[5]=="X"&&this.val[14]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			this.dis24=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla24)&&(this.turno==0)&&(this.dis24==1)){
			this.casilla24.setText("O");
			this.val[23]="O";
			if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			else if(this.val[20]=="O"&&this.val[23]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[5]=="O"&&this.val[14]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			this.dis24=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla25)&&(this.turno==1)&&(this.dis25==1)){
			this.casilla25.setText("X");
			this.val[24]="X";
			if(this.val[24]=="X"&&this.val[25]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[21]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[22]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[6]=="X"&&this.val[15]=="X"&&this.val[24]=="X"){
				firstWin=true;
			}
			this.dis25=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla25)&&(this.turno==0)&&(this.dis25==1)){
			this.casilla25.setText("O");
			this.val[24]="O";
			if(this.val[24]=="O"&&this.val[25]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[21]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[6]=="O"&&this.val[15]=="O"&&this.val[24]=="O"){
				secondWin = true;
			}
			this.dis25=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla26)&&(this.turno==1)&&(this.dis26==1)){
			this.casilla26.setText("X");
			this.val[25]="X";
			if(this.val[21]=="X"&&this.val[22]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			else if(this.val[19]=="X"&&this.val[22]=="X"&&this.val[25]=="X"){
				firstWin=true;
			}
			else if(this.val[7]=="X"&&this.val[16]=="X"&&this.val[25]=="X"){
				firstWin=true;
			}
			this.dis26=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla26)&&(this.turno==0)&&(this.dis26==1)){
			this.casilla26.setText("O");
			this.val[25]="O";
			if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
				secondWin = true;
			}
			else if(this.val[19]=="O"&&this.val[22]=="O"&&this.val[25]=="O"){
				secondWin = true;
			}
			else if(this.val[7]=="O"&&this.val[16]=="O"&&this.val[25]=="O"){
				secondWin = true;
			}
			this.dis26=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla27)&&(this.turno==1)&&(this.dis27==1)){
			this.casilla27.setText("X");
			this.val[26]="X";
			if(this.val[21]=="X"&&this.val[22]=="X"&&this.val[23]=="X"){
				firstWin=true;
			}
			else if(this.val[20]=="X"&&this.val[23]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[18]=="X"&&this.val[22]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			else if(this.val[8]=="X"&&this.val[17]=="X"&&this.val[26]=="X"){
				firstWin=true;
			}
			this.dis27=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla27)&&(this.turno==0)&&(this.dis27==1)){
			this.casilla27.setText("O");
			this.val[26]="O";
			if(this.val[21]=="O"&&this.val[22]=="X"&&this.val[23]=="O"){
				secondWin = true;
			}
			else if(this.val[20]=="O"&&this.val[23]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			else if(this.val[8]=="O"&&this.val[17]=="O"&&this.val[26]=="O"){
				secondWin = true;
			}
			this.dis27=0;
			this.turno=1;
			repaint();
		}

		if(this.val[0]=="O"&&this.val[1]=="O"&&this.val[2]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[3]=="O"&&this.val[6]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[4]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[9]=="O"&&this.val[18]=="O"){
			secondWin = true;
		}
		if(this.val[0]=="O"&&this.val[1]=="O"&&this.val[2]=="O"){
			secondWin = true;
		}
		else if(this.val[1]=="O"&&this.val[4]=="O"&&this.val[7]=="O"){
			secondWin = true;
		}
		else if(this.val[1]=="O"&&this.val[10]=="O"&&this.val[19]=="O"){
			secondWin = true;
		}
		if(this.val[0]=="O"&&this.val[1]=="O"&&this.val[2]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[5]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[4]=="O"&&this.val[6]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[11]=="O"&&this.val[20]=="O"){
			secondWin = true;
		}
		if(this.val[3]=="O"&&this.val[4]=="O"&&this.val[5]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[3]=="O"&&this.val[6]=="O"){
			secondWin = true;
		}
		else if(this.val[3]=="O"&&this.val[12]=="O"&&this.val[21]=="O"){
			secondWin = true;
		}
		if(this.val[3]=="O"&&this.val[4]=="O"&&this.val[5]=="O"){
			secondWin = true;
		}
		else if(this.val[1]=="O"&&this.val[4]=="O"&&this.val[7]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[4]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[4]=="O"&&this.val[6]=="O"){
			secondWin = true;
		}
		else if(this.val[4]=="O"&&this.val[13]=="O"&&this.val[22]=="O"){
			secondWin = true;
		}
		if(this.val[3]=="O"&&this.val[4]=="O"&&this.val[5]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[5]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[5]=="O"&&this.val[14]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		if(this.val[6]=="O"&&this.val[7]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[3]=="O"&&this.val[6]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[4]=="O"&&this.val[6]=="O"){
			secondWin = true;
		}
		else if(this.val[6]=="O"&&this.val[15]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		if(this.val[6]=="O"&&this.val[7]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[1]=="O"&&this.val[4]=="O"&&this.val[7]=="O"){
			secondWin = true;
		}
		else if(this.val[7]=="O"&&this.val[16]=="O"&&this.val[25]=="O"){
			secondWin = true;
		}
		if(this.val[6]=="O"&&this.val[7]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[5]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[4]=="O"&&this.val[8]=="O"){
			secondWin = true;
		}
		else if(this.val[8]=="O"&&this.val[17]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		if(this.val[9]=="O"&&this.val[10]=="O"&&this.val[11]=="O"){
			secondWin = true;
		}
		else if(this.val[9]=="O"&&this.val[12]=="O"&&this.val[15]=="O"){
			secondWin = true;
		}
		else if(this.val[9]=="O"&&this.val[13]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[9]=="O"&&this.val[18]=="O"){
			secondWin = true;
		}
		if(this.val[9]=="O"&&this.val[10]=="O"&&this.val[11]=="O"){
			secondWin = true;
		}
		else if(this.val[10]=="O"&&this.val[13]=="O"&&this.val[16]=="O"){
			secondWin = true;
		}
		else if(this.val[1]=="O"&&this.val[10]=="O"&&this.val[19]=="O"){
			secondWin = true;
		}
		if(this.val[9]=="O"&&this.val[10]=="O"&&this.val[11]=="O"){
			secondWin = true;
		}
		else if(this.val[11]=="O"&&this.val[14]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[11]=="O"&&this.val[13]=="O"&&this.val[15]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[11]=="O"&&this.val[20]=="O"){
			secondWin = true;
		}
		if(this.val[12]=="O"&&this.val[13]=="O"&&this.val[14]=="O"){
			secondWin = true;
		}
		else if(this.val[9]=="O"&&this.val[12]=="O"&&this.val[15]=="O"){
			secondWin = true;
		}
		else if(this.val[3]=="O"&&this.val[12]=="O"&&this.val[21]=="O"){
			secondWin = true;
		}
		if(this.val[12]=="O"&&this.val[13]=="O"&&this.val[14]=="O"){
			secondWin = true;
		}
		else if(this.val[10]=="O"&&this.val[13]=="O"&&this.val[16]=="O"){
			secondWin = true;
		}
		else if(this.val[9]=="O"&&this.val[13]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[11]=="O"&&this.val[13]=="O"&&this.val[15]=="O"){
			secondWin = true;
		}
		else if(this.val[4]=="O"&&this.val[13]=="O"&&this.val[22]=="O"){
			secondWin = true;
		}
		if(this.val[12]=="O"&&this.val[13]=="O"&&this.val[14]=="O"){
			secondWin = true;
		}
		else if(this.val[11]=="O"&&this.val[14]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[5]=="O"&&this.val[14]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		if(this.val[15]=="O"&&this.val[16]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[9]=="O"&&this.val[12]=="O"&&this.val[15]=="O"){
			secondWin = true;
		}
		else if(this.val[11]=="O"&&this.val[13]=="O"&&this.val[15]=="O"){
			secondWin = true;
		}
		else if(this.val[6]=="O"&&this.val[15]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		if(this.val[15]=="O"&&this.val[16]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[10]=="O"&&this.val[13]=="O"&&this.val[16]=="O"){
			secondWin = true;
		}
		if(this.val[15]=="O"&&this.val[16]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[11]=="O"&&this.val[14]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[9]=="O"&&this.val[13]=="O"&&this.val[17]=="O"){
			secondWin = true;
		}
		else if(this.val[7]=="O"&&this.val[16]=="O"&&this.val[25]=="O"){
			secondWin = true;
		}
		else if(this.val[8]=="O"&&this.val[17]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		if(this.val[18]=="O"&&this.val[19]=="O"&&this.val[20]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[21]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[0]=="O"&&this.val[9]=="O"&&this.val[18]=="O"){
			secondWin = true;
		}
		if(this.val[18]=="O"&&this.val[19]=="O"&&this.val[20]=="O"){
			secondWin = true;
		}
		else if(this.val[19]=="O"&&this.val[22]=="O"&&this.val[25]=="O"){
			secondWin = true;
		}
		else if(this.val[1]=="O"&&this.val[10]=="O"&&this.val[19]=="O"){
			secondWin = true;
		}
		if(this.val[18]=="O"&&this.val[19]=="O"&&this.val[20]=="O"){
			secondWin = true;
		}
		else if(this.val[20]=="O"&&this.val[23]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[20]=="O"&&this.val[22]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		else if(this.val[2]=="O"&&this.val[11]=="O"&&this.val[20]=="O"){
			secondWin = true;
		}
		if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[21]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		else if(this.val[3]=="O"&&this.val[12]=="O"&&this.val[21]=="O"){
			secondWin = true;
		}
		if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		else if(this.val[19]=="O"&&this.val[22]=="O"&&this.val[25]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[4]=="O"&&this.val[13]=="O"&&this.val[22]=="O"){
			secondWin = true;
		}
		if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		else if(this.val[20]=="O"&&this.val[23]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[5]=="O"&&this.val[14]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		if(this.val[24]=="O"&&this.val[25]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[21]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[6]=="O"&&this.val[15]=="O"&&this.val[24]=="O"){
			secondWin = true;
		}
		if(this.val[21]=="O"&&this.val[22]=="O"&&this.val[23]=="O"){
			secondWin = true;
		}
		else if(this.val[19]=="O"&&this.val[22]=="O"&&this.val[25]=="O"){
			secondWin = true;
		}
		else if(this.val[7]=="O"&&this.val[16]=="O"&&this.val[25]=="O"){
			secondWin = true;
		}
		if(this.val[21]=="O"&&this.val[22]=="X"&&this.val[23]=="O"){
			secondWin = true;
		}
		else if(this.val[20]=="O"&&this.val[23]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[18]=="O"&&this.val[22]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}
		else if(this.val[8]=="O"&&this.val[17]=="O"&&this.val[26]=="O"){
			secondWin = true;
		}

		if(ans==1){
			if(this.turno==0){
				int n=0;
				while(n==0){
					int randomInt = 0;
					Random randomGenerator = new Random();
					while(randomInt == 0){
						randomInt = randomGenerator.nextInt(28);
						System.out.println(randomInt);
					}
					if((randomInt == 1)&&(this.dis1==1)){
						this.casilla1.setText("O");
						this.val[0]="O";
						this.turno=1;
						this.dis1=0;
						n+=1;
					}
					if((randomInt == 2)&&(this.dis2==1)){
						this.casilla2.setText("O");
						this.val[1]="O";
						this.turno=1;
						this.dis2=0;
						n+=1;
					}
					if((randomInt == 3)&&(this.dis3==1)){
						this.casilla3.setText("O");
						this.val[2]="O";
						this.turno=1;
						this.dis3=0;
						n+=1;
					}
					if((randomInt == 4)&&(this.dis4==1)){
						this.casilla4.setText("O");
						this.val[3]="O";
						this.turno=1;
						this.dis4=0;
						n+=1;
					}
					if((randomInt == 5)&&(this.dis5==1)){
						this.casilla5.setText("O");
						this.val[4]="O";
						this.turno=1;
						this.dis5=0;
						n+=1;
					}
					if((randomInt == 6)&&(this.dis6==1)){
						this.casilla6.setText("O");
						this.val[5]="O";
						this.turno=1;
						this.dis6=0;
						n+=1;
					}
					if((randomInt == 7)&&(this.dis7==1)){
						this.casilla7.setText("O");
						this.val[6]="O";
						this.turno=1;
						this.dis7=0;
						n+=1;
					}
					if((randomInt == 8)&&(this.dis8==1)){
						this.casilla8.setText("O");
						this.val[7]="O";
						this.turno=1;
						this.dis8=0;
						n+=1;
					}
					if((randomInt == 9)&&(this.dis9==1)){
						this.casilla9.setText("O");
						this.val[8]="O";
						this.turno=1;
						this.dis9=0;
						n+=1;
					}
					if((randomInt == 10)&&(this.dis10==1)){
						this.casilla10.setText("O");
						this.val[9]="O";
						this.turno=1;
						this.dis10=0;
						n+=1;
					}
					if((randomInt == 11)&&(this.dis11==1)){
						this.casilla11.setText("O");
						this.val[10]="O";
						this.turno=1;
						this.dis11=0;
						n+=1;
					}
					if((randomInt == 12)&&(this.dis12==1)){
						this.casilla12.setText("O");
						this.val[11]="O";
						this.turno=1;
						this.dis12=0;
						n+=1;
					}
					if((randomInt == 13)&&(this.dis13==1)){
						this.casilla13.setText("O");
						this.val[12]="O";
						this.turno=1;
						this.dis13=0;
						n+=1;
					}
					if((randomInt == 14)&&(this.dis14==1)){
						this.casilla14.setText("O");
						this.val[13]="O";
						this.turno=1;
						this.dis14=0;
						n+=1;
					}
					if((randomInt == 15)&&(this.dis15==1)){
						this.casilla15.setText("O");
						this.val[14]="O";
						this.turno=1;
						this.dis15=0;
						n+=1;
					}
					if((randomInt == 16)&&(this.dis16==1)){
						this.casilla16.setText("O");
						this.val[15]="O";
						this.turno=1;
						this.dis16=0;
						n+=1;
					}
					if((randomInt == 17)&&(this.dis17==1)){
						this.casilla17.setText("O");
						this.val[16]="O";
						this.turno=1;
						this.dis17=0;
						n+=1;
					}
					if((randomInt == 18)&&(this.dis18==1)){
						this.casilla18.setText("O");
						this.val[17]="O";
						this.turno=0;
						this.dis18=1;
						n+=1;
					}
					if((randomInt == 19)&&(this.dis19==1)){
						this.casilla19.setText("O");
						this.val[18]="O";
						this.turno=1;
						this.dis19=0;
						n+=1;
					}
					if((randomInt == 20)&&(this.dis20==1)){
						this.casilla20.setText("O");
						this.val[19]="O";
						this.turno=1;
						this.dis20=0;
						n+=1;
					}
					if((randomInt == 21)&&(this.dis21==1)){
						this.casilla21.setText("O");
						this.val[20]="O";
						this.turno=1;
						this.dis21=0;
						n+=1;
					}
					if((randomInt == 22)&&(this.dis22==1)){
						this.casilla22.setText("O");
						this.val[21]="O";
						this.turno=1;
						this.dis22=0;
						n+=1;
					}
					if((randomInt == 23)&&(this.dis23==1)){
						this.casilla23.setText("O");
						this.val[22]="O";
						this.turno=1;
						this.dis23=0;
						n+=1;
					}
					if((randomInt == 24)&&(this.dis24==1)){
						this.casilla24.setText("O");
						this.val[23]="O";
						this.turno=1;
						this.dis24=0;
						n+=1;
					}
					if((randomInt == 25)&&(this.dis25==1)){
						this.casilla25.setText("O");
						this.val[24]="O";
						this.turno=1;
						this.dis25=0;
						n+=1;
					}
					if((randomInt == 26)&&(this.dis26==1)){
						this.casilla26.setText("O");
						this.val[25]="O";
						this.turno=1;
						this.dis26=0;
						n+=1;
					}
					if((randomInt == 27)&&(this.dis27==1)){
						this.casilla27.setText("O");
						this.val[26]="O";
						this.turno=1;
						this.dis27=0;
						n+=1;
					}

				}
			}
		}

		if(firstWin){
			gameOver = JOptionPane.showConfirmDialog(null, "El Jugador 1(X) ha ganado ¿Jugar otra vez?");
			if(gameOver==JOptionPane.YES_OPTION){
				this.val = new String[27];
				this.casilla1.setText("");
				this.dis1=1;
				this.casilla2.setText("");
				this.dis2=1;

				this.casilla2.setText("");
				this.dis3=1;

				this.casilla3.setText("");
				this.dis3=1;

				this.casilla4.setText("");
				this.dis4=1;

				this.casilla5.setText("");
				this.dis5=1;

				this.casilla6.setText("");
				this.dis6=1;

				this.casilla7.setText("");
				this.dis7=1;

				this.casilla8.setText("");
				this.dis8=1;

				this.casilla9.setText("");
				this.dis9=1;

				this.casilla10.setText("");
				this.dis10=1;

				this.casilla11.setText("");
				this.dis11=1;

				this.casilla12.setText("");
				this.dis12=1;

				this.casilla13.setText("");
				this.dis13=1;

				this.casilla14.setText("");
				this.dis14=1;

				this.casilla15.setText("");
				this.dis15=1;

				this.casilla16.setText("");
				this.dis16=1;

				this.casilla17.setText("");
				this.dis17=1;

				this.casilla18.setText("");
				this.dis18=1;

				this.casilla19.setText("");
				this.dis19=1;

				this.casilla20.setText("");
				this.dis20=1;

				this.casilla21.setText("");
				this.dis21=1;

				this.casilla22.setText("");
				this.dis22=1;

				this.casilla23.setText("");
				this.dis23=1;

				this.casilla24.setText("");
				this.dis24=1;

				this.casilla25.setText("");
				this.dis25=1;

				this.casilla26.setText("");
				this.dis26=1;

				this.casilla27.setText("");
				this.dis27=1;

				this.turno=1;
				firstWin=false;
				secondWin=false;
				try {
					output.write(1);
					System.out.println("Se envio 1");
				} catch (IOException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
			}
			else{
				System.exit(0);
			}

		}
		else if(secondWin){
			gameOver = JOptionPane.showConfirmDialog(null, "El Jugador 2(O) ha ganado ¿Jugar otra vez?");
			if(gameOver==JOptionPane.YES_OPTION){
				this.val = new String[27];
				this.casilla1.setText("");
				this.dis1=1;

				this.casilla2.setText("");
				this.dis2=1;

				this.casilla2.setText("");
				this.dis3=1;

				this.casilla3.setText("");
				this.dis3=1;

				this.casilla4.setText("");
				this.dis4=1;

				this.casilla5.setText("");
				this.dis5=1;

				this.casilla6.setText("");
				this.dis6=1;

				this.casilla7.setText("");
				this.dis7=1;

				this.casilla8.setText("");
				this.dis8=1;

				this.casilla9.setText("");
				this.dis9=1;

				this.casilla10.setText("");
				this.dis10=1;

				this.casilla11.setText("");
				this.dis11=1;

				this.casilla12.setText("");
				this.dis12=1;

				this.casilla13.setText("");
				this.dis13=1;

				this.casilla14.setText("");
				this.dis14=1;

				this.casilla15.setText("");
				this.dis15=1;

				this.casilla16.setText("");
				this.dis16=1;

				this.casilla17.setText("");
				this.dis17=1;

				this.casilla18.setText("");
				this.dis18=1;

				this.casilla19.setText("");
				this.dis19=1;

				this.casilla20.setText("");
				this.dis20=1;

				this.casilla21.setText("");
				this.dis21=1;
				
				this.casilla22.setText("");
				this.dis22=1;

				this.casilla23.setText("");
				this.dis23=1;

				this.casilla24.setText("");
				this.dis24=1;

				this.casilla25.setText("");
				this.dis25=1;

				this.casilla26.setText("");
				this.dis26=1;

				this.casilla27.setText("");
				this.dis27=1;

				this.turno=1;
				firstWin=false;
				secondWin=false;
				try {
					output.write(1);
					System.out.println("Se envio 1");
				} catch (IOException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
			}
			else{
				System.exit(0);
			}
		}
	}



	@Override
	public void serialEvent(SerialPortEvent arg0) {
		if (arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
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

	}
} 	