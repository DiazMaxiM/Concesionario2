import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Planta {

	private List<Modelo> listaDeModelos = new ArrayList<Modelo>();
	private Integer puntoEnElMapa;
	private List<Stock> stocks;

	public Planta(List<Modelo> listaDeModelos, Integer puntoEnElMapa) {
		this.puntoEnElMapa = puntoEnElMapa;
		this.stocks = new ArrayList<Stock>();
		for (Modelo modelo : listaDeModelos) {
			agregarModeloAProducir(modelo);
		}
	}

	public List<Modelo> listaDeModelos() {
		return this.listaDeModelos;
	}

	public Integer puntoEnElMapa() {
		return this.puntoEnElMapa;
	}

	public Integer stockTotalEnPlanta() {
		return stocks.stream().mapToInt(Stock::totalStock).sum();
	}
	
	public void agregarModeloAProducir(Modelo unModelo) {
		listaDeModelos.add(unModelo);
		this.stocks.add(new Stock(0, unModelo));
}
	
	public Integer cantidadDeModelosAProducir() {
		return listaDeModelos.size();
	}
	
	public void agregarStock(Modelo unModelo) {
		this.stocks.stream().forEach(stock -> stock.aumentarStockEsDe(unModelo));
	}

	public Integer stockTotalEnPlantaPara(Modelo unModelo) {
		List<Stock> listaDeStocksConUnModelo = new ArrayList<Stock>();
		listaDeStocksConUnModelo = stocks.stream().filter(stockActual -> stockActual.esStockDe(unModelo)).collect(Collectors.toList());
		return listaDeStocksConUnModelo.stream().mapToInt(Stock::totalStock).sum();
	}

	public Boolean tieneStockDe(Modelo unModelo) {
		return this.stockTotalEnPlantaPara(unModelo) > 0;
	}

	public Boolean produceModelo(Modelo unModelo) {
		return this.listaDeModelos.contains(unModelo);
	}
	
	/**
	 * 
	 * @return: Devuelve la direccion de la planta.
	 */
	public String obtenerDireccion() 
	{	
		// IMPLEMENTAME!!! :D YO SOY TU NUEVO "PUNTO EN EL MAPA" 
		// REEMPLAZA A ESA BESTIA POR MI, YO SOY MEJOR <3
		return null;
	}

}
