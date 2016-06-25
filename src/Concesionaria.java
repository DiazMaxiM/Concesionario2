/**
 * Acá esta modelada la clase Concesionaria
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chambi Orellena, Liza
 * 
 */
public class Concesionaria 
{
	private List<Cliente> clientes;
	private List<PlanDeAhorro> planesDeAhorro;
	private Fabrica miFabrica;
	private String direccion;
	private GoogleMap mapa;
	private Flete flete;
	private List<Stock> stockDeVehiculos;
	private CompaniaAseguradora companiaAseguradora;

	/**
	 * @param unaFabrica : Es la fabrica asociada a la concesionararia que produce los autos a vender.
	 * @param unaDireccion : Es la direccion que tendra la concesionaria.
	 */
	public Concesionaria (Fabrica unaFabrica, String unaDireccion, GoogleMap unMapa, Flete unFlete, List<Stock> stocksDeVehiculos, CompaniaAseguradora unaCompaniaAseguradora)
	{
		this.clientes = new ArrayList<Cliente> ();
		this.planesDeAhorro = new ArrayList<PlanDeAhorro>();
		this.cambiarFabrica (unaFabrica);
		this.cambiarDireccion(unaDireccion);
		this.cambiarMapa(unMapa);
		this.cambiarFlete(unFlete);
		this.cambiarStockDeVehiculos(stocksDeVehiculos);
		this.cambiarCompaniaAseguradora(unaCompaniaAseguradora);
	}

	private void cambiarCompaniaAseguradora(CompaniaAseguradora unaCompaniaAseguradora) 
	{
		this.companiaAseguradora = unaCompaniaAseguradora;
	}

	private void cambiarStockDeVehiculos(List<Stock> stocksDeVehiculos) 
	{
		this.stockDeVehiculos = stocksDeVehiculos;
	}

	private void cambiarFlete(Flete unFlete) 
	{
		this.flete = unFlete;
	}

	private void cambiarMapa(GoogleMap unMapa) 
	{
		this.mapa = unMapa;
	}

	private void cambiarDireccion(String unaDireccion) 
	{
		this.direccion = unaDireccion;
	}

	/**
	 * PROPOSITO: Cambia la fabrica asociada de la concesionaria
	 * @param unaFabrica : Es la nueva fabrica con la que trabajara la concesionaria. 
	 */
	private void cambiarFabrica(Fabrica unaFabrica) 
	{
		this.miFabrica=unaFabrica;
	}

	/**
	 * PROPOSITO: Agrega un nuevo cliente a la concesionaria.
	 * @param unCliente : Cliente a agregar en la base de datos de la concesionaria.
	 */
	public void agregarCliente(Cliente unCliente) 
	{
		this.clientes.add(unCliente);
	}

	/**
	 * PROPOSITO: Agrega un Plan de ahorro a la concesionaria.
	 * @param unPlanDeAhorro : Es el nuevo plan de ahorro que gestionara la concesionaria.
	 */
	public void agregarPlanDeAhorro(PlanDeAhorro unPlanDeAhorro) 
	{
		this.planesDeAhorro.add(unPlanDeAhorro);
	}

	/**
	 * @return : Devuelve todos los clientes de la concesionaria.
	 */
	public List<Cliente> obtenerClientes() 
	{
		return this.clientes;
	}

	/**
	 * @return : Devuelve todos los planes de ahorro que gestiona la concesionaria.
	 */
	public List<PlanDeAhorro> obtenerPlanesDeAhorro() 
	{
		return this.planesDeAhorro;
	}

	/**
	 * @return : Retorna los 10 primeros planes de ahorro con mayor cantidad de suscriptores
	 */
	public List<PlanDeAhorro> planesCon10MayoresSuscriptores()
	{
		planesOrdPorMayorSuscriptores();
		return planesDeAhorro.subList(0, 9);
	}
	
