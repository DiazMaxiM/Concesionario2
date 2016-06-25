
public class Modelo {

	private String nombre;
	private Integer anio;
	private Integer cantidadDePuertas;
	private Boolean esBase;
	private Float precioMovil;

	public Modelo(String nombre, Integer anio, Integer cantidadDePuertas, Boolean esBase, Float precioMovil) {
		this.nombre = nombre;
		this.anio = anio;
		this.cantidadDePuertas = cantidadDePuertas;
		this.esBase = esBase ;
		this.precioMovil = precioMovil;
	}

	public String obtenerNombreDeModelo() {
		return this.nombre;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public Integer getCantidadDePuertas() {
		return this.cantidadDePuertas;
	}

	public Boolean esBase() {
		return this.esBase;
	}

	public Float precioMovil() {
		return this.precioMovil;
	}

}
