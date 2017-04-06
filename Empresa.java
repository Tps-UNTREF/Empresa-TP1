import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Empresa {
	private static ArrayList<Trabajador> trabajadores = new ArrayList<>();
	private static int repetir;
	
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
					+ "5-terminar\n");
			BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
			int opcion = Integer.parseInt(lector.readLine());
			repetir = 0;
			switch (opcion) {
				case 1:
					System.out.println("Ingrese dni del trabajador que quiera la descripcion: ");
					int dni = Integer.parseInt(lector.readLine());
					getDescripcionTrabajador(dni);
					Terminar();
					break;
				case 2:
					System.out.println("Elige el tipo de trabajador que quieras crear: 1-Empleado 2-Voluntario 3-Ejecutivo 4-EmpleadoPorHora 5-EmpleadoPorHoraAComision");
					crearTrabajador(Integer.parseInt(lector.readLine()));
					agregarTrabajador(null);
					Terminar();
					break;
				case 3:
					int dni2 = Integer.parseInt(lector.readLine());
					obtenerTrabajador(dni2);
					Terminar();
					break;
				case 4:
					listarSueldoDeTrabajadores();
					Terminar();
					break;
				case 5:
					repetir = 0;
					break;
			}
		}while(repetir == 1);
		
	}
	
	private static void crearTrabajador(int trabajador) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String nombre;
		int dni;
		double sueldo;
		switch(trabajador){
			case 1://empleado
				System.out.print("Inserte nombre: ");
				nombre = lector.readLine();
				System.out.print("Inserte dni: ");
				dni = Integer.parseInt(lector.readLine());
				System.out.print("Inserte sueldo: ");
				sueldo = Integer.parseInt(lector.readLine());
				trabajadores.add(new Empleado(nombre,dni,sueldo));
				break;
			case 2://voluntario
				 System.out.println("Ingrese nombre: ");
				 nombre = lector.readLine();
				 System.out.println("Ingrese DNI: ");
				 dni = Integer.parseInt(lector.readLine());
				 trabajadores.add(new Voluntario(nombre,dni));
				break;
			case 3://Ejecutivo
				System.out.print("ingresar nombre : ");
				nombre = lector.readLine();
				System.out.print("ingresar dni :");
				dni = Integer.parseInt(lector.readLine());
				System.out.print("ingresar sueldo");
				sueldo = Integer.parseInt(lector.readLine());
				trabajadores.add(new Ejecutivo(nombre, dni, sueldo));
				break;
			case 4://
				System.out.print("Inserte nombre: ");
				nombre = lector.readLine();
				System.out.print("Inserte dni: ");
				dni = Integer.parseInt(lector.readLine());
				System.out.print("Inserte sueldo por hora: ");
				sueldo = Integer.parseInt(lector.readLine());
				trabajadores.add(new EmpleadoPorHora(nombre,dni,sueldo));
				break;
			case 5:
				 System.out.println("Ingrese nombre: ");
				 nombre = lector.readLine();
				 System.out.println("Ingrese DNI: ");
				 dni = Integer.parseInt(lector.readLine());
				 System.out.println("Ingrese el sueldo por hora: ");
				 double sueldoPorHora = Integer.parseInt(lector.readLine());
				 System.out.println("Ingrese el porcentaje de comisión: ");
				 int comision = Integer.parseInt(lector.readLine());
				 trabajadores.add(new EmpleadoPorHoraAComision(nombre, dni, sueldoPorHora, comision));
				break;	
		}	
	}

	private static void Terminar() throws NumberFormatException, IOException {
		BufferedReader lector2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Desea terminar? 1-Seguir 0-Terminar");
		repetir = Integer.parseInt(lector2.readLine());
	
	}
	
	
	
	public static void getDescripcionTrabajador(int dni){ //la cambie de String a void
		for(Trabajador t: trabajadores){
			if(dni == t.getDni()){
				System.out.println(t.toString());
			}
		}
	}
	public static void agregarTrabajador(Trabajador trabajador){
		trabajadores.add(trabajador);
	}
	
	public static Trabajador obtenerTrabajador(int dni){
		for(Trabajador t: trabajadores){
			if(dni == t.getDni()){
				return t;
				/*
				if(t instanceof Empleado){
					return 
				}else if(t instanceof Ejecutivo){
					return 
				}else if(t instanceof Voluntario){
					return
				}else if(t instanceof EmpleadoPorHora){
					return
				}else if(t instanceof EmpleadoPorHoraAComision){
					
				}
				*/
			}
		}
		System.out.println("No se encontro el trabajador");
		return null;
	}
	
	public static void listarSueldoDeTrabajadores(){
		
	}
	

}
