package Paneles.arquetipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Paneles.MensajeEmergente;
import Pruebas.Main;
import modeloHce.Arquetipo;
import modeloHce.Plantilla;
import modeloHce.PlantillaArquetipo;

public class Insertar extends JPanel {

	private JButton boton;
	private JTextField buscador;
	private JButton buscador_Boton;
	private JLabel idArquetipo_Label;
	private JTextField idArquetipo_Text;
	private JLabel idPlantilla_Label;
	private JLabel buscador_Text;
	private JLabel nombre_Label;
	private JTextField nombre_Text;
	private JComboBox<String> tipoBusqueda;
	private JComboBox<Plantilla> idPlantilla_final;
	
	private HashMap<Double, Plantilla> plantillaSelect;

	public Insertar() {
		super();
		idArquetipo_Label = new JLabel();
		idArquetipo_Text = new JTextField();
		nombre_Label = new JLabel();
		nombre_Text = new JTextField();
		boton = new JButton();
		buscador = new JTextField();
		buscador_Boton = new JButton();
		buscador_Text = new JLabel();
		tipoBusqueda = new JComboBox<>();
		idPlantilla_Label = new JLabel();
		idPlantilla_final = new JComboBox<>();
		plantillaSelect = new HashMap<>();
		initComponents();
	}
	
	
	private void Buscador_ActionPerformed(java.awt.event.ActionEvent evt) {
		List<Plantilla> listaPlantillas = new ArrayList<>();
		
		String busqueda = (String) tipoBusqueda.getSelectedItem();
		
		if(busqueda.equals("id_plantilla")) {
			Plantilla prueba = null;
			Double id;
			
			try {
				id = Double.parseDouble(buscador.getText());
			} catch (Exception e) {
				new MensajeEmergente(0);
				return;
			}
			
			if((prueba = Main.plantillaImplementacion.readId(id)) == null){
				new MensajeEmergente(1);
				return;
			}
			
			listaPlantillas.add(prueba);
			
		}else if(busqueda.equals("nombre")) {
			String id = buscador.getText();
			listaPlantillas = Main.plantillaImplementacion.read(id, "nombre");
			
			if(listaPlantillas.size() == 0){
				new MensajeEmergente(3);
				return;
			}
		}
		
		plantillaSelect = new HashMap<>();
		for (Plantilla plantilla : listaPlantillas) {
			plantillaSelect.put(plantilla.getId(), plantilla);
		}
		
		idPlantilla_final = Funcionalidades.actualizarPlantilla(idPlantilla_final,listaPlantillas);
	}
	

	private void Insertar_ActionPerformed(java.awt.event.ActionEvent evt) {
		Double idArquetipo = Double.parseDouble(idArquetipo_Text.getText());
		String nombre = nombre_Text.getText();
		
		if(Main.arquetipoImplementacion.read(idArquetipo) != null) {
			new MensajeEmergente(1);
			return;
		}
		
		if(plantillaSelect.size() == 0) {
			new MensajeEmergente(2);
			return;
		}
			
		Arquetipo arquetipo = new Arquetipo(idArquetipo,nombre);
		
		PlantillaArquetipo arquetipoPlantilla = new PlantillaArquetipo((Plantilla)idPlantilla_final.getSelectedItem(), arquetipo , Main.arquetipoPlantillaImplementacion.getLast());		
		arquetipo.annadirArqPlant(arquetipoPlantilla);
		
		Main.arquetipoImplementacion.create(arquetipo);
	}

	
	private void initComponents() {
		idArquetipo_Label.setText("ID_Arquetipo");
		nombre_Label.setText("Nombre");
		buscador_Text.setText("Buscar plantilla");
		idPlantilla_Label.setText("ID_Plantilla");
		
		buscador_Text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		
		boton.setText("INSERTAR");
		boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Insertar_ActionPerformed(evt);
			}
		});
		
		buscador_Boton.setText("BUSCAR");
		buscador_Boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Buscador_ActionPerformed(evt);
			}
		});

		tipoBusqueda.setModel(
				new DefaultComboBoxModel<>(new String[] { "id_plantilla", "nombre" }));


		GroupLayout arquetipo_InsertarLayout = new GroupLayout(this);
		this.setLayout(arquetipo_InsertarLayout);
		arquetipo_InsertarLayout.setHorizontalGroup(
	            arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                        .addComponent(buscador_Text, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(tipoBusqueda, 0, 133, Short.MAX_VALUE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(buscador, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(buscador_Boton)
	                        .addGap(21, 21, 21))
	                    .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                        .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
	                                .addComponent(nombre_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(idArquetipo_Label))
	                            .addComponent(idPlantilla_Label))
	                        .addGap(40, 40, 40)
	                        .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                .addComponent(idArquetipo_Text, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                                .addComponent(nombre_Text, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                            .addComponent(idPlantilla_final, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                        .addGap(0, 0, Short.MAX_VALUE))))
	            .addGroup(GroupLayout.Alignment.TRAILING, arquetipo_InsertarLayout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(boton)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        arquetipo_InsertarLayout.setVerticalGroup(
	            arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(buscador_Text, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(buscador, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(buscador_Boton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(tipoBusqueda, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
	                .addGap(9, 9, 9)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(idPlantilla_Label)
	                    .addComponent(idPlantilla_final))
	                .addGap(18, 18, 18)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(idArquetipo_Label)
	                    .addComponent(idArquetipo_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(nombre_Label)
	                    .addComponent(nombre_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(126, 126, 126)
	                .addComponent(boton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	}
}
