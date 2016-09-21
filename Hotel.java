
public class Hotel{
	private String nombreHotel;
	private Habitacion[] cuartos;
	private int habitaciones;

	public Hotel(String nombreHotel,int habitaciones){
		this.cuartos=new Habitacion[habitaciones];
		for(int i=0;i<habitaciones;i++){
			this.cuartos[i]=new Habitacion(i+100);
			
		}
		this.nombreHotel=nombreHotel;
	}

	public int checkin(String nombre, int adultos, int infantes, double credito){
		for(int i=0; i<this.cuartos.length;i++){
			if(this.cuartos[i].getDisponible()){
				this.cuartos[i].checkin(nombre,adultos,infantes,credito);
				return i+100;
			}
		}
		return -1;
	}

	public boolean ckeckout(int num){
		if(num>=100&&num<=this.habitaciones+100){//BETA arreglo.length
			return true;
		}
		else{
			return false;
		}
	}

	public double getTotalXTarifaBase(){
		double totalDia=0;
		for(int i=0;i<this.cuartos.length; i++){
			if(this.cuartos[i].getDisponible()){
				totalDia+= this.cuartos[i].getTarifaBase();
			}
		}
		return totalDia;
	}

	public boolean realizarCargosHabitacion(int numero, double cargo){
		if(numero>=100&&numero<=this.habitaciones+100){
			if(!cuartos[numero-100].getDisponible()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

/*	public String toString(){
		for(int i=0;i<this.cuartos.length;i++){
			return "Huesped:"+this.nombre+",Tarifa Base:"+this.tarifaB+",Credito:"+this.credito+",Cargos:"+this.cargo;
		}
	}*/

	public void imprimeOcupacion(){
		System.out.println("Ocupacion en" + this.nombreHotel);
		System.out.println(this);
		/*for(int i=0;i<this.cuartos.length;i++){
			if(!cuartos[i].getDisponible()){
				System.out.println(cuartos[i]);*/
			//}
		//}
	}

	public static void main(String[] args){
		Hotel POO = new Hotel("POO",10);
		POO.checkin("Salinas",3,2,5000);
		POO.imprimeOcupacion();
	}
}