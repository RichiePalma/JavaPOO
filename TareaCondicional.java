import javax.swing.*;

public class TareaCondicional{
	public static void main(String[] args){
		String tabulador =JOptionPane.showInputDialog("Sueldo por hora");
		String horas =JOptionPane.showInputDialog("Horas semanales");
		Double semanales = Double.valueOf(tabulador) * Double.valueOf(horas);
		Double totalsemanal = semanales - semanales*0.08;
		Double totalsemanal2 = semanales - semanales*0.15;
		Double totalsemanal3 = semanales - semanales*0.23;
		Double totalsemanal4 = semanales - semanales*0.30;
		if(semanales <= 5000)
			System.out.println("Tu sueldo semanal total es de: $"+totalsemanal);
		if(semanales > 5000 && semanales <= 10000)
			System.out.println("Tu sueldo semanal total es de: $"+totalsemanal2);
		if(semanales > 10000 && semanales <= 17000)
			System.out.println("Tu sueldo semanal total es de: $"+totalsemanal3);
		if(semanales > 17000)
			System.out.println("Tu sueldo semanal total es de: $"+totalsemanal4);
	}
}

//Ricardo Palma A01226922
