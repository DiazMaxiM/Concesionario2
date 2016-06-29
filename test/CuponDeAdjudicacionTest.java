import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class CuponDeAdjudicacionTest {

	private CuponDeAdjudicacion cuponDeAdjudicacion;
	private PlanDeAhorro planDeAhorro;
	private Float montoAPagarPorFlete =0f;
	private Participante unParticipante;

	@Before
	public void setUp() throws Exception {
		planDeAhorro = mock(PlanDeAhorro.class);
		cuponDeAdjudicacion = new CuponDeAdjudicacion(planDeAhorro, unParticipante, montoAPagarPorFlete);
	}

	@Test
	public void testDadoUnCuponDeAdjudicacionDeUnParticipanteSiLePreguntoSiEsDeEseParticipanteRespondeTrue() {
		assertEquals(cuponDeAdjudicacion.conocerParticipanteGanador(), unParticipante);
	}
	
	@Test
	public void testDadoUnCuponDeAdjudicacionDeUnParticipanteSiLePreguntoSiEsDeOtroarticipanteRespondeFalse() {
		Participante otroParticipante = mock(Participante.class);
		assertNotEquals(cuponDeAdjudicacion.conocerParticipanteGanador(), otroParticipante);
	}
	
	@Test
	public void testDadoUnCuponDeAdjudicacionPorUnPlan100SiLePreguntoSuGastoPorPlanDevuelve0(){
		//when(planDeAhorro.gastoPorPlan()).thenReturn(0);
		assertTrue(cuponDeAdjudicacion.gastoPorPlan() == 0);
	}

}
