package model.persistence.interfaces;

import java.util.List;

import model.entity.Passenger;

public interface DaoPassenger {

	/**
	 * Crea un pasajero en la persistencia en base al objeto Passenger pasado por parámetro.
	 * @param passenger el objeto Passenger a persistir.
	 * @return 0 en caso de que se haya persistido correctamente, 
	 * 1 en caso de que no se haya persistido por error en algún atributo,
	 * null en caso de que haya ocurrido alguna excepción de I/O
	 */
	Integer createPassenger(Passenger passenger);
	
	/**
	 * Elimina un pasajero de la persistencia en base al id pasado por parámetro.
	 * @param passengerID el ID del Passenger a eliminar.
	 * @return 0 en caso de que se haya eliminado correctamente, 
	 * 1 en caso de que no se haya eliminado por no haberse encontrado el ID,
	 * null en caso de que haya ocurrido alguna excepción de I/O.
	 */
	Integer deletePassengerById(int passengerID);
	
	/**
	 * Recupera un pasajero de la persistencia en base al id pasado por parámetro.
	 * @param passengerID el ID del Passenger a recuperar de la persistencia.
	 * @return el Passenger que coincida con el id,
	 * un objeto Passenger vacío en caso de que no se encuentre el Passenger
	 * null en caso de que haya ocurrido alguna excepción de I/O.
	 */
	Passenger getPassengerById(int passengerID);
	
	/**
	 * Recupera todos los Passengers de la persistencia.
	 * @return una List<Passenger> con todos los Passengers que se hayan recuperado,
	 * un List<Passenger> vacío en caso de que no se haya encontrado ninguno,
	 * null en caso de que haya ocurrido alguna excepción de I/O.
	 */
	List<Passenger> listAllPassengers();
	
	/**
	 * Añade un Passenger a un Car existente en la persistencia.
	 * @param passengerID el ID del Passenger a añadir al Car
	 * @param carID el ID del Car al cual debe ser añadido el Passenger
	 * @return 0 en caso de que se haya añadido correctamente el Passenger al Car, 
	 * 1 en caso de que no se haya añadido por no encontrarse el Passenger,
	 * 2 en caso de que no se haya añadido por no encontrarse el Car,
	 * null en caso de que haya ocurrido alguna excepción de I/O.
	 */
	Integer addPassengerToCar(int passengerID, int carID);
	
	/**
	 * Elimina un Passenger de un Car en la persistencia.
	 * @param passengerID el ID del Passenger a eliminar del Car
	 * @param carID el ID del Car del cual eliminar al Passenger
	 * @return 0 en caso de que se haya eliminado correctamente, 
	 * 1 en caso de que no se haya eliminado por no haberse encontrado al Passenger,
	 * 2 en caso de que no se haya eliminado por no haberse encontrado al Car,
	 * null en caso de que haya ocurrido alguna excepción de I/O.
	 */
	Integer deletePassengerFromCar(int passengerID, int carID);
	
	/**
	 * Recupera los Passenger de un determinado Car.
	 * @param carID el ID del Car del cual recuperar los Passenger
	 * @return una List<Passenger> con todos los Passengers que se hayan recuperado,
	 * un List<Passenger> vacío en caso de que no se haya encontrado ninguno,
	 * null en caso de que haya ocurrido alguna excepción de I/O.
	 */
	List<Passenger> listPassengersFromCar(int carID);
}
