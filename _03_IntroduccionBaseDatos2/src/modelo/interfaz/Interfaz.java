package modelo.interfaz;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.persistencia.Dao;

public class Interfaz {
	public static void main(String[] args) {
		TipoMotor motor = TipoMotor.GASOLINA;
		Coche c = new Coche("Ferrari", "F40", motor, 75000);
		Dao.getInstance().insert(c);
	}
}
