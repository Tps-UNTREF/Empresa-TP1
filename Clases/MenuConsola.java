package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import Excepciones.CuilInvalidoExcepcion;
import Excepciones.DniInvalidoExcepcion;
import Excepciones.ErrorDeComision;
import Excepciones.ErrorVentasRealizadas;
import Excepciones.HorasTrabajadasInvalidasExcepcion;
import Excepciones.NombreInvalidoExcepcion;
import Excepciones.PremioInvalidoExcepcion;
import Excepciones.ValorFueraDeRangoException;

public class MenuConsola {

	private static BufferedReader teclado = null;
	private static boolean salir = false;
	private static Empresa empresa = new Empresa();
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
			try {
				switch (printMenu("Eliga una opcion: \n"
						+ "1-Obtener la descripcion de un trabajador \n"
						+ "2-Agregar un trabajador\n"
						+ "3-Obtener un trabajador para modificarle los datos\n"
						+ "4-Obtener la lista de los trabajadores\n"
						+ "5-Salir")) {
					case 1:
						getDescripcionTrabajador(Integer.parseInt(msgUsuario("Ingrese DNI del trabajador " + 
								"que quiera la descripcion: ")));
						break;
					case 2:
						crearTrabajador();
						break;
					case 3:
						modificarTrabajador();
						break;
					case 4:
						listarSueldoDeTrabajadores();
						break;
					case 5:
						salir = !salir;
				}
			} catch (ValorFueraDeRangoException | NumberFormatException | IOException e) {
				System.err.println(e.getMessage());
			}
		}while(!salir);
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	private static void crearTrabajador() throws IOException{		
		do{
			String nombre = "";
			String cuil = "";
			int dni = 0;
			double sueldo = 0;
			
			try {
				int trabajador = printMenu("Elige el tipo de trabajador " + 
						"que quieras crear: \n" + 
						"1-Empleado \n" + 
						"2-Voluntario \n" + 
						"3-Ejecutivo \n" +
						"4-EmpleadoPorHora \n" + 
						"5-EmpleadoPorHoraAComision \n" +
						"6-Salir \n");
				
				nombre = msgUsuario("Inserte nombre: ");
				if (trabajador == 2) {
					dni = Integer.parseInt(msgUsuario("Inserte DNI: "));
				} else {
					cuil = msgUsuario("Inserte CUIL: ");
				}
			
				switch(trabajador){
					case 1://Empleado
						sueldo = Integer.parseInt(msgUsuario("Inserte sueldo: "));
						empresa.altaTrabajador(new Empleado(nombre,cuil,sueldo));
						break;
					case 2://Voluntario
						empresa.altaTrabajador(new Voluntario(nombre,dni));
						break;
					case 3://Ejecutivo
						sueldo = Integer.parseInt(msgUsuario("Inserte sueldo: "));
						empresa.altaTrabajador(new Ejecutivo(nombre, cuil, sueldo));
						break;
					case 4://EmpleadoPorHora
						sueldo = Integer.parseInt(msgUsuario("Inserte sueldo por hora: "));
						empresa.altaTrabajador(new EmpleadoPorHora(nombre,cuil,sueldo));
						break;
					case 5://EmpleadoPorHoraAComision
						sueldo = Integer.parseInt(msgUsuario("Ingrese el sueldo por hora: "));
						 int comision = Integer.parseInt(msgUsuario("Ingrese el porcentaje de comisión: "));
						 empresa.altaTrabajador(new EmpleadoPorHoraAComision(nombre, cuil, sueldo, comision));
						break;
				}	
				salir = !salir;
			} catch (ValorFueraDeRangoException | NumberFormatException | CuilInvalidoExcepcion | DniInvalidoExcepcion | NombreInvalidoExcepcion | ErrorDeComision e) {
				System.err.println(e.getMessage());
			}
		}while(!salir);
		salir = !salir;//Vuelvo al estado anterior
	}
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	public static void getDescripcionTrabajador(int dni) throws IOException{ //la cambie de String a void
		try {
			System.out.println(empresa.obtenerTrabajadorByDni(dni).toString());
		} catch (DniInvalidoExcepcion e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Precione Enter para continuar");
		teclado.readLine();
	}
	
	private static void modificarTrabajador() {
		boolean volver = false;
		Trabajador t = null;
		do {
			try {
				if (t==null) {
					t = empresa.obtenerTrabajadorByDni(Integer.parseInt(msgUsuario("Inserte DNI: ")));					
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
				volver = printMenu("Desea finalizar la edicion? \n 1-Seguir \n 0-Terminar") == 1;
			} catch (Exception e) {
				System.err.println(e.getMessage());
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
		boolean volver = false;
		do {
			switch (printMenu("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "4-Horas Trabajadas \n"
					+ "5-Ventas Realizadas \n"
					+ "6-Salir")) {
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
		boolean volver = false;
		do {
			switch (printMenu("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "4-Horas Trabajadas \n"
					+ "5-Salir")) {
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
		boolean volver = false;
		do {
			switch (printMenu("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "4-Horas Trabajadas \n"
					+ "5-Salir")) {
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
		boolean volver = false;
		do {
			switch (printMenu("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Salir")) {
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
		boolean volver = false;
		do {
			switch (printMenu("Eliga una opcion: \n"
					+ "1-Nombre \n"
					+ "2-Cuil \n"
					+ "3-Sueldo \n"
					+ "5-Salir")) {
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
	/**
	 * pre: 
	 * 
	 * post:
	 * 
	 */
	public static void listarSueldoDeTrabajadores() throws IOException{
		ArrayList<Empleado> empleados = new ArrayList<>();
		for(Trabajador t : empresa.getTrabajadores()){
			if(t instanceof Empleado){
				empleados.add((Empleado)t);
			}
		}
		Collections.sort(empleados);
		int i = 0;
		File f = new File("Extras/empleados.txt");
		FileWriter fw = new FileWriter(f);
		for(Empleado e: empleados){
			fw.write(i+"."+e.toString()+" \n");
			System.out.println(i+"."+e.toString());
			i++;
		}
		for(Trabajador t: empresa.getTrabajadores()){
			if(t instanceof Voluntario){
				fw.write(i+"."+t.toString()+" \n");
				System.out.println(i+"."+t.toString());
				i++;
			}
		}
		fw.close();
		System.out.println("Precione Enter para continuar");
		teclado.readLine();
	}
	/**
	 * pre: menu=Menu que se le presentará al usuario. Debe tener las opciones te tal manera "{Numero}-{Opcion}"
	 * post: Devuelve el numero que el usuario elige
	 */
	private static int printMenu(String menu) throws ValorFueraDeRangoException, NumberFormatException, IOException {
		int resultado = 0;
		int min = Integer.parseInt(menu.split("-")[0].substring(menu.split("-")[0].length()-1));
		int max = Integer.parseInt(menu.split("-")[menu.split("-").length-2].substring(menu.split("-")[menu.split("-").length-2].length()-1));
		
		System.out.println(menu);
		resultado = Integer.parseInt(teclado.readLine());
		if (resultado > max || resultado < min) {
			throw new ValorFueraDeRangoException();
		}
		return resultado;
	}
	/**
	 * pre: msg=Mensaje que se le presentará al usuario
	 * post: Devuelve el string que el usuario escribe
	 */
	private static String msgUsuario(String msg){
		String resultado = "";
		
		do {	
			System.out.println(msg);
		  	try {
		  		resultado = teclado.readLine();
			} catch (IOException e) {
				System.err.println("Error");
			}
		} while (resultado == "");
		
		return resultado;
	}
	
}
