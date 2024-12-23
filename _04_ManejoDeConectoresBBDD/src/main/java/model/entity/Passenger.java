package model.entity;

import java.util.Objects;

public class Passenger {
	private int id;
	private String nombre;
	private int edad;
	private double peso;
	private int id_coche;
//	private Car coche;
	
	public Passenger(String nombre, int edad, double peso, Car coche, int id_coche) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.id_coche = id_coche;
//		this.coche = coche;
	}

	public int getId_coche() {
		return id_coche;
	}

	public void setId_coche(int id_coche) {
		this.id_coche = id_coche;
	}

	public Passenger() {
		super();
	}
	
	public void setId(int id) {
		this.id = id;
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

//	public Car getCoche() {
//		return coche;
//	}
//
//	public void setCoche(Car coche) {
//		this.coche = coche;
//	}

	@Override
	public String toString() {
	    return "=== Información del Pasajero ===\n" +
	           "ID: " + id + "\n" +
	           "Nombre: " + capitalize(nombre) + "\n" +
	           "Edad: " + edad + " años\n" +
	           "Peso: " + peso + " kg\n" +
	           "Coche: " + id_coche + "\n";
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
		Passenger other = (Passenger) obj;
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
