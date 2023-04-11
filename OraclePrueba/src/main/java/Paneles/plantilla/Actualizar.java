package Paneles.plantilla;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Paneles.MensajeEmergente;
import Paneles.Principal;
import Pruebas.Main;
import modeloHce.Plantilla;

public class Actualizar extends JPanel {

	private javax.swing.JTextField buscador;
	private javax.swing.JButton actualizar_Boton;
	private javax.swing.JLabel idPlantilla_Label;
	private javax.swing.JTextField idPlantilla_Text;
	private javax.swing.JLabel nombre_Label;
	private javax.swing.JTextField nombre_Text;	
	private javax.swing.JButton buscador_Boton;
	
	private void plantilla_Actualizar_Buscador_BotonActionPerformed(java.awt.event.ActionEvent evt) {
		Double valorBuscador = Double.parseDouble(buscador.getText());

		Plantilla plantillaSelect = Main.plantillaImplementacion.readId(valorBuscador);
		idPlantilla_Text.setText(plantillaSelect.getId() + "");
		nombre_Text.setText(plantillaSelect.getDescripcion());

	}

	private void plantilla_Actualizar_BotonActionPerformed(java.awt.event.ActionEvent evt) {
		double id;
		String nombre;

		try {
			id = Double.parseDouble(idPlantilla_Text.getText());
			nombre = nombre_Text.getText();
		} catch (Exception e) {
			new MensajeEmergente(0);
			return;
		}

		Main.plantillaImplementacion.update(new Plantilla(id, nombre));
	}

	public Actualizar() {
		super();
		buscador = new javax.swing.JTextField();
		buscador_Boton = new javax.swing.JButton();
		idPlantilla_Label = new javax.swing.JLabel();
		nombre_Label = new javax.swing.JLabel();
		idPlantilla_Text = new javax.swing.JTextField();
		nombre_Text = new javax.swing.JTextField();
		actualizar_Boton = new javax.swing.JButton();

		buscador_Boton.setText("BUSCAR");
		buscador_Boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				plantilla_Actualizar_Buscador_BotonActionPerformed(evt);
			}
		});

		idPlantilla_Label.setText("ID_PLANTILLA");

		nombre_Label.setText("Nombre");

		actualizar_Boton.setText("ACTUALIZAR");
		actualizar_Boton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				plantilla_Actualizar_BotonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout plantilla_ActualizarLayout = new javax.swing.GroupLayout(this);
		this.setLayout(plantilla_ActualizarLayout);
		plantilla_ActualizarLayout.setHorizontalGroup(plantilla_ActualizarLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(plantilla_ActualizarLayout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(plantilla_ActualizarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(plantilla_ActualizarLayout.createSequentialGroup()
										.addComponent(buscador).addGap(30, 30, 30)
										.addComponent(buscador_Boton).addGap(20, 20, 20))
								.addGroup(plantilla_ActualizarLayout.createSequentialGroup()
										.addGroup(plantilla_ActualizarLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(nombre_Label,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(idPlantilla_Label,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(40, 40, 40)
										.addGroup(plantilla_ActualizarLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(nombre_Text,
														javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
												.addComponent(idPlantilla_Text))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						plantilla_ActualizarLayout.createSequentialGroup().addContainerGap(246, Short.MAX_VALUE)
								.addComponent(actualizar_Boton).addGap(244, 244, 244)));
		plantilla_ActualizarLayout.setVerticalGroup(plantilla_ActualizarLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(plantilla_ActualizarLayout.createSequentialGroup().addContainerGap()
						.addGroup(plantilla_ActualizarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(buscador_Boton,
										javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(plantilla_ActualizarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(idPlantilla_Label).addComponent(
										idPlantilla_Text, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(plantilla_ActualizarLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nombre_Label)
								.addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
						.addComponent(actualizar_Boton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
	}
}
