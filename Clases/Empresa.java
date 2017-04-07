package Clases;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Excepciones.ValorFueraDeRangoException;

class Empresa {
	private static ArrayList<Trabajador> trabajadores = new ArrayList<>();
	private static boolean repetir = true;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		seleccionadorDeMenu();
	}
	
	private static void seleccionadorDeMenu() throws NumberFormatException, IOException{
		do{
			System.out.println("Eliga una opcion: \n"
					+ "1-Obtener la descripcion de un trabajador \n"
					+ "2-Agregar un trabajador\n"
					+ "3-Obtener un trabajador para modificarle los datos\n"
					+ "4-Obtener la lista de los trabajadores\n"
					+ "5-terminar");
			BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
			try {
				switch (valorEntre(Integer.parseInt(lector.readLine()),1,5)) {
					case 1:
						getDescripcionTrabajador(Integer.parseInt(msgUsuario("Ingrese DNI del trabajador " + 
								"que quiera la descripcion: ", lector)));
						Terminar();
						break;
					case 2:
						crearTrabajador(Integer.parseInt(msgUsuario("Elige el tipo de trabajador " + 
								"que quieras crear: \n" + 
								"1-Empleado \n" + 
								"2-Voluntario \n" + 
								"3-Ejecutivo \n" + 
								"4-EmpleadoPorHora \n" + 
								"5-EmpleadoPorHoraAComision", lector)));
						Terminar();
						break;
					case 3:
						modificarTrabajador();
						Terminar();
						break;
					case 4:
						listarSueldoDeTrabajadores();
						Terminar();
						break;
					case 5:
						repetir = !repetir;
						break;
				}
			} catch (ValorFueraDeRangoException e) {
				System.out.print(e.error() + "\n");
			}
		}while(repetir);
	}

	private static void crearTrabajador(int trabajador) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String nombre;
		int dni;
		double sueldo;
		
		nombre = msgUsuario("Inserte nombre: ", lector);
		dni = Integer.parseInt(msgUsuario("Inserte DNI: ", lector));
		
		switch(trabajador){
			case 1://Empleado
				sueldo = Integer.parseInt(msgUsuario("Inserte sueldo: ", lector));
				trabajadores.add(new Empleado(nombre,dni,sueldo));
				break;
			case 2://Voluntario
				 dni = Integer.parseInt(lector.readLine());
				 trabajadores.add(new Voluntario(nombre,dni));
				break;
			case 3://Ejecutivo
				sueldo = Integer.parseInt(msgUsuario("ingresar sueldo", lector));
				trabajadores.add(new Ejecutivo(nombre, dni, sueldo));
				break;
			case 4://EmpleadoPorHora
				sueldo = Integer.parseInt(msgUsuario("Inserte sueldo por hora: ", lector));
				trabajadores.add(new EmpleadoPorHora(nombre,dni,sueldo));
				break;
			case 5://EmpleadoPorHoraAComision
				 double sueldoPorHora = Integer.parseInt(msgUsuario("Ingrese el sueldo por hora: ", lector));
				 int comision = Integer.parseInt(msgUsuario("Ingrese el porcentaje de comisión: ", lector));
				 trabajadores.add(new EmpleadoPorHoraAComision(nombre, dni, sueldoPorHora, comision));
				break;
		}	
	}

	private static void Terminar() throws NumberFormatException, IOException {
		BufferedReader lector2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Desea terminar? 1-Seguir 0-Terminar");
		repetir = Integer.parseInt(lector2.readLine()) == 1;
	}
	
	public static void getDescripcionTrabajador(int dni){ //la cambie de String a void
		for(Trabajador t: trabajadores){
			if(dni == t.getDni()){
				System.out.println(t.toString());
			}
		}
	}
	
	private static void modificarTrabajador() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean volver = false;
		do {
			try {
				Trabajador t = obtenerTrabajador(Integer.parseInt(msgUsuario("Inserte DNI: ", lector)));
				
			} catch (Exception e) {
				System.out.println("Error: vuelva a intertarlo");
				volver = !volver;
			}			
		} while (volver);
	}
	
	public static Trabajador obtenerTrabajador(int dni){
		for(Trabajador t: trabajadores){
			if(dni == t.getDni()){
				return t;
			}
		}
		return null;
	}
	
	public static void listarSueldoDeTrabajadores() throws IOException{
		Collections.sort(trabajadores);
		int i = 0;
		File f = new File("Extras/empleados.txt");
		System.out.println(f.exists());
		FileWriter fw = new FileWriter(f);
		
		for(Trabajador t: trabajadores){
				fw.write(i+"."+t.toString());
				System.out.println(i+"."+t.toString());
				i++;
		}
		fw.close();
	}
	
	private static String msgUsuario(String msg, BufferedReader in) throws IOException {
		  System.out.print(msg);
		  return in.readLine();
	}
	
	private static int valorEntre(int valor, int min, int max) throws ValorFueraDeRangoException {
		if (valor > max || valor < min) {
			throw new ValorFueraDeRangoException();
		}
		return valor;
	}

}
