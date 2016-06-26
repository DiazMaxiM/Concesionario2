
public class CuponDeAdjudicacion {

	private PlanDeAhorro planDeAhorro;
	private Flete flete;
	private Participante unParticipante;

	public CuponDeAdjudicacion(PlanDeAhorro planDeAhorro, Flete flete, Participante unParticipante) {
		this.planDeAhorro = planDeAhorro;
		this.flete = flete;
		this.unParticipante = unParticipante; 
	}

	public Participante conocerParticipanteGanador() {
		return this.unParticipante;
	}

	public Float gastoPorPlan() {
		/*if(planDeAhorro.esPlan7030()){
			return planDeAhorro.precioDelVehiculo() * (float)0.30;
		}*/

		return (float)0;
	}

}
