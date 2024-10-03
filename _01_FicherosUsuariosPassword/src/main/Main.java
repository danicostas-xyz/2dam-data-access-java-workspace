package main;

import java.util.HashMap;
import java.util.Scanner;

import entidad.App;
import entidad.Usuario;

public class Main {

	public static final String FICHERO_USERS_PASSWORDS = "users-and-passwords.txt";
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		App app = new App();

		switch (printMenu()) {
		case 1:
			int intentos = 3;
			while (intentos > 0) {
				if(app.validarLogIn()) {
					app.iniciarSesion();
					return;
				} else {
					intentos--;
				}
			}
			System.out.println("App Bloqueada por pasarte de intentos");
			break;
		case 2:
			app.registrarUsuario();
			break;
		}

		sc.close();
	}

	private static int printMenu() {
		System.out.println("-----------------------------");
		System.out.println("         UPGRADE HUB         ");
		System.out.println("-----------------------------");

		System.out.println("MENÚ DE INICIO");
		System.out.println("");
		System.out.println("1. Iniciar Sesión");
		System.out.println("2. Nuevo Registro");
		System.out.println("");

		int choice = 0;
		do {
			System.out.print("Selecciona 1 o 2: ");
			choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2) {
				System.out.println("Opción incorrecta");
			}
		} while (choice < 1 || choice > 2);

		return choice;
	}

}
