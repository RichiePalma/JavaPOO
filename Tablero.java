import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import java.util.NoSuchElementException;
import java.util.Scanner;
public class Tablero {
	private Casilla[][][] casillas;
	private boolean turno;
	//private static int[] prueba;

	private int ejeX, ejeY, ejeZ, totalEjes;
	private StringTokenizer coordenada;

	public Tablero(){
		this.casillas=new Casilla[3][3][3];
		this.turno=false;
		//prueba = new int[3];
	}

	public boolean pedirCoordenada(){
		boolean turno;
		int numTurno=1;
		String jugada=null;


		do{
			try{
				if(numTurno == 2){
					numTurno=0;
					jugada = JOptionPane.showInputDialog("Jugador 2(X): Inserte las coordenadas donde deseas lanzar la jugada");
					numTurno++;
				}
				else{
					jugada = JOptionPane.showInputDialog("Jugador 1(O): Inserte las coordenadas donde deseas lanzar la jugada");
					numTurno++;
				}
				try{
					this.coordenada = new StringTokenizer(jugada);
				}catch(NullPointerException e){
					if(numTurno ==2){
						JOptionPane.showMessageDialog(null,"El jugador 2 se ha rendido ¡Gana el jugador 1!");
					}
					else{
						JOptionPane.showMessageDialog(null, "El jugador 1 se ha rendido ¡Gana el jugador 2!");
					}
				}

				this.ejeX = Integer.valueOf(this.coordenada.nextToken()) - 1; // -1 porque para el jugador las coordenadas que inserte el jugador son 1,2 o 3
				this.ejeY = Integer.valueOf(this.coordenada.nextToken()) - 1;   // pero en el arrego solo hay posiciones 0,1 y 2
				this.ejeZ = Integer.valueOf(this.coordenada.nextToken()) - 1;
				this.totalEjes = ejeX+ejeY+ejeZ; //Para evitar que salga fuera del rango de ejes y así evitar hacer un largo if, el maximo es 6 ya que 2+2+2
				System.out.println("X: " + ejeX + " Y: "+ejeY+" Z: "+ejeZ + " Total " + totalEjes);

			}
			catch(NoSuchElementException e){
				JOptionPane.showMessageDialog(null,"Por favor inserte 3 coordenadas separadas por un espacio. Ej: x y z ");
			}
		}while((this.totalEjes>=0 || this.totalEjes < 7));

//		if(this.turno==false){
//			this.turno=true;
//			this.casillas[ejeX][ejeY][ejeZ].setValor(Casilla.O);
//		}
//		else{
//			this.turno=false;
//			this.casillas[ejeX][ejeY][ejeZ].setValor(Casilla.X);
//		}
		return false;
	}

	public boolean gano(){
		return true;
	}

	public boolean empate(){
		return true;
	}
	public void imprimeTablero(){
		for(int i = 0; i<3; i++){
			System.out.println(this.casillas[0][0][i]+"|"+this.casillas[1][0][i]+"|"+this.casillas[2][0][i] + "\n -----"); 
			//Imprime los ejes x en y=0 del i gato donde en este caso seran i = 3 gatos
			System.out.println(this.casillas[0][1][i]+"|"+this.casillas[1][1][i]+"|"+this.casillas[2][1][i] + "\n -----"); 
			//Ejes x en y=1 del i gato
			System.out.println(this.casillas[0][2][i]+"|"+this.casillas[1][2][i]+"|"+this.casillas[2][2][i]); 
			//ejes x en y=2 del i gato
			System.out.println(" "+"\n"+" ");
		}

	}
	public static void main(String[] args){	
		Tablero gato3D = new Tablero();
		gato3D.imprimeTablero();
		gato3D.pedirCoordenada();

	}
}