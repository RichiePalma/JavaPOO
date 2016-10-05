
public class MyException extends Exception{
//Para crear una exception se tiene que heredar de una ya existente
	//RunTime es atribuible al programador lo demas al usuario
	public MyException(){
		super("Error tipo MyException");
	}
	
	public MyException(String msj){
		super(msj);
	}
}
