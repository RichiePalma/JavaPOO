public class Naipe{
	private int valor, //0-> As, 1->2.... 	0-> J, 11->8, 12->K
		palo; //0-> Espadas, 1->corazones 2-> tréboles, 3-> diamantes

	private static final String[] sValor={"as","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez","joto","reina","rey"};
	private static final String[] sPalo={"espadas","corazones","treboles","diamantes"}; //Con final se crea una constante que SIEMPRE sea ese valor

	public Naipe(int valor, int palo){
		this.valor=valor;
		this.palo=palo;
	}

	public String toString(){  //Este metodo tiene que regresar un String de a fuerza y se tiene que respetar estructura como toString para que lo llame auto
		return this.sValor[this.valor]+ " de " +this.sPalo[this.palo];
	}

//toString es el valor que regresa de predeterminado al imprimir un objeto directamente en este caso imprime nombreObjeto@IDlugarguardadoenmemoria

	public static void main(String[] args){
		Baraja baraja=new Baraja();
		System.out.println(baraja);

		System.out.println("----------------Se Mezclan las Cartas------------------");
		baraja.mezclar();
		System.out.println(baraja);

/*
		Naipe cincoEspadas=new Naipe(4,0);
		System.out.println(cincoEspadas); //Asi llamas automaticamente al toString, eso pasa si pones el puro nombre sin .otroNombre()

		Naipe reyCorazones=new Naipe(12,1);
		System.out.println(reyCorazones);
*/
	}
}