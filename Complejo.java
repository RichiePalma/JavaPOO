/*
	Autor: Ricardo Daniel Palma Mendoza A01226922
	Clase: Complejo
	Fecha: 28/08/2016
*/

import javax.swing.*;

public class Complejo{

	public static void main(String[] args){
		Complejo a=new Complejo(1.0,7.0,3.0,2.0);
		Complejo c=new Complejo(); 

		a.imprimir();
		a.suma();
		a.resta();
		a.multiplicacionAC();
		a.multiplicacionXC();
		a.conjugado();

		c.agregar();
	}

// Comienzo de declarando la existencia del objeto y todo lo que debe de tener.

// -------------Apartir de aqui comienzan los valores de a---------------

	private double A, //Real , para c este seria C
		Bi, //Imaginaria, para c este seria Di

//--------------Apartir de aqui comienzan los valores de c --------------

		C, //Real
		Di; //Imaginaria

	public Complejo(){
		this(0,0,0,0);

	}

	public Complejo(double A, double Bi, double C, double Di){
		establecer(A,Bi,C,Di); //
	}

	public void establecer(double A, double Bi, double C, double Di){ //establecer() <--
		this.A=A;
		this.Bi=Bi;
		this.C=C;
		this.Di=Di;
	}
	
	public double getA(){
		return this.A;
	}

	public double getBi(){
		return this.Bi;
	}
	
	public void imprimir(){ // imprimir() <--
		System.out.println("a = " + this.A + " + " + this.Bi + "i");
		System.out.println("c = " + this.C + " + " + this.Di + "i");
	}

//Final de declarando la existencia del objeto y todo lo que debe de tener.

/* Pendiente... 
	
	public static void agregar(){
	
	}
*/

// ----------------------Comienzo inciso 8.8----------------------

	public void suma(){
		Double suma_reales = this.A + this.C;
		Double suma_imaginarios = this.Bi + this.Di;
		if(suma_imaginarios >= 0){  //Si sale positivo salga el signo de suma para separar reales e imaginarios.
						
			System.out.println("Resultado de la suma es: " + suma_reales + " + " + suma_imaginarios + "i" );
		}
		else{		// si sale negativo el resultado imaginario imprimira el signo de menos que separara reales e imaginarios.
			System.out.println("Resultado de la suma es: " + suma_reales + suma_imaginarios + "i" );
		}
	}

	public void resta(){
		Double resta_reales = this.A - this.C;
		Double resta_imaginarios = this.Bi - this.Di;
		if(resta_imaginarios >= 0){
			System.out.println("Resultado de la resta es: " + resta_reales + " + " + resta_imaginarios + "i");
		}
		else{
			System.out.println("Resultado de la resta es: " + resta_reales + resta_imaginarios + "i");
		}
	}

	public void multiplicacionAC(){
		Double multiplicacion_reales = (this.A * this.C) - (this.Bi * this.Di);
		Double multiplicacion_imaginarios = (this.A *this.Di) + (this.Bi * this.C);
		if(multiplicacion_imaginarios >= 0){
			System.out.println("Resultado de la multiplicación a*c es: " + multiplicacion_reales + " + " + multiplicacion_imaginarios + "i");
		} 
		else{
			System.out.println("Resultado de la multiplicación a*c es: " + multiplicacion_reales + multiplicacion_imaginarios + "i");
		}
	}

	public void multiplicacionXC(){
		Double X = Double.valueOf(JOptionPane.showInputDialog("Inserte valor de x (real): "));
		Double multiplicacionX_real = X * this.C;
		Double multiplicacionX_imaginaria = X * this.Di;
		if(multiplicacionX_imaginaria >= 0){
			System.out.println("Resultado de la multiplicación x*c es: " + multiplicacionX_real + " + " + multiplicacionX_imaginaria + "i");
		} 
		else{
			System.out.println("Resultado de la multiplicación x*c es: " + multiplicacionX_real + " + " + multiplicacionX_imaginaria + "i");
		}
	}
	
	public void conjugado(){
		if(this.Bi > 0){
			System.out.println("Conjugado de a es ¬a = " + this.A + "-" + this.Bi + "i");
		}
		else{ 
			System.out.println("Conjugado de ¬a = " + this.A + " + " + (this.Bi*-1) + "i");
		}
	}
	
	public void agregar(){
		String incorporar = JOptionPane.showInputDialog("¿Te gustaria sumar tus propios numero complejo? Si / No");
		while(incorporar.equalsIgnoreCase("si")){
			Double realA = Double.valueOf(JOptionPane.showInputDialog("¿Cual es el valor de la parte real del 1er numero complejo? "));
			Double imaginarioA = Double.valueOf(JOptionPane.showInputDialog("¿Cual es el valor de la parte imaginaria de 1er numero complejo? "));
			Double realB = Double.valueOf(JOptionPane.showInputDialog("¿Cual es el valor de la parte real de 2ndo numero complejo? "));
			Double imaginarioB = Double.valueOf(JOptionPane.showInputDialog("¿Cual es el valor de la parte imaginaria de 2ndo numero complejo? "));

			this.A=realA;
			this.Bi=imaginarioA;
			this.C=realB;
			this.Di=imaginarioB;

//-----------------------------Suma-----------------------------

			Double SumarReales = this.A + this.C;
			Double SumarImaginarios =this.Bi + this.Di;
			if(SumarImaginarios >= 0){ 
				System.out.println("Resultado de la suma de tus valores es: " + SumarReales + " + " + SumarImaginarios + "i" );
			}
			else{		
				System.out.println("Resultado de la suma de tus valores es: " + SumarReales + SumarImaginarios + "i" );
			}



			String continuar = JOptionPane.showInputDialog("¿Te gustaria sumarle al resultado otro numero complejo? Si / No");
			if(continuar.equalsIgnoreCase("si")){
				Double siguienteReal = Double.valueOf(JOptionPane.showInputDialog("¿Cual es el valor de la parte real del siguiente numero complejo? "));
				Double siguienteImaginario = Double.valueOf(JOptionPane.showInputDialog("¿Cual es el valor de la parte imaginaria del siguiente numero complejo? "));
				Double SumarSiguienteReal = SumarReales + siguienteReal;
				Double SumarSiguienteImaginario = SumarImaginarios + siguienteImaginario;	
				if(SumarSiguienteImaginario >= 0){ 
					System.out.println("Resultado de la suma de tus valores es: " + SumarSiguienteReal + " + " + SumarSiguienteImaginario + "i" );
				}
				else{		
				System.out.println("Resultado de la suma de tus valores es: " + SumarSiguienteReal + SumarSiguienteImaginario + "i" );
				}
			}
			else{
				break;
			}
		}
	}
}
