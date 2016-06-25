
import java.util.List;
import java.util.Random;
/**
 * 
 * @author MaxiDiaz
 *
 */

public class ModalidadSorteo implements ModalidadDeAdjudicacion {
	/**
	 * @param plan = plan de Ahorro sobre el cual se desea realizar la adjudicacion
	 * @throws Exception 
	 */
	Random miRandom;
	public ModalidadSorteo(Random miRandom){
	this.miRandom= miRandom;
	}
	public Participante adjudicar(PlanDeAhorro plan) throws ExceptionAdjudicarPlanSinParticipantes{
        
		List<Participante> listaDeClientesPosiblesDeAdjudicacion = plan.clientesQueNoAdjudicaron();
		if  (listaDeClientesPosiblesDeAdjudicacion.isEmpty())
		{
			throw new ExceptionAdjudicarPlanSinParticipantes();
		}
		
		int index = miRandom.nextInt(listaDeClientesPosiblesDeAdjudicacion.size());
	        return( listaDeClientesPosiblesDeAdjudicacion.get(index));
	}
}
