package Paneles.arquetipo;

import javax.swing.JPanel;

public class Arquetipo extends JPanel{
	Tabla tabla;
	
	public Arquetipo() {
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
