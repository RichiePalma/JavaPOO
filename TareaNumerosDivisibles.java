/*
	Autor: Ricardo Daniel Palma Mendoza A01226922
	Clase: IntroJava
	Fecha: 18/08/2016
*/

import javax.swing.*;

public class TareaNumerosDivisibles{
	public static void main(String[] args){
		factores();
		
	}
	public static void factores(){
		String sParametro=JOptionPane.showInputDialog("Inserta el limite del parametro");
		int parametro=Integer.parseInt(sParametro);
		for(int i=1;i<=parametro;i++){
			int residuo= parametro%i;
			if(residuo==0){
				System.out.println(i);
			}
		}
	}
}