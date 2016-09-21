public class Clock{
	private int hr,
		min,
		sec;

	private String cd;

	public Clock(){  //Empieza desde las 12:00:00

/* 	
	this.Clock(12,0,0);
	Clock(12,0,0);
	No funcionara por la sintaxis
*/

		this(12,0,0,"Guadalajara"); //Solamente cuando un constructor llama a otro constructor
//Tiene que ser la primer linea siempre!
		/*hr=12;
		min=0;
		sec=0;*/
	}

	public Clock(int hr,int min,int sec,String cd){
		setTime(hr,min,sec);
		this.cd=cd;
	}

	public void setCiudad(String cd){
		this.cd=cd;
	}

	public void setTime(int hr, int min, int sec){
		if(hr>=0 && hr<24){
			this.hr=hr;
//This hace referencia al atributo de un objeto para poder ser capaz de modificarlo
		}
		else{
			this.hr=12;
		}

		if(min>=0 && min<60){ //Aqui no porque lo que deseas
//checar es el parametro y no los atributos. 
			this.min=min;
		}
		else{
			this.min=0;
		}

		if(sec>=0 && sec<60){
			this.sec=sec;
		}
		else{
			this.sec=0;
		}

	}

	public int getHours(){
		return this.hr;
	}
	
	public int getMinutes(){
		return this.min;
	}

	public int getSeconds(){
		return this.sec;
	}

	public String getCiudad(){
		return this.cd;
	}

	public void incrementHours(){

/* Lo que debe de hacer el metodo es incrementar la hora en una unidad 
	al mandarlo a llamar
*/
		//this.hr=(this.hr++)%24; La hora que tenia la incremento en 1
// El modulo puede servir para poner un rango entre 0 y n-1

		if(this.hr<23){
			this.hr++;
		}
		else{
			this.hr=0;
		}
	}

	public void incrementMinutes(){
		if(this.min<59){
			this.min++;
		}
		else{
			this.min=0;
			this.incrementHours();
		}
	}

	public void incrementSeconds(){
		if(this.sec<59){
			this.sec++;
		}
		else{
			this.sec=0;
			this.incrementMinutes();
		}
	}

	public void printTime(){
		System.out.println(this.cd+" "+this.hr+":"+this.min+":"+this.sec);
	}

	public String toString(){
		return this.cd+" "+this.hr+":"+this.min+":"+this.sec;
	}

	public boolean equals(Clock reloj){ //Recibe un Clock de parametro
		return this.hr==reloj.hr && this.min==reloj.min && this.sec==reloj.sec;
//No es necesario un if porque un boolean por predeterminado regresa false
	//Automaticamente regresa true cuando sue cumplen las 3 condiciones
			
	}
	
	public void makeCopy(Clock reloj){
		this.hr=reloj.hr;
		this.min=reloj.min;
		this.sec=reloj.sec;
		//this.cd=reloj.cd;

		//this.setTime(reloj.hr,reloj.min,reloj.sec,reloj.cd); otra manera de hacerlo 
	}

	public Clock getCopy(){
		return new Clock(this.hr,this.min,this.sec,this.cd);
	}
}