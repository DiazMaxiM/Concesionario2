import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class FabricaTest {
	private Fabrica miFabrica;
	private List<Planta> listaDePlantas;
	private List<Modelo> listaDeModelos;
	private Modelo modeloFocus = mock(Modelo.class);
	private Modelo modeloKa = mock(Modelo.class);
	private Planta plantaMock;
	private Planta plantaMasCercana;

	@Before
	public void setUp() throws Exception {
		//listaDeModelos = new ArrayList<Modelo>();
		listaDeModelos = mock(List.class);
		listaDeModelos.add(modeloKa);
		listaDeModelos.add(modeloFocus);
		
		//plantaMock = mock(Planta.class); 
		plantaMock = new Planta(listaDeModelos, "direccion uno");
		//plantaMasCercana = mock(Planta.class); 
		plantaMasCercana  =new Planta(listaDeModelos, "direccion dos");
		
		//listaDePlantas = new ArrayList<Planta>();
		listaDePlantas = mock(List.class);
		listaDePlantas.add(plantaMock);
		listaDePlantas.add(plantaMasCercana);
		
		miFabrica = new Fabrica(listaDePlantas, listaDeModelos);
	}

	@Test
	public void testFabricaConsistente(){
		assertEquals(miFabrica.plantasDeProduccion(), listaDePlantas);
		assertEquals(miFabrica.listaDeModelos(), listaDeModelos);
	}
	
	@Test
	public void testDadoUnaFabricaConUnaListaDeModelosSiLePreguntoSiTieneOtraListaDevuelveFalse(){
		List<Modelo> otraListaDeModelos = mock(List.class);
		Modelo modeloMock = mock(Modelo.class);
		otraListaDeModelos.add(modeloMock);
		assertNotEquals(miFabrica.listaDeModelos(),otraListaDeModelos);
	}
	
	
	@Test
	public void testObtenerListaDePlantas() {
		assertEquals(miFabrica.plantasDeProduccion(),listaDePlantas);
	}
	
	@Test
	public void testDadoUnaFabricaQueProduceFordKaSiLePreguntoSiProduceFordKaRespondeTrue(){
		assertTrue(miFabrica.produceModelo(modeloKa));
	}
	
	@Test
	public void testDadoUnaFabricaQueProduceFordFiestaSiLePreguntoSiProduceFordKaRespondeFalse(){
		Modelo otroModelo  = mock(Modelo.class);
		assertFalse(miFabrica.produceModelo(otroModelo));
	}
		
	@Test
	public void testDadoUnaFabricaConUnaPlantaQueProduceFordFocusConStockSiLePreguntoSiTieneStockYEsDeFordFocusRespondeTrue(){
		assertTrue(miFabrica.tieneStockDe(modeloFocus));
	}
	
	@Test
	public void testDadoUnaFabricaConUnaPlantaQueProduceFordFocusConStockSiLePreguntoSiTieneStockYEsDeFordFocusRespondeFalse(){
		assertFalse(miFabrica.tieneStockDe(modeloFocus));
	}
	
	/*
	@Test
	public void testDadoUnaFabricaConDosPlantasQueProducenFordFocusDevuelveLaListaConAmbasPlantas(){
		plantaMock.agregarStock(modeloFocus);
		plantaMasCercana.agregarStock(modeloFocus);
		
		miFabrica.agregarPlantaProduccion(plantaMock);
		miFabrica.agregarPlantaProduccion(plantaMasCercana);
		
		assertTrue(miFabrica.plantasQueProducen(modeloFocus).equals(listaDePlantas));
	}
	
	@Test
	public void testDadoUnaFabricaQueProduceDosModelosMeDevuelveLaPlantaMasCercanaDeDichoModelo(){
		miFabrica.agregarPlantaProduccion(plantaMock);
		miFabrica.agregarPlantaProduccion(plantaMasCercana);
		assertTrue(miFabrica.plantaMasCercanaQueProduce(modeloFocus).equals(plantaMasCercana));
	}
	
	
	@Test
	public void testDadoUnaFabricaQueProduceDosModelosMeDevuelveLaPlantaMasLejanaDeDichoModelo(){
		miFabrica.agregarPlantaProduccion(plantaMock);
		miFabrica.agregarPlantaProduccion(plantaMasCercana);
		assertFalse(miFabrica.plantaMasCercanaQueProduce(modeloFocus).equals(plantaMock));
	}
	
	
	@Test
	public void testDadoUnaFabricaConDosPlantasQueProducenFordFocusConStockEnAmbasMeDevuelvePlantaMasCercana() throws ExceptionFaltanteStock{
		assertTrue(miFabrica.listaDeModelos().contains(modeloFocus));
		plantaMasCercana.agregarStock(modeloFocus);
		assertEquals(miFabrica.plantaMasCercanaQueProduceConStock(modeloFocus),plantaMasCercana);
	}

	@Test (expected = ExceptionFaltanteStock.class)
	public void testDadoUnaFabricaConUnaPlantaQueProduceFocusPeroNoTieneStockGeneraGeneraUnaFaltaStockException() throws ExceptionFaltanteStock{
		Fabrica fabricaMock = mock(Fabrica.class);
		plantaMasCercana.agregarStock(modeloFocus);
		fabricaMock.agregarPlantaProduccion(plantaMasCercana);
		when(fabricaMock.plantaMasCercanaQueProduceConStock(modeloFocus)).thenReturn(plantaMock);
		fabricaMock.plantaMasCercanaQueProduceConStock(modeloFocus);
	}*/

}
