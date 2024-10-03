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

		switch (menu()) {
		case 1:
			int intentos = 3;
			while (intentos > 0) {
				if (app.validarLogIn()) {
					app.iniciarSesion();
					return;
				} else if (app.getListaUsuarios().isEmpty()) {
					app.registrarUsuario();
					return;
				} else if (!app.getListaUsuarios().isEmpty()) {
					intentos--;
				}
			}
			System.out.println("App Bloqueada por pasarte de intentos");
			break;
		case 2:
			app.registrarUsuario();
			break;
		case 3:
			System.out.println("Programa finalizado");
		}

		sc.close();
	}

	private static int menu() {
		System.out.println("-----------------------------");
		System.out.println("         UPGRADE HUB         ");
		System.out.println("-----------------------------");

		System.out.println("MENÚ DE INICIO");
		System.out.println("");
		System.out.println("1. Iniciar Sesión");
		System.out.println("2. Nuevo Registro");
		System.out.println("3. Salir del Programa");
		System.out.println("");

		int choice = 0;
		do {
			System.out.print("Selecciona 1, 2 o 3: ");
			choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 3) {
				System.out.println("Opción incorrecta");
			}
		} while (choice < 1 || choice > 3);

		return choice;
	}

}
