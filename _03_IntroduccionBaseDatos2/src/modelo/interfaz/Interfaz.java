package modelo.interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.negocio.Gestor;

public class Interfaz {

	public static Interfaz interfaz;
	private Scanner scInt;
	private Scanner scStr;
	private Gestor gestor;

	private Interfaz() {
		scInt = new Scanner(System.in);
		scStr = new Scanner(System.in);
		gestor = Gestor.getInstance();
	}

	public static Interfaz getInstance() {
		return (interfaz == null) ? new Interfaz() : interfaz;
	}

	public void runApp() {
	    System.out.println("\n===========================");
	    System.out.println("        MENÚ PRINCIPAL     ");
	    System.out.println("===========================\n");

		int opcion = validarOpcion();
		
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
				opcion = validarOpcion();
				break;
			case 2:
				bajaCochePorId();
				opcion = validarOpcion();
				break;
			case 3:
				modificarCochePorID();
				opcion = validarOpcion();
				break;
			case 4:
				buscarCochePorId();
				opcion = validarOpcion();
				break;
			case 5:
				buscarCochePorMarca();
				opcion = validarOpcion();
				break;
			case 6:
				listarTodosLosCoches();
				opcion = validarOpcion();
				break;
			default:
				break;
			}

		}

		System.out.println("\n============================");
	    System.out.println("       FIN DEL PROGRAMA      ");
	    System.out.println("=============================");

	}

	private int validarOpcion() {
		int opcion = printMenu();
		while (opcion < 0 || opcion > 6) {
			System.out.print("Introduce un número entre 0 y 6: ");
			opcion = scInt.nextInt();
		}
		return opcion;
	}

	private int printMenu() {
		System.out.println("===========================");
	    System.out.println("0. Salir de la aplicación");
	    System.out.println("1. Dar de alta un coche");
	    System.out.println("2. Dar de baja un coche por ID");
	    System.out.println("3. Modificar un coche por ID");
	    System.out.println("4. Buscar un coche por ID");
	    System.out.println("5. Buscar coches por marca");
	    System.out.println("6. Listar todos los coches");
	    System.out.println("===========================");
	    System.out.print("Seleccione una opción: ");
	    
	    int opcion = scInt.nextInt();
	    return opcion;
	}

	private void listarTodosLosCoches() {
		// TODO Auto-generated method stub

	}

	private void buscarCochePorId() {
		// TODO Auto-generated method stub

	}

	private void buscarCochePorMarca() {
		// TODO Auto-generated method stub

	}

	private void modificarCochePorID() {
		// TODO Auto-generated method stub

	}

	private void bajaCochePorId() {
		// TODO Auto-generated method stub

	}

	private void altaCoche() {

	    System.out.println("Dar de alta un coche");
	    System.out.println("- Marca: ");
	    String marca = scStr.nextLine();
	    System.out.println("- Modelo: ");
	    String modelo = scStr.nextLine();
	    System.out.println("- Kilómetros: ");
	    int kilometros = scInt.nextInt();
	    System.out.println("- Seleccione un motor: ");
	    TipoMotor motor = seleccionMotor();
	    
		Coche c = new Coche(marca, modelo, motor, kilometros);
		
		boolean[] resValidacion = gestor.validarDatos(c);
		

			if (resValidacion[0]) {
				System.out.print("Selecccione una marca correcta: ");
				c.setMarca(scStr.nextLine());
			}
			if (resValidacion[1]) {
				System.out.print("Selecccione una marca correcta: ");
				c.setMarca(scStr.nextLine());
			}
			if (resValidacion[2]) {
				System.out.print("Selecccione una marca correcta: ");
				c.setMarca(scStr.nextLine());
			}
			if (resValidacion[3]) {
				System.out.print("Selecccione una marca correcta: ");
				c.setMarca(scStr.nextLine());
			}


	}

	private TipoMotor seleccionMotor() {
		System.out.println("1. Diésel");
	    System.out.println("2. Gasolina");
	    System.out.println("3. Eléctrico");
	    System.out.println("4. Híbrido");
	    System.out.println("5. GLP");
	    System.out.print("Opción: ");
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

}
