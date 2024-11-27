package model.service;

import java.util.List;

import model.entity.Passenger;
import model.persistence.dao.DaoPassengerMySQL;

public class PassengerService {
	
	/*
	 * Ahora mismo los métodos son una réplica de los métodos del DAO
	 * Sería interesante aplicar alguna restricción (número de plazas, etc.)
	 * 
	 * */
	
	DaoPassengerMySQL dao;

	public static PassengerService gestorPasajeros;

	private PassengerService() {
		dao = DaoPassengerMySQL.getInstance();
	}

	public static PassengerService getInstance() {
		return (gestorPasajeros == null) ? gestorPasajeros = new PassengerService() : gestorPasajeros;
	}
	
	public Integer createPassenger(Passenger passenger) {
		return dao.createPassenger(passenger);
	}
	
	
	public Integer deletePassengerById(int passengerID) {
		return dao.deletePassengerById(passengerID);
	}
	
	
	public Passenger getPassengerById(int passengerID) {
		return dao.getPassengerById(passengerID);
	}
	
	
	public List<Passenger> listAllPassengers() {
		return dao.listAllPassengers();
	}
	
	
	public Integer addPassengerToCar(int passengerID, int carID) {
		return dao.addPassengerToCar(passengerID, carID);
	}
	
	
	public Integer deletePassengerFromCar(int passengerID) {
		return dao.deletePassengerFromCar(passengerID);
	}
	
	
	public List<Passenger> listPassengersFromCar(int carID) {
		return dao.listPassengersFromCar(carID);
	}

}
