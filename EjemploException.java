
public class EjemploException {
	
	public void metodoD() throws MyException{
		throw new MyException("Ocurrio error en método D");
	}
	
	public void metodoC() throws MyException{
		metodoD();
	}
	
	public void metodoB()throws MyException{
		metodoC();
	}
	
	public void metodoA()throws MyException{
		metodoB();
	}

	public static void main(String[] args){
		try{
			EjemploException a=new EjemploException();
			a.metodoA();
		}catch(MyException e){
			System.out.println("Ocurrio error "+e);
		}
	}
}
