package Paneles.datoBasico;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Pruebas.Main;
import modeloHce.TipoDatoBasico;

public class Insertar extends JPanel {
	
	private JButton botonInsertar;
	
	private JLabel Nombre_Label;
	private JTextField nombre_Text;
	
	private JLabel idDatoBasico_Label;
	private JTextField idDatoBasico_Text;
	
	private JLabel tipoBasico_Label;
	private JComboBox<TipoDatoBasico> tipoBasicoSelect;
	
	public Insertar() {
		super();
		initComponents();
	}
	
	private void botonInsertarActionPerformed(ActionEvent evt) {
		
	}
	
	private void initComponents() {
		
		
		botonInsertar  = new JButton();
		botonInsertar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonInsertarActionPerformed(evt);
			}
		});
		
		Nombre_Label  = new JLabel();
		nombre_Text  = new JTextField();
		
		idDatoBasico_Label  = new JLabel();
		idDatoBasico_Text = new JTextField();
		
		tipoBasico_Label = new JLabel();
		
		tipoBasicoSelect = new JComboBox<TipoDatoBasico>();
		tipoBasicoSelect = Funcionalidades.actualizarTipoDatBasico(tipoBasicoSelect, Main.tipoDatoBasicoDaoImplement.read());
		
		
		Nombre_Label.setText("Nombre");
		idDatoBasico_Label.setText("Id Dato Basico");
		tipoBasico_Label.setText("Tipo Basico");
		botonInsertar.setText("INSERTAR");

		javax.swing.GroupLayout arquetipo_Insertar1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(arquetipo_Insertar1Layout);
        arquetipo_Insertar1Layout.setHorizontalGroup(
            arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, arquetipo_Insertar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonInsertar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, arquetipo_Insertar1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Nombre_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipoBasico_Label, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(idDatoBasico_Label))
                .addGap(40, 40, 40)
                .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(idDatoBasico_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tipoBasicoSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 354, Short.MAX_VALUE))
        );
        arquetipo_Insertar1Layout.setVerticalGroup(
            arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arquetipo_Insertar1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idDatoBasico_Label)
                    .addComponent(idDatoBasico_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoBasico_Label)
                    .addComponent(tipoBasicoSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(arquetipo_Insertar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(botonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
	}
}
