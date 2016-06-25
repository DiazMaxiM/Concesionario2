
public class Financiacion7030 implements TipoDeFinanciacion {

	@Override
	public float montoDeLaCuota(PlanDeAhorro plan) {
		int cantidadDeCuotas = plan.cantidadDeCuotas();
		float valorVehiculo = (float) (plan.precioDelVehiculo()*0.7);
		return (valorVehiculo/cantidadDeCuotas);
	}

}
