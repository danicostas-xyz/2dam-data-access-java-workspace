package entidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import main.Main;

public class App {

	private Usuario usuario;
	private HashMap<String, String> listaUsuarios = crearListaUsuarios();

	public HashMap<String, String> crearListaUsuarios() {
		try (FileReader fr = new FileReader(Main.FICHERO_USERS_PASSWORDS); BufferedReader br = new BufferedReader(fr)) {

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

	public boolean validarLogIn() {
		System.out.print("- User: ");
		String user = Main.sc.nextLine().trim();
		System.out.print("- Pass: ");
		String pass = Main.sc.nextLine().trim();

		if (listaUsuarios != null) {
			if (listaUsuarios.containsKey(user)) {
				if (listaUsuarios.get(user).equals(pass)) {
					System.out.println("Bienvenido " + user);
					return true;
				} else {
					System.out.println("Usuario y/o contraseña incorrectos");
					return false;
				}
			} else {
				System.out.println("Usuario y/o contraseña incorrectos");
				return false;
			}
		} else {
			System.out.println("Se ha producido un error en la carga de usuarios.");
			System.out.println("Por favor, vuelva a intentarlo más tarde");
			
		}
		return false;
	}

	public void registrarUsuario() {
		usuario = new Usuario();
		System.out.print("- User: ");
		usuario.setUser(Main.sc.nextLine().trim());
		System.out.print("- Pass: ");
		usuario.setPass(Main.sc.nextLine().trim());

		try (FileWriter fw = new FileWriter(Main.FICHERO_USERS_PASSWORDS, true);
				BufferedWriter bw = new BufferedWriter(fw)) {

			bw.write(usuario.getUser() + "/" + usuario.getPass());
			bw.newLine();

			System.out.println("Usuario creado con éxito");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getListaUsuarios() {
		return listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void iniciarSesion() {
		// TODO Auto-generated method stub
		
	}

}
