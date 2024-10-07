package entidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		String user = Main.sc.nextLine().trim().toLowerCase();
		System.out.print("- Pass: ");
		String pass = hashPass(Main.sc.nextLine().trim());

		if (listaUsuarios != null) {
			if (!listaUsuarios.isEmpty()) {
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
				System.out.println("No hay ningún usuario en la plataforma");
				System.out.println("Por favor, cree el primer usuario");
				return false;
			}

		} else {
			System.out.println("Se ha producido un error en la carga de usuarios.");
			System.out.println("Por favor, vuelva a intentarlo más tarde");

		}
		return false;
	}

	public void registrarUsuario() {
		
		validarSiExisteUsuario();

		try (FileWriter fw = new FileWriter(Main.FICHERO_USERS_PASSWORDS, true);
				BufferedWriter bw = new BufferedWriter(fw)) {

			bw.write(usuario.getUser() + "/" + usuario.getPass());
			bw.newLine();

			System.out.println("Usuario creado con éxito");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String hashPass(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pass.getBytes(StandardCharsets.UTF_8));
			byte[] digest = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				String hex = Integer.toHexString(0xff & digest[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public HashMap<String, String> getListaUsuarios() {
		return listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	private void validarSiExisteUsuario(){
		usuario = new Usuario();
		System.out.print("- User: ");
		usuario.setUser(Main.sc.nextLine().trim().toLowerCase());
		boolean usuarioExiste = listaUsuarios.containsKey(usuario.getUser());
		
		while (usuarioExiste) {
			System.out.println("** EL USUARIO YA EXISTE **");
			System.out.println("** PRUEBA UNO DIFERENTE **");
			System.out.print("- User: ");
			usuario.setUser(Main.sc.nextLine().trim());
			usuarioExiste = listaUsuarios.containsKey(usuario.getUser());
		}

		System.out.print("- Pass: ");
		usuario.setPass(hashPass(Main.sc.nextLine().trim()));

	}

	public void iniciarSesion() {
		// TODO Auto-generated method stub

	}

}
