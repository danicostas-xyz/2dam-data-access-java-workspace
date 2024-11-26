package model.service;

public class PassengerService {

	
	
	public static PassengerService gestorPasajeros;
	private PassengerService() {
	}
	public static PassengerService getInstance() {
		return (gestorPasajeros == null) ? new PassengerService() : gestorPasajeros;
	}

}
