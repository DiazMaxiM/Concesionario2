
public class CompaniaAseguradora {

	private Participante participante;
	private PlanDeAhorro planDeAhorro;

	public CompaniaAseguradora(Participante participante, PlanDeAhorro planDeAhorro) {
		this.participante = participante;
		this.planDeAhorro = planDeAhorro;
	}

	public Double montoAAbonarPorParticipante() {
		return 50.00;
	}

}
