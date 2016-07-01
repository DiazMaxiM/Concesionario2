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

*/	public Planta plantaMasCercanaQueProduceConStock(Concesionaria concesionaria,Modelo modeloFocus) throws  ExceptionErrorAlObtenerDistancia{
		String direccionConcesionaria = concesionaria.obtenerDireccion();
			
		this.listaDePlantas = listaDePlantas.stream().filter(planta->planta.tieneStockDe(modeloFocus)).collect(Collectors.toList());
		Integer distanciaMin=concesionaria.obtenerMapa().obtenerDistancia(direccionConcesionaria, listaDePlantas.get(0).obtenerDireccion());;
		Planta plantaMasCercana=listaDePlantas.get(0);
		for (Planta planta : listaDePlantas) {
			
			Integer distancia = concesionaria.obtenerMapa().obtenerDistancia(direccionConcesionaria, planta.obtenerDireccion());
			if (distanciaMin == -1){
				 plantaMasCercana= planta;
				distanciaMin= distancia;
			}
			else{
				if (distancia < distanciaMin){
					plantaMasCercana= planta;
					distanciaMin= distancia;
				}
			}
		}
		return plantaMasCercana;
	}



	public void entregarVehiculo(Modelo modeloAAdjudicar) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
