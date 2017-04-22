package Clases;

import Excepciones.DniInvalidoExcepcion;
import Excepciones.NombreInvalidoExcepcion;

abstract class Trabajador{
	
	private String nombre;
	private int dni;
	/**
	 * pre:Nombre= Nombre de Trabajador, no puede ser vacio o ser solo numero. DNI=Int que funciona como identificador unico, no puede ser negativo o mayor a 8 digitos 
	 * post:Se crea un trabajador con el nombre y DNI ingresado
	 */
	public Trabajador(String nombre, int dni) throws DniInvalidoExcepcion, NombreInvalidoExcepcion {
		this.nombre = validarNombre(nombre);
		this.dni = validarDNI(dni);
	}
	/**
	 * pre:Nombre= Nombre de Trabajador, no puede ser vacio o ser solo numero.
	 * post:Devuelve el nombre del trabajador
	 */
	private String validarNombre(String nombre) throws NombreInvalidoExcepcion {
		if (nombre == "") {
			throw new NombreInvalidoExcepcion();
		}
		try {
			Double.parseDouble(nombre);	
			throw new NombreInvalidoExcepcion();
		} catch (NumberFormatException ex) {}
		
		return nombre;
	}
	/**
	 * pre:DNI=Int que funciona como identificador unico, no puede ser negativo o mayor a 8 digitos 
	 * post:Devuelve el dni del trabajador
	 */
	private int validarDNI(int dni) throws DniInvalidoExcepcion {
		if (dni<0 || dni > 99999999) {
			throw new DniInvalidoExcepcion();
		}
		return dni;
	}
	/**
	 * pre:Una vez instanciado con un nombre
	 * post:Devuelve el nombre del trabajador
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * pre:Nombre= Nombre de Trabajador.
	 * post:El nombre ingresado se guarda
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * pre:Una vez instanciado con un DNI
	 * post:Devuelve el DNI del trabajador
	 */
	public Integer getDni() {
		return dni;
	}		
}
