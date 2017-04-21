package Clases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import Excepciones.*;

class Empresa {
	private static ArrayList<Trabajador> trabajadores = new ArrayList<>();
	private static boolean repetir = true;
	private static BufferedReader teclado = null;
	/**
	 * post:
	 * Inicia el programa
	 */
	public static void main(String[] args) throws IOException{
		teclado = new BufferedReader(new InputStreamReader(System.in));
		seleccionadorDeMenu();
		teclado.close();
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * Metodo en el cual se muestra al menu principal
	 */
	private static void seleccionadorDeMenu(){
		do{
			System.out.println("Eliga una opcion: \n"
					+ "1-Obtener la descripcion de un trabajador \n"
					+ "2-Agregar un trabajador\n"
					+ "3-Obtener un trabajador para modificarle los datos\n"
					+ "4-Obtener la lista de los trabajadores\n"
					+ "5-terminar");
			
			try {
				switch (valorEntre(Integer.parseInt(teclado.readLine()),1,5)) {
					case 1:
						getDescripcionTrabajador(Integer.parseInt(msgUsuario("Ingrese DNI del trabajador " + 
								"que quiera la descripcion: ")));
						Terminar();
						break;
					case 2:
						crearTrabajador(Integer.parseInt(msgUsuario("Elige el tipo de trabajador " + 
								"que quieras crear: \n" + 
								"1-Empleado \n" + 
								"2-Voluntario \n" + 
								"3-Ejecutivo \n" + 
								"4-EmpleadoPorHora \n" + 
								"5-EmpleadoPorHoraAComision \n")));
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
			} catch (ValorFueraDeRangoException | NumberFormatException | IOException e) {
				System.out.print(e.getMessage() + "\n");
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
		String nombre = msgUsuario("Inserte nombre: ");
		String cuil = "";
		int dni = 0;
		double sueldo = 0;
		boolean volver = false;
		
		do{
			volver = false;
			if (trabajador == 2) {
				dni = Integer.parseInt(msgUsuario("Inserte DNI: "));
			} else {
				cuil = msgUsuario("Inserte CUIL: ");
			}
			
			try {
				switch(trabajador){
					case 1://Empleado
						sueldo = Integer.parseInt(msgUsuario("Inserte sueldo: "));
						trabajadores.add(new Empleado(nombre,cuil,sueldo));
						break;
					case 2://Voluntario
						 trabajadores.add(new Voluntario(nombre,dni));
						break;
					case 3://Ejecutivo
						sueldo = Integer.parseInt(msgUsuario("Inserte sueldo: "));
						trabajadores.add(new Ejecutivo(nombre, cuil, sueldo));
						break;
					case 4://EmpleadoPorHora
						sueldo = Integer.parseInt(msgUsuario("Inserte sueldo por hora: "));
						trabajadores.add(new EmpleadoPorHora(nombre,cuil,sueldo));
						break;
					case 5://EmpleadoPorHoraAComision
						sueldo = Integer.parseInt(msgUsuario("Ingrese el sueldo por hora: "));
						 int comision = Integer.parseInt(msgUsuario("Ingrese el porcentaje de comisión: "));
						 trabajadores.add(new EmpleadoPorHoraAComision(nombre, cuil, sueldo, comision));
						break;
				}	
			} catch (NumberFormatException | CuilInvalidoExcepcion e) {
				System.out.print(e.getMessage() + "\n");
				volver = !volver;
			}
		}while(volver);
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	private static void Terminar() throws NumberFormatException, IOException {
		repetir = Integer.parseInt(msgUsuario("Desea terminar? \n 1-Seguir \n 0-Terminar \n")) == 1;
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
		boolean volver = false;
		Trabajador t = null;
		do {
			try {
				if (t==null) {
					t = obtenerTrabajador(Integer.parseInt(msgUsuario("Inserte DNI: ")));					
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
				volver = Integer.parseInt(msgUsuario("Desea finalizar la edicion? \n 1-Seguir \n 0-Terminar \n")) == 1;
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
			EmpleadoPorHoraAComision t) throws NumberFormatException, ValorFueraDeRangoException, IOException, HorasTrabajadasInvalidasExcepcion, ErrorVentasRealizadas, CuilInvalidoExcepcion {
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
					t.setNombre(msgUsuario("Inserte nuevo nombre: "));
					break;
				case 2:
					t.setCuil(msgUsuario("Inserte nuevo Cuil: "));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ")));
					break;
				case 4:
					t.setHorasTrabajadas(Integer.parseInt(msgUsuario("Inserte nuevo Horas Trabajadas: ")));
					break;
				case 5:
					t.setVentasRealizadas(Integer.parseInt(msgUsuario("Inserte nuevo Ventas Realizadas: ")));
					break;
				case 6:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarEmpleadoPorHora(EmpleadoPorHora t) throws NumberFormatException, ValorFueraDeRangoException, IOException, HorasTrabajadasInvalidasExcepcion, CuilInvalidoExcepcion {
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
					t.setNombre(msgUsuario("Inserte nuevo nombre: "));
					break;
				case 2:
					t.setCuil(msgUsuario("Inserte nuevo Cuil: "));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ")));
					break;
				case 4:
					t.setHorasTrabajadas(Integer.parseInt(msgUsuario("Inserte nuevo Horas Trabajadas: ")));
					break;
				case 5:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarEjecutivo(Ejecutivo t) throws NumberFormatException, ValorFueraDeRangoException, IOException, PremioInvalidoExcepcion, CuilInvalidoExcepcion {
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
					t.setNombre(msgUsuario("Inserte nuevo nombre: "));
					break;
				case 2:
					t.setCuil(msgUsuario("Inserte nuevo Cuil: "));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ")));
					break;
				case 4:
					t.setPremio(Integer.parseInt(msgUsuario("Inserte nuevo Premio: ")));
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
					t.setNombre(msgUsuario("Inserte nuevo nombre: "));
					break;
				case 2:
					volver = !volver;
					break;
			}		
		} while (volver);
	}

	private static void modificarEmpleado(Empleado t) throws NumberFormatException, ValorFueraDeRangoException, IOException, CuilInvalidoExcepcion {
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
					t.setNombre(msgUsuario("Inserte nuevo nombre: "));
					break;
				case 2:
					t.setCuil(msgUsuario("Inserte nuevo Cuil: "));
					break;
				case 3:
					t.setSueldo(Integer.parseInt(msgUsuario("Inserte nuevo sueldo: ")));
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
	private static String msgUsuario(String msg) throws IOException {
		  System.out.print(msg);
		  return teclado.readLine();
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
