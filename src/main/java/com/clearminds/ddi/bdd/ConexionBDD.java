package com.clearminds.ddi.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConexionBDD {

	public static String leerPropiedad(String nombrePropiedad) {
		Properties p = new Properties();
		String valorPropiedad = null;
		try {
			p.load(new FileReader("conexion.properties"));
			valorPropiedad = p.getProperty(nombrePropiedad);	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null; 
		}
		return valorPropiedad;
	}

}
