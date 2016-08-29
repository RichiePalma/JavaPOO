/* Ricardo Daniel Palma Mendoza A01226922
	Clase: Libro
	Fecha: 21/08/2016
*/ 

public class Libro{
	public static void main(String[] args){
		Libro miLibro=new Libro();
		miLibro.titulo= "Ensayo sobre la ceguera";
		miLibro.autor="José Saramago";
		miLibro.editorial="Alfaguara";
		miLibro.isbn="9789724212470";
		
		System.out.println(miLibro.titulo);
		System.out.println(miLibro.autor);
		System.out.println(miLibro.editorial);
		System.out.println(miLibro.isbn);
	}
	
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;

	public Libro(){ //Valores default
		titulo="Un asesino solitario";
		autor="Élmer Mendoza";
		editorial="Tusquets";
		isbn="9789706990433";
		
	}

	public Libro(String t){ //Valores default
		titulo=t;
		autor=t;
		editorial=t;
		isbn=t;
	}
	
	public void setTitulo(String t){
		titulo=t;
	}

	public void setAutor(String t){
		autor=t;
	}

	public void setEditorial(String t){
		editorial=t;
	}

	public void setIsbn(String t){
		isbn=t;
	}

	public String getTitulo(){
		return titulo;
	}

	public String getAutor(){
		return autor;
	}

	public String getEditorial(){
		return editorial;
	}

	public String getIsbn(){
		return isbn;
	}
}
