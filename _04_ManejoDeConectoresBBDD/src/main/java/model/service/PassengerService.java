package model.service;

public class PassengerService {

	public static PassengerService gestorPasajeros;

	private PassengerService() {
	}

	public static PassengerService getInstance() {
		return (gestorPasajeros == null) ? gestorPasajeros = new PassengerService() : gestorPasajeros;
	}

}
