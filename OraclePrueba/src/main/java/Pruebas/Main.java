package Pruebas;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import DaoHce.ArquetipoDaoImplement;
import DaoHce.DatoBasicoDaoImplement;
import DaoHce.PlantillaArquetipoDaoImplement;
import DaoHce.PlantillaDaoImplement;
import DaoHce.TipoDatoBasicoDaoImplement;
import Hilo.FormatoLog;
import Paneles.Principal;

public class Main {
	public static PlantillaDaoImplement plantillaImplementacion;
	public static ArquetipoDaoImplement arquetipoImplementacion;
	public static PlantillaArquetipoDaoImplement arquetipoPlantillaImplementacion;
	public static DatoBasicoDaoImplement datoBasicoDaoImplement;
	public static TipoDatoBasicoDaoImplement tipoDatoBasicoDaoImplement;
	public static FormatoLog querys;
	
	public static void main(String[] args) {
		FlatDarkLaf.install();//TEMA VISUAL
		
		Properties pro = new Properties();
		try {
			//String v = System.getProperty("user.dir");
			pro.load(new FileInputStream(new File("src/main/resources/Log.properties")));
			querys = new FormatoLog(new File((String) pro.get("querysnofiltradas")),
					new File((String) pro.get("querysfiltradas")));

		} catch (Exception e) {
		}

		plantillaImplementacion = new PlantillaDaoImplement();
		arquetipoImplementacion = new ArquetipoDaoImplement();
		arquetipoPlantillaImplementacion = new PlantillaArquetipoDaoImplement();
		datoBasicoDaoImplement = new DatoBasicoDaoImplement();
		tipoDatoBasicoDaoImplement = new TipoDatoBasicoDaoImplement();
		
		new Principal().setVisible(true);
		new Thread(querys).start();
	}
}
