package model.persistence.dao;

import java.util.List;

import model.entity.Passenger;
import model.persistence.interfaces.DaoPassenger;

public class DaoPassengerMySQL implements DaoPassenger {

	
	public static DaoPassengerMySQL dao;
	private DaoPassengerMySQL() {	
	}
	public static DaoPassengerMySQL getInstance() {
		return (dao == null) ? dao = new DaoPassengerMySQL() : dao;
	}
	

	@Override
	public Integer createPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deletePassengerById(int passengerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger getPassengerById(int passengerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> listAllPassengers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addPassengerToCar(int passengerID, int carID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deletePassengerFromCar(int passengerID, int carID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> listPassengersFromCar(int carID) {
		// TODO Auto-generated method stub
		return null;
	}

}
