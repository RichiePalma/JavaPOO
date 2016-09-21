public class ZonaHoraria{
	private Clock[] zonaHorarias;

	public ZonaHoraria(){
		this.zonaHorarias=new Clock[10];
	}

	public void ponerHora(int pos, int hr, int min, int sec, String cd){
		if(this.zonaHorarias[pos]==null){
			this.zonaHorarias[pos]=new Clock(hr,min,sec,cd);
		}
		else{
			this.zonaHorarias[pos].setTime(hr,min,sec);
			this.zonaHorarias[pos].setCiudad(cd);
		}
	}

	public String toString(){
		String resultado="";
		for(int i=0;i<this.zonaHorarias.length;i++){
			if(this.zonaHorarias[i]!=null){
				resultado+=this.zonaHorarias[i]+"\n";
			}
		}
		return resultado;
	}

	public void cambiarHorarioInvierno(){
		for(int i=0;i<this.zonaHorarias.length;i++){
			if(this.zonaHorarias[i]!=null){
				this.zonaHorarias[i].incrementHours();
			}
		}	
	}

	public static void main(String[] args){
		/*Clock reloj=new Clock(5,8,40,"Zapopan");
		System.out.println(reloj);*/
		

		ZonaHoraria zh=new ZonaHoraria();
		zh.ponerHora(0,10,26,30,"NY");
		zh.ponerHora(1,16,26,30,"Paris");
		zh.ponerHora(2,17,26,30,"Moscu");
		System.out.println(zh);
		
		zh.cambiarHorarioInvierno();
		System.out.println("----Cambiamos a horario de invierno----");
		System.out.println(zh);	
	}
}