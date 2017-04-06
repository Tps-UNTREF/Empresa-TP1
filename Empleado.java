import java.util.StringTokenizer;


public class Empleado extends Trabajador {
	private String cuil;
	private double sueldo;
	int d1, d2, d3, d4, d5, d6, d7 ,d8;

	public Empleado(String nombre, int dni,double sueldo) {
		super(nombre, dni);
		setCuil(dni);
		
	}
	public String toString(){
		return "Nombre: " + super.getNombre() + " Cuil: " + getCuil() + " Sueldo: " + getSueldo();
	}
	
	public void setCuil(int dni) {
		this.cuil = "00-" + dni + "-" + AlgoritmoUltimoDigito(dni); ; 	
	}
	
	private int AlgoritmoUltimoDigito(int dni) {
		int suma = 0;
		int x=0;
		d8 = dni % 10;
		d7 = dni % 100 / 10;
		d6 = dni % 1000 / 100;
		d5 = dni % 10000 / 1000;
		d4 = dni % 100000 / 10000;
		d3 = dni % 1000000 / 100000;
		d2 = dni % 10000000 / 1000000;
		d1 = dni % 100000000 / 10000000;
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

}
