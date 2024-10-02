package entidad;

import java.io.BufferedWriter;
import java.io.FileWriter;

import main.Main;

public class Usuario {

	private String user;
	private String pass;

	public Usuario() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void altaUsuario() {
		// Hay que poner true, si no existe se crea y si existe se abre en modo append
		// para no sobreescribirlo
		try (FileWriter fw = new FileWriter(Main.FICHERO_USERS_PASSWORDS, true);
				BufferedWriter bw = new BufferedWriter(fw)) {

			bw.write(user + "/" + pass);
			bw.newLine();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
