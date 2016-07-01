import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Planta {

	private List<Modelo> listaDeModelos= new ArrayList<Modelo>();
	private String direccion;
	private List<Stock> stocks;

	public Planta(String direccion) {
		this.direccion = direccion;
		this.stocks = new ArrayList<Stock>();
		
	}

	public void agregarListaModelos(List<Modelo> listaModelosAAgregar){
		for (Modelo modelo : listaModelosAAgregar) {
			agregarModeloAProducir(modelo);
		}
	}
	
	public List<Modelo> listaDeModelos() {
		return this.listaDeModelos;
	}
	
	/**
	 * 
	 * @return: Devuelve la direccion de la planta.
	 */
	public String obtenerDireccion() {
		return this.direccion;
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
	
}
