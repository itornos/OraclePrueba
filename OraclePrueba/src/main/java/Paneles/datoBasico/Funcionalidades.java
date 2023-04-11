package Paneles.datoBasico;

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
import modeloHce.TipoDatoBasico;
import modeloHce.Arquetipo;

public class Funcionalidades {
	
	public static JComboBox<TipoDatoBasico> actualizarTipoDatBasico(JComboBox<TipoDatoBasico> jComboBox, List<TipoDatoBasico> lista){
		ComboBoxModel<TipoDatoBasico> modelo = new DefaultComboBoxModel<>(lista.toArray(new TipoDatoBasico[lista.size()]));
		
		jComboBox.setModel(modelo);
		jComboBox.setRenderer(new ListCellRenderer<TipoDatoBasico>() {
		    @Override
		    public Component getListCellRendererComponent(JList<? extends TipoDatoBasico> list, TipoDatoBasico value, int index, boolean isSelected, boolean cellHasFocus) {
		        JLabel label = new JLabel(value.getId() + " " + value.getDescripcion());
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
