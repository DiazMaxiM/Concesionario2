
import java.util.List;
/**
 * 
 * @author MaxiDiaz
 *
 */
public class ModalidadMayorCobertura implements ModalidadDeAdjudicacion {
	/**
	 * @param plan = plan de Ahorro sobre el cual se desea realizar la adjudicacion
	 */
	public Participante adjudicar(PlanDeAhorro plan)throws ExceptionAdjudicarPlanSinParticipantes{
		
		List<Participante> listaDeClientesPosiblesDeAdjudicacion = plan.clientesQueNoAdjudicaron();
		
		if (listaDeClientesPosiblesDeAdjudicacion.isEmpty()){
			throw new ExceptionAdjudicarPlanSinParticipantes() ;
		}
		
		Participante participanteMayorCobertura;
		 participanteMayorCobertura = listaDeClientesPosiblesDeAdjudicacion.stream().max((Participante p1, Participante p2)->p1.compararQuienPagoMas(p2)).get();
		 return participanteMayorCobertura;
	}
	
}
