
public class Financiacion7030 implements TipoDeFinanciacion {

	@Override
	public float montoDeLaCuota(PlanDeAhorro plan) {
		int cantidadDeCuotas = plan.cantidadDeCuotas();
		float valorVehiculo = (float) (plan.precioDelVehiculo()*0.7);
		return (valorVehiculo/cantidadDeCuotas);
	}

	@Override
	public float montoPagoEfectivoEnAdjudicacion(PlanDeAhorro plan) {
		return (float)(plan.precioDelVehiculo()*0.3);
	}

}
