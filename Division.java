import javax.swing.JOptionPane;
/* Autor: Ricardo Daniel Palma Mendoza 
 * Clase: Division
 * Fecha 05/10/2016
 */
public class Division {

	public static int divisionEntera(int numerador, int denominador){
		return numerador / denominador;
	}

	public static void main(String[] args){
		boolean error=false;
		do{
			try{
				int num=Integer.parseInt(JOptionPane.showInputDialog("Escribe el numerador"));
				int den=Integer.parseInt(JOptionPane.showInputDialog("Escribe el denominador"));
				JOptionPane.showMessageDialog(null, "El resultado de dividir "+num+"/"+den+" es "+divisionEntera(num,den));	
				error=false;
			}
			catch(ArithmeticException e){ // Arithmetic Exception para las divisiones entre 0 aun que exception es más general
				System.out.println("Ocurrio un error "+e);
				error=true;
			} 
			catch(NumberFormatException e){
				System.out.println("Ocurrio un error en " +e);
				error=true;
			}
		}while(error);
	}
	//Ctrl+A = Seleccionar todo Ctrl+I=Indent all
	//Subir antes del jueves si el usuario pone algun dato invalido que mande una excepción (Tal como div 0 o String)
	// java.lang.NumberFormatException: error por un String
	//IllegalArgumentException salía antes, despues comenzo a salir Arithmetic Exception
}
