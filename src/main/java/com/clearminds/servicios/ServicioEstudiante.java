package com.clearminds.servicios;

import java.sql.*;

import com.clearminds.ddi.dtos.Estudiante;
import com.clearminds.ddi.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando Estudiante: " + estudiante.toString());

		Statement stmt = null;

		try {
			stmt = conexion.createStatement();
			String sql = "insert into estudiantes(nombre,apellido,edad) values('" + estudiante.getNombre() + "','"
					+ estudiante.getApellido()+ "','" + estudiante.getEdad() + "')";
			System.out.println("Script: " + sql);
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}

	}

	public void actualizarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Actualizando Estudiante: " + estudiante.toString());

		Statement stmt = null;

		try {
			stmt = conexion.createStatement();
			String sql = "update estudiantes set nombre='" + estudiante.getNombre() + "', apellido='" + estudiante.getApellido()
					+ "', edad='" + estudiante.getEdad() +"' where id=" + estudiante.getId();
			System.out.println("Script: " + sql);
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al actualizar estudiante");
		}
	}

}
