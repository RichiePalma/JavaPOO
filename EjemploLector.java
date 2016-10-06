/* Autor: Ricardo Daniel Palma Mendoza 
 * Clase: EjemploLector
 * Fecha 05/10/2016
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EjemploLector {

	public static void main(String[] args) {
		try{
			String ruta=JOptionPane.showInputDialog("Dame la ruta del archivo a leer");
			BufferedReader br=new BufferedReader(new FileReader(ruta)); //No tienes unidad D
			//C:\\Users\\Ricardo Palma\\Documents\\2ndo Semestre\\entrada2.txt
			// se pone doble linea "\\" porque si solo pones "\" se confunde con un escape, por ejemplo "\n" es salto de linea
			String linea; //Declaras existencia de linea y despues indicas que linea tiene el valor de string de cada linea del documento
			while((linea = br.readLine()) != null){ //Mientras haya algo que leer en una linea, lee e imprime tal linea
				System.out.println(linea);
			}
			br.close();
		}catch (FileNotFoundException e){
			System.out.println("El archivo no se encontró "+e);
		}
		catch(IOException e){
			System.out.println("Error de tipo I/O " + e);
		}
		//Hacer que lea el archivo completo Jueves antes de las 8
		//readLine regresa null cuando ya no hay algo por leer
	}
}