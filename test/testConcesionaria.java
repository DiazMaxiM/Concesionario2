import static org.junit.Assert.*;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class testConcesionaria 
{

	DateTime fechaIngresoLiza;
	DateTime fechaIngresoMelody;
	DateTime fechaNacimientoLiza;
	DateTime fechaNacimientoMelody;
	
	@Before
	public void setUp() throws Exception
	{
		this.fechaIngresoLiza = new DateTime(2015, 1, 10, 0, 0);
		this.fechaNacimientoLiza = new DateTime (1994, 5, 10,0,0);
		
		//when(this.clienteMockLiza.obtenerDni()).thenReturn(38354056);
		
		this.fechaIngresoMelody = new DateTime(2010,3,5,0,0);
		this.fechaNacimientoMelody = new DateTime (1990,3,27,0,0);
	}
	
	@Test
	/**
	 * Dada una concesionaria sin clientes, le agregar un cliente.
	 */
	public void testAgregarCliente () 
	{
		Fabrica fabricaMock = mock(Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		Cliente clienteMockLiza = mock(Cliente.class);
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);		
		concesionario.agregarCliente(clienteMockLiza);
		
		assertTrue(concesionario.obtenerClientes().contains(clienteMockLiza));
	}
	
	@Test
	/**
	 * Dada una concesionaria sin planes de ahorro, le agrego un plan de ahorro "2".
	 */
	public void testAgregarPlanDeAhorro () 
	{
		Fabrica fabricaMock = mock(Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		PlanDeAhorro planDeAhorroMock2 = mock(PlanDeAhorro.class);		
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		concesionario.agregarPlanDeAhorro(planDeAhorroMock2);
		
		assertTrue(concesionario.obtenerPlanesDeAhorro().contains(planDeAhorroMock2));
	}
	
	@Test
	/**
	 * Dada una concesionaria con un cliente "Melody" y le pregunto por todos sus clientes, 
	 * me devuelve un listado de sus clientes con "Melody".
	 */
	public void testObtenerClientes () 
	{
		Fabrica fabricaMock = mock(Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		Cliente clienteMockMelody = mock(Cliente.class);		
		List<Cliente> todosLosClientesMelody = new ArrayList<Cliente>();		
		
		concesionario.agregarCliente(clienteMockMelody);
		todosLosClientesMelody.add(clienteMockMelody);
		
		assertTrue(concesionario.obtenerClientes().equals(todosLosClientesMelody));
	}
	
	@Test
	/**
	 * Dada una concesionaria con un plan de ahorro "1", cuando le pregunto 
	 * por sus planes de ahorro me devuelve una lista con el plan de ahorro "1"
	 */
	public void testObtenerPlanesDeAhorro () 
	{	
		Fabrica fabricaMock = mock(Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		PlanDeAhorro planDeAhorroMock1 = mock(PlanDeAhorro.class);
		List<PlanDeAhorro> planesDeAhorroConPlan1 = new ArrayList<PlanDeAhorro>();
		
		concesionario.agregarPlanDeAhorro(planDeAhorroMock1);
		planesDeAhorroConPlan1.add(planDeAhorroMock1);
		
		assertTrue(concesionario.obtenerPlanesDeAhorro().equals(planesDeAhorroConPlan1));
	}
	
	@Test
	/**
	 * Dada una concesionaria que esta asociada con una Fabrica1, le pregunto por su fabrica.
	 */
	public void testObtenerFabrica () 
	{
		Fabrica fabricaMock = mock(Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		assertTrue(concesionario.obtenerFabrica().equals(fabricaMock));
	}
	
	/**
	 * Dada una concesionaria con 12 planes, devuelve los 10 primeros planes con mayor cantidad de suscriptos.
	 */
	@Test
	public void test10planesConMayorSuscripcion() 
	{
		Fabrica fabricaMock = mock(Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionariaCon11Planes = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		PlanDeAhorro planMock1 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock2 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock3 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock4 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock5 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock6 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock7 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock8 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock9 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock10 = mock(PlanDeAhorro.class);
		PlanDeAhorro planMock11 = mock(PlanDeAhorro.class);
		
		List<PlanDeAhorro> res10Planes = new ArrayList<PlanDeAhorro>();
		
		res10Planes.add(planMock1);
		res10Planes.add(planMock2);
		res10Planes.add(planMock3);
		res10Planes.add(planMock4);
		res10Planes.add(planMock5);
		res10Planes.add(planMock6);
		res10Planes.add(planMock7);
		res10Planes.add(planMock8);
		res10Planes.add(planMock9);
		res10Planes.add(planMock10);
		
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock1);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock2);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock3);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock4);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock5);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock6);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock7);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock8);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock9);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock10);
		concesionariaCon11Planes.agregarPlanDeAhorro(planMock11);
		
		assertTrue(res10Planes.containsAll(concesionariaCon11Planes.planesCon10MayoresSuscriptores()) );
	}

	@Test
	/**
	 * Dado una concesionaria, le pido la planta mas cercana que produce un determinado modelo.
	 */
	public void testPlantaMasCercanaCasoPositivo() throws SinVehiculosDelModeloSolicitado
	{	
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		Modelo modeloMock = mock(Modelo.class);
	
		Boolean hayStock = new Boolean("True");
		Planta plantaMasCercanaMock = mock(Planta.class);
		when(fabricaMock.tieneStockDe(modeloMock)).thenReturn(hayStock);
		when(concesionario.plantaMasCercana(modeloMock)).thenReturn(plantaMasCercanaMock);
		
		assertTrue(concesionario.plantaMasCercana(modeloMock).equals (plantaMasCercanaMock));
	}
	
	@Test (expected = SinVehiculosDelModeloSolicitado.class)
	/**
	 * Dado una concesionaria, le pido la planta mas cercana que produce su fabrica de un determinado modelo.
	 * CASO NEGATIVO : No hay vehiculos disponibles del modelo solicitado.
	 */
	public void testPlantaMasCercanaCasoNegativo() throws SinVehiculosDelModeloSolicitado 
	{	
		
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		Modelo modeloMock = mock(Modelo.class);
		Planta plantaMasCercana = concesionario.plantaMasCercana(modeloMock);
		
		doThrow(new SinVehiculosDelModeloSolicitado()).when(concesionario.plantaMasCercana(modeloMock));
		assertTrue(concesionario.plantaMasCercana(modeloMock).equals(plantaMasCercana));
	}
	
	@Test
	/**
	 * Dado una concesionaria, le pregunto a un flete cuanto cuesta el envio hacia una Planta.
	 */
	public void testCostoDeEnvio()
	{	
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		Planta plantaMock = mock (Planta.class);

		when(concesionario.costoDeEnvio(plantaMock, fleteMock)).thenReturn(10000);
		
		assertEquals(concesionario.costoDeEnvio(plantaMock, fleteMock), 10000);
	}
	
	@Test
	/**
	 * Dado una concesionaria, le pregunto por la distancia vial hacia una de las plantas.
	 * Caso positivo.
	 */
	public void testDistanciaVialCasoPositivo()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "miDireccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		Planta plantaMock = mock(Planta.class);
		
		when (mapaMock.obtenerDistancia("miDireccion","direccionDestino")).thenReturn(34000);
		when (plantaMock.obtenerDireccion()).thenReturn("direccionDestino");
		
		assertTrue(concesionario.distanciaVial(plantaMock).equals(34000));
	}
	
	@Test
	/**
	 * Dado una concesionaria, le pregunto por la distancia vial hacia una de las plantas.
	 * Caso negativo.
	 */
	public void testDistanciaVialCasoNegativo()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock(GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "miDireccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		Planta plantaMock = mock(Planta.class);

		when (mapaMock.obtenerDistancia("miDireccion","direccionDestino")).thenReturn(34000);
		when (plantaMock.obtenerDireccion()).thenReturn("direccionDestino");
		
		assertFalse(concesionario.distanciaVial(plantaMock).equals(50000));
	}
	
	@Test
	/**
	 * Dado una concesionaria con la direcccion "direccion", le pregunto por su direccion "direccion".
	 */
	public void testObtenerDireccion()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		assertEquals(concesionario.obtenerDireccion(), "direccion");
	}
	
	@Test
	/**
	 * Dado una concesionaria con un flete, le pregunto por ese flete.
	 */
	public void testObtenerFlete()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		assertEquals(concesionario.obtenerFlete(), fleteMock);
	}
	
	@Test
	/**
	 * Dado una concesionaria, le pregunto si sus stocks coinciden con los de las plantas.
	 * Caso Positivo
	 */
	public void testTieneLosMismosStocksCasoPositivo()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();
		Stock stockMock1 = mock(Stock.class);
		Stock stockMock2 = mock(Stock.class);
		
		miStock.add(stockMock1);
		miStock.add(stockMock2);
	
		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		when(fabricaMock.stockDeProduccion()).thenReturn(miStock);
		when(stockMock1.esIgualA(stockMock1)).thenReturn(true);
		when(stockMock2.esIgualA(stockMock2)).thenReturn(true);
		
		assertTrue(concesionario.tieneLosMismosStocks());
	}

	@Test
	/**
	 * Dado una concesionaria, le pregunto si sus stocks coinciden con los de las plantas.
	 * Caso Negativo.
	 */
	
	public void testTieneLosMismosStocksCasoNegativo()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);		
		List<Stock> miStock = new ArrayList<Stock>();
		List<Stock> otroStock = new ArrayList<Stock>();
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();
		Stock stockMock1 = mock(Stock.class);
		Stock stockMock2 = mock(Stock.class);
		
		miStock.add(stockMock1);
		miStock.add(stockMock2);
		otroStock.add(stockMock1);

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		when(fabricaMock.stockDeProduccion()).thenReturn(otroStock);
		assertFalse(concesionario.tieneLosMismosStocks());
	}
	
	@Test
	/**
	 * Dada una concesionaria, le pregunto por su stock.
	 */
	public void testObtenerStockDeVehiculos()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();
		Stock stockMock1 = mock(Stock.class);
		
		miStock.add(stockMock1);
		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		when(stockMock1.esIgualA(stockMock1)).thenReturn(true);
		when(fabricaMock.stockDeProduccion()).thenReturn(miStock);
		
		assertEquals(concesionario.obtenerStockDeVehiculos(), miStock);
	}
	
	@Test
	public void testObtenerAseguradora()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();

		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		
		assertEquals(concesionario.obtenerCompaniaAseguradora(), aseguradoraMock);
	}
	
	@Test
	public void testAdjudicarVehiculo()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();
		PlanDeAhorro planMock = mock (PlanDeAhorro.class);
		Modelo modeloMock = mock (Modelo.class);
		Stock stockMock1 = mock (Stock.class);

		miStock.add(stockMock1);
		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);	
		concesionario.agregarPlanDeAhorro(planMock);
		when(stockMock1.esStockDe(modeloMock)).thenReturn(true);
		when(stockMock1.totalStock()).thenReturn(1);
		when(fabricaMock.stockDeProduccion()).thenReturn(miStock);
		
		concesionario.adjudicarVehiculo(modeloMock);
		concesionario.actualizarStockDeVehiculos();
		
		assertTrue(concesionario.obtenerStockDelModelo(modeloMock).equals(1));
	}
	
	@Test
	public void testRegistrarCuponDeAdjudicacion()
	{
		Fabrica fabricaMock = mock (Fabrica.class);
		GoogleMap mapaMock = mock (GoogleMap.class);
		Flete fleteMock = mock (Flete.class);
		List<Stock> miStock = new ArrayList<Stock>();
		CompaniaAseguradora aseguradoraMock = mock (CompaniaAseguradora.class);
		List<CuponDeAdjudicacion> cuponesMock = new ArrayList<CuponDeAdjudicacion>();
		CuponDeAdjudicacion cuponMock = mock (CuponDeAdjudicacion.class);
		
		Concesionaria concesionario = new Concesionaria(fabricaMock, "direccion", mapaMock, fleteMock, miStock, aseguradoraMock, cuponesMock);
		concesionario.registrarCuponDeAdjudicacion(cuponMock);
		
		assertTrue(concesionario.obtenerCuponesDeAdjudicacion().contains(cuponMock));
	}
	
}
