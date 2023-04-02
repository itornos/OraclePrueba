package Paneles.arquetipo;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Pruebas.Main;
import modeloHce.Arquetipo;
import modeloHce.Plantilla;
import modeloHce.PlantillaArquetipo;


public class Actualizar extends JPanel{
	
	private JLabel idplantilla_Label;
	private JTextField idPlantilla_Text;
	private JTextField idArquetipo_Text;
	private JLabel idArquetipo_Label;
	private JButton boton_Actualizar;
	private JTextField nombre_Text;
	private JLabel nombre_Label;
	private JLabel busqueda;
	private JTextField buscador_Text;
	private JComboBox selector;
	private JButton boton_Busacdor;

	private void Boton_BusacdorActionPerformed(java.awt.event.ActionEvent evt) {
		Double buscador = Double.parseDouble(buscador_Text.getText());

		PlantillaArquetipo arquetipo = Main.arquetipoPlantillaImplementacion.read(new PlantillaArquetipo(new Plantilla(), new Arquetipo(buscador), 0));
		idPlantilla_Text.setText(arquetipo.getIdPlantilla() + "");
		idArquetipo_Text.setText(arquetipo.getIdArquetipo() + "");
		nombre_Text.setText(arquetipo.getArquetipoNombre());
	}
	
	private void Boton_ActualizarActionPerformed(ActionEvent evt) {
		/*double id;
		String nombre;

		try {
			id = Double.parseDouble(plantilla_Actualizar_IdPlantilla_Text.getText());
			nombre = plantilla_Actualizar_Nombre_Text.getText();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El id es un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Main.plantillaImplementacion.update(new Plantilla(id, nombre));*/
	}

	public Actualizar() {
		super();
		
		idplantilla_Label = new javax.swing.JLabel();
	    idArquetipo_Label = new javax.swing.JLabel();
	    idPlantilla_Text = new javax.swing.JTextField();
	    idArquetipo_Text = new javax.swing.JTextField();
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

        selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_ARQUETIPO", "NOMBRE", "Item 3", "Item 4" }));

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
                            .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idArquetipo_Text, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(idPlantilla_Text))
                            .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        ActualizarLayout.setVerticalGroup(
            ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActualizarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscador_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_Busacdor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selector, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idplantilla_Label)
                    .addComponent(idPlantilla_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idArquetipo_Label)
                    .addComponent(idArquetipo_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_Label)
                    .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(boton_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
	}
}
