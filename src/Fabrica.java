import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;
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
	
	public void agregarPlantaProduccion(Planta unaPlanta) {
		listaDePlantas.add(unaPlanta);	
	}

	public Boolean produceModelo(Modelo unModelo) {
		return this.listaDeModelosAProducir.contains(unModelo);
	}

	public List<Planta> plantasQueProducen(Modelo modeloMock) {
		return listaDePlantas.stream().filter(planta -> planta.produceModelo(modeloMock)).collect(Collectors.toList());
	}

	public Planta plantaMasCercanaQueProduce(Modelo modeloMock) {
		List<Planta> listaAux = new ArrayList<Planta>();
		listaAux = this.plantasQueProducen(modeloMock);
		return listaAux.stream().min((Planta plantaUno, Planta plantaDos) -> plantaUno.puntoEnElMapa().compareTo(plantaDos.puntoEnElMapa())).get();
		
	}

	public Boolean tieneStockDe(Modelo modeloMock) {
		List<Planta> listaPlantasQueProducenUnModelo = new ArrayList<Planta>();
		listaPlantasQueProducenUnModelo = listaDePlantas.stream().filter(planta -> planta.tieneStockDe(modeloMock)).collect(Collectors.toList());
		return listaPlantasQueProducenUnModelo.size()>0;
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
		/*listaDePlantas = listaDePlantas.stream().filter(planta -> planta.tieneStockDe(modeloFocus)).collect(Collectors.toList());
		return this.plantaMasCercanaQueProduce(modeloFocus);*/
	}
	
	
	
	
	

}
