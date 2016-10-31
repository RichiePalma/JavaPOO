
public class Casilla {
	private boolean disponible, //Casilla vacia = true , Llena = false
					valor; // Si casilla es X = true , si es O = false
	
	public static boolean X,
						  O;
	
	public Casilla(){
		this.disponible = true;
		this.valor=false;
		this.X=true;
		this.O=false;//Es false
	}
	
	public void setValor(boolean valor){
			this.valor=valor;
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
		if(this.getDisponible()==false){
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
//	public static void main(String[] args) {
//		System.out.println("Si compilo");
//		System.out.println(O);
//	}

}
