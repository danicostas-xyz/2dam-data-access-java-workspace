package main;

import java.util.HashMap;
import java.util.Scanner;

import entidad.App;
import entidad.Usuario;

public class Main {

	public static final String FICHERO_USERS_PASSWORDS = "users-and-passwords.txt";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		App app = new App();
		HashMap<String, String> listaUsuarios = app.getListaUsuarios();

		switch (printMenu()) {
		case 1:
			validarLogIn(listaUsuarios);
			break;
		case 2:
			registrarUsuario();
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

	private static void validarLogIn(HashMap<String, String> listaUsuarios) {
		System.out.print("- User: ");
		String user = sc.nextLine().trim();
		System.out.print("- Pass: ");
		String pass = sc.nextLine().trim();

		if (listaUsuarios != null) {
			if (listaUsuarios.containsKey(user)) {
				if (listaUsuarios.get(user).equals(pass)) {
					System.out.println("Bienvenido " + user);
				} else {
					System.out.println("Usuario y/o contraseña incorrectos");
				}
			} else {
				System.out.println("Usuario y/o contraseña incorrectos");
			}
		} else {
			System.out.println("Se ha producido un error en la carga de usuarios.");
			System.out.println("Por favor, vuelva a intentarlo más tarde");
		}
	}

	private static void registrarUsuario() {
		Usuario usuario = new Usuario();
		System.out.print("- User: ");
		usuario.setUser(sc.nextLine().trim());
		System.out.print("- Pass: ");
		usuario.setPass(sc.nextLine().trim());
		usuario.altaUsuario();
	}

}
