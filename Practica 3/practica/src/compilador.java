

import java.io.*;

public class compilador {

	public static void main(String[] args){
		
		RauD rd = new RauD(false,6,"pepito");
		RauD rd2 = new RauD(true,4,"josefa");
		RauD rd3 = null;
		RauD rd4 = new RauD(true,4,"josefaaaaaaaaaa");
		RauC rc = new RauC(false,4,1);
		rd3 = new RauD(true, 5,"pepeeee");
		Rau[] animalitos = new Rau[1];

		rd.setEnergia(1, 10);
		Rau hijo = null;
		try {
			hijo = rd.reproduce(rd2, "pepa");
			System.out.println(((RauD)hijo).getNombre());
			if(hijo instanceof RauD){
				System.out.println("es un raud");
				animalitos[0] = hijo;
				
				System.out.println(((RauD) hijo).getNombre());
			}
			//System.out.println(animalitos[0].getSexo());
			System.out.println("acaba el try");
		} catch (IncompatiblesException e) {
			
			System.out.println("IncompatiblesException: "+e.getMessage());
		}
		
		
	}
	
	
	public static int prueba() throws IncompatiblesException{
		int devolucion = 5;
		throw new IncompatiblesException("hola");
	}

}