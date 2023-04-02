package Pruebas;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import DaoHce.ArquetipoDaoImplement;
import DaoHce.PlantillaArquetipoDaoImplement;
import DaoHce.PlantillaDaoImplement;
import Hilo.FormatoLog;
import Paneles.Principal;

public class Main {
	public static PlantillaDaoImplement plantillaImplementacion;
	public static ArquetipoDaoImplement arquetipoImplementacion;
	public static PlantillaArquetipoDaoImplement arquetipoPlantillaImplementacion;
	public static FormatoLog querys;
	
	public static void main(String[] args) {

		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File("src/main/resources/Log.properties")));
			querys = new FormatoLog(new File((String) pro.get("querysnofiltradas")),
					new File((String) pro.get("querysfiltradas")));

		} catch (Exception e) {
		}

		new Thread(querys).start();
		plantillaImplementacion = new PlantillaDaoImplement();
		arquetipoImplementacion = new ArquetipoDaoImplement();
		arquetipoPlantillaImplementacion = new PlantillaArquetipoDaoImplement();
		
		new Principal().setVisible(true);
	}
}