	/**
	 * PROPOSITO: Ordenas los planes de ahorro por la cantidad de suscriptores, de mayor a menor.
	 */
	private void planesOrdPorMayorSuscriptores() 
	{
		this.planesDeAhorro = this.planesDeAhorro.stream().sorted((plan1, plan2 )-> plan1.cantidadDeParticipantes().compareTo(plan2.cantidadDeParticipantes())).collect(Collectors.toList());
	}

	/**
	 * @param unModelo = Es el modelo de vehiculo que se solicita a la fabrica.
	 * @return Retorna la Planta mas cercana a la concesionaria que fabrique el modelo solicitado.
	 * @throws SinVehiculosDelModeloSolicitado = Error en el caso de que la fabrica no tenga stock de ese modelo.
	 */
	public Planta plantaMasCercana(Modelo unModelo) throws SinVehiculosDelModeloSolicitado
	{
		if (obtenerFabrica().tieneStockDe(unModelo))
		{
			return obtenerFabrica().plantaMasCercanaQueProduce(unModelo);
		}
		else
		{
			throw new SinVehiculosDelModeloSolicitado();
		}
	}
	
	
	/**
	 * @return : Retorna la fabrica con la que trabaja la concesionaria.
	 */
	public Fabrica obtenerFabrica() 
	{
		return this.miFabrica;
	}

	/**
	 * @param unaPlanta : Es la Planta desde la cual estoy haciendo el envio.
	 * @param unFlete : Es el Flete que determinara el costo del envio.
	 * @return : Devuelve el costo total del flete hasta la ubicacion de la Planta.
	 */
	public int costoDeEnvio(Planta unaPlanta, Flete unFlete) 
	{
		return unFlete.costo(distanciaVial(unaPlanta));
	}

	public Integer distanciaVial(Planta unaPlanta) 
	{
		return obtenerMapa().obtenerDistancia(obtenerDireccion(), unaPlanta.obtenerDireccion());
	}

	private GoogleMap obtenerMapa() 
	{
		return this.mapa;
	}


	public String obtenerDireccion() 
	{
		return this.direccion;
	}

	public Object obtenerFlete() 
	{
		return this.flete;
	}

	/**
	 * @param modelos = Son todos los modelos de vehiculos que vende la concesionaria.
	 * @param plantas = Son todas las plantas que producen los vehiculos.
	 * @return : Devuelve True si el stock que tiene la concesionaria es igual al de las plantas, de lo contrario devuelve False.
	 */
	public Boolean tieneLosMismosStocks() 
	{
		return compararStocks(obtenerStockDeVehiculos(), obtenerFabrica().stockDeProduccion() );
	}
	
	public Boolean compararStocks(List<Stock> stockC, List<Stock> stockF) 
	{
		return (compararCantidadDeModelos(stockC, stockF) && compararLosStock(stockC, stockF));
	}

	private Boolean compararLosStock(List<Stock> stockC, List<Stock> stockF) 
	{
		Boolean resultado = true;
		for (int index= 0; index < stockC.size(); index++)
		{
			resultado &= (stockC.get(index).igualA (stockF.get(index)));
		}
		return resultado;
	}


	private Boolean compararCantidadDeModelos(List<Stock> stockC, List<Stock> stockF) 
	{
		return (stockC.size() == stockF.size());
	}

	public List<Stock> obtenerStockDeVehiculos() 
	{
		return stockDeVehiculos;
	}

	public Aseguradora obtenerCompaniaAseguradora() 
	{
		return companiaAseguradora;
	}

	public void ejecutarAdjudicaciones() 
	{
		this.planesDeAhorro.stream().forEach(plan -> adjudicarPlan(plan.adjudicar() ));
	}

	private void adjudicarPlan(Participante participante) 
	{
		// Entregar el vehiculo
		// Generar el cupon
		// Registrarlo en la concesionaria
		return null;
	}


	
	
	
	
}
