
import java.io.*;

public class compilador2 {

	public static void main(String[] args) {
		
		//Escribir en un fichero
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("archivo.txt");
            pw = new PrintWriter(fichero);
            
            
            try {
				prueba();
			} catch (IncompatiblesException e) {
				pw.println("IncompatiblesException: "+e.getMessage());
			}
            
            for (int i = 0; i < 10; i++){
            	pw.println("asd");
            }
            
           
                
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
		
				
		//leer un fichero
		
		try {
			FileReader f = new FileReader("archivo.txt");
			BufferedReader br = new BufferedReader(f);
			
			String leida=br.readLine();
			
			while(leida!=null){
				System.out.println(leida);
				leida=br.readLine();
			}
			
			br.close();
		} catch (IOException e) {
			System.err.println("Error: "+e.getMessage());
		}
		
		
		
		
		
		
	}
	
	
	
	public static int prueba() throws IncompatiblesException{
		int devolucion = 5;
		throw new IncompatiblesException("hola");
	}

}
