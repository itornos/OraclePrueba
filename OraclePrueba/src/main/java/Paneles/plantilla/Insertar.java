package Paneles.plantilla;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Paneles.MensajeEmergente;
import Paneles.Principal;
import Pruebas.Main;
import modeloHce.Plantilla;

public class Insertar extends JPanel {

	private javax.swing.JLabel idPlantilla_Label;
	private javax.swing.JTextField idPlantilla_Text;
	private javax.swing.JLabel nombre_Label;
	private javax.swing.JTextField nombre_Text;
	private javax.swing.JButton insertar_Boton;

	public Insertar() {
		super();
		idPlantilla_Label = new javax.swing.JLabel();
		idPlantilla_Text = new javax.swing.JTextField();
		nombre_Label = new javax.swing.JLabel();
		nombre_Text = new javax.swing.JTextField();
		insertar_Boton = new javax.swing.JButton();

		initComponents();
	}

	private void plantilla_Insertar_BotonActionPerformed(java.awt.event.ActionEvent evt) {
		double id;
		String nombre;

		try {
			id = Double.parseDouble(idPlantilla_Text.getText());
			nombre = nombre_Text.getText();
		} catch (Exception e) {
			new MensajeEmergente(0);
			return;
		}

		Main.plantillaImplementacion.create(new Plantilla(id, nombre));
	}

	private void initComponents() {
		idPlantilla_Label.setText("ID_PLANTILLA");
		nombre_Label.setText("Nombre");

		insertar_Boton.setText("INSERTAR");
		insertar_Boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				plantilla_Insertar_BotonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout plantilla_InsertarLayout = new javax.swing.GroupLayout(this);
		this.setLayout(plantilla_InsertarLayout);
		plantilla_InsertarLayout.setHorizontalGroup(
				plantilla_InsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(plantilla_InsertarLayout.createSequentialGroup().addGroup(plantilla_InsertarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(plantilla_InsertarLayout.createSequentialGroup().addGap(20, 20, 20)
										.addGroup(plantilla_InsertarLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(nombre_Label,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(idPlantilla_Label,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(40, 40, 40)
										.addGroup(plantilla_InsertarLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(idPlantilla_Text,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(nombre_Text,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(plantilla_InsertarLayout.createSequentialGroup().addGap(253, 253, 253)
										.addComponent(insertar_Boton)))
								.addContainerGap(254, Short.MAX_VALUE)));
		plantilla_InsertarLayout.setVerticalGroup(plantilla_InsertarLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(plantilla_InsertarLayout.createSequentialGroup().addGap(30, 30, 30)
						.addGroup(plantilla_InsertarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(idPlantilla_Label).addComponent(
										idPlantilla_Text, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(plantilla_InsertarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nombre_Label)
								.addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
						.addComponent(insertar_Boton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
	}
}
