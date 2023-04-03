package Paneles.arquetipo;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Paneles.Principal;
import Pruebas.Main;
import modeloHce.Arquetipo;
import modeloHce.Plantilla;
import modeloHce.PlantillaArquetipo;

public class Insertar extends JPanel {

	private javax.swing.JButton boton;
	private javax.swing.JTextField buscador;
	private javax.swing.JButton buscador_Boton;
	private javax.swing.JLabel idArquetipo_Label;
	private javax.swing.JTextField idArquetipo_Text;
	private javax.swing.JLabel idPlantilla_Label;
	private javax.swing.JLabel buscador_Text;
	private javax.swing.JLabel nombre_Label;
	private javax.swing.JTextField nombre_Text;
	private javax.swing.JComboBox<String> tipoBusqueda;
	private javax.swing.JLabel idPlantilla_final;

	public Insertar() {
		super();
		idArquetipo_Label = new javax.swing.JLabel();
		idArquetipo_Text = new javax.swing.JTextField();
		nombre_Label = new javax.swing.JLabel();
		nombre_Text = new javax.swing.JTextField();
		boton = new javax.swing.JButton();
		buscador = new javax.swing.JTextField();
		buscador_Boton = new javax.swing.JButton();
		buscador_Text = new javax.swing.JLabel();
		tipoBusqueda = new javax.swing.JComboBox<>();
		idPlantilla_Label = new javax.swing.JLabel();
		idPlantilla_final = new javax.swing.JLabel();

		initComponents();
	}

	private void initComponents() {
		idArquetipo_Label.setText("ID_Arquetipo");
		nombre_Label.setText("Nombre");
		buscador_Text.setText("Buscar plantilla");
		idPlantilla_Label.setText("ID_Plantilla");
		idPlantilla_final.setText("...");
		
		buscador_Text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		
		boton.setText("INSERTAR");
		boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonActionPerformed(evt);
			}
		});
		
		buscador_Boton.setText("BUSCAR");
		buscador_Boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Buscador_BotonActionPerformed(evt);
			}
		});

		tipoBusqueda.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "id_plantilla", "nombre", "Item 3", "Item 4" }));


		javax.swing.GroupLayout arquetipo_InsertarLayout = new javax.swing.GroupLayout(this);
		this.setLayout(arquetipo_InsertarLayout);
		arquetipo_InsertarLayout.setHorizontalGroup(
	            arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                        .addComponent(buscador_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(tipoBusqueda, 0, 133, Short.MAX_VALUE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(buscador_Boton)
	                        .addGap(21, 21, 21))
	                    .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                        .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                .addComponent(nombre_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(idArquetipo_Label))
	                            .addComponent(idPlantilla_Label))
	                        .addGap(40, 40, 40)
	                        .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(idArquetipo_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(nombre_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(idPlantilla_final, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(0, 0, Short.MAX_VALUE))))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, arquetipo_InsertarLayout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(boton)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        arquetipo_InsertarLayout.setVerticalGroup(
	            arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(arquetipo_InsertarLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(buscador_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(buscador_Boton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(tipoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
	                .addGap(9, 9, 9)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(idPlantilla_Label)
	                    .addComponent(idPlantilla_final))
	                .addGap(18, 18, 18)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(idArquetipo_Label)
	                    .addComponent(idArquetipo_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(arquetipo_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(nombre_Label)
	                    .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(126, 126, 126)
	                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	}

	private void Buscador_BotonActionPerformed(java.awt.event.ActionEvent evt) {
		Double valorBuscador = Double.parseDouble(buscador.getText());
		Plantilla plantillaSelect;

		if((plantillaSelect = Main.plantillaImplementacion.read(valorBuscador)) == null){
			JOptionPane.showMessageDialog(null, "El id no existe", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		idPlantilla_final.setText(plantillaSelect.getId() + "");
	}

	private void BotonActionPerformed(java.awt.event.ActionEvent evt) {
		Double idArquetipo = Double.parseDouble(idArquetipo_Text.getText());
		Double idplantilla = Double.parseDouble(idPlantilla_final.getText());
		String nombre = nombre_Text.getText();
		
		Arquetipo arquetipo = new Arquetipo(idArquetipo,nombre);
		Plantilla plantilla = new Plantilla(idplantilla,"");
		
		PlantillaArquetipo arquetipoPlantilla = new PlantillaArquetipo(plantilla, arquetipo , Main.arquetipoPlantillaImplementacion.getLast());
		
		arquetipo.annadirArqPlant(arquetipoPlantilla);
		plantilla.annadirArqPlant(arquetipoPlantilla);
		
		
		Main.arquetipoImplementacion.create(arquetipo);
		Main.arquetipoPlantillaImplementacion.create(arquetipoPlantilla);
	}
}
