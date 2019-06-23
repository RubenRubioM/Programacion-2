//DNI 20084606 Rubio Martinez, Ruben
public class Navegante {
	private String nombre;
	private double especia;
	private double tempo;
	private double cosecha;
	private int pasaje;
	
	//constructor
	public Navegante(String n,double d){
		nombre=n;
		if(d>0){
			especia=d;
		}else{
			especia=7.5;
		}
		tempo=0;
		cosecha=0;
		pasaje=-1;
		
	}
	
	
	//done?
	public Mercancia trabaja(Mercancia m,double t){
		double[] d;
		d=new double[2];
		d[1]=1;
		d[0]=1;
		Mercancia devolucion=new Mercancia(0,d);
		devolucion=null;
		if(t>0){
			tempo=tempo+t;
			
			if(m instanceof Skrogem){
				
				cosecha+=((Skrogem) m).eliminado();
				
				devolucion=m.duplicado();
				
			
			}else{
				devolucion=m;
			}
		}
		
		return devolucion;
	}
	
	
	public Mercancia noTrabaja(Mercancia m){
		double[] d;
		d=new double[2];
		d[1]=1;
		d[0]=1;
		Mercancia devolucion=new Mercancia(0,d);
		devolucion=null;
		
			
			
			if(m instanceof Skrogem){
				
				
				
				devolucion=m.duplicado();
				
			
			}else{
				devolucion=m;
			}
		
		
		return devolucion;
	}
	
	
	//done
	public double cobra(){
		double tarifa=0.0;
		double sueldo=0.0;
		double devolucion=0;
		if(cosecha>0){
			
			
			tarifa=especia/cosecha;
		}
		
		sueldo=tarifa*tempo;
		
		especia+=sueldo;
		
		devolucion=cosecha-sueldo;
		
		tempo=0;
		cosecha=0;
		
		
		
		return devolucion;
		
	}
	
	

	
	
	//done asegurado
	public boolean embarca(Dophraki n){
		boolean devolucion=false;
		int pasaje_set=0;
		
		pasaje_set=n.embarque(this);
		
		if(n!=null){
			if(getPasaje()==-1){
				if(pasaje_set>=0){
					
					setPasaje(pasaje_set);
					devolucion=true;
					
				}
			}
		}
		
		return devolucion;
	}
	
	
	//done?? dudo con los this pero bueno
	public boolean desembarca(Dophraki n){
		boolean devolucion=false;
		
		if(n!=null){
			if(n.desembarque(this.pasaje, this)){
				devolucion=true;
			}
		}
			
		return devolucion;
	}
	
	
	//done
	public double paga(double d){
		double devolucion=0;

		if(d>0){
			if(especia>=d){
				especia=especia-d;
				devolucion=d;
			}else{
				devolucion=0.0;
			}
		}else{
			devolucion=-1.0;
		}
		
		return devolucion;
	}
	
	
	//done
	public String getNombre(){
		return nombre;
	}
	
	
	//done
	public double getEspecia(){
		return especia;
	}
	
	
	//done
	public double getTempo(){
		return tempo;
	}
	
	
	//done
	public double getCosecha(){
		return cosecha;
	}
	
	
	//done
	public int getPasaje(){
		return pasaje;
	}
	
	
	//done
	public void setPasaje(int pasaje_set){
		this.pasaje=pasaje_set;
	}
	
	
	//done
	public boolean iguales(Navegante n){
		boolean devolucion=false;
		
		
		if(this.getNombre().equalsIgnoreCase(n.getNombre())){
			
			if(this.getEspecia()==n.getEspecia()){
				
				if(this.getTempo()==n.getTempo()){
					
					if(this.getCosecha()==n.getCosecha()){
						
						if(this.getPasaje()==n.getPasaje()){
							
							devolucion=true;
						}
					}
				}
			}
		}
		return devolucion;
	}
	
	
	public void setEspecia(double d){
		this.especia=especia+d;
	}
	
	
	public void setCosecha(double d){
		cosecha=cosecha+d;
	}
	
	
	public void setTempo(double d){
		tempo=tempo+d;
	}
}