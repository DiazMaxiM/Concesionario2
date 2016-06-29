import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class testPlan7030 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMontoDeLaCuotaParaUnPlan100Financiado() {
		TipoDeFinanciacion miFinanciacion = new Financiacion7030();
		
		PlanDeAhorro miPlan= mock(PlanDeAhorro.class);
		when(miPlan.cantidadDeCuotas()).thenReturn(70);
		when(miPlan.precioDelVehiculo()).thenReturn((float) 100000);
		
		assertTrue(miFinanciacion.montoDeLaCuota(miPlan)==1000);
	
	}
	@Test
	public void testmontoPagoEfectivoEnAdjudicacion(){
TipoDeFinanciacion miFinanciacion = new Financiacion7030();
		
		PlanDeAhorro miPlan= mock(PlanDeAhorro.class);
		
		when(miPlan.precioDelVehiculo()).thenReturn((float) 100000);
		
		assertTrue(miFinanciacion.montoPagoEfectivoEnAdjudicacion(miPlan)==30000);
	}


}
