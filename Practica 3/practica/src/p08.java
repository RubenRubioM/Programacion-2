

/**
 * Se crea una serie de objetos de tipo RauD y de tipo RauC. Se invoca come de
 * todos los Rau creados. Se invoca reproduce de distintos RauC, pasándole por
 * parámetro unas veces otro RauC y otras un RauD, de manera que nunca se llega
 * a producir la reproducción.
 * 
 * @author Nedyar
 */
public class p08 {
	public static void main(String[] args) {
		Rau[] raus = new Rau[10];

		for (int i = 0; i < raus.length; i++) {
			boolean sexo;
			if (i % 3 == 0)
				sexo = false;
			else
				sexo = true;

			if (i % 2 == 0)
				raus[i] = new RauC(sexo, 0, 0);
			else
				raus[i] = new RauD(sexo, 0, null);

			raus[i].come(3, i + 5);
		}

		for (int i = 0; i < raus.length; i += 2) {
			for (int j = 0; j < raus.length; j++) {
				try {
					if (raus[i].reproduce(raus[j], null) != null)
						System.out.println("Hay tema");
				} catch (IncompatiblesException e) {
					System.out.println("Contigo no, bicho");
				}
			}
		}
	}
}
