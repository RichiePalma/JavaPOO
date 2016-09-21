public class UsaClock{
	public static void main(String[] args){
		Clock a=new Clock();
		Clock b=new Clock(23,59,59);
		
		a.printTime();
		b.printTime();

		a.setTime(13,10,15);
		b.incrementSeconds();

		a.printTime();
		b.printTime();

		boolean iguales=a.equals(b); //Regresa True or False
//Recibe un Clock b y manda a llamar reloj a
		System.out.println(a.equals(b));

		b.makeCopy(a); //b tiene hora de a en lugar de un set
		iguales=a.equals(b);
		System.out.println(iguales);

		Clock c=a.getCopy();
//Todavia no esta declarado c
//Pero crea otro objeto diferente a "a" pero con sus mismos valores.
	}
}