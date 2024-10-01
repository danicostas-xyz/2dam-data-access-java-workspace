package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	public static final String FICHERO_USERS_PASSWORDS = "users-and-passwords.txt";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		
		
		System.out.println("-----------------------------");
		System.out.println("         UPGRADE HUB         ");
		System.out.println("-----------------------------");
		
		System.out.println("1. Iniciar Sesión");
		System.out.println("2. Nuevo Registro");
		System.out.println("");
		
		System.out.print("Introduce 1 o 2: ");
		int choice = Integer.parseInt(sc.nextLine());
		
		String user;
		String pass;
		
		switch (choice) {
		case 1:
			System.out.print("- User: ");
			user = sc.nextLine().trim();
			System.out.print("- Pass: ");
			pass = sc.nextLine().trim();
			leer(user, pass);
			break;
		case 2:
			System.out.print("- User: ");
			user = sc.nextLine().trim();
			System.out.print("- Pass: ");
			pass = sc.nextLine().trim();
			escribir(user, pass);
			break;
		}
		
		
	

		

		// escribir(user, pass);

		sc.close();
	}

	private static void escribir(String user, String pass) {
		// Hay que poner true, si no existe se crea y si existe se abre en modo append
		// para no sobreescribirlo
		try (FileWriter fw = new FileWriter(FICHERO_USERS_PASSWORDS, true);
				BufferedWriter bw = new BufferedWriter(fw)) {

			bw.write(user + "/" + pass);
			bw.newLine();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void leer(String user, String pass) {
		try (FileReader fr = new FileReader(FICHERO_USERS_PASSWORDS); 
				BufferedReader br = new BufferedReader(fr)) {
			
			String linea = br.readLine();
			while(linea != null) {
				//System.out.println(linea.split("/")[0]);
				if (linea.split("/")[0]);
				linea = br.readLine();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
