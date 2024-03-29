//DNI 20084606 Rubio Martinez, Ruben
public class Romskip {
	private String nombre;
	private Mercancia[] bodega;
	private double carga;
	private static Galaxia mapa;
	
	
	public Romskip(String n,int i,double x){
		
		nombre=n;
		
		if(i<=0){
			i=3;
		}
		bodega=null;
		bodega=new Mercancia[i];
		
		if(x<=0){
			carga=8.5;
		}else{
			carga=x;
		}	
		
		
	}
	
	public String embarque(String s,Coordenada c){
		String devolucion=null;
		
		
		if(c!=null){
			
			if(mapa!=null){
				boolean existe_mercancia=false;
				Sector[][][] espacio = null;
				espacio=mapa.getEspacio();
				//Ruben hay un problema con el espacio
				int i2=0,j2=0,k2=0,l2=0;
				String[] etiqueta=null;
				//Ciclos para detectar el sector de la galaxia que coincida con esas coordenadas
				
				
				for (int i = 0; i < espacio.length; i++) {
					for (int j = 0; j < espacio[0].length; j++) {
						for (int k = 0; k < espacio[0][0].length; k++) {
							
							if(espacio[i][j][k]!=null){
								Coordenada coordenadas=null;
								coordenadas=espacio[i][j][k].getCoordenada();
								int[] coordenada=null;
								coordenada=coordenadas.getCoordenadas();
							
							
								if(c.getCoordenadas()[0]==espacio[i][j][k].getCoordenada().getCoordenadas()[0]
									&& (c.getCoordenadas()[1]==espacio[i][j][k].getCoordenada().getCoordenadas()[1])
									&& (c.getCoordenadas()[2]==espacio[i][j][k].getCoordenada().getCoordenadas()[2])){
										
										i2=i;
										j2=j;
										k2=k;
										
										etiqueta=espacio[i][j][k].disponibilidad();
										
										
										//Ciclo para detectar la etiqueta de ese sector que coincida con la pasada
										for (int l = 0; l < etiqueta.length; l++) {
											if(s.equalsIgnoreCase(etiqueta[l])){
												l2=l;
												existe_mercancia=true;
												i=espacio.length;
												j=espacio[0].length;
												k=espacio[0][0].length;
												
												
											}
										}
								}
							}
						}
					}
				}
				
				if(existe_mercancia){
					Mercancia[] mercancias=null;
					mercancias=espacio[i2][j2][k2].getAlmacen();
					boolean espacio_libre=false;
					boolean pesojusto=false;
					int posicion_mercancia=0;
					
					//Buscamos la mercancia almacenada en el almacen del sector
					for (int i = 0; i < mercancias.length; i++) {
						if(mercancias[i]!=null && etiqueta[l2].equalsIgnoreCase(mercancias[i].getEtiqueta())){
							posicion_mercancia=i;
						}
					}
					for (int i = 0; i < bodega.length; i++) {
						if(bodega[i]==null){
							espacio_libre=true;
						}
					}
					if(!espacio_libre){
						devolucion=mercancias[posicion_mercancia].getEtiqueta()+": bodega de carga completa";
					}
					if(mercancias[posicion_mercancia].getPeso()>carga-getPeso()){
						devolucion=mercancias[posicion_mercancia].getEtiqueta()+": sobrecarga";
					}else{
						pesojusto=true;
					}
					
					
					//Recogemos la mercancia y la guardamos en la bodega
					if(espacio_libre==true && pesojusto==true){
						for (int i = 0; i < bodega.length; i++) {
							if(bodega[i]==null){
								bodega[i]=espacio[i2][j2][k2].recoge(s);
								bodega[i].almacena(s);
								i=bodega.length;
							}
						}
					}
					//Ordenamos el array de bodega
					for(int i=0;i<(bodega.length-1);i++){
			            for(int j=i+1;j<bodega.length;j++){
			            	if(bodega[i]!=null && bodega[j]!=null){
			            		if(bodega[i].getDimension()>bodega[j].getDimension()){
				                    //Intercambiamos valores
				                	double[] d;
				            		d=null;
				            		d=new double[4];
				            		d[0]=2.42;
				            		d[1]=5.44;
				                	
				                	Mercancia variableauxiliar=new Mercancia(1,d);
				                
				                    variableauxiliar=bodega[i];
				                    bodega[i]=bodega[j];
				                    bodega[j]=variableauxiliar;
				 
				                }else if(bodega[i].getDimension()==bodega[j].getDimension()){
				                	double[] d;
				            		d=null;
				            		d=new double[4];
				            		d[0]=2.42;
				            		d[1]=5.44;
				                	Mercancia variableauxiliar=new Mercancia(1,d);
				                
				                    variableauxiliar=bodega[i];
				                    bodega[i]=bodega[j];
				                    bodega[j]=variableauxiliar;
				                }
			            	}
			                
			            }
			        }
					
			}
			
				
		}
			
		}
		return devolucion;
	}
		
		
		

