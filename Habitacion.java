public class Habitacion{
	private int numero, //Num. Habitacion
		adultos, // Cant. Adultos en habitacon
		infantes; // Cant. Niños en habitacion

	//private static final String[] sCuarto={"100","101","102","103","104","105","106","107","108","109","110"};

	private String nombre; // Nombre del huesped

	private double credito, //Voucher abierto
		cargo, // Cargos adicionales
		tarifaB;
		//cargototal;

	private boolean disponible; //¿Libre o no?


	public Habitacion(int numero){
		this.numero=numero;
		this.disponible=true; 
	}

	public int getNumero(){
		return this.numero;
	}

	public boolean getDisponible(){
		return this.disponible;
	}

	public void checkin(String nombre, int adultos, int infantes, double credito){ 
		this.nombre=nombre;
		this.adultos=adultos;
		this.infantes=infantes;
		this.credito=credito;
		this.disponible=false;
	}

	public boolean checkout(String nombre, int adultos, int infantes, double credito){
		if(this.disponible==false){
			this.nombre=null;
			this.adultos=0;
			this.infantes=0;
			this.credito=0;
			this.cargo=0;
			this.disponible=true;
			this.tarifaB=0;
			return true;
		}
		else{
			return false;
		}
	}

	public double getTarifaBase(){
		this.tarifaB= (this.adultos*350.00) + (this.infantes*100.00);
		return this.tarifaB;
	}

	public boolean cargar(double cargo){

		if(cargo>0&&this.cargo<this.credito){
			this.cargo=cargo + this.tarifaB;
			return true;
		}
		else{
			return false;
		}
		/*if(this.cargo<0){
			//double cargototal= this.tarifaB + this.cargo;
			if(cargototal > this.credito){
				return false;
			}
			else{
				double cargototal= this.tarifaB + this.cargo;
				return true;
			}
		}
		else{
			return false;
		}*/
	}

	public String toString(){
		return "Habitacion:"+ this.numero+ ", Huesped:"+this.nombre+",Tarifa Base:"+this.tarifaB+",Credito:"+this.credito+",Cargos:"+this.cargo;
	}
// Main creado para hacer testing del objeto
/*
	public static void main(String[] args){
		Habitacion uno = new Habitacion(1);
		Habitacion dos = new Habitacion(2);
		Habitacion tres = new Habitacion(3);

		//uno.checkout();
		uno.checkin("Ricardo",3,5,5000.00);
		uno.getTarifaBase();
		uno.cargar(500.00);

		//dos.checkin("David",4,2,5600.00);
		//dos.getTarifaBase();
		//dos.cargar(600.00);

		//tres.checkin("Alex",1,4,7000.00);
		//tres.getTarifaBase();
		//tres.cargar(900.00);

		System.out.println(uno);
		//System.out.println(dos);
		//System.out.println(tres);
	}*/

}