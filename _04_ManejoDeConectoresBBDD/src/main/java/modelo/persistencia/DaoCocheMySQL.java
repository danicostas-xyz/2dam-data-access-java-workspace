package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.AppConfig;
import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.persistencia.interfaz.DaoCoche;

public class DaoCocheMySQL implements DaoCoche {

	/*
	 * 
	 * Tabla SQL usada:
	 * 
	 * CREATE TABLE coches ( id INT AUTO_INCREMENT PRIMARY KEY, marca VARCHAR(50)
	 * NOT NULL, modelo VARCHAR(50) NOT NULL, motor VARCHAR(50) NOT NULL, kilometros
	 * INT NOT NULL );
	 */

	private String url = AppConfig.getInstance().getProperty("url");
	private String user = AppConfig.getInstance().getProperty("user");
	private String pass = AppConfig.getInstance().getProperty("pass");

	// Begin Singleton
	public static DaoCocheMySQL dao;

	private DaoCocheMySQL() {
	}

	public static DaoCocheMySQL getInstance() {
		return (dao == null) ? new DaoCocheMySQL() : dao;
	}
	// End Singleton

	/**
	 * Inserta un nuevo coche en la base de datos.
	 * 
	 * @param c el objeto Coche con los datos a insertar
	 * @return 1 si la inserción es exitosa, 0 si no se ha insertado nada, o null si
	 *         ocurre una SQLException
	 */
	public Integer insert(Coche c) {

		Integer resultado = 0;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "INSERT INTO coches (MARCA, MODELO, MOTOR, KILOMETROS) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c.getMarca().toUpperCase());
			ps.setString(2, c.getModelo().toUpperCase());
			ps.setString(3, String.valueOf(c.getMotor()).toUpperCase());
			ps.setInt(4, c.getKilometros());

			int rows = ps.executeUpdate();

			if (rows != 0) {
				resultado = rows;
			}

		} catch (SQLException e) {
			resultado = null;
			e.printStackTrace();
		}

		return resultado;
	}

	/**
	 * Elimina un coche en la base de datos a partir de su ID.
	 * 
	 * @param id el ID del coche a eliminar
	 * @return el número de filas eliminadas, 0 si no se ha eliminado nada, o null
	 *         si ocurre una SQLException
	 */
	public Integer deleteById(int id) {

		Integer resultado = 0;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "DELETE FROM coches WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows != 0) {
				resultado = rows;
			}

		} catch (SQLException e) {
			resultado = null;
			e.printStackTrace();
		}

		return resultado;
	}

	/**
	 * Actualiza los datos de un coche en la base de datos a partir de su ID.
	 * 
	 * @param c el objeto Coche con los datos actualizados
	 * @return 1 si la actualización es exitosa, 0 si no se ha modificado nada, o
	 *         null si ocurre una SQLException
	 */
	public Integer updateById(Coche c) {

		Integer resultado = 0;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "UPDATE coches SET marca = ?, modelo = ?, motor = ?, kilometros = ? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c.getMarca().toUpperCase());
			ps.setString(2, c.getModelo().toUpperCase());
			ps.setString(3, String.valueOf(c.getMotor()).toUpperCase());
			ps.setInt(4, c.getKilometros());
			ps.setInt(5, c.getId());

			int rows = ps.executeUpdate();

			if (rows != 0) {
				resultado = 1;
			}

		} catch (SQLException e) {
			resultado = null;
			e.printStackTrace();
		}

		return resultado;
	}

	/**
	 * Recupera un coche de la base de datos a partir de su ID.
	 * 
	 * @param id el ID del coche a buscar
	 * @return el objeto Coche si existe, o null si no se encuentra o si ocurre una
	 *         SQLException
	 */
	public Coche selectById(int id) {

		List<Coche> listaCoches = new ArrayList<Coche>();

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "SELECT * FROM coches WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			listaCoches = selectQuery(ps);

			selectQuery(ps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (listaCoches.size() == 0) {
			return null;
		}

		return listaCoches.get(0);

	}

	/**
	 * Recupera una lista de coches que coincidan con una marca específica.
	 * 
	 * @param marca la marca de los coches a buscar
	 * @return una lista de coches de la marca especificada, o una lista vacía si no
	 *         se encuentran coincidencias
	 */
	public List<Coche> selectByMarca(String marca) {

		List<Coche> listaCoches = new ArrayList<Coche>();

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "SELECT * FROM coches WHERE marca =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, marca);
			listaCoches = selectQuery(ps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaCoches;

	}

	/**
	 * Recupera todos los coches de la base de datos.
	 * 
	 * @return una lista con todos los coches de la base de datos
	 */
	public List<Coche> selectAll() {

		List<Coche> listaCoches = new ArrayList<Coche>();

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "SELECT * FROM coches";
			PreparedStatement ps = conn.prepareStatement(query);
			listaCoches = selectQuery(ps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaCoches;

	}

	/**
	 * Ejecuta una consulta SELECT y devuelve una lista de coches resultante.
	 * 
	 * @param ps el PreparedStatement que contiene la consulta SELECT
	 * @return una lista de coches recuperados por la consulta. Si la consulta no
	 *         devolviese ningún coche, se devolverá una lista vacía
	 * @throws SQLException si ocurre un error en la consulta
	 */

	private List<Coche> selectQuery(PreparedStatement ps) throws SQLException {

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
			listaCoches.add(c);
		}

		return listaCoches;

	}

}
