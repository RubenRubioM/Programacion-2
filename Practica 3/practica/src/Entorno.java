//DNI 20084606 Rubio Martinez, Ruben

import java.io.*;

public class Entorno {

	public static void main(String[] args) {
		BufferedReader lec=null;
		FileReader fe = null;
		FileWriter fichero = null;
        PrintWriter pw = null;
		boolean existe_ent = false;
		int[][] ent = null;
		Rau[] animalitos = null;
		
		if(args.length==2){
			try {
				fe = new FileReader(args[0]);
				lec = new BufferedReader(fe);
				String leida = lec.readLine();
				String[] elems = leida.split(" ");
				int filas = Integer.parseInt(elems[0]);
				int columnas = Integer.parseInt(elems[1]);
				
				
				if(filas>0 && columnas>0){
					ent = new int[filas][columnas];
					existe_ent = true;
				}
				
				
				if(leida!=null && existe_ent){
					//leemos la linea
					for (int i = 0; i < ent.length; i++) {
						
						leida=lec.readLine();
						elems=leida.split(" ");
						
						//leemos la columna
						for (int j = 0; j < ent[0].length; j++) {
							if(leida!=null){
								ent[i][j]=Integer.parseInt(elems[j]);
							}
						}
					}//Acabamos de leer el fichero con los datos
				}
				//ahora leemos el numero de animales para crear
				
				leida = lec.readLine();
				int num_animales = Integer.parseInt(leida);
				boolean existe_animalitos = false;
				boolean sexo = false;	
				int energia = 0;
				String nombre = null;
				int parejas = 0;
				
				if(num_animales>0){
					animalitos = new Rau[num_animales];
					existe_animalitos= true;
				}
				
				if(existe_animalitos){
					for (int i = 0; i < animalitos.length; i++) {
						//elems[0] tipo - elems[1] sexo - elems[2] energia - elems[3] nombre/parejas.length 
						leida=lec.readLine();
						elems=leida.split(" ");
						
						//comprobamos el sexo
						if(elems[1].equalsIgnoreCase("M")){
							sexo=false;
						}else if(elems[1].equalsIgnoreCase("H")){
							sexo=true;
						}
						
						//asignamos el tamano del array de energia
						energia=Integer.parseInt(elems[2]);
						
						
						//Es un RauD
						if(elems[0].equalsIgnoreCase("D")){
							nombre=elems[3];
							
							RauD animal = new RauD(sexo,energia,nombre);
							animalitos[i]=animal;
						//Es un RauC	
						}else if(elems[0].equalsIgnoreCase("C")){
							parejas = Integer.parseInt(elems[3]);
							
							RauC animal = new RauC(sexo,energia,parejas);
							animalitos[i]=animal;
						}
						
						
						
					}//fin del ciclo para crear animalitos
					
					int filas_ent=0;
					int columnas_ent=0;
					int redimension = 0;
					Rau hijo = null;
					fichero = new FileWriter(args[1]);
			        pw = new PrintWriter(fichero);
					//procedemos a leer y realizar la parte de las acciones
			        leida = lec.readLine();
			        
			        //bucle hasta que acabe el archivo de lectura o hasta que se acabe el archivo de acciones (ent[][])
					while(leida!=null && (filas_ent<=ent.length && columnas_ent<=ent[0].length)){
						
									
						elems = leida.split(" ");
						
						int num_animal = Integer.parseInt(elems[0]);
						
						//hacer la accion de comer
						if(elems[1].equalsIgnoreCase("come")){
							
							pw.println("come "+animalitos[num_animal].come(filas_ent, ent[filas_ent][columnas_ent]));
						}
						
						//hacer la accion de interacciona(columnas_ent)
						if(elems[1].equalsIgnoreCase("interacciona")){
							pw.println("interacciona "+animalitos[num_animal].interacciona(columnas_ent));
						}
						
						//hacer la accion de reproduce(animalitos[num_animal-1,elems[2])
						if(elems[1].equalsIgnoreCase("reproduce")){
							if(num_animal>0){
								try {
									
									hijo = animalitos[num_animal].reproduce(animalitos[num_animal-1], elems[2]);
									if(hijo!=null){
										//redimensionamos el array de animalitos
										Rau[] tmp = new Rau[animalitos.length+1];
										for (int j = 0; j < animalitos.length; j++) {
											tmp[j]=animalitos[j];
											redimension = j;
										}
										
										if(hijo instanceof RauD){
											tmp[redimension+1] = (RauD) hijo;
										}
										
										if(hijo instanceof RauC){
											tmp[redimension+1] = (RauC) hijo;
										}
										
										
										animalitos=tmp;
										
									}
								} catch (IncompatiblesException ex) {
									pw.println("IncompatiblesException: "+ex.getMessage());
								}
							}
							
						}
						columnas_ent++;
						if(columnas_ent==ent[0].length){
							filas_ent++;
							columnas_ent=0;
						}
						
						leida = lec.readLine();
					}//Acaba de escribir las acciones en el fichero por lo que sea
					
					for (int i = 0; i < animalitos.length; i++) {
						if(animalitos[i] instanceof RauD){
							if(animalitos[i].getSexo()==false){
								pw.println("RauD macho");
							}else{
								pw.println("RauD hembra");
							}
						}
						
						if(animalitos[i] instanceof RauC){
							if(animalitos[i].getSexo()==false){
								pw.println("RauC macho");
							}else{
								pw.println("RauC hembra");
							}
						}
					}
					
						
				
					
				}
				

			//pos si falla en algo	
			} catch (Exception e) {
				e.printStackTrace();
			
			//cerramos los buffereds y eso	
			} finally{
				if(pw!=null){
					pw.close();
				}
				
				if(lec!=null){
					try {
						lec.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.exit(-1);
			}
			
			
			
			
		//no tiene dos ficheros	
		}else{
			System.out.println("Error se necesitan dos nombres de fichero");
		}

	}

}
