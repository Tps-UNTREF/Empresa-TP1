package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.DniInvalidoExcepcion;
import Excepciones.ErrorValorEnSueldo;
import Excepciones.NombreInvalidoExcepcion;

public class Empleado extends Trabajador implements Comparable<Empleado> {
	private String cuil;
	private double sueldo;
	/**
	 * pre: Se ingresa un nombre, un cuil de 11 digitos y un sueldo correcto.
	 * 
	 */
	public Empleado(String nombre, String cuil, double sueldo) throws NumberFormatException, CuilInvalidoExcepcion, DniInvalidoExcepcion, NombreInvalidoExcepcion {
		super(nombre, Integer.parseInt(validarCuil(cuil.replace("-", "")).substring(2, 10)));
		setCuil(cuil.replace("-", ""));
		setSueldo(sueldo);
	}
	/**
	 * pre: Se le ingresa un cuil.
	 * 
	 * post: Verifica si el cuil es un valor de 11 digitos y devuelve el cuil.
	 * @throws CuilInvalidoExcepcion 
	 * 
	 */
	private static String validarCuil(String cuil) throws CuilInvalidoExcepcion {
		if (cuil.length() != 11) {
			throw new CuilInvalidoExcepcion();
		}
		return cuil;
	}
	/**
	 * post: Devuelve la descripcion del empleado.
	 * 
	 */
	public String toString(){
		return "Tipo: Empleado"+" Nombre: " + super.getNombre() + " Cuil: " + getCuil() + " Sueldo: " + getSueldo();
	}
	/**
	 * pre: Se ingresa un cuil de 11 digitos.
	 * 
	 * post: Establece el cuil ingresado.
	 * 
	 */
	public void setCuil(String cuil) throws CuilInvalidoExcepcion {
		if (Integer.parseInt(cuil.substring(2, 10)) != super.getDni()) {
			throw new CuilInvalidoExcepcion();
		}
		this.cuil = validarCuil(cuil); 	
	}
	/**
	 * post: Devuelve el cuil.
	 * 
	 */
	public String getCuil() {
		return this.cuil;
	}
	/**
	 * pre: Se ingresa un sueldo valido.
	 * 
	 * post: Establece el sueldo ingresado.
	 * 
	 */
	public void setSueldo(double sueldo){
		if(sueldo > 0){
			this.sueldo = sueldo;
		}else{
			throw new ErrorValorEnSueldo();
		}
	}
	/**
	 * post: Devuelve el sueldo.
	 * 
	 */
	public double getSueldo(){
		return this.sueldo;
	}
	/**
	 * post: Compara empleados por sueldo de mayor a menor y si es igual, compara por DNI.
	 * 
	 */
	@Override
	public int compareTo(Empleado o) {
		if (this.sueldo < o.sueldo){
			return 1;
		}else if(this.sueldo > o.sueldo) {
			return -1;
			}
		return super.getDni().compareTo(o.getDni());
	}
		
}
