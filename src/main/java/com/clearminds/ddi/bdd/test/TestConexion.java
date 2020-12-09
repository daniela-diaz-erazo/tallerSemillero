package com.clearminds.ddi.bdd.test;

import java.sql.Connection;

import com.clearminds.ddi.bdd.ConexionBDD;
import com.clearminds.ddi.excepciones.BDDException;

public class TestConexion {
	public static void main(String[] args) {
		try {
			Connection conexion = ConexionBDD.obtenerConexion();
			if (conexion != null) {
				System.out.println("Conexion Exitosa");
			}
		} catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

	}
}
