import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class CalculaNomina {

	public static void main(String[] args) {
		try{
			String linea,
				   nombre,
				   paterno;
			int horas;
			double tabulador;
			
			StringTokenizer st;
			
			BufferedReader br=new BufferedReader(new FileReader("horasTrabajadas.txt"));
			PrintWriter pw=new PrintWriter(new FileWriter("nomina.csv")); //.csv = coma separated value ; valor separado por comas excel hace eso
			pw.println("Nombre Completo,Pago Semanal");
			br.readLine();
			while((linea=br.readLine()) != null){
				st=new StringTokenizer(linea); //se pone entre " " dependiendo de como quieres separar los campos (linea," " )
				nombre=st.nextToken(); //De la linea que lei te voy a pasar el primer campo
				paterno=st.nextToken(); //Tokenizer siempre regresa String
				horas=Integer.parseInt(st.nextToken());
				tabulador=Double.parseDouble(st.nextToken());
				pw.println(nombre+" "+paterno+","+horas*tabulador);
			}
			br.close();
			pw.close();
			st=new StringTokenizer("Maria de Todos los Angeles Guadalupe Santisima");
			while(st.hasMoreTokens()){ //.hasMoreTokens es un booleano que revisa si hay un campo más o no.
				System.out.println(st.nextToken()); 
			}
			JOptionPane.showMessageDialog(null, "Programa Finalizado");
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo"+e);
		}
		catch(IOException e){
			JOptionPane.showConfirmDialog(null, "Error de I/O " + e);
		}
	}

}
