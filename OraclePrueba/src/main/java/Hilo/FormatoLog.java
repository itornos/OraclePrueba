package Hilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Paneles.Principal;

public class FormatoLog implements Runnable{

	BufferedReader broriginal;
	
	BufferedWriter bwscript;
	BufferedReader brscript;
	public FormatoLog(File rutaOriginal, File scriptOracle) {
		try {
			newFichero(rutaOriginal);
			newFichero(scriptOracle);
			broriginal = new BufferedReader(new FileReader(rutaOriginal));
			bwscript = new BufferedWriter(new FileWriter(scriptOracle));
			brscript = new BufferedReader(new FileReader(scriptOracle));
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		String line;
		
		while (true) {
			try {
				if ((line = broriginal.readLine()) == null) {
					continue;
				}

				if (line.contains(";")){
					if (line.contains("insert") || line.contains("update") || line.contains("delete")) {
						bwscript.append(line + "\n");
						bwscript.flush();
						Principal.script.append(line+"\n");
					}
				}
				
			} catch (IOException e) {
			}
		}
	}
	
	private void newFichero(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		}catch (Exception e) {}
	
	}
}
