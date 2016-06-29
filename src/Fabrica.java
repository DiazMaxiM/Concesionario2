import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fabrica {
 
	private List<Planta> listaDePlantas;
	private List<Modelo> listaDeModelosAProducir;

	public Fabrica(List<Planta> listaDePlantas, List<Modelo> listaDeModelos) {
		this.listaDePlantas = listaDePlantas;
		this.listaDeModelosAProducir = listaDeModelos;
	}

	public List<Planta> plantasDeProduccion() {
		return this.listaDePlantas;
	}

	public List<Modelo> listaDeModelos() {
		return this.listaDeModelosAProducir;
	}
	
	public Boolean produceModelo(Modelo unModelo) {
		return this.listaDeModelosAProducir.contains(unModelo);
	}

	public Boolean tieneStockDe(Modelo modelo) {
		List<Planta> listaPlantasQueProducenUnModelo = new ArrayList<Planta>();
		listaPlantasQueProducenUnModelo = listaDePlantas.stream().filter(planta -> planta.tieneStockDe(modelo)).collect(Collectors.toList());
		return listaPlantasQueProducenUnModelo.size()>0;
	}
/*
	public List<Planta> plantasQueProducen(Modelo modeloMock) {
		return listaDePlantas.stream().filter(planta -> planta.produceModelo(modeloMock)).collect(Collectors.toList());
	}
	
	public void agregarPlantaProduccion(Planta unaPlanta) {
		listaDePlantas.add(unaPlanta);	
	}
	
	public Planta plantaMasCercanaQueProduce(Modelo modeloMock) {
		List<Planta> listaAux = new ArrayList<Planta>();
		listaAux = this.plantasQueProducen(modeloMock);
		return listaAux.stream().min((Planta plantaUno, Planta plantaDos) -> plantaUno.puntoEnElMapa().compareTo(plantaDos.puntoEnElMapa())).get();
		
	}

	public Planta plantaMasCercanaQueProduceConStock(Modelo modeloFocus) throws ExceptionFaltanteStock{
		if(this.tieneStockDe(modeloFocus)){
			this.listaDePlantas = listaDePlantas.stream().filter(planta->planta.tieneStockDe(modeloFocus)).collect(Collectors.toList());
			this.listaDePlantas.stream().min((Planta plantaUno, Planta plantaDos) -> plantaUno.puntoEnElMapa().compareTo(plantaDos.puntoEnElMapa())).get();
			return this.listaDePlantas.get(0);
		}
		else{
			throw new ExceptionFaltanteStock();
		}
	}

	/**
	 * @return: Retorna el stock total de todas las plantas.
	 */
	public List<Stock> stockDeProduccion() 
	{
		// IMPLEMEEENTAME! IMPLEMEEENTAME! X3
		return null;
	}

	/**
	 * PROPOSITO: Entregar un vehiculo del modeloAAdjudicar mas cercano a la Concesionaria.
	 * @param modeloAAdjudicar: Es el modelo de vehiculo a adjudicar.
	 */
	/*public void entregarVehiculo(Modelo modeloAAdjudicar) 
	{
		// HOLA! :D ME IMPLEMENTAS? SI? SI? SI? OwO
	}
	*/
	
	
	
	

}
