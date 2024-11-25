package modelo.interfaz;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.negocio.GestorCoche;

public class Interfaz {

	public static Interfaz interfaz;
	private Scanner scInt;
	private Scanner scStr;
	private GestorCoche gestor;

	private Interfaz() {
		scInt = new Scanner(System.in);
		scStr = new Scanner(System.in);
		gestor = GestorCoche.getInstance();
	}

	public static Interfaz getInstance() {
		return (interfaz == null) ? new Interfaz() : interfaz;
	}

	public void runApp() {
		
		printSlowly("CARGANDO", 5);
		print3Points(5, 5);
		
		System.out.println("\n================================");
		System.out.println("          MENÚ PRINCIPAL     ");
		System.out.println("================================");

		printMainMenu();
		int opcion = validarOpcion(0, 7);

//		boolean opcionValida = false;

//		while(!opcionValida) {
//			try {
//				opcion = printMenu();
//				while (opcion < 0 || opcion > 6) {
//					System.out.print("Introduce un número entre 0 y 6: ");
//					opcion = scInt.nextInt();
//				}
//				opcionValida = true;
//				
//			} catch (InputMismatchException e) {
//				System.out.println("Introduce un carácter válido");
//				
//			}
//			opcion = scInt.nextInt();
//		}

		while (opcion != 0) {

			switch (opcion) {
			case 1:
				altaCoche();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 2:
				bajaCochePorId();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 3:
				modificarCochePorID();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 4:
				buscarCochePorId();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 5:
				buscarCochePorMarca();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 6:
				listarTodosLosCoches();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 7:
				gestionPasajeros();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			default:
				break;
			}

		}

		System.out.println("\n============================");
		System.out.println("       FIN DEL PROGRAMA      ");
		System.out.println("=============================");

	}
	
	private void gestionPasajeros() {
		printPassengersMenu();
		int opcion = validarOpcion(0, 7);

		while (opcion != 0) {

			switch (opcion) {
			case 1:
				altaCoche();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 2:
				bajaCochePorId();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 3:
				modificarCochePorID();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 4:
				buscarCochePorId();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 5:
				buscarCochePorMarca();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 6:
				listarTodosLosCoches();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 7:
				gestionPasajeros();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			default:
				break;
			}
		}
	}

	private void printMainMenu() {
		System.out.println("\n================================");
		printlnSlowly("- 0. Salir de la aplicación", 5);
		printlnSlowly("- 1. Dar de alta un coche", 5);
		printlnSlowly("- 2. Dar de baja un coche por ID", 5);
		printlnSlowly("- 3. Modificar un coche por ID", 5);
		printlnSlowly("- 4. Buscar un coche por ID", 5);
		printlnSlowly("- 5. Buscar coches por marca", 5);
		printlnSlowly("- 6. Listar todos los coches", 5);
		printlnSlowly("- 7. Gestión de Pasajeros", 5);
		
		System.out.println("================================\n");
		printSlowly("- Seleccione una opción: ", 5);
	}
	
	private void printPassengersMenu() {
		System.out.println("\n================================");
		printlnSlowly("- 0. Volver al menú principal", 5);
		printlnSlowly("- 1. Crear nuevo pasajero", 5);
		printlnSlowly("- 2. Borrar pasajero por ID", 5);
		printlnSlowly("- 3. Consulta pasajero por ID", 5);
		printlnSlowly("- 4. Listar todos los pasajeros", 5);
		printlnSlowly("- 5. Añadir pasajero a un coche", 5);
		printlnSlowly("- 6. Eliminar el pasajero de un coche", 5);
		printlnSlowly("- 7. Listar todos los pasajeros de un coche", 5);
		
		System.out.println("================================\n");
		printSlowly("- Seleccione una opción: ", 5);
	}

	private void listarTodosLosCoches() {
		System.out.println("\n===========================");
		printlnSlowly("  Listar todos los coches  ", 5);
		System.out.println("===========================\n");

		List<Coche> listaCoches = gestor.selectAll();
		if (listaCoches.size() == 0) {
			System.out.println("No hay ningún coche en la Base de Datos");
		} else {
			System.out.print("Pulsa enter para listar todos los coches ");
			scStr.nextLine();
			System.out.println("");
			for (Coche coche : listaCoches) {
				System.out.println(coche);
			}
		}

	}

	private void buscarCochePorId() {
		System.out.println("\n===========================");
		printlnSlowly("    Buscar coche por ID    ", 5);
		System.out.println("===========================\n");

		System.out.println("Seleccione el ID a buscar: ");
		int id = validarIntNoVacio("ID");
		Coche c = gestor.selectById(id);
		if (c == null) {
			System.out.println("No se ha encontrado ningún coche con el ID especificado.");
		} else {
			System.out.println("Coche seleccionado: ");
			System.out.println(c);
		}

	}

	private void buscarCochePorMarca() {
		System.out.println("\n===========================");
		printlnSlowly("   Buscar coche por marca  ", 5);
		System.out.println("===========================\n");

		printSlowly("Seleccione la marca a buscar: ", 25);
		String marca = validarStringNoVacio("Marca");
		List<Coche> listaCoches = gestor.selectByMarca(marca);
		if (listaCoches.size() == 0) {
			printlnSlowly("No se ha encontrado ningún coche con la marca especificada.", 25);
		} else {
			printlnSlowly("Coches con la marca " + marca + ": ", 25);
			for (Coche coche : listaCoches) {
				System.out.println(coche);
			}
		}

	}

