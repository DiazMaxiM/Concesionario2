
public class Stock {

	private Integer cantidadVehiculos;
	private Modelo miModelo;

	public Stock(Integer cantidadVehiculos, Modelo unModelo) {
		this.cantidadVehiculos = cantidadVehiculos;
		this.miModelo = unModelo;
	}

	public Integer totalStock() {
		return this.cantidadVehiculos;
	}

	public String nombreDeModelo() {
		return this.miModelo.obtenerNombreDeModelo();
	}

	public void aumentar() {
		this.cantidadVehiculos += 1;		
	}

	public Boolean esStockDe(Modelo unModelo) {
		return this.obtenerModelo() == unModelo;
	}

	private Modelo obtenerModelo() {
		return this.miModelo;
	}

	public void aumentarStockEsDe(Modelo unModelo) {
		if(this.esStockDe(unModelo)){
			this.aumentar();
		}
	}

}
