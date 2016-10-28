import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import java.util.NoSuchElementException;

public class Tablero {
	private Casilla[][][] casillas;
	private int turnosTotales;
	//private static int[] prueba;

	private int ejeX, ejeY, ejeZ, totalEjes;
	private StringTokenizer coordenada;

	public Tablero(){
		this.casillas=new Casilla[3][3][3];
		this.turnosTotales=1;

		//prueba = new int[3];
	}

	public boolean pedirCoordenada(){
		int numTurno=1;
		String jugada=null;

		try{
			do{
				try{
					if(numTurno == 2){
						numTurno=1;
						jugada = JOptionPane.showInputDialog("Turno: "+turnosTotales+" | Jugador 2(X): Inserte las coordenadas donde deseas lanzar la jugada");
						//this.casillas[this.ejeX][this.ejeY][this.ejeZ].setValor(Casilla.X);
						//numTurno++;
					}
					else{
						jugada = JOptionPane.showInputDialog("Turno: "+turnosTotales+" | Jugador 1(O): Inserte las coordenadas donde deseas lanzar la jugada");
						//this.casillas[this.ejeX][this.ejeY][this.ejeZ].setValor(Casilla.O);
						numTurno=2;
					}
					this.coordenada = new StringTokenizer(jugada);
					this.ejeX = Integer.valueOf(this.coordenada.nextToken()) - 1; // -1 porque para el jugador las coordenadas que inserte el jugador son 1,2 o 3
					this.ejeY = Integer.valueOf(this.coordenada.nextToken()) - 1;   // pero en el arrego solo hay posiciones 0,1 y 2
					this.ejeZ = Integer.valueOf(this.coordenada.nextToken()) - 1;
					this.totalEjes = ejeX+ejeY+ejeZ; //Para evitar que salga fuera del rango de ejes y as� evitar hacer un largo if, el maximo es 6 ya que 2+2+2
					System.out.println("X: " + ejeX + " Y: "+ejeY+" Z: "+ejeZ + " Total " + totalEjes);

				}
				//Evaluar si x posicion i sea todo O / X
				catch(NoSuchElementException e){
					if(numTurno ==2){
						numTurno=1;
					}
					else{
						numTurno=2;
					}
					JOptionPane.showMessageDialog(null,"Por favor inserte 3 coordenadas separadas por un espacio. Ej: x y z ");
					//NumberFormatException
				}catch(NumberFormatException ex){
					if(numTurno ==2){
						numTurno=1;
					}
					else{
						numTurno=2;
					}
					JOptionPane.showMessageDialog(null,"Por favor inserte 3 numeros y no letras ");
				}
				this.turnosTotales++;

			}while((this.totalEjes>=0 || this.totalEjes < 7));
		}catch(NullPointerException e){
			if(numTurno ==2){ //el else hace unTurno==2 por eso si cancela tecnicamente esta perdiendo jugador 1
				JOptionPane.showMessageDialog(null,"El jugador 1 se ha rendido �Gana el jugador 2!");
			}
			else{
				JOptionPane.showMessageDialog(null, "El jugador 2 se ha rendido �Gana el jugador 1!");
			}
		}

		//		if(numTurno==2){
		//			this.casillas[ejeX][ejeY][ejeZ].setValor(Casilla.X);
		//		}
		//		else{
		//			this.casillas[ejeX][ejeY][ejeZ].setValor(Casilla.O);
		//		}
		return false;
	}

	public boolean gano(){
		for(int i=0; i<3;i++){
			for(int j=0;j<3;j++){
				if(this.casillas[i][0][j].getValor() == casillas[i][1][j].getValor() == casillas[i][2][j].getValor()){
					return true;
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(this.casillas[0][i][j].getValor()== this.casillas[1][i][j].getValor()== this.casillas[2][i][j].getValor()){
					return true;
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(this.casillas[i][j][0].getValor()== this.casillas[i][j][1].getValor()== this.casillas[i][j][2].getValor()){
					return true;
				}
			}
		}
		for(int i=0; i<3;i++){
			if(this.casillas[0][0][i].getValor()== this.casillas[1][1][i].getValor()== this.casillas[2][2][i].getValor()){
				return true;
			}
			else if(this.casillas[2][0][i].getValor() == this.casillas[1][1][i].getValor() == this.casillas[0][2][i].getValor()){
				return true;
			}
		}
		return false;
	}

	public boolean empate(){
		if(this.turnosTotales > 4){
			JOptionPane.showMessageDialog(null, "�Han empatado!");
			return true;
		}
		else{
			return false;
		}
	}
	public void imprimeTablero(){
		for(int i = 0; i<3; i++){ //[x][y][z]
			System.out.println(this.casillas[0][0][i]+"|"+this.casillas[1][0][i]+"|"+this.casillas[2][0][i] + "\n ---------"); 
			//Imprime los ejes x en y=0 del i gato donde en este caso seran i = 3 gatos
			System.out.println(this.casillas[0][1][i]+"|"+this.casillas[1][1][i]+"|"+this.casillas[2][1][i] + "\n ---------"); 
			//Ejes x en y=1 del i gato
			System.out.println(this.casillas[0][2][i]+"|"+this.casillas[1][2][i]+"|"+this.casillas[2][2][i]); 
			//ejes x en y=2 del i gato
			System.out.println(" "+"\n"+" ");
		}
	}

	//----------------------------------------------------------------------------------------------------------------------------------------



	public static void main(String[] args){	
		Tablero gato3D = new Tablero();
		gato3D.imprimeTablero();

			gato3D.pedirCoordenada();
			gato3D.empate();
		//		}
	}
}