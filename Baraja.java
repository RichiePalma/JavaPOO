import java.util.*; //Para el metodo mezclar()

public class Baraja{
	private Naipe[] cartas; //Creo el arreglo

	public Baraja(){
		cartas = new Naipe[52]; //Definir el tamaño del arrego
		int c=0;
		for(int i=0; i<4;i++){
			for(int j=0; j<13;j++){
				this.cartas[c++]=new Naipe(j,i); //c++ guarda en la posicion 0 un naipe 0,1 en posicion c=1 guarda otro naipe y asi
			}
		}
	}

	public void mezclar(){ //Mezcla la baraja, "barajea"
		Random rdm=new Random();
		Naipe tmp; //variable temporal, un placeholder
		int iRdm=rdm.nextInt(52);
		for(int i=0;i<this.cartas.length;i++){
			iRdm=rdm.nextInt(52);
			tmp=this.cartas[i];
			this.cartas[i]=this.cartas[iRdm];
			this.cartas[iRdm]=tmp;
		}
	}

	public String toString(){
		String resultado="";
		for(int i=0;i<this.cartas.length;i++){
			resultado+=this.cartas[i] + "\n";
		}
//toString tambien se manda a llamar cuando se quiere concatenar con el de la clase que se creo
		return resultado;
	}
}