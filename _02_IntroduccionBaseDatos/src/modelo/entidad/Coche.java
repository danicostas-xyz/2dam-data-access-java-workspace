package modelo.entidad;

public class Coche {
	private String id;
	private String marca;
	private String modelo;
	private TipoMotor motor;
	private int kilometros;
	
	public Coche() {
		super();
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
}
