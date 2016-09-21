public class EjemploStatic{
	private static int x;
	private int y;

	public int getY(){
		return this.y;
	}
	public static int getX(){
		return EjemploStatic.x;
	}
	
	public static void main(String[] args){
		EjemploStatic.x=10000;
		EjemploStatic.getX();

		EjemploStatic obj=new EjemploStatic();
		EjemploStatic obj2=new EjemploStatic();

		EjemploStatic.x=10;
		EjemploStatic.x=20;

		obj.getY();
		obj.y=30;
		obj2.y=40;

		System.out.println(EjemploStatic); //Imprimira 20 por que x fue modificado de 10 a 20 al ultimo por obj2.x
		System.out.println(obj.y);
		System.out.println(EjemploStatic);
		System.out.println(obj2.y);

//Los atributos de clase (Static) que los mande a llamar el nombre de la clase los de instancia el objeto por convension EjemploStatic.x
//Default que no sea un static
//Static se usa para constantes, Si el metodo no accede a un atributo
	}
}