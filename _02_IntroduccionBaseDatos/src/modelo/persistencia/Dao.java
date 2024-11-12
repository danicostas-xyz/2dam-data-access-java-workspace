package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.entidad.Coche;

public class Dao {

	public static Dao dao;
	private String url = "jdbc:mysql://127.0.0.1:3306/bbdd";
	private String user = "root";
	private String pass = "";

	private Dao() {

	}

	public static Dao getInstance() {
		if (dao == null) {
			dao = new Dao();
		}

		return dao;
	}

	/**
	 * Método que dado un Coche pasado por parámetro, extrae sus atributos y los
	 * persiste en Base de Datos
	 * 
	 * @param c el Coche a persistir en la Base de Datos
	 * @return 0 en caso de que se haya persistido el coche correctamente, 1 en caso
	 *         de que no se haya persistido ningún coche, 2 en caso de que haya
	 *         ocurrido algún error en la conexión a la base de datos
	 */
	public int insertIntoBBDD(Coche c) {

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "INSERT INTO coches (MARCA, MODELO, MOTOR, KILOMETROS) VALUES" + "(?, ?, ?, ?)";
			PreparedStatement prStmt = conn.prepareStatement(query);
			prStmt.setString(1, c.getMarca());
			prStmt.setString(2, c.getModelo());
			prStmt.setString(3, String.valueOf(c.getMotor()));
			prStmt.setInt(4, c.getKilometros());

			int rows = prStmt.executeUpdate();

			return (rows > 0) ? 0 : 1;

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			return 2;
		}
	}
}
