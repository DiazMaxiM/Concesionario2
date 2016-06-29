
public class CuponDeAdjudicacion {

	private PlanDeAhorro planDeAhorro;
	private float montoAPagarPorFlete;
	private Participante unParticipante;

	public CuponDeAdjudicacion(PlanDeAhorro planDeAhorro, Participante unParticipante, float montoAPagarPorFlete) {
		this.planDeAhorro = planDeAhorro;
		this.unParticipante =unParticipante;
		this.montoAPagarPorFlete = montoAPagarPorFlete; 
	}

	public Participante conocerParticipanteGanador() {
		return this.unParticipante;
	}

	
	public float gastoTotalCupon(){
	return	this.planDeAhorro.montoAPagarPorAdjudicacion()+ this.montoAPagarPorFlete;
	}

}
