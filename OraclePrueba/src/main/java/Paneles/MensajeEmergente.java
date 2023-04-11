package Paneles;

import javax.swing.JOptionPane;

public class MensajeEmergente {
	
	public MensajeEmergente(int numero) {
		switch (numero) {
		case 0:
			JOptionPane.showMessageDialog(null, "El id es un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		case 1:
			JOptionPane.showMessageDialog(null, "El id existe", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		case 2:
			JOptionPane.showMessageDialog(null, "Debes Asignarle una plantilla", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		case 3:
			JOptionPane.showMessageDialog(null, "Este nombre no pertenence a ninguna Plantilla", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		case 4:
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
			return;
		case 5:
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
			return;
		case 6:
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
			return;
		case 7:
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
			return;
		case 8:
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
			return;

		default:
			return;
		}
	}
}
