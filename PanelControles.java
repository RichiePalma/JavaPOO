import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import java.swing.* para que te importe todo lo de swing igual .awt.* para lo de awt
public class PanelControles extends JPanel implements ActionListener, MouseListener, ChangeListener{
	private JTextField tfNombre; //Por convención en el nombre de una varianle text field que empieze con tf
	private JButton bAceptar, //Lo mismo en Button
	bCambiarColor,
	bCambiarNombreArchivo;

	private JRadioButton rbRojo,
	rbVerde,
	rbAzul;

	private MyPanel pd; 

	private JPanel panelColor;
	private JSlider slider;

	private JFileChooser jfc;
	
	public PanelControles(MyPanel pd){ //Aqui recibo referencia
		super();
		this.setPreferredSize(new Dimension(150,600));
		this.pd=pd; //Guardo referencia
		this.tfNombre=new JTextField(10);
		this.bAceptar=new JButton("Aceptar");
		this.bAceptar.addActionListener(this); //Recibe un ActionListener lo cual es una interface, tiene solo un metodo "Action Perform"

		this.rbRojo=new JRadioButton("Color Rojo");
		this.rbRojo.setSelected(true); //Por defaul esta seleccionado
		this.rbVerde=new JRadioButton("Color Verde");
		this.rbAzul=new JRadioButton("Color Azul");

		this.panelColor=new JPanel();
		this.panelColor.setPreferredSize(new Dimension(100,100));
		this.panelColor.setBackground(Color.BLUE);
		this.panelColor.addMouseListener(this);

		this.slider=new JSlider(JSlider.VERTICAL,0,500,0); //(Hor o vert, menor, mayor, valor seleccionado default)
		this.slider.setMajorTickSpacing(100); //Cada cuando quiero que se dibuje una linea
		this.slider.setMinorTickSpacing(20); //Poner rayas mas chicas cada cuanto
		this.slider.setPaintTicks(true); //Que sea verdad que se pinte una linea
		this.slider.setPaintLabels(true); //Pone etiquetas
		this.slider.addChangeListener(this); //Cuando cambie que me avise

		ButtonGroup bg=new ButtonGroup(); //Crear un grupo de botones de radio para que no se pueda dar más de un boton al mismo tiempo
		bg.add(this.rbRojo);
		bg.add(this.rbVerde);
		bg.add(this.rbAzul);

		this.bCambiarColor=new JButton("Cambiar color");
		this.bCambiarColor.addActionListener(this);

		this.bCambiarNombreArchivo=new JButton("Cambiar desde archivo");
		this.bCambiarNombreArchivo.addActionListener(this);
		this.jfc=new JFileChooser();

		this.add(this.tfNombre);
		this.add(this.bAceptar);

		this.add(this.rbRojo);
		this.add(this.rbVerde);
		this.add(this.rbAzul);

		this.add(this.bCambiarColor);
		this.add(this.panelColor);
		this.add(this.slider);
		this.add(this.bCambiarNombreArchivo);

	}
	//En un panel se usa FlowLayout el cual acomoda donde quepa respetando los tamaños analizando si caben en la misma fila si no en la siguiente
	@Override 
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.bAceptar){ //.getSource = ¿Que elemento genero el evento?
			this.pd.setNombre(this.tfNombre.getText());
		}
		else if(e.getSource()==this.bCambiarNombreArchivo){
			try{
				int resultado=this.jfc.showOpenDialog(this.pd);
				if (resultado==this.jfc.APPROVE_OPTION){
					//System.out.println(this.jfc.getSelectedFile().toString()); //Aqui solo imprime ruta del archivo
					String archivo=this.jfc.getSelectedFile().toString();
					BufferedReader bf=new BufferedReader(new FileReader(archivo));
					this.pd.setNombre(bf.readLine());
					bf.close();
				}
				else{
					System.out.print("Se cancelo la apertura de archivo");
				}
			}catch(IOException ex){
				System.out.println(ex);
			}

		}
		else{
			Color fondo; 
			if(this.rbRojo.isSelected()){ //Si el boton rojo esta selecciónado
				fondo=Color.RED;
			}
			else if(this.rbVerde.isSelected()){
				fondo=Color.GREEN;
			}
			else{
				fondo=Color.BLUE;
			}
			this.setBackground(fondo);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Color fondo=JColorChooser.showDialog(this.pd, "Selecciona un color de fondo", Color.BLUE); //( , Mensaje en la ventana, color predeterminado)
		this.panelColor.setBackground(fondo);
		this.pd.setBackground(fondo);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void stateChanged(ChangeEvent arg0) { //Cada vez que mueva la palanca se ejecuta...
		this.pd.setY(this.slider.getValue());
	}
}
