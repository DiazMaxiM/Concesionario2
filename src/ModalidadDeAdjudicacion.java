
/**
 * Esta Interfaz se utiliza para asegurar el mesaje adjudicar en las Clases que la implementan
 * @author MaxiDiaz
 * 
 */
public  interface ModalidadDeAdjudicacion  {

	public Participante adjudicar(PlanDeAhorro plan) throws ExceptionAdjudicarPlanSinParticipantes;
}
