package modelo.entidad;

import java.util.Objects;

public class Pasajero {
	private int id;
	private String nombre;
	private int edad;
	private double peso;
	private Coche coche;
	
	public Pasajero(String nombre, int edad, double peso, Coche coche) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.coche = coche;
	}

	public Pasajero() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	@Override
	public String toString() {
	    return "=== Información del Pasajero ===\n" +
	           "ID: " + id + "\n" +
	           "Nombre: " + capitalize(nombre) + "\n" +
	           "Edad: " + edad + " años\n" +
	           "Peso: " + peso + " kg\n" +
	           "Coche: " + coche.getId() + "\n";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return id == other.id;
	}
	
	private String capitalize(String s) {
		String strCapitalized = "";

		/* MERCEDES BENZ */
		String strRaw = s.toLowerCase(); /* mercedes benz */

		String strAuxiliar = "";
		String strAuxiliar2 = "";

		String[] listaPalabrasRaw = strRaw.split(" "); /* [mercedes][benz] */

		for (String string : listaPalabrasRaw) {
			/* 1º mercedes 2º benz */
			char inicial = string.charAt(0); /* m */
			strAuxiliar += inicial;
			strAuxiliar2 = strAuxiliar.toUpperCase(); /* M */
			for (int i = 1; i < string.length(); i++) {
				strAuxiliar2 += string.charAt(i);
			} /* M+e+r+c+e+d+e+s */

			strCapitalized += (strAuxiliar2 + " ");
			strAuxiliar = "";
			strAuxiliar2 = "";
		}

		return strCapitalized.trim();
	}



}
