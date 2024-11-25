package modelo.entidad;

import java.util.List;
import java.util.Objects;

public class Coche {
	private int id;
	private String marca;
	private String modelo;
	private TipoMotor motor;
	private int kilometros;
	private List<Pasajero> listaPasajeros;
	
	public List<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}

	public void setListaPasajeros(List<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}

	public Coche() {
		super();
	}

	@Override
	public String toString() {
		return "Información del coche " + id + ":\n" + "-----------------------\n" + "ID: " + id + "\n" + "Marca: "
				+ capitalize(marca) + "\n" + "Modelo: " + capitalize(modelo) + "\n" + "Motor: " + capitalize(motor.toString()) + "\n" + "Kilómetros: " + kilometros
				+ " km\n";
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
		Coche other = (Coche) obj;
		return id == other.id;
	}

	public Coche(String marca, String modelo, TipoMotor motor, int kilometros) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
		this.kilometros = kilometros;
	}

	public String getMarca() {
		return marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public TipoMotor getMotor() {
		return motor;
	}
	public void setMotor(TipoMotor motor) {
		this.motor = motor;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
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
