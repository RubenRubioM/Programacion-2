//DNI 20084606 Rubio Martinez, Ruben
public class Mercancia {
	private double peso;
	private double[] dimension;
	private String etiqueta;
	private boolean almacenada;
	
	
	//Constructor
	public Mercancia(double p,double[] d){
		//Creacion del constructor
		if(p<0){
			peso=1.5;
		}else{
			peso=p;
		}
		
		if(d!=null){
			dimension=new double[d.length];
			for (int i = 0; i < d.length; i++) {
				dimension[i]=d[i];
			}
		}else{
			dimension=new double[1];
			dimension[0]=0.5;
		}
		etiqueta=null;
		almacenada=false;
	}
	
	
	//Almacena una mercancia asignandole una etiqueta
	public boolean almacena(String s){
		//Almacena el producto si no esta almacenado ya, le crea una etiqueta y cambia su valor de la variable almacenada
		double[] aux;
		double suma = 0;
		aux=new double[dimension.length];
		aux=dimension;
		int[] enteros;
		enteros=null;
		enteros=new int[aux.length];
		
		if(etiqueta==null){
			for (int i = 0; i < aux.length; i++) {
				suma=suma+aux[i];
			}
			for (int i = 0; i < enteros.length; i++) {
				suma=suma*10;
				suma=(int) suma;
				suma=(double) suma;
				suma=suma/10;
			}
			etiqueta=s+peso+"-"+suma;
		}
		if(almacenada==false){
			almacenada=true;
			return true;
		}else{
			return false;
		}
	}
	
	
	//recoge una mercancia
	public boolean recogida(){
		//Recoge una mercancia y pone su valor de almacenada en false si la recoge, si no es que no esta almacenada
		boolean devolucion=false;
		if(almacenada==true){
			almacenada=false;
			devolucion=true;
		}else{
			devolucion=false;
		}
		return devolucion;
	}
	
	
	//compara dos mercancias
	public boolean iguales(Mercancia m){
		//Metodo para ver si dos mercancias son la misma
		
		boolean respuesta = false;
		if(m!=null){
			if(m.getEtiqueta()!=null && (m.getEtiqueta().equalsIgnoreCase(etiqueta))&& (m.getPeso()==peso && (m.igualdimension(this)))){
				respuesta=true;
				
			}else{
				respuesta=false;
			}
		}
		
		return respuesta;
	}
			

	
	
	//duplica una mercancia
	public Mercancia duplicado(){
		Mercancia m = new Mercancia(peso, dimension);
		m.etiqueta=etiqueta;
		m.almacenada=almacenada;
		return m;
	}
	
	
	//return dimension
	public double getDimension(){
		double suma=0;
		for (int i = 0; i < dimension.length; i++) {
			suma=suma+dimension[i];
		}
		return suma;
	}
	
	
	public double[] getDimensiones(){
		return dimension;
	}
	
	
	
	public boolean igualdimension(Mercancia m){
		boolean devolucion=false;
		
		for (int i = 0; i < dimension.length; i++) {
			if(dimension[i]==m.getDimensiones()[i]){
				devolucion=true;
			}else{
				devolucion=false;
				i=dimension.length;
			}
		}
		
		return devolucion;
	}
	
	//return estado de la mercancia
	public boolean getAlmacenada(){
		return almacenada;
	}
	
	
	//return peso
	public double getPeso(){
		return peso;
	}
	
	public String getEtiqueta(){
		return etiqueta;
	}
	//done
	public boolean almacena(Romskip r){
		boolean devolucion=false;
		
		if(r!=null){
				if(this.getAlmacenada()==false){
					almacenada=true;
					etiqueta=r.getNombre()+Double.toString(this.getPeso());
					devolucion=true;
				}
			
		}
		
		return devolucion;
	}
	
	public void setAlmacenada(boolean almacenada){
		this.almacenada=almacenada;
	}
	
	
	public void setEtiqueta(String s){
		this.etiqueta=s;
	}
	
}