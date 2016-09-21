/* Una clase llamada Termómetro con el atributo Temperatura
	Metodos Costructor default, Constructor con Parametro
	setTemp (Modifica un atributo)
 	getTemp (Revisa un atributo)
*/

public class Termometro implements Comparable{
	private double temp;     //Declaramos atributo, por defaul declaralo siempre privato y los metodos publicos
	
	public Termometro(){ 	//Constructores mismo valor que la clase y no tiene valor de retorno
		temp=20.0;     //Declaras los atributos default
	}

	public Termometro(double t){ 	//Este constructor recibe un valor double
		temp=t;
	}
	
	public void setTemp(double t){		//No es constructor porque tiene void
		temp=t;
	}
	
	public double getTemp(){		//Aqui no recibe parametro porque seria como preguntarle a Luis su nombre, o decir bajar abajo.
		return temp;
	}

	public int compareTo(Object a){
		Termometro tmp=(Termometro)a;
		return (int)(this.temp-tmp.temp);
	}

	public static void main(String[] args){
		Termometro a=new Termometro();
		Termometro b=new Termometro(30.5);
		a.compareTo(b);
	}
}