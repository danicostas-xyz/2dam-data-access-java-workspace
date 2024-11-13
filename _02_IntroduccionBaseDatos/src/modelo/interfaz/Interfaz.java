package modelo.interfaz;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.negocio.Gestor;

public class Interfaz {
	static Scanner scInt = new Scanner(System.in);
	static Scanner scStr = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("App de Coches");
		System.out.println("Seleccione una opción:");
		int opcion = printMenu();

		while (opcion != 0) {
			switch (opcion) {
			case 1:
				introducirCoche();
				opcion = printMenu();
				break;
			}
		}
		System.out.println("Fin del programa");
	}

	private static void introducirCoche() {
		
		System.out.println("- Marca: ");
		String marca = scStr.nextLine();
		System.out.println("- Modelo: ");
		String modelo = scStr.nextLine();
		System.out.println("- Kilómetros: ");
		int kilometros = scInt.nextInt();
		System.out.println("- Elija la opción del motor: ");
		System.out.println("1. Gasolina");
		System.out.println("2. Diésel");
		System.out.println("3. Hidrógeno");
		int motor = scInt.nextInt();
		TipoMotor tipoMotor = null;
		
		switch (motor) {
		case 1:
			tipoMotor = TipoMotor.GASOLINA;
			break;
		case 2:
			tipoMotor = TipoMotor.DIESEL;
			break;
		case 3:
			tipoMotor = TipoMotor.HIDROGENO;
			break;
		default:
			break;
		}

		Coche c = new Coche(marca, modelo, tipoMotor, kilometros);
		int respuesta = Gestor.getInstance().validarDatosCoche(c);
		
		if (respuesta == 0) {
			int respuestaGuardar = Gestor.getInstance().guardarCoche(c);
			if (respuestaGuardar == 00) {
				System.out.println("Coche guardado correctamente");
			}
		}

	}

	private static int printMenu() {
		System.out.println("0. Salir");
		System.out.println("1. Introducir Coche");
		int opcion = scInt.nextInt();
		return opcion;
	}

}
