package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaz.DaoCoche;

public class GestorCoche {

	// Begin Singleton
	public static GestorCoche gestor;
	private DaoCoche dao;

	private GestorCoche() {
		dao = DaoCocheMySQL.getInstance();
	}

	public static GestorCoche getInstance() {
		return (gestor == null) ? new GestorCoche() : gestor;
	}
	// End Singleton

	/**
	 * Valida que ninguno de los atributos del coche estén vacíos.
	 * 
	 * @param c el objeto Coche con los datos a validar
	 * @return un array de booleans de 4 posiciones, en la que cada posición
	 *         representa el atributo a analizar. Si en una posición dada hay un
	 *         false, es que ese atributo es correcto. Si hay un true, es que es
	 *         incorrecto
	 *         <ul>
	 *         <li>Posición 0: Marca</li>
	 *         <li>Posición 1: Modelo</li>
	 *         <li>Posición 2: Motor</li>
	 *         <li>Posición 3: Kilometros</li>
	 *         </ul>
	 */
	public boolean[] validarDatos(Coche c) {

		boolean[] resValidacion = new boolean[4];

		if (c.getMarca().isBlank()) {
			resValidacion[0] = true;
		}

		if (c.getModelo().isBlank()) {
			resValidacion[1] = true;
		}

		if (c.getMotor() == null) {
			resValidacion[2] = true;
		}

		if (c.getKilometros() == 0) {
			resValidacion[3] = true;
		}

		return resValidacion;

	}

	/**
	 * Llama al método insert del Dao para insertar el coche pasado por parámetro.
	 * 
	 * @param c el objeto Coche con los datos a insertar
	 * @return 1 si la inserción es exitosa, 0 si no se ha insertado nada, o null si
	 *         ocurre una SQLException
	 */
	public Integer insert(Coche c) {
		return dao.insert(c);
	}

	/**
	 * Llama al método deleteById del Dao para eliminar el coche pasado por
	 * parámetro
	 * 
	 * @param id el ID del coche a eliminar
	 * @return el número de filas eliminadas, 0 si no se ha eliminado nada, o null
	 *         si ocurre una SQLException
	 */
	public Integer deleteById(int id) {
		return dao.deleteById(id);
	}

	/**
	 * Llama al método updateById para actualizar los datos del coche pasado por
	 * parámetro a partir de su ID
	 * 
	 * @param c el objeto Coche con los datos actualizados
	 * @return 1 si la actualización es exitosa, 0 si no se ha modificado nada, o
	 *         null si ocurre una SQLException
	 */
	public Integer updateById(Coche c) {
		return dao.updateById(c);
	}

	/**
	 * Llama al método selectByID para recuperar un coche por su ID
	 * 
	 * @param id el ID del coche a buscar
	 * @return el objeto Coche si existe, o null si no se encuentra o si ocurre una
	 *         SQLException
	 */
	public Coche selectById(int id) {
		return dao.selectById(id);
	}

	/**
	 * Llama al método selectByMarca del dao para recuperar los coches que coincidan
	 * con la marca pasada por parámetro.
	 * 
	 * @param marca la marca de los coches a buscar
	 * @return una lista de coches de la marca especificada, o una lista vacía si no
	 *         se encuentran coincidencias
	 */
	public List<Coche> selectByMarca(String marca) {
		return dao.selectByMarca(marca);
	}

	/**
	 * Recupera todos los coches de la base de datos.
	 * 
	 * @return una lista con todos los coches de la base de datos
	 */
	public List<Coche> selectAll() {
		return dao.selectAll();
	}

}
