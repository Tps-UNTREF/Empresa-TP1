package Clases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;
import Excepciones.PremioInvalidoExcepcion;
import Excepciones.ValorFueraDeRangoException;

class Empresa {
	private static ArrayList<Trabajador> trabajadores = new ArrayList<>();
	private static boolean repetir = true;
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException{
		trabajadores.add(new Voluntario("Franco", 38991911));
		seleccionadorDeMenu();
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
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

	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */

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
				 trabajadores.add(new Voluntario(nombre,dni));
				break;
			case 3://Ejecutivo
				sueldo = Integer.parseInt(msgUsuario("ingresar sueldo: ", lector));
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
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	private static void Terminar() throws NumberFormatException, IOException {
		BufferedReader lector2 = new BufferedReader(new InputStreamReader(System.in));
		repetir = Integer.parseInt(msgUsuario("Desea terminar? \n 1-Seguir \n 0-Terminar \n", lector2)) == 1;
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
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
		Trabajador t = null;
		do {
			try {
				if (t==null) {
					t = obtenerTrabajador(Integer.parseInt(msgUsuario("Inserte DNI: ", lector)));					
				}
				if (t instanceof Voluntario) {
					modificarVoluntario((Voluntario)t);
				} else if (t instanceof EmpleadoPorHoraAComision) {
					modificarEmpleadoPorHoraAComision((EmpleadoPorHoraAComision)t);
				} else if (t instanceof EmpleadoPorHora) {
					modificarEmpleadoPorHora((EmpleadoPorHora)t);
				} else if (t instanceof Ejecutivo) {
					modificarEjecutivo((Ejecutivo)t);
			 	} else if (t instanceof Empleado) {
					modificarEmpleado((Empleado)t);
				}
				volver = Integer.parseInt(msgUsuario("Desea finalizar la edicion? \n 1-Seguir \n 0-Terminar \n", lector)) == 1;
			} catch (Exception e) {
				System.out.println("Error: vuelva a intertarlo");
				volver = !volver;
			}			
		} while (volver);
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	private static void modificarEmpleadoPorHoraAComision(
			EmpleadoPorHoraAComision t) throws NumberFormatException, ValorFueraDeRangoException, IOException, HorasTrabajadasInvalidasExcepcion, ErrorVentasRealizadas {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean volver = false;
		do {
			System.out.println("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "4-Horas Trabajadas \n"
					+ "5-Ventas Realizadas \n"
					+ "6-Salir");
			switch (valorEntre(Integer.parseInt(lector.readLine()),1,6)) {
				case 1:
					t.setNombre(msgUsuario("Inserte nuevo nombre: ", lector));
					break;
				case 2:
					t.setCuil(Integer.parseInt(msgUsuario("Inserte nuevo Cuil: ", lector)));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ", lector)));
					break;
				case 4:
					t.setHorasTrabajadas(Integer.parseInt(msgUsuario("Inserte nuevo Horas Trabajadas: ", lector)));
					break;
				case 5:
					t.setVentasRealizadas(Integer.parseInt(msgUsuario("Inserte nuevo Ventas Realizadas: ", lector)));
					break;
				case 6:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarEmpleadoPorHora(EmpleadoPorHora t) throws NumberFormatException, ValorFueraDeRangoException, IOException, HorasTrabajadasInvalidasExcepcion {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean volver = false;
		do {
			System.out.println("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "4-Horas Trabajadas \n"
					+ "5-Salir");
			switch (valorEntre(Integer.parseInt(lector.readLine()),1,5)) {
				case 1:
					t.setNombre(msgUsuario("Inserte nuevo nombre: ", lector));
					break;
				case 2:
					t.setCuil(Integer.parseInt(msgUsuario("Inserte nuevo Cuil: ", lector)));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ", lector)));
					break;
				case 4:
					t.setHorasTrabajadas(Integer.parseInt(msgUsuario("Inserte nuevo Horas Trabajadas: ", lector)));
					break;
				case 5:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarEjecutivo(Ejecutivo t) throws NumberFormatException, ValorFueraDeRangoException, IOException, PremioInvalidoExcepcion {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean volver = false;
		do {
			System.out.println("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "4-Horas Trabajadas \n"
					+ "5-Salir");
			switch (valorEntre(Integer.parseInt(lector.readLine()),1,5)) {
				case 1:
					t.setNombre(msgUsuario("Inserte nuevo nombre: ", lector));
					break;
				case 2:
					t.setCuil(Integer.parseInt(msgUsuario("Inserte nuevo Cuil: ", lector)));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ", lector)));
					break;
				case 4:
					t.setPremio(Integer.parseInt(msgUsuario("Inserte nuevo Premio: ", lector)));
					break;
				case 5:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarVoluntario(Voluntario t) throws NumberFormatException, ValorFueraDeRangoException, IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean volver = false;
		do {
			System.out.println("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Salir");
			switch (valorEntre(Integer.parseInt(lector.readLine()),1,2)) {
				case 1:
					t.setNombre(msgUsuario("Inserte nuevo nombre: ", lector));
					break;
				case 2:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarEmpleado(Empleado t) throws NumberFormatException, ValorFueraDeRangoException, IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean volver = false;
		do {
			System.out.println("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "5-Salir");
			switch (valorEntre(Integer.parseInt(lector.readLine()),1,4)) {
				case 1:
					t.setNombre(msgUsuario("Inserte nuevo nombre: ", lector));
					break;
				case 2:
					t.setCuil(Integer.parseInt(msgUsuario("Inserte nuevo Cuil: ", lector)));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ", lector)));
					break;
				case 4:
					volver = !volver;
					break;
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
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	public static void listarSueldoDeTrabajadores() throws IOException{
		ArrayList<Empleado> empleados = new ArrayList<>();
		for(Trabajador t: trabajadores){
			if(t instanceof Empleado){
				empleados.add((Empleado)t);
			}
		}
		Collections.sort(empleados);
		int i = 0;
		File f = new File("Extras/empleados.txt");
		System.out.println(f.exists());
		FileWriter fw = new FileWriter(f);
		for(Empleado e: empleados){
				fw.write(i+"."+e.toString()+" \n");
				System.out.println(i+"."+e.toString()+" \n");
				i++;
		}
		for(Trabajador t: trabajadores){
			if(t instanceof Voluntario){
				fw.write(i+"."+t.toString()+" \n");
				System.out.println(i+"."+t.toString()+" \n");
				i++;
			}
		}
		fw.close();
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	private static String msgUsuario(String msg, BufferedReader in) throws IOException {
		  System.out.print(msg);
		  return in.readLine();
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	private static int valorEntre(int valor, int min, int max) throws ValorFueraDeRangoException {
		if (valor > max || valor < min) {
			throw new ValorFueraDeRangoException();
		}
		return valor;
	}

}
