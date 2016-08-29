/*
	Autor: Ricardo Daniel Palma Mendoza A01226922
	Clase: TareaCiclos
	Fecha: 19/08/2016
Ejemplo:
Input = 150
150 divisible entre 2? Si, da 75
75 divisible entre 2? No pero es divisible entre 3 y da 25
25 no es divisible entre 3 pero si entre 5 y da 5
5 es divisible entre 5 y es 1
1 es primo y solo puede ser dividido entre el mismo entonces ahi se detiene
*/

import javax.swing.*;

public class TareaCiclos{
	public static void main(String[] args){
		factores(150);
		factores(300);
		factores (30);
		factores(15);
		factores(90);
		
	}

	public static void factores(int base){
		//String sParametro=JOptionPane.showInputDialog("Inserta el limite del parametro"); // En caso de que sea input, lo puse como comentario
		// porque la tarea pide pobrar con unos valores desde el main.
		//parametro=Integer.valueOf(sParametro); //Esto igual ya que no es necesario pasar de string a int
		
		int parametro=base;
		int factor=2; //Empieza desde el 2 para que no sea un loop infinito ya que cualquier numero es divisible entre 1.
		System.out.println("Los factores de " + parametro + " son:");
		while(parametro!=1){ //Asi se detiene cuando el parametro sea reducido a 1
			int residuo = parametro%factor;
			if(residuo==0){   	//Si el numero entero puede dividir el otro numero sin dejar decimales 
				parametro = parametro/factor;		//Entonces se imprime y ese resultado se evalua si es divisible por el mismo dividuendo
				System.out.println(factor);
			}
			else{		//Si no lo es, entonces se añade 1 al factor para evaluar la condición con el siguiente valor de este.
				factor++;
			}
		}		
	}

}


/* Lo intente hacer con un for en lugar de un while pero no imprimia todos los factores
	por ejemplo en el de 150 solo imprimia 2 y 3 pero no 5 y 5. Por eso cambie a un while
		aun así dejo el lo que hice con el for como comentario

	public static void factores(){
		String sParametro=JOptionPane.showInputDialog("Inserta el limite del parametro");
		int parametro=Integer.valueOf(sParametro);
		int factor = 2; //Para que termine en 2 ya que en 1 seria un loop infinito
		for(int i=factor;i<=parametro;i++){
			int residuo = parametro%i;
			if(residuo==0){
				System.out.println(i);
				parametro=parametro/i;
				System.out.println("P: " + parametro);
			}
			else{
				i++;
			}
		}
	}
}

*/
