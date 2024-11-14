package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;

public class Dao {

	/*
	 * CREATE TABLE coches ( id INT AUTO_INCREMENT PRIMARY KEY, MARCA VARCHAR(50)
	 * NOT NULL, MODELO VARCHAR(50) NOT NULL, MOTOR VARCHAR(50) NOT NULL, KILOMETROS
	 * INT NOT NULL );
	 * 
	 */

	private String url = "jdbc:mysql://localhost:3306/03_introduccionbbdd2";
	private String user = "root";
	private String pass = "";

	// Begin Singleton
	public static Dao dao;

	private Dao() {
	}

	public static Dao getInstance() {
		return (dao == null) ? new Dao() : dao;
	}
	// End Singleton

	public int insert() {

		return 0;
	}

	public int deleteById() {

		return 0;
	}

	public int updateById() {

		return 0;
	}

	public Coche selectById(int id) {
		
		Coche c = null;

		try (Connection conn = DriverManager.getConnection(url);) {

			String query = "SELECT * FROM coches WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			selectQuery(ps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;

	}

	public ResultSet selectByMarca(String marca) {
		return null;

	}

	public ResultSet selectAll() {

		return null;

	}

	private Coche selectQuery(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.executeQuery();
		Coche c = null;
		List<Coche> listaCoches = new ArrayList<Coche>();
		while (rs.next()) {
			c = new Coche();
			c.setId(rs.getInt(1));
			c.setMarca(rs.getString(2));
			c.setModelo(rs.getString(3));
			String motor = rs.getString(4);
			switch (motor) {
			case "GASOLINA":
				c.setMotor(TipoMotor.GASOLINA);
				break;
			case "DIESEL":
				c.setMotor(TipoMotor.DIESEL);
				break;
			case "ELECTRICO":
				c.setMotor(TipoMotor.ELECTRICO);
				break;
			case "HIBRIDO":
				c.setMotor(TipoMotor.HIBRIDO);
				break;
			case "GLP":
				c.setMotor(TipoMotor.GLP);
				break;
			}
			c.setKilometros(rs.getInt(5));
		}

		return c;
	}

}
