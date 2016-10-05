import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
//IOException tiene que ver con el leer o escribir archivos
//Esto sucede cuando no se encuentra un archivo o no se tiene permiso a una carpeta, FileNotFound,etc...
public class EjemploEscritor {

	public static void main(String[] args) {
		try{
			FileWriter fw=new FileWriter("C:\\Users\\Ricardo Palma\\Documents\\2ndo Semestre\\texto.txt"); //Arregla esto no tienes unidad D
			PrintWriter pw=new PrintWriter(fw);
			pw.println("Este es mi primer archivo de texto generado en java");
			pw.println("Espero que si funcione");
			pw.println("Y sino ya estoy acostumbrado! :(");
			pw.close(); //Siempre hay que cerrar el archivo!
		}catch(IOException e){
			System.out.println("Ocurrio un error "+e);
		}
	}

}
