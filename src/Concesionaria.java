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
	private CompaniaAseguradora companiaAseguradora;
	private List<CuponDeAdjudicacion> cuponesDeAdjudicacion;
	/**
	 * @param unaFabrica : Es la fabrica asociada a la concesionararia que produce los autos a vender.
	 * @param unaDireccion : Es la direccion que tendra la concesionaria.
	 */
	public Concesionaria (Fabrica unaFabrica, String unaDireccion, GoogleMap unMapa, Flete unFlete,  CompaniaAseguradora unaCompaniaAseguradora)
	{
		this.clientes = new ArrayList<Cliente> ();
		this.planesDeAhorro = new ArrayList<PlanDeAhorro>();
		this.cambiarFabrica (unaFabrica);
		this.cambiarDireccion(unaDireccion);
		this.cambiarMapa(unMapa);
		this.cambiarFlete(unFlete);
		this.cambiarCompaniaAseguradora(unaCompaniaAseguradora);
		this.cuponesDeAdjudicacion = new ArrayList<CuponDeAdjudicacion>();
	}
	
	private void cambiarCompaniaAseguradora(CompaniaAseguradora unaCompaniaAseguradora) 
	{
		this.companiaAseguradora = unaCompaniaAseguradora;
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
	 * @throws ExceptionErrorAlObtenerDistancia 
	 */
	public int costoDeEnvio(Planta unaPlanta, Flete unFlete) throws ExceptionErrorAlObtenerDistancia 
	{
		return unFlete.costo(distanciaVial(unaPlanta));
	}

	public Integer distanciaVial(Planta unaPlanta) throws ExceptionErrorAlObtenerDistancia 
	{
		return obtenerMapa().obtenerDistancia(this.obtenerDireccion(), unaPlanta.obtenerDireccion());
	}

	public GoogleMap obtenerMapa() 
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
	
	public CompaniaAseguradora obtenerCompaniaAseguradora() 
	{
		return companiaAseguradora;
	}

	public void ejecutarAdjudicaciones() throws ExceptionAdjudicarPlanSinParticipantes, ExceptionErrorAlObtenerDistancia 
	{
		//obtenerPlanesDeAhorro().stream().forEach(plan -> adjudicarPlan(plan));
	}

	private void adjudicarPlan (PlanDeAhorro planAAdjudicar) throws ExceptionAdjudicarPlanSinParticipantes, ExceptionErrorAlObtenerDistancia
	{
		Participante ganador=planAAdjudicar.adjudicar();
		Planta pantaMasCercana =miFabrica.plantaMasCercanaQueProduceConStock(this, planAAdjudicar.obtenerModelo());
		float precio =this.flete.costo(this.distanciaVial(pantaMasCercana));
		this.registrarCuponDeAdjudicacion(new CuponDeAdjudicacion(planAAdjudicar, ganador, precio));
	}
	


	public void adjudicarVehiculo(Modelo modeloAAdjudicar) 
	{
		obtenerFabrica().entregarVehiculo(modeloAAdjudicar);
	}
	
	public List<CuponDeAdjudicacion> obtenerCuponesDeAdjudicacion() 
	{
		return cuponesDeAdjudicacion;
	}

	public void registrarCuponDeAdjudicacion(CuponDeAdjudicacion cupon) 
	{
		this.cuponesDeAdjudicacion.add(cupon);
	}
	
}
