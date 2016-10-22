
public class Casilla {
	private boolean disponible, //Casilla vacia = true , Llena = false
					valor; // Si casilla es X = true , si es O = false
	
	public static boolean X,
						  O;
	
	public Casilla(){
		this.disponible = false;
		this.valor=valor;
		this.X=true;
		this.O=O;//Es false
	}
	
	public void setValor(boolean valor){
		this.valor=valor;
	}
	public boolean getValor(){
		return this.valor;
	}

	public String toString(){
		return "Something";
	}
	public static void main(String[] args) {
		System.out.println("Si compilo");
		System.out.println(O);
	}

}
