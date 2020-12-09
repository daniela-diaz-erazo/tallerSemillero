package com.clearminds.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.ddi.bdd.ConexionBDD;
import com.clearminds.ddi.excepciones.BDDException;

public class ServicioBase {
	Connection conexion;

	public void abrirConexion() throws BDDException {
		conexion = ConexionBDD.obtenerConexion();
	}

	public void cerrarConexion() {

		try {
			if (conexion != null) {
				conexion.close();
				System.out.println("Conexión cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cerrar conexión");
		}

	}
}
