
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

	/**
	 * PROPOSITO: Dado un stock, comparo si su modelo y cantidad de vehiculos es igual al mio.
	 * @param stockAComparar: Es el stock con el que me voy a comparar.
	 * @return: True si son iguales, de lo contrario devuelve False.
	 */
	public Boolean esIgualA (Stock stockAComparar) 
	{
		return (this.obtenerModelo()==stockAComparar.obtenerModelo() 
				&& (this.cantidadVehiculos==stockAComparar.cantidadVehiculos)
				);
	}
	
}
