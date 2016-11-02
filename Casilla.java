/*	Ricardo Daniel Palma Mendoza A01226922
 * 	Andres Quiroz Duarte A01400033 
 *	Clase: Casilla
 *	Fecha 01/11/2016
 */
public class Casilla {
	private boolean disponible, //Casilla vacia = true , Llena = false
					valor; // Si casilla es X = true , si es O = false
	
	public static boolean X,
						  O;
	
	public Casilla(){
		this.disponible = true;
		this.valor=false;
		X=true;
		O=false;//Es false
	}
	
	public void setValor(boolean valor){
		if(valor==true){
			this.valor=Casilla.O;
			this.disponible=false;
		}
		else{
			this.valor=Casilla.X;
			this.disponible=false;
		}
	}
	public boolean getValor(){
		return this.valor;
	}
	
	public void setDisponible(boolean disponible){
		this.disponible=disponible;
	}
	
	public boolean getDisponible(){
		return this.disponible;
	}

	public String toString(){
		if(this.disponible==false){
			if(this.getValor()==true ){ // Si no esta disponible y aparte es true entonces regresa/imprime X
				return "X";
			}
			else{
				return "O";
			}
			
		}
		else{
			return " "; //Si esta disponible el espacio esta en blanco
		}
	}

}
