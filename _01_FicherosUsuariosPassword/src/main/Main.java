package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import entidad.Usuario;

public class Main {

	public static final String FICHERO_USERS_PASSWORDS = "users-and-passwords.txt";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		switch (printMenu()) {
		case 1:
			validarLogIn();
			break;
		case 2:
			registrarUsuario();
			break;
		}

		sc.close();
	}

	private static void registrarUsuario() {
		Usuario usuario = new Usuario();
		System.out.print("- User: ");
		usuario.setUser(sc.nextLine().trim());
		System.out.print("- Pass: ");
		usuario.setPass(sc.nextLine().trim());
		usuario.altaUsuario();
	}

	private static void validarLogIn() {
		System.out.print("- User: ");
		String user = sc.nextLine().trim();
		System.out.print("- Pass: ");
		String pass = sc.nextLine().trim();

		HashMap<String, String> listaUsuarios = crearListaUsuarios(user, pass);

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

	private static HashMap<String, String> crearListaUsuarios(String user, String pass) {
		try (FileReader fr = new FileReader(FICHERO_USERS_PASSWORDS); BufferedReader br = new BufferedReader(fr)) {

			String linea = br.readLine();
			HashMap<String, String> listaUsuarios = new HashMap<String, String>();

			while (linea != null) {
				listaUsuarios.put(linea.split("/")[0], linea.split("/")[1]);
				linea = br.readLine();
			}
			return listaUsuarios;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
