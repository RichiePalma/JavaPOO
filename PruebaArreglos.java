public class PruebaArreglos{
	public int suma(int[] arreglo){
		int res=0;//Un recolector
		for(int i=0;i<arreglo.length;i++){ //Pasa por todas las posiciónes del arreglo
			res+=arreglo[i];
		}
		return res;
	}

	public int maximo(int[] arreglo){
		int max = arreglo[0];  //Si pones 0 cuando la lista sea de negativos 0 sera el mayor aunque no este en la lista
		for(int i=0;i<arreglo.length;i++){
			if(max<arreglo[i]){
				max=arreglo[i];
			}
		}
		return max;	
	}

	public void imprime(String[][] valores){
		for(int i=0; i<valores.length; i++){
			for(int j=0; j<valores[i].length; j++){ 
				System.out.print(valores[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		PruebaArreglos obj=new PruebaArreglos();
		int filas=Integer.parseInt(args[0]);
		int columnas=Integer.parseInt(args[1]);
		int c=2; //0 y 1 es para definir columnas y filas 2 en adelante son argumentos
		String[][] palabras2=new String[filas][columnas];
		for(int i=0; i<filas; i++){
			for(int j=0; j<columnas; j++){
				palabras2[i][j]=args[c++];
			}
		}
		obj.imprime(palabras2);
		System.out.println();

		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
		String[][] palabras={{"a","b","c"},{"d","e"},{"f"},{"g","h","i","j","k","l"}};
		obj.imprime(palabras);
		
	}

	//Terminar los metodos minimo & promedio
}