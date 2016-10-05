
public class Rectangulo implements Figura { //Implements en lugar de extends por que es interface
	protected double largo,
		           ancho;
	public Rectangulo(){
		this(5.0,3.0);
	}
	
	public Rectangulo(double largo,double ancho){
		this.largo=largo;
		this.ancho=ancho;
	}
	
	public double perimetro(){
		return 2.0*(this.largo + this.ancho);
	}
	
	public double area(){
		return this.largo*this.ancho;
	}

	public double volumen(){
		return 0.0;
	}
	
	public String toString(){
		return "Rectangulo de largo = "+this.largo + " y ancho = " + this.ancho;
	}

	public static void main(String[] args) {
		String a="Hola";
		String b="Adios";
		int comp=a.compareTo(b);

		if(comp<0){
			System.out.println("El string " + a + " es menor que " + b);
		}
		else if(comp==0){
			System.out.println("El string " + a + " es igual que " + b);
		}
		else {
			System.out.println("El string " + a + " es mayor que " + b);
		}

		Figura[] figuras =new Figura[3];
		figuras[0]=new Rectangulo();
		figuras[1]=new Cuadrado(); //Casting de cuadrado a figura
		figuras[2]=new Caja();	

		for(int i=0;i<figuras.length;i++){
			System.out.println(figuras[i]);
			System.out.println("Perimetro: "+figuras[i].perimetro());
			System.out.println("Area: "+figuras[i].area());
			System.out.println("Volumen: "+figuras[i].volumen());
			System.out.println();
			if(figuras[i] instanceof Cuadrado){ //Si el metodo posición i esta lleno de un Cuadrado, llama .saluda()
				((Cuadrado)figuras[i]).saluda(); //(Cuadrado) hace que lo vea como un cuadrado, se llama "Downcasting"
			}
		}
	}	
}
