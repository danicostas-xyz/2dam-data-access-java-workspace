package model.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.AppConfig;
import model.entity.Passenger;
import model.persistence.interfaces.DaoPassenger;

public class DaoPassengerMySQL implements DaoPassenger {

	Passenger passenger;

	public static DaoPassengerMySQL dao;

	private DaoPassengerMySQL() {
	}

	public static DaoPassengerMySQL getInstance() {
		return (dao == null) ? dao = new DaoPassengerMySQL() : dao;
	}

	private String url = AppConfig.getInstance().getProperty("url");
	private String user = AppConfig.getInstance().getProperty("user");
	private String pass = AppConfig.getInstance().getProperty("pass");

	@Override
	public Integer createPassenger(Passenger passenger) {

		Integer result = null;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			String query = "INSERT INTO PASAJEROS (nombre, edad, peso) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, passenger.getNombre().toUpperCase());
			ps.setInt(2, passenger.getEdad());
			ps.setDouble(3, passenger.getPeso());

			return (ps.executeUpdate() > 0) ? 0 : 1; // Si executeUpdate() es > 0 es que se ha creado correctamente y se
														// devuelve 0
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	@Override
	public Integer deletePassengerById(int passengerID) {

		Integer result = null;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			String query = "DELETE FROM PASAJEROS WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, passengerID);
			result = (ps.executeUpdate() > 0) ? 0 : 1; // Si executeUpdate() es > 0 es que se ha eliminado correctamente
														// y se devuelve 0
		} catch (SQLException e) {
			result = null;
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Passenger getPassengerById(int passengerID) {

		List<Passenger> passengerList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "SELECT * FROM PASAJEROS WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, passengerID);
			passengerList = resultSetHandler(ps);

		} catch (SQLException e) {
			passenger = null;
			e.printStackTrace();
		}

		// Aquí habría que añadir un pasajero vacío en caso de que no se encuentre
		// ningún pasajaro con un ID dado
		return passengerList.get(0);
	}

	@Override
	public List<Passenger> listAllPassengers() {

		List<Passenger> passengerList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "SELECT * FROM PASAJEROS";
			PreparedStatement ps = conn.prepareStatement(query);
			passengerList = resultSetHandler(ps);

		} catch (SQLException e) {
			passenger = null;
			e.printStackTrace();
		}
		return passengerList;
	}

	@Override
	public Integer addPassengerToCar(int passengerID, int carID) {

		Integer result = null;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "UPDATE pasajeros SET id_coche=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, carID);
			ps.setInt(2, passengerID);
			result = (ps.executeUpdate() > 0) ? 0 : 1;
			/*
			 * Hay que revisar este método porque no valido si existe coche y/o pasajero y
			 * entonces no estoy cumpliendo con las opciones de return de la interfaz
			 */

		} catch (SQLException e) {
			result = null;
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Integer deletePassengerFromCar(int passengerID) {

		Integer result = null;

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "UPDATE pasajeros SET id_coche=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setNull(1, java.sql.Types.INTEGER);
			ps.setInt(2, passengerID);
			result = (ps.executeUpdate() > 0) ? 0 : 1;
			/*
			 * Hay que revisar este método porque no valido si existe coche y/o pasajero y
			 * entonces no estoy cumpliendo con las opciones de return de la interfaz
			 */

		} catch (SQLException e) {
			result = null;
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Passenger> listPassengersFromCar(int carID) {

		List<Passenger> listaPasajeros = new ArrayList<Passenger>();

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String query = "SELECT * FROM pasajeros WHERE id_coche=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, carID);
			listaPasajeros = resultSetHandler(ps);

		} catch (SQLException e) {
			listaPasajeros = null;
			e.printStackTrace();
		}

		return listaPasajeros;
	}

	private List<Passenger> resultSetHandler(PreparedStatement ps) {

		List<Passenger> passengerList = new ArrayList<>();
		Passenger passenger = null;

		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				passenger = new Passenger();
				passenger.setId(rs.getInt(1));
				passenger.setNombre(rs.getString(2));
				passenger.setEdad(rs.getInt(3));
				passenger.setPeso(rs.getDouble(4));
				passenger.setId_coche(rs.getInt(5));

				passengerList.add(passenger);
			}
		} catch (SQLException e) {
			passengerList = null;
			e.printStackTrace();
		}
		
		if (passengerList.size() == 0) passengerList.add(null);

		return passengerList;
	}

}
