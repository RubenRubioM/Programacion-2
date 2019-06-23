

/**
 * Se crea un objeto de tipo RauC usando una variable de tipo Rau. Se invoca
 * come para todas las posiciones de su array de energ�a. Se invoca
 * nivelEnergetico. Se invoca interacciona de manera que accede a todas las
 * posiciones de su array de energ�a. Se invoca nivelEnergetico.
 * 
 * @author Nedyar
 */
public class p06 {
	public static void main(String[] args) {
		Rau rau = new RauC(true, 0, 0);

		for (int i = 0; i <= rau.getEnergia().length; i++) {
			if (rau.come(i, i))
				System.out.println("rau come " + i + " en " + i);
			else
				System.out.println("rau no ha comido " + i + " en " + i);
		}
		System.out.println("Nivel energetico despues de comer: " + rau.nivelEnergetico());
		for (int i = 0; i <= rau.getEnergia().length*8; i+=9) {
			System.out.println("Interacciona " + i + ": " + rau.interacciona(i));
		}
		System.out.println("Nivel energetico despues de interaccionar: " + rau.nivelEnergetico());
	}
}
