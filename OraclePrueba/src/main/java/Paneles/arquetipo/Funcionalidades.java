package Paneles.arquetipo;

import java.awt.Component;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

import Paneles.MensajeEmergente;
import Pruebas.Main;
import modeloHce.Plantilla;
import modeloHce.PlantillaArquetipo;
import modeloHce.Arquetipo;

public class Funcionalidades {
	
	public static JComboBox<Plantilla> actualizarPlantilla(JComboBox<Plantilla> jComboBox, List<Plantilla> lista){
		ComboBoxModel<Plantilla> modelo = new DefaultComboBoxModel<>(lista.toArray(new Plantilla[lista.size()]));
		
		jComboBox.setModel(modelo);
		jComboBox.setRenderer(new ListCellRenderer<Plantilla>() {
		    @Override
		    public Component getListCellRendererComponent(JList<? extends Plantilla> list, Plantilla value, int index, boolean isSelected, boolean cellHasFocus) {
		        JLabel label = new JLabel(value.getId() + " " + value.getDescripcion()); // aquí se muestra el nombre de la plantilla
		        if (isSelected) {
		            label.setBackground(list.getSelectionBackground());
		            label.setForeground(list.getSelectionForeground());
		        } else {
		            label.setBackground(list.getBackground());
		            label.setForeground(list.getForeground());
		        }
		        return label;
		    }
		});
		
		return jComboBox;
	}
	
	public static JComboBox<Arquetipo> actualizarArquetipo(JComboBox<Arquetipo> jComboBox, List<Arquetipo> lista){
		ComboBoxModel<Arquetipo> modelo = new DefaultComboBoxModel<>(lista.toArray(new Arquetipo[lista.size()]));
		
		jComboBox.setModel(modelo);
		jComboBox.setRenderer(new ListCellRenderer<Arquetipo>() {
		    @Override
		    public Component getListCellRendererComponent(JList<? extends Arquetipo> list, Arquetipo value, int index, boolean isSelected, boolean cellHasFocus) {
		        JLabel label = new JLabel(value.getId() + " " + value.getDescripcion()); // aquí se muestra el nombre de la plantilla
		        if (isSelected) {
		            label.setBackground(list.getSelectionBackground());
		            label.setForeground(list.getSelectionForeground());
		        } else {
		            label.setBackground(list.getBackground());
		            label.setForeground(list.getForeground());
		        }
		        return label;
		    }
		});
		
		return jComboBox;
	}
}
