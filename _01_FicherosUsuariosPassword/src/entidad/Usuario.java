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

}
