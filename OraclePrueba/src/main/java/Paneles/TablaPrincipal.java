package Paneles;

import javax.swing.JTabbedPane;

import Paneles.arquetipo.Arquetipo;
import Paneles.datoBasico.DatoBasico;
import Paneles.plantilla.Plantilla;

public class TablaPrincipal extends JTabbedPane{
    
    public TablaPrincipal() {
    	super();
    	this.addTab("PLANTILLA", new Plantilla());
    	this.addTab("ARQUETIPO", new Arquetipo());
    	this.addTab("DATO BASICO", new DatoBasico());
    }
}
