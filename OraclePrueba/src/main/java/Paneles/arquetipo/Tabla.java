package Paneles.arquetipo;

import javax.swing.JTabbedPane;

public class Tabla extends JTabbedPane{
	
    public Tabla() {
    	super();
    	this.addTab("INSERTAR", new Insertar());
    	this.addTab("ACTUALIZAR", new Actualizar());
		this.addTab("BORRAR", new Borrar());
    }
}
