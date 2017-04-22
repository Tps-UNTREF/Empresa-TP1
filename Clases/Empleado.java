package Clases;
import Excepciones.CuilInvalidoExcepcion;
import Excepciones.ErrorValorEnSueldo;

public class Empleado extends Trabajador implements Comparable<Empleado> {
	private String cuil;
	private double sueldo;
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public Empleado(String nombre, String cuil, double sueldo) throws NumberFormatException, CuilInvalidoExcepcion {
		super(nombre, Integer.parseInt(validarCuil(cuil).substring(2, 10)));
		setCuil(cuil);
		setSueldo(sueldo);
	}
	/**
	 * pre : 
	 * 
	 * post:
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
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String toString(){
		return "Tipo:Empleado, Nombre:" + super.getNombre() + ", Cuil:" + getCuil() + ", Sueldo:" + getSueldo();
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setCuil(String cuil) throws CuilInvalidoExcepcion {
		if (Integer.parseInt(cuil.substring(2, 10)) != super.getDni()) {
			throw new CuilInvalidoExcepcion();
		}
		this.cuil = validarCuil(cuil); 	
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
//	private int AlgoritmoUltimoDigito(int dni) {
//		int suma = 0;
//		int x=0;
//		int d8 = dni % 10;
//		int d7 = dni % 100 / 10;
//		int d6 = dni % 1000 / 100;
//		int d5 = dni % 10000 / 1000;
//		int d4 = dni % 100000 / 10000;
//		int d3 = dni % 1000000 / 100000;
//		int d2 = dni % 10000000 / 1000000;
//		int d1 = dni % 100000000 / 10000000;
//		suma = (d8*2)+(d7*3)+(d6*4)+(d5*5)+(d4*6)+(d3*7)+(d2*2)+(d1*3)+10; 
//		suma = suma % 11;
//		if(suma > 0){ 
//			return x = 11-suma;
//		}
//		return x;
//	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public String getCuil() {
		return this.cuil;
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public void setSueldo(double sueldo){
		try{
			if(sueldo > 0){
				this.sueldo = sueldo;
			}else{
				throw new ErrorValorEnSueldo();
			}
		}catch(ErrorValorEnSueldo e){
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * pre : 
	 * 
	 * post:
	 * 
	 */
	public double getSueldo(){
		return this.sueldo;
	}
	/**
	 * pre : 
	 * 
	 * post:
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
