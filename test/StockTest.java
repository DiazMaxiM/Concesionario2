import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class StockTest {

	private Stock miStock;
	private Modelo modeloKa;

	@Before
	public void setUp() throws Exception {
		modeloKa = new Modelo("Ka",2016,5,true, (float)1000);
		miStock = new Stock(0, modeloKa);
	}

	@Test
	public void testStockInicialEnCero() {
		assertTrue(miStock.totalStock().equals(0));
	}
	
	@Test
	public void testDadoStockDeKaSiLePreguntoElNombreDeModeloDevuelveKa(){
		assertEquals(miStock.nombreDeModelo(),"Ka");
	}
	
	@Test
	public void testDadoUnStockNuevoSiAumentoElStockDevuelve1(){
		miStock.aumentar();
		assertTrue(miStock.totalStock().equals(1));
	}

	@Test
	public void testDadoUnStockNuevoSiAumentoElStockDosVecesDevuelve2(){
		miStock.aumentar();
		miStock.aumentar();
		assertTrue(miStock.totalStock().equals(2));
	}
	
	@Test
	public void testDadoUnStockConAutosKaSiLePreguntoSiSuStockEsDeAutosKaEsTrue(){
		assertTrue(miStock.esStockDe(modeloKa));
	}
	
	@Test
	public void testDadoUnStockConAutosKaSiLePreguntoSiSuStockEsDeAutosFocusEsFalse(){
		Modelo modeloFocus = mock(Modelo.class);
		assertFalse(miStock.esStockDe(modeloFocus));
	}
}
