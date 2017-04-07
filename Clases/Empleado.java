package Clases;

public class Empleado extends Trabajador implements Comparable<Empleado> {
	private String cuil;
	private double sueldo;

	public Empleado(String nombre, int dni,double sueldo) {
		super(nombre, dni);
		setCuil(dni);
		setSueldo(sueldo);
	}
	
	public String toString(){
		return "Tipo: Empleado"+" Nombre: " + super.getNombre() + " Cuil: " + getCuil() + " Sueldo: " + getSueldo();
	}
	
	public void setCuil(int dni) {
		this.cuil = "00-" + dni + "-" + AlgoritmoUltimoDigito(dni); ; 	
	}
	
	private int AlgoritmoUltimoDigito(int dni) {
		int suma = 0;
		int x=0;
		int d8 = dni % 10;
		int d7 = dni % 100 / 10;
		int d6 = dni % 1000 / 100;
		int d5 = dni % 10000 / 1000;
		int d4 = dni % 100000 / 10000;
		int d3 = dni % 1000000 / 100000;
		int d2 = dni % 10000000 / 1000000;
		int d1 = dni % 100000000 / 10000000;
		suma = (d8*2)+(d7*3)+(d6*4)+(d5*5)+(d4*6)+(d3*7)+(d2*2)+(d1*3)+10; 
		suma = suma % 11;
		if(suma > 0){ 
			return x = 11-suma;
		}
		return x;
	}
	
	public String getCuil() {
		return this.cuil;
	}
	
	public void setSueldo(double sueldo){
		this.sueldo = sueldo;
	}
	
	public double getSueldo(){
		return this.sueldo;
	}
	
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
