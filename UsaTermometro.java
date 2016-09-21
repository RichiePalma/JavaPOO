public class UsaTermometro{
	public static void main(String[] args){
		Termometro a=new Termometro();
		Termometro b=new Termometro(25.0);

		System.out.println("La temperatura de a es "+a.getTemp());
		System.out.println("La temperatura de b es "+b.getTemp());
	}
}