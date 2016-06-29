
public class CuponDeAdjudicacion {

	private PlanDeAhorro planDeAhorro;
	private Float montoAPagarPorFlete;
	private Participante unParticipante;

	public CuponDeAdjudicacion(PlanDeAhorro planDeAhorro, Participante unParticipante, Float montoAPagarPorFlete) {
		this.planDeAhorro = planDeAhorro;
		this.montoAPagarPorFlete = montoAPagarPorFlete; 
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
