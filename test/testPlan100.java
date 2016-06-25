import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class testPlan100 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMontoDeLaCuotaParaUnPlan100Financiado() {
		TipoDeFinanciacion miFinanciacion = new Financiacion100();
		
		PlanDeAhorro miPlan= mock(PlanDeAhorro.class);
		when(miPlan.cantidadDeCuotas()).thenReturn(60);
		when(miPlan.precioDelVehiculo()).thenReturn((float) 60000);
		
		assertTrue(miFinanciacion.montoDeLaCuota(miPlan)==1000);
	
	}


}
