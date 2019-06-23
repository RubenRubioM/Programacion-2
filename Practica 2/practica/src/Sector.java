//DNI 20084606 Rubio Martinez, Ruben
public class Sector {
	private Coordenada coordenada;
	private Mercancia[] almacen;
	private int[] existencias;
	
	
	//Constructor
	public Sector(int n){
		if(n>0){
			almacen=null;
			almacen=new Mercancia[n];
			existencias=null;
			existencias=new int[n];
		}
	}
	
	
	//situa la nave
	public boolean situa(int i,int j,int k){
		if (coordenada==null){
			coordenada = new Coordenada(i,j,k);

			return true;
		}else{
			return false;
		}
	}
	
	
	//almacena una mercancia
	public boolean almacena(Mercancia o){   
		
		boolean iguales=false;
		boolean almacen_libre=false;
		int posicion=0;
		int[] coordenadas2;
		String s;
		boolean devolucion =false;
		coordenadas2=null;
		coordenadas2=new int[3];
		
		coordenadas2=coordenada.getCoordenadas();
		
		s=String.valueOf(coordenadas2[0])+String.valueOf(coordenadas2[1])+String.valueOf(coordenadas2[2]);

		if(coordenada!=null){
			
			for (int i = 0; i < almacen.length; i++) {
				//Ya ha sido almacenado alguna vez
				if(o.iguales(almacen[i])==true){
					
					existencias[i]=existencias[i]+1;
					iguales=true;
					devolucion=true;
					
				}
			}
			//Comprueba si el almacen esta libre
			for (int i = 0; i < almacen.length; i++) {
				if(almacen[i]==null){
					posicion=i;
					almacen_libre=true;
					i=almacen.length;
				}
			
			}
			//Asignarle una etiqueta
			if((iguales==false) && almacen_libre==true){
				o.almacena(s);
				almacen[posicion]=o;
				existencias[posicion]=1;
				devolucion=true;
				
			}else if(almacen_libre==false){
				devolucion=false;
			}
		}else{
			devolucion=false;
		}
		return devolucion;
	}
	
	
	//recoge una mercancia
	public Mercancia recoge(String s){
		double p = 4.5;
		double[]d = null;
		d= new double[2];
		Mercancia devolucion = new Mercancia(p,d);
		devolucion=null;
		for (int i = 0; i < almacen.length; i++) {
			if(almacen[i]!=null){
				if(s.equalsIgnoreCase(almacen[i].getEtiqueta())){
					
					if(existencias[i]>1){
						
						almacen[i].recogida();
						devolucion=almacen[i].duplicado();
						existencias[i]=existencias[i]-1;
						i=almacen.length;
						
					}else{
						devolucion=almacen[i];
						almacen[i].recogida();
						almacen[i]=null;
						existencias[i]=0;
						i=almacen.length;
						
					}
				}else{
					devolucion=null;
				}
			}
			
		}
		return devolucion;
	}
	
	
	//recuento de las existencias de una mercancia en concreto
	public int recuento(String s){
		int devolucion=0;
		
		for (int i = 0; i < almacen.length; i++) {	
			if(almacen[i]!=null && s.equalsIgnoreCase(almacen[i].getEtiqueta())){
				devolucion=existencias[i];
				
			}
		}
		
		return devolucion;
	}
	
	
	//Array de etiquetas disponibles en el almacen
	public String[] disponibilidad(){
		String[] devolucion = null;
		devolucion = new String[almacen.length];
		
		for (int i = 0; i < devolucion.length; i++) {
			if(almacen[i]!=null){
				devolucion[i]=almacen[i].getEtiqueta();
			}
			
		}
		return devolucion;
	}
	
	
	//Capacidad del almacen
	public int capacidadDisponible(){
		int devolucion=0;
		
		for (int i = 0; i < almacen.length; i++) {
			if(almacen[i]==null){
				devolucion=devolucion+1;
			}
		}
		return devolucion;
	}
	
	
	//return coordenada
	public Coordenada getCoordenada(){
		return coordenada;
	}
	
	
	//return almacen
	public Mercancia[] getAlmacen(){

		return almacen;
	}
	
	
	
	public int[] getExistencias(){
		return existencias;
	}
	
	
	//comprobar si dos sectores son iguales
	public boolean iguales(Sector s){
		boolean devolucion=false;
		
		if((this.coordenada.getCoordenadas()[0]==s.getCoordenada().getCoordenadas()[0]) && (this.coordenada.getCoordenadas()[1]==s.getCoordenada().getCoordenadas()[1]) && (this.coordenada.getCoordenadas()[2]==s.getCoordenada().getCoordenadas()[2])){
			for (int i = 0; i < almacen.length; i++) {
				if(this.almacen[i].iguales(s.getAlmacen()[i])){
					if(this.existencias[i]==s.getExistencias()[i]){
						devolucion=true;
					}else{
						devolucion=false;
						i=almacen.length;
					}
				}else{
					devolucion=false;
					i=almacen.length;
				}
			}
		}else{
			devolucion=false;
		}
		
		return devolucion;
	}
}


