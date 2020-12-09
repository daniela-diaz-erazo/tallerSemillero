package com.clearminds.servicios;

import com.clearminds.ddi.dtos.Estudiante;
import com.clearminds.ddi.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando Estudiante: " + estudiante.toString());
		cerrarConexion();
	}

}
