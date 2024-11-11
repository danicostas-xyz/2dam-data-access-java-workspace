package modelo.negocio;

import modelo.entidad.Coche;

public class Gestor {
	public static Gestor gestor;

	private Gestor() {

	}

	public static Gestor getInstance() {
		if (gestor == null) {
			gestor = new Gestor();
		}

		return gestor;
	}

	/**
	 * Método que valida los atributos de un Coche pasado por parámetro para
	 * comprobar que no estén vacíos
	 * 
	 * @param c el Coche pasado por parámetro
	 * @return 0 Si todos los atributos tienen contenido 1 Si los kilómetros son
	 *         iguales a 0 2 Si la marca está vacío o solo tiene espacios en blanco
	 *         3 Si el modelo está vacío o solo tiene espacios en blanco 4 Si el
	 *         motor está vacío o solo tiene espacios en blanco
	 */
	public int validarDatosCoche(Coche c) {

		if (c.getKilometros() == 0 || c.getMarca().isBlank() || c.getModelo().isBlank() || c.getMotor() == null) {

			if (c.getKilometros() == 0) {
				return 1;
			}

			if (c.getMarca().isBlank()) {
				return 2;
			}

			if (c.getModelo().isBlank()) {
				return 3;
			}

			if (c.getMotor() == null) {
				return 4;
			}
		}

		return 0;
	}

}