	private void modificarCochePorID() {
		System.out.println("\n===========================");
		printlnSlowly("   Modificar coche por ID  ", 5);
		System.out.println("===========================\n");

		printlnSlowly("Seleccione el ID a modificar: ", 25);
		int id = validarIntNoVacio("ID");
		Coche c = gestor.selectById(id);

		if (c == null) {
			printlnSlowly("No se ha encontrado ningún coche con el ID especificado.", 25);
		} else {
			printlnSlowly("Coche seleccionado: ", 25);
			System.out.println(c.toString());
			printlnSlowly("¿Seguro que quieres modificarlo?", 25);
			printlnSlowly("\n1. Modificarlo", 10);
			printlnSlowly("2. No modificarlo\n", 10);
			printSlowly("- Seleccione una opción: ", 25);
			int opcion = validarOpcion(1, 2);
			if (opcion == 1) {

				c = pedirDatosCoche();
				c.setId(id);
				int resultado = gestor.updateById(c);
				
				if (resultado == 1) {
					printlnSlowly("Coche con id " + id + " modificado correctamente.", 25);
				} else {
					printlnSlowly("Ha ocurrido un error. Inténtelo de nuevo más tarde.", 25);
				}
			}
		}

	}

	private void bajaCochePorId() {
		System.out.println("\n===========================");
		printlnSlowly("      Baja coche por ID    ", 5);
		System.out.println("===========================\n");

		printSlowly("Seleccione el ID a borrar: ", 25);
		int id = validarIntNoVacio("ID");
		Coche c = gestor.selectById(id);

		if (c == null) {
			printSlowly("No se ha encontrado ningún coche con el ID especificado.", 25);
		} else {
			printlnSlowly("Coche seleccionado: ", 25);
			System.out.println(c.toString());
			printlnSlowly("¿Seguro que quieres eliminarlo?", 25);
			printlnSlowly("\n- 1. Eliminarlo", 10);
			printlnSlowly("- 2. No eliminarlo\n", 10);
			printSlowly("- Seleccione una opción: ", 25);
			int opcion = validarOpcion(1, 2);
			if (opcion == 1) {
				int resultado = gestor.deleteById(id);
				if (resultado == 1) {
					printlnSlowly("Coche con ID " + id + " eliminado correctamente.", 25);
				} else {
					printlnSlowly("Ha ocurrido un error. Inténtelo de nuevo más tarde.", 25);
				}
			}
		}

	}

	private void altaCoche() {
		System.out.println("\n===========================");
		printlnSlowly("    Dar de alta un coche   ", 5);
		System.out.println("===========================\n");
		Coche c = pedirDatosCoche();
		int resultado = gestor.insert(c);
		if (resultado == 1) {
			printlnSlowly("\nCoche insertado correctamente.", 25);
		} else {
			printlnSlowly("Ha ocurrido un error. Inténtelo de nuevo más tarde.", 25);
		}
	}


	private Coche pedirDatosCoche() {

		printSlowly("- Marca: ", 25);
		String marca = validarStringNoVacio("Marca");
		printSlowly("- Modelo: ", 25);
		String modelo = validarStringNoVacio("Modelo");
		printSlowly("- Kilómetros: ", 25);
		int kilometros = validarIntNoVacio("Kilometros");
		printSlowly("- Seleccione un motor: ", 25);
		TipoMotor motor = seleccionMotor();

		return new Coche(marca, modelo, motor, kilometros);

	}

	private TipoMotor seleccionMotor() {
		printlnSlowly("\n\t1. Diésel", 25);
		printlnSlowly("\t2. Gasolina", 25);
		printlnSlowly("\t3. Eléctrico", 25);
		printlnSlowly("\t4. Híbrido", 25);
		printlnSlowly("\t5. GLP\n", 25);
		printSlowly("- Opción: ", 25);
		int opcionMotor = scInt.nextInt();
		TipoMotor motor = null;

		switch (opcionMotor) {
		case 1:
			motor = TipoMotor.DIESEL;
			break;
		case 2:
			motor = TipoMotor.GASOLINA;
			break;
		case 3:
			motor = TipoMotor.ELECTRICO;
			break;
		case 4:
			motor = TipoMotor.HIBRIDO;
			break;
		case 5:
			motor = TipoMotor.GLP;
			break;
		}

		return motor;
	}

	private int validarIntNoVacio(String atributo) {
		int i = scInt.nextInt();

		while (i == 0) {
			printlnSlowly("Campo vacío no válido.", 25);
			printlnSlowly("- Introduce un valor para " + atributo, 25);
			i = scInt.nextInt();
		}
		return i;
	}

	private String validarStringNoVacio(String atributo) {

		String s = scStr.nextLine();

		while (s.isBlank()) {
			printlnSlowly("Campo vacío no válido.", 25);
			printlnSlowly("- Introduce un valor para " + atributo, 25);
			s = scStr.nextLine();
		}
		return s;
	}

	private int validarOpcion(int i, int j) {
		int opcion = scInt.nextInt();
		System.out.println("");
		while (opcion < i || opcion > j) {
			printlnSlowly("  [ERROR] Introduce una opción correcta", 25);
			System.out.println();
			printSlowly("- Introduce un número entre " + i + " y " + j + ": ", 25);
			opcion = scInt.nextInt();
		}
		return opcion;
	}
	
	public static void print3Points(int time, int time2) {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(time);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		try {
			Thread.sleep(time2);
			System.out.print(" ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void printSlowly(String s, int time) {
		for (int i = 0; i < s.length(); i++) {
			try {
				Thread.sleep(time);
				System.out.print(s.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void printlnSlowly(String s, int time) {
		for (int i = 0; i < s.length(); i++) {
			try {
				Thread.sleep(time);
				System.out.print(s.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
	}

}
