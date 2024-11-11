package modelo.interfaz;

import java.util.Scanner;

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
		Gestor.getInstance();

	}

	private static int printMenu() {
		System.out.println("0. Salir");
		System.out.println("1. Introducir Coche");
		int opcion = scInt.nextInt();
		return opcion;
	}

}
