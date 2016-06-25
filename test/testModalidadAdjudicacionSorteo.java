import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class testModalidadAdjudicacionSorteo {
	ModalidadDeAdjudicacion modalidadSorteo= new ModalidadSorteo(new Random());	
	PlanDeAhorro plan= mock (PlanDeAhorro.class);
	PlanDeAhorro planSinParticipantes= mock (PlanDeAhorro.class);
	Participante participante1 = mock (Participante.class);
	Participante participante2 = mock (Participante.class);
	@Before
	public void setUp() throws Exception {
		}
	@Test
	public void testAdjudicarConPlanConParticipantes() throws ExceptionAdjudicarPlanSinParticipantes  {	 
		List<Participante> participantesPosibles= new ArrayList<Participante>();
		participantesPosibles.add(participante1);
		participantesPosibles.add(participante2);
		when(plan.clientesQueNoAdjudicaron()).thenReturn(participantesPosibles);
		Participante participanteGanador=modalidadSorteo.adjudicar(plan);
		assertTrue(participantesPosibles.contains(participanteGanador));
	}
	@Test (expected =  ExceptionAdjudicarPlanSinParticipantes.class)
	public void testAdjudicarSinPlanConParticipantes() throws ExceptionAdjudicarPlanSinParticipantes {	 
		when(planSinParticipantes.clientesQueNoAdjudicaron()).thenReturn(new ArrayList<Participante>());
		modalidadSorteo.adjudicar(planSinParticipantes);
	}
}
