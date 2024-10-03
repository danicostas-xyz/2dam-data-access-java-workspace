package entidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import main.Main;

public class App {

	HashMap<String, String> listaUsuarios = crearListaUsuarios();

	private static HashMap<String, String> crearListaUsuarios() {
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

	public HashMap<String, String> getListaUsuarios() {
		return listaUsuarios;
	}

}
