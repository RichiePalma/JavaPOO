/*
	Autor: Ricardo Daniel Palma Mendoza A01226922
	Clase: Complejo
	Fecha: 31/08/2016
*/

/*
Complejo a=new Complejo();
Complejo b=new Complejo(-3,5);

Complejo c=a.multiplicacion(b);
Complejo d=a.multiplicacion(5.4);

*/

import javax.swing.*;

public class Complejo{

	public static void main(String[] args){
		Complejo a=new Complejo();
		Complejo b=new Complejo(3.0,2.0); 
		// Complejo c=a.suma(b);

		a.imprimir();
		b.imprimir();

		a.agregar(3.0,5.0);
		b.agregar(2.0,4.0);

		a.agregar(b);
		a.suma(b);
		a.resta(b);
		a.multiplicacionAC(b);
		b.multiplicacionXC(8.0);
		conjugado(a);
		conjugado(b);
	}

// Comienzo de declarando la existencia del objeto y todo lo que debe de tener.

	private double real,
		imaginario;

	//private double [] valores = {real, imaginario};

	public Complejo(){ //Default
		this(1,7);
	}

	public Complejo(double real, double imaginario){
		establecer(real, imaginario); //
	}

	public void establecer(double real, double imaginario){ //establecer() <--
		this.real=real;
		this.imaginario=imaginario;
		//this.valores=valores;

	}
/*
	public double[] getValores(){
		return this.valores;
	}
*/
	public double getReal(){
		return this.real;
	}

	public double getImaginario(){
		return this.imaginario;
	}


	public void imprimir(){ 
		System.out.println("a = " + this.real + " + " + this.imaginario + "i");
	}


//Final de declarando la existencia del objeto y todo lo que debe de tener.

	public void agregar(double c, double d){
		double agregar_reales = this.real + c;
		double agregar_imaginarios = this.imaginario + d;
		System.out.println("El resultado de sumar " + c + " + " + d +"i a la variable a es: " + agregar_reales + " + " + agregar_imaginarios + "i");
	}

	public void agregar(Complejo c){
		double agregar_complejoReal = this.real + c.real;
		double agregar_complejoImaginario = this.imaginario + c.imaginario;
		System.out.println("El resultado de agregar las dos variables entre si es de: " + agregar_complejoReal + " + " + agregar_complejoImaginario + "i");
	}

// ----------------------Comienzo inciso 8.8----------------------

	// No logre entender o mejor dicho hacer funcionar la parte de Complejo c=a.suma(b); 
	// Pero con el objetivo de entregar la tarea completa con lo que se logro corregir, se anexa lo siguiente.


	public void suma(Complejo c){
		double sumar_complejoReal = this.real + c.real;
		double sumar_complejoImaginario = this.imaginario + c.imaginario;
		System.out.println("El resultado de sumar las dos variables es de: " + sumar_complejoReal + " + " + sumar_complejoImaginario + "i");
	}

	public void resta(Complejo c){
		double restar_complejoReal = this.real - c.real;
		double restar_complejoImaginario = this.imaginario - c.imaginario;
		System.out.println("El resultado de sumar las dos variables es de: " + restar_complejoReal + " + " + restar_complejoImaginario + "i");
	}

	public void multiplicacionAC(Complejo c){
		double multi_real = (this.real*c.real) - (this.imaginario * c.imaginario);
		double multi_imaginario = (this.real*c.imaginario) - (this.imaginario * c.real);
		System.out.println("El resultado de la multiplicación entre ambas variables es: " + multi_real + " + " + multi_imaginario + "i");

	}

	public void multiplicacionXC(double x){
		double xmulti_real = x * this.real;
		double xmulti_imaginario = x * this.imaginario;
		System.out.println("El resultado de la multiplicación entre "+ x + " es: " + xmulti_real + " + " + xmulti_imaginario + "i");

	}
	
	public static void conjugado(Complejo c){
		double negado = -c.imaginario;
		if(negado>=0){
			System.out.println("El conjugado de es: " + c.real + " + " + negado + "i");
		}
		else{
			System.out.println("El conjugado de es: " + c.real + " - " + c.imaginario + "i");
		}
	}
}