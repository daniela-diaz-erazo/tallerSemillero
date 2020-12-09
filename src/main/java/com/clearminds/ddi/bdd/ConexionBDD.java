package com.clearminds.ddi.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.clearminds.ddi.excepciones.BDDException;

import java.sql.*;

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

	public static Connection obtenerConexion() throws BDDException {
		String usuario = leerPropiedad("usuario");
		String password = leerPropiedad("password");
		String url = leerPropiedad("urlConexion");

		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, usuario, password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new BDDException("No se pudo registrar el JDBC driver");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("No se pudo abrir la conexión con las propiedades indicadas.");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
