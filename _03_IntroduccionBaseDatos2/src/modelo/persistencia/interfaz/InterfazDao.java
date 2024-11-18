package modelo.persistencia.interfaz;
import java.util.List;
import modelo.entidad.Coche;


public interface InterfazDao {
	
	public Integer insert(Coche c);

	/**
	 * Elimina un coche en la base de datos a partir de su ID.
	 * 
	 * @param id el ID del coche a eliminar
	 * @return el número de filas eliminadas, 0 si no se ha eliminado nada, o null
	 *         si ocurre una SQLException
	 */
	public Integer deleteById(int id);

	/**
	 * Actualiza los datos de un coche en la base de datos a partir de su ID.
	 * 
	 * @param c el objeto Coche con los datos actualizados
	 * @return 1 si la actualización es exitosa, 0 si no se ha modificado nada, o
	 *         null si ocurre una SQLException
	 */
	public Integer updateById(Coche c);

	/**
	 * Recupera un coche de la base de datos a partir de su ID.
	 * 
	 * @param id el ID del coche a buscar
	 * @return el objeto Coche si existe, o null si no se encuentra o si ocurre una
	 *         SQLException
	 */
	public Coche selectById(int id);

	/**
	 * Recupera una lista de coches que coincidan con una marca específica.
	 * 
	 * @param marca la marca de los coches a buscar
	 * @return una lista de coches de la marca especificada, o una lista vacía si no
	 *         se encuentran coincidencias
	 */
	public List<Coche> selectByMarca(String marca);

	/**
	 * Recupera todos los coches de la base de datos.
	 * 
	 * @return una lista con todos los coches de la base de datos
	 */
	public List<Coche> selectAll();


}
