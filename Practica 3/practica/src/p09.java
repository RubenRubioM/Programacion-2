


/**
 * Se crean dos RauD de distinto sexo. Se invoca come de ambos para todas las
 * posiciones de su array de energía. Se invoca reproduce de uno de ellos
 * pasando por parámetro el otro RauD. Se repite el proceso para tengan varios
 * hijos. Se invoca arbolGenealogico de todos los Rau.
 * 
 * @author Nedyar
 */
public class p09 {
	public static void main(String[] args) {
		RauD skull = new RauD(false, 0, "Skull");
		RauD hembra = new RauD(true, 0, "hembra");

		for (int i = 0; i < skull.getEnergia().length; i++) {
			skull.come(i, 3);
			hembra.come(i, 1);
		}

		try {
			RauD mordekai = (RauD) skull.reproduce(hembra, "Mordekai");
			RauD bliosa = (RauD) skull.reproduce(hembra, "Bliosa");
			RauD pherds = (RauD) mordekai.reproduce(hembra, "Pherds");
			RauD jardy = (RauD) pherds.reproduce(hembra, "Jardy");
			RauD leonidas = (RauD) pherds.reproduce(hembra, "Leonidas");

			imprimirArbol(skull);
			imprimirArbol(hembra);
			imprimirArbol(bliosa);
			imprimirArbol(pherds);
			imprimirArbol(jardy);
			imprimirArbol(leonidas);
		} catch (IncompatiblesException e) {
			e.printStackTrace();
		}
	}

	private static void imprimirArbol(RauD rau) {
		System.out.print("Arbol genealogico de "+   rau.getNombre() + ": " );
		String[] arbol = rau.arbolGenealogico();
		for (String s : arbol)
			System.out.print(s + ", ");
		System.out.println();
	}
}