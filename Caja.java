
public class Caja extends Rectangulo {
	protected double alto;
	
	public Caja(){
		this(5.0,4.0,3.0);
	}
	
	public Caja(double largo, double ancho, double alto){
		super(ancho,ancho);
		this.alto=alto;
	}
	
	public double area(){
		return 2.0*(this.ancho*this.largo+this.ancho*this.alto+this.largo*this.alto);
	}
	
	public double volumen(){
		return this.alto*this.ancho*this.largo;
	}
	
	public String toString(){
		return "Caja de largo = " + this.largo+ ", ancho = "+ this.ancho +"y alto = "+this.alto;
	}
}
