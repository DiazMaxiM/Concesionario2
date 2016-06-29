import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class CuponDeAdjudicacionTest {

	private CuponDeAdjudicacion cuponDeAdjudicacion;
	private PlanDeAhorro planDeAhorro;
	private float montoAPagarPorFlete =0f;
	private Participante unParticipante;

	@Before
	public void setUp() throws Exception {
		planDeAhorro = mock(PlanDeAhorro.class);
	}

	@Test
	public void testDadoUnCuponDeAdjudicacionDeUnParticipanteSiLePreguntoSiEsDeEseParticipanteRespondeTrue() {
		cuponDeAdjudicacion = new CuponDeAdjudicacion(planDeAhorro, unParticipante, montoAPagarPorFlete);
		assertEquals(cuponDeAdjudicacion.conocerParticipanteGanador(), unParticipante);
	}
	
	@Test
	public void testDadoUnCuponDeAdjudicacionDeUnParticipanteSiLePreguntoSiEsDeOtroarticipanteRespondeFalse() {
		Participante otroParticipante = mock(Participante.class);
		cuponDeAdjudicacion = new CuponDeAdjudicacion(planDeAhorro, unParticipante, montoAPagarPorFlete);
		assertNotEquals(cuponDeAdjudicacion.conocerParticipanteGanador(), otroParticipante);
	}
	
	@Test
	public void testDadoUnCuponDeAdjudicacionPorUnPlan100SiLePreguntoSuGastoPorPlanDevuelve0(){
		montoAPagarPorFlete = 100;
		cuponDeAdjudicacion = new CuponDeAdjudicacion(planDeAhorro, unParticipante, montoAPagarPorFlete);
		when(planDeAhorro.montoAPagarPorAdjudicacion()).thenReturn(0f);
		assertTrue(cuponDeAdjudicacion.gastoTotalCupon() == 100);
	}
	
	@Test
	public void testDadoUnCuponDeAdjudicacionPorUnPlan7030SiLePreguntoSuGastoPorPlanDevuelve0(){
		montoAPagarPorFlete = 100;
		cuponDeAdjudicacion = new CuponDeAdjudicacion(planDeAhorro, unParticipante, montoAPagarPorFlete);
		when(planDeAhorro.montoAPagarPorAdjudicacion()).thenReturn(100f);
		assertTrue(cuponDeAdjudicacion.gastoTotalCupon() == 200);
	}

}
