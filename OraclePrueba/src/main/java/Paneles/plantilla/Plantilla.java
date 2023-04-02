package Paneles.plantilla;

import javax.swing.JPanel;

public class Plantilla extends JPanel{
	Tabla tabla;
	
	public Plantilla() {
		super();
		tabla = new Tabla();
		initComponents();
	}
	
	private void initComponents() {
		javax.swing.GroupLayout plantillaLayout = new javax.swing.GroupLayout(this);

		this.setLayout(plantillaLayout);
		plantillaLayout.setHorizontalGroup(
				plantillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tabla));

		plantillaLayout.setVerticalGroup(
				plantillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tabla));
	}
}
