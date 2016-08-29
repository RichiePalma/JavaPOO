/*
	Autor: Ricardo Daniel Palma Mendoza A01226922
	Clase: IntroJava
	Fecha: 15/08/2016
*/

import javax.swing.*;

public class IntroJava{
	public static void saluda(){	
		String nombre =JOptionPane.showInputDialog("Dime tu nombre");
		System.out.println("Hola "+nombre);
	}
// Declaras la existencia de saluda()

	public static void calificacion(){
		String sNota=JOptionPane.showInputDialog("Dime tu calificación");
		int nota=Integer.parseInt(sNota);
		if(nota<70){
			System.out.println("Reprobado");
		}
		else{
			System.out.println("Aprobado");
		}
}
// Aqui solo lo declaraste pero no imprimira nada si no lo llamas en el void main
// Se usa {} despues de los condicionales para meter 2 o más acciones

	public static void numerosdel1al100(){
		for(int i=0; i<100; i++){
			System.out.println(i+1);
		}
}
// i++ significa variable más valor en uno, osea i= i + 1
// en el println es i+1 para que llegue hasta 100 si no llega a 99 

	public static void serie(int base){
		for(int i=1; i<51; i++){
			System.out.print(base*i+", ");
		}
		System.out.println(base*50); //Da el salto de linea
}
//int base es el parametro en este caso la serie que se imprimira para que sea un predeterminado en lugar de preguntar
//print sin ln para que se imprima en el mismo renglón sin dar salto de linea y el + "," para que separe los numeros

	public static int calorias(){
		int comidas=Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas comidas has hecho el día de hoy?"));
		int totalCalorias=0;
		for(int i=0;i<comidas;i++){
			int caloria=Integer.parseInt(JOptionPane.showInputDialog("¿Cuantás calorias tiene tu comida" + (i+1) + "?"));
			totalCalorias=totalCalorias+caloria;
		}
		return totalCalorias; //Para que regrese un valor
	}

	public static void main(String[] args){
		saluda();
		calificacion();
		numerosdel1al100();
		serie(7);
		int resultado=calorias();
		JOptionPane.showMessageDialog(null,"El total de calorias consumidas hoy es " + resultado);
		// Llamar saluda,calificacion,numerosdel1al100,etc a esta función
	// El programa hace unicamente lo que hace el metodo main
	// En el main para el caso de serie() pones dentro del parentesis el valor base para que imprima la serie
	}
}

/* 
	Comentario
	Multilineal
*/
