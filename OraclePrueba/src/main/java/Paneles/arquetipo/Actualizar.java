package Paneles.arquetipo;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Paneles.MensajeEmergente;
import Pruebas.Main;
import modeloHce.Arquetipo;
import modeloHce.Plantilla;
import modeloHce.PlantillaArquetipo;


public class Actualizar extends JPanel{
	
	private JLabel idplantilla_Label;
	private JComboBox<Plantilla> idPlantilla_selector;
	private JLabel idArquetipo_Label;
	private JComboBox<Arquetipo> idArquetipo_selector;
	private JButton boton_Actualizar;
	private JLabel nombre_Label;
	private JTextField nombre_Text;
	private JLabel busqueda;
	private JTextField buscador_Text;
	private JComboBox<String> selector;
	private JButton boton_Busacdor;

	private JButton botonPlantilla;
	private JButton botonArquetipo;
	
	private void Boton_BusacdorActionPerformed(java.awt.event.ActionEvent evt) {
		List<Plantilla> listaPlantillas = new ArrayList<>();
		List<Arquetipo> listaArquetipos = new ArrayList<>();
		
		String busqueda = (String) selector.getSelectedItem();
		
		if(busqueda.equals("id_plantilla")) {
			Plantilla prueba = null;
			Double id;
			
			try {
				id = Double.parseDouble(buscador_Text.getText());
			} catch (Exception e) {
				new MensajeEmergente(0);
				return;
			}
			
			if((prueba = Main.plantillaImplementacion.read(id)) == null){
				new MensajeEmergente(1);
				return;
			}
			
			listaPlantillas.add(prueba);
			
			for (PlantillaArquetipo plantillaArquetipo : prueba.getArquetipoPlantilla()) {
				listaArquetipos.add(plantillaArquetipo.getArquetipo());
			}
			
			Main.plantillaImplementacion.reset();
			
		}else if(busqueda.equals("id_arquetipo")) {
			
			Arquetipo prueba = null;
			Double id;
			
			try {
				id = Double.parseDouble(buscador_Text.getText());
			} catch (Exception e) {
				new MensajeEmergente(0);
				return;
			}
			
			if((prueba = Main.arquetipoImplementacion.read(id)) == null){
				new MensajeEmergente(1);
				return;
			}
			
			listaArquetipos.add(prueba);
			
			for (PlantillaArquetipo plantillaArquetipo : prueba.getArquetipoPlantilla()) {
				listaPlantillas.add(plantillaArquetipo.getPlantilla());
			}
			
			Main.arquetipoImplementacion.reset();
		}
		
		if(listaPlantillas.size() != 0) {
			idPlantilla_selector = Funcionalidades.actualizarPlantilla(idPlantilla_selector,listaPlantillas);
		}
	
		if(listaArquetipos.size() != 0) {
			idArquetipo_selector = Funcionalidades.actualizarArquetipo(idArquetipo_selector,listaArquetipos);
		}
	}
	
	private void Boton_ActualizarActionPerformed(ActionEvent evt) {
		Arquetipo arquetipo = (Arquetipo) idArquetipo_selector.getSelectedItem();
		arquetipo.setNombre(nombre_Text.getText());
		
		Main.arquetipoImplementacion.update(arquetipo);	
	}
	
