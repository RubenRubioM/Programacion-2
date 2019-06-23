//DNI 20084606 Rubio Martinez, Ruben
public class Galaxia {
	private String galaxia;
	private Sector[][][] espacio;
	
	//Prueba
	//Constructor
	public Galaxia(String s,int i, int j, int k){
		
		galaxia=s;
		
		if(i<0){
			i=2;
		}
		if(j<0){
			j=2;
		}
		if(k<0){
			k=2;
		}
		espacio =new Sector[i][j][k];
	}
	
	
	//coloca una galaxia en un sector
	public boolean coloca(Sector s){
		boolean devolucion=false;
		Coordenada c = new Coordenada(1,1,1);
		int[] dimension;
		dimension=null;
		dimension=new int[3];
		
		if(s!=null && s.getCoordenada()!=null){
			c=s.getCoordenada();
			dimension=c.getCoordenadas();
			
			if((dimension[0]>=0 && dimension[0]<getEspacio().length) && (dimension[1]>=0 && dimension[1]<getEspacio()[0].length)
					&& (dimension[2]>=0 & dimension[2]<getEspacio()[0][0].length) 
					&& (getEspacio()[dimension[0]][dimension[1]][dimension[2]]==null)){
	
				getEspacio()[dimension[0]][dimension[1]][dimension[2]]=s;
				devolucion=true;
			}else{
				devolucion=false;
			}
		}
		return devolucion;
	}
	
	
	
	public Coordenada[] existencias(String s){
		int tam;
		tam=getEspacio().length * getEspacio()[1].length * getEspacio()[1][1].length;
		Coordenada[] c;
		c=null;
		c=new Coordenada[tam];
		String[] etiquetas;
		etiquetas=null;
		etiquetas = new String[tam];
		
		int r=0;
		for (int i = 0; i < espacio.length; i++) {
			for (int j = 0; j < espacio[1].length; j++) {
				for (int k = 0; k < espacio[1][1].length; k++) {
					if(getEspacio()[i][j][k]!=null){
						etiquetas=getEspacio()[i][j][k].disponibilidad();
						for (int k2 = 0; k2 < etiquetas.length; k2++) {
							if(s.equalsIgnoreCase(etiquetas[k2])){
								c[r]=getEspacio()[i][j][k].getCoordenada();
								r++;
							}
						}
					}
					
				}
			}
		}
		
		//Ordenamos el array
		if(c[0]!=null){
			c = new Coordenada[r];
		}else{
			c = new Coordenada[1];
			c[0]=null;
		}
		
		return c;
	}
	
	
	
	public String getNombre(){
		return galaxia;
	}
	
	
	
	public int getAgujerosNegros(){
		int agujeros=0;
		
		for (int i = 0; i < getEspacio().length; i++) {
			for (int j = 0; j < getEspacio()[0].length; j++) {
				for (int k = 0; k < getEspacio()[0][0].length; k++) {
					if(getEspacio()[i][j][k]==null){
						agujeros++;
					}
				}
			}
		}
		return agujeros;
	}

	
	
	public Sector[][][] getEspacio() {
		return espacio;
	}
	
	
	
	public int getSectores(){
		int devolucion=0;
		
		for (int i = 0; i < espacio.length; i++) {
			for (int j = 0; j < espacio[0].length; j++) {
				for (int k = 0; k < espacio[0][0].length; k++) {
					if(espacio[i][j][k]!=null){
						devolucion=devolucion+1;
					}
				}
			}
		}
		
		return devolucion;
	}

	
	
	public boolean iguales(Galaxia g){
		boolean devolucion=false;
		
		if(this.galaxia.equalsIgnoreCase(g.getNombre())==true){
			for (int i = 0; i < espacio.length; i++) {
				for (int j = 0; j < espacio[0].length; j++) {
					for (int k = 0; k < espacio[0][0].length; k++) {
						
						if(this.espacio[i][j][k].iguales(g.getEspacio()[i][j][k])==true){
							devolucion=true;
						}else{
							devolucion=false;
							k=espacio[0][0].length;
							j=espacio[0].length;
							i=espacio.length;
						}
					}
				}
			}
		}else{
			devolucion=false;
		}
		return devolucion;
	}
}
		
		