	public Mercancia desembarque(String s){
		Mercancia devolucion=null;
		for (int i = 0; i < bodega.length; i++) {
			if(bodega[i].getEtiqueta().equalsIgnoreCase(s)){
				devolucion=bodega[i];
				bodega[i]=null;
				i=bodega.length;
			}
		}
		
		for(int i=0;i<(bodega.length-1);i++){
            for(int j=i+1;j<bodega.length;j++){
                if(bodega[i]==null){
                    //Intercambiamos valores
                	double[] d;
            		d=null;
            		d=new double[4];
            		d[0]=2.42;
            		d[1]=5.44;
                	Mercancia variableauxiliar=new Mercancia(1,d);
	                
                    variableauxiliar=bodega[i];
                    bodega[i]=bodega[j];
                    bodega[j]=variableauxiliar;
                }
            }
        }
		return devolucion;
	}

	public boolean teletransporte(Romskip r,int i){
		boolean devolucion=false;
		
		
		if(r!=null){
			if(bodega[i]!=null && r.verifica(bodega[i])){
				bodega[i]=null;
				devolucion=true;
				//Ordenacion
				for(int i2=0;i2<(bodega.length-1);i2++){
		            for(int j=i2+1;j<bodega.length;j++){
		                if(bodega[i2]==null){
		                    //Intercambiamos valores
		                	double[] d;
		            		d=null;
		            		d=new double[4];
		            		d[0]=2.42;
		            		d[1]=5.44;
		                	Mercancia variableauxiliar=new Mercancia(1,d);
			                
		                    variableauxiliar=bodega[i2];
		                    bodega[i2]=bodega[j];
		                    bodega[j]=variableauxiliar;
		                   
		                }
		            }
		        }
			}
		}
		return devolucion;
	}

	public boolean verifica(Mercancia m){
		boolean devolucion=false;
		boolean hay_espacio=false;
		
		if(m!=null && m.getPeso()<=carga-this.getPeso()){
			for (int i = 0; i < bodega.length; i++) {
				if(bodega[i]==null){
					bodega[i]=m;
					i=bodega.length;
					hay_espacio=true;
					devolucion=true;
					
				}
				//redimensionamos
				if(i==bodega.length-1 && !hay_espacio){
					int k=0;
					Mercancia[] tmp = new Mercancia[bodega.length+1];
					for (int j = 0; j < bodega.length; j++) {
						tmp[k]=bodega[j];
						k++;
					}
					tmp[k]=m;
					bodega=tmp;
					devolucion=true;
				}
			}
		}
		
		//Ordenar array
		for(int i=0;i<(bodega.length-1);i++){
            for(int j=i+1;j<bodega.length;j++){
            	if(bodega[i]!=null && bodega[j]!=null){
            		if(bodega[i].getDimension()>bodega[j].getDimension()){
                        //Intercambiamos valores
                    	double[] d;
                		d=null;
                		d=new double[4];
                		d[0]=2.42;
                		d[1]=5.44;
                    	
                    	Mercancia variableauxiliar=new Mercancia(1,d);
                    
                        variableauxiliar=bodega[i];
                        bodega[i]=bodega[j];
                        bodega[j]=variableauxiliar;
     
                    }else if(bodega[i].getDimension()==bodega[j].getDimension()){
                    	double[] d;
                		d=null;
                		d=new double[4];
                		d[0]=2.42;
                		d[1]=5.44;
                    	Mercancia variableauxiliar=new Mercancia(1,d);
                    
                        variableauxiliar=bodega[i];
                        bodega[i]=bodega[j];
                        bodega[j]=variableauxiliar;
                    }
            	}
                
            }
        }
		return devolucion;
	}
	
	public int conteo(){
		int devolucion=0;
		
		for (int i = 0; i < bodega.length; i++) {
			if(bodega[i]!=null){
				devolucion=devolucion+1;
			}
		}
		return devolucion;
	}
	
	public Mercancia[] getBodega(){
		return bodega;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public static String getNombreMapa(){
		return mapa.getNombre();
	}
	
	public static void setMapa(Galaxia g){
		if(g!=null){
			mapa=g;
		}
	}
	
	public static boolean hayAgujerosNegros(){

		int agujeros = 0;
		boolean devolucion = false;
		
		agujeros = mapa.getAgujerosNegros();
		
		if(agujeros>0){
			devolucion = true;
		}else{
			devolucion = false;
		}
		
		return devolucion;
	}
	
	public double getPeso(){
		double devolucion=0;
		
		for (int i = 0; i < bodega.length; i++) {
			if(bodega[i]!=null){
				devolucion=devolucion+bodega[i].getPeso();
			}
		}
		return devolucion;
	}
}
