package modelo.interfaz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.persistencia.Dao;

public class Interfaz {
	public static void main(String[] args) {
		TipoMotor motor = TipoMotor.GASOLINA;
		Coche c = new Coche("Seat", "F40", motor, 75000);
		Dao.getInstance().insert(c);
		List<Coche> cs = Dao.getInstance().selectByMarca("Seat");
		System.out.println(cs);

	}
}
