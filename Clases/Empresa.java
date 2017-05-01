package Clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Excepciones.DniInvalidoExcepcion;

public class Empresa {
	
	private Map<Integer, Trabajador> trabajadores = new HashMap<Integer, Trabajador>();
	
	public Empresa() { }
	/**
	 * post:Devuelve la lista de trabajadores actuales
	 */
	public Map<Integer, Trabajador> getTrabajadores() {
		return trabajadores;
	}
	/**
	 * pre:trabajadores=Lista de trabajadores con Dni distintos
	 * post:Carga todos los trabajadores con Dni distintos
	 */
	public void setTrabajadores(List<Trabajador> trabajadores) {
		for (Trabajador t : trabajadores) {
			this.trabajadores.put(t.getDni(), t);
		}
	}

	/**
	 * pre:newTrabajador=Trabajador que no se encuentra cargado en la empresa
	 * post:True si carga el trabajador. False si ya hay un trabajador con ese Dni
	 */
	public boolean altaTrabajador(Trabajador newTrabajador) {
		boolean confirmacion = false;
		if (!trabajadores.containsKey(newTrabajador.getDni())) {
			trabajadores.put(newTrabajador.getDni(), newTrabajador);
			confirmacion = !confirmacion;
		}
		return confirmacion;
	}
	/**
	 * pre:trabajador=Trabajador que se encuentra cargado en la empresa
	 * post:True si actualiza el trabajador. False si no hay un trabajador con ese Dni
	 */
	public boolean actualizarTrabajador(Trabajador trabajador) {
		boolean confirmacion = false;
		if (trabajadores.containsKey(trabajador.getDni())) {
			trabajadores.put(trabajador.getDni(), trabajador);
			confirmacion = !confirmacion;
		}
		return confirmacion;
	}
	/**
	 * pre:dni=Dni del Trabajador que se encuentra cargado en la empresa
	 * post:True si borra el trabajador. False si no hay un trabajador con ese Dni
	 */
	public boolean bajaTrabajador(int dni) {
		boolean confirmacion = false;
		if (trabajadores.containsKey(dni)) {
			trabajadores.remove(dni);
			confirmacion = !confirmacion;
		}
		return confirmacion;
	}
	/**
	 * pre:dni=Dni del Trabajador que se encuentra cargado en la empresa
	 * post:Si no hay un trabajador con ese Dni tira la excepcion DniInvalidoExcepcion.
	 * En caso contrario, devuelve el trabajador con ese Dni.
	 */
	public Trabajador obtenerTrabajadorByDni(int Dni) throws DniInvalidoExcepcion {
		if (!trabajadores.containsKey(Dni)) {
			throw new DniInvalidoExcepcion();
		}
		return trabajadores.get(Dni);
	}
	
}
