
public class Cuadrado extends Rectangulo {
	public Cuadrado(){
		this(5.0);
	}
	
	public Cuadrado(double lado){
		super(lado,lado);
	}
	public String toString(){
		return "Cuadrado de lado = "+ this.largo;
	}

	public void saluda(){
		System.out.println("Hola  !!:D");
	}
}
