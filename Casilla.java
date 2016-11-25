

/*	Ricardo Daniel Palma Mendoza A01226922 %33.33
 * 	David Medina Dow A01631918  %33.33
 *  Alejandro Delgado Medrano A01227074 %33.33 
 *	Clase: Casilla
 *	Fecha 21/11/2016
 */
public class Casilla{
	private boolean disponible, //Casilla vacia = true , Llena = false
					valor; // Si casilla es X = true , si es O = false
	
	public static boolean X, //Se podria hacer final inclusive, ya que el valor de estos nunca deben de cambiar y no deberian de
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
			this.disponible=false; //Para que muestre que ya esta lleno una vez puesto el valor
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