	private void actualizarPlantilla(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Double currentArquetipo = ((Arquetipo) idArquetipo_selector.getSelectedItem()).getId();
			List<Arquetipo> listaArquetipos = new ArrayList<>();
			
			Plantilla plantilla = Main.plantillaImplementacion.read(((Plantilla) idPlantilla_selector.getSelectedItem()).getId());
			
			for (PlantillaArquetipo plantillaArquetipo : plantilla.getArquetipoPlantilla()) {
				listaArquetipos.add(plantillaArquetipo.getArquetipo());
			}
			
			idArquetipo_selector = Funcionalidades.actualizarArquetipo(idArquetipo_selector,listaArquetipos);
			
			Main.plantillaImplementacion.reset();
			
			for (int i = 0; i < idArquetipo_selector.getModel().getSize(); i++) {
			    if(idArquetipo_selector.getModel().getElementAt(i).getId() == currentArquetipo) {
			    	idArquetipo_selector.setSelectedIndex(i);
			    	break;
			    }
			}
		}
	}
	
	private void actualizarArquetipo(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Double currentPlantilla = ((Plantilla) idPlantilla_selector.getSelectedItem()).getId();
			List<Plantilla> listaArquetipos = new ArrayList<>();
			
			Arquetipo arquetipo = Main.arquetipoImplementacion.read(((Arquetipo) idArquetipo_selector.getSelectedItem()).getId());
			
			for (PlantillaArquetipo plantillaArquetipo : arquetipo.getArquetipoPlantilla()) {
				listaArquetipos.add(plantillaArquetipo.getPlantilla());
			}
			
			idPlantilla_selector = Funcionalidades.actualizarPlantilla(idPlantilla_selector,listaArquetipos);
        
			Main.arquetipoImplementacion.reset();
			
			for (int i = 0; i < idPlantilla_selector.getModel().getSize(); i++) {
			    if(idPlantilla_selector.getModel().getElementAt(i).getId() == currentPlantilla) {
			    	idPlantilla_selector.setSelectedIndex(i);
			    	break;
			    }
			}
            nombre_Text.setText(arquetipo.getNombre());
        }
	}
	

	public Actualizar() {
		super();
		
		botonArquetipo = new JButton();
		botonArquetipo.setMargin(new java.awt.Insets(2, 0, 3, 0));
		botonArquetipo.setText("+/-");
		
		botonPlantilla = new JButton();
		botonPlantilla.setMargin(new java.awt.Insets(2, 0, 3, 0));
		botonPlantilla.setText("+/-");
		
		idplantilla_Label = new javax.swing.JLabel();
	    idArquetipo_Label = new javax.swing.JLabel();
	    
	    idPlantilla_selector = new javax.swing.JComboBox<Plantilla>();
	    idPlantilla_selector.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	            actualizarPlantilla(e);
	        }
	    });
	    
	    idArquetipo_selector = new javax.swing.JComboBox<Arquetipo>();
	    idArquetipo_selector.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	            actualizarArquetipo(e);
	        }
	    });
	    
	    boton_Actualizar = new javax.swing.JButton();
	    nombre_Label = new javax.swing.JLabel();
	    nombre_Text = new javax.swing.JTextField();
	    busqueda = new javax.swing.JLabel();
	    selector = new javax.swing.JComboBox<>();
	    buscador_Text = new javax.swing.JTextField();
	    boton_Busacdor = new javax.swing.JButton();

        idplantilla_Label.setText("ID_PLANTILLA");

        idArquetipo_Label.setText("ID_ARQUETIPO");

        boton_Actualizar.setText("ACTUALIZAR");
        boton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Boton_ActualizarActionPerformed(evt);
            }
        });

        nombre_Label.setText("Nombre");

        busqueda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        busqueda.setText("Buscar plantilla");

        selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_plantilla", "id_arquetipo"}));

        boton_Busacdor.setText("BUSCAR");
        boton_Busacdor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Boton_BusacdorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ActualizarLayout = new javax.swing.GroupLayout(this);
        this.setLayout(ActualizarLayout);
        ActualizarLayout.setHorizontalGroup(
            ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActualizarLayout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(boton_Actualizar)
                .addGap(244, 244, 244))
            .addGroup(ActualizarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ActualizarLayout.createSequentialGroup()
                        .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selector, 0, 134, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscador_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_Busacdor))
                    .addGroup(ActualizarLayout.createSequentialGroup()
                        .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombre_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idArquetipo_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idplantilla_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ActualizarLayout.createSequentialGroup()
                                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idArquetipo_selector, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(idPlantilla_selector))
                                .addGap(18, 18, 18)
                                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonArquetipo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        ActualizarLayout.setVerticalGroup(
            ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActualizarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscador_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boton_Busacdor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idplantilla_Label)
                    .addComponent(idPlantilla_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonArquetipo))
                .addGap(18, 18, 18)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idArquetipo_Label)
                    .addComponent(idArquetipo_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPlantilla))
                .addGap(18, 18, 18)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_Label)
                    .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(boton_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
	}
}
