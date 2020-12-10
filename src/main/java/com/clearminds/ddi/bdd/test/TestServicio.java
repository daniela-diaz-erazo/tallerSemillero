package com.clearminds.ddi.bdd.test;

import com.clearminds.ddi.dtos.Estudiante;
import com.clearminds.ddi.excepciones.BDDException;
import com.clearminds.servicios.ServicioEstudiante;

public class TestServicio {
	public static void main(String[] args) {

		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			srvEstudiante.insertarEstudiante(new Estudiante("Ana", "Chavez", 12));
		} catch (BDDException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}
