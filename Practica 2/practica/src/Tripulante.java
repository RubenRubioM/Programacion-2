//DNI 20084606 Rubio Martinez, Ruben
public class Tripulante extends Navegante{
	private Dophraki conexion;
	private String rango;
	
	//constructor
	public Tripulante(String n,double p,String r){
		super(n,p);
		
		if(r.equalsIgnoreCase("superior") || r.equalsIgnoreCase("subalterno")){
			rango=r;
		}else{
			rango="subalterno";
		}
		
		conexion=null;
	}
	
	//algo falla
	public int trabaja(double t){
		int devolucion=0;
		double setCosecha=0;
		
		if(t>0){
			if(conexion!=null){
				for (int i = 0; i < conexion.getBodega().length; i++) {
					if(conexion.getBodega()[i]!=null && devolucion<3){
						if(conexion.getBodega()[i] instanceof Skrogem){
							
							if(super.trabaja(conexion.getBodega()[i], t)!=null){
								conexion.setBodega(super.noTrabaja(conexion.getBodega()[i]), i);
								devolucion=devolucion+1;
								
								
							}
						}
						
					}
				}
			}
		}
		
		return devolucion;
	}
	
	
	
	//done
	public double cobra(){
		double tarifa=0.0;
		double sueldo=0.0;
		double devolucion=0;
		if(super.getCosecha()>0){
			
			tarifa=super.getEspecia()/super.getCosecha();
		}
		
		
		sueldo=tarifa*super.getTempo();
	
		
		
		
		if(rango.equalsIgnoreCase("superior")){
			sueldo=sueldo+(sueldo*0.35);
			
		}else if(rango.equalsIgnoreCase("subalterno")){
			sueldo=sueldo+(sueldo*0.20);
		}
		devolucion=super.getCosecha()-sueldo;
		super.setEspecia(sueldo);
		super.setCosecha(-super.getCosecha());
		super.setTempo(-super.getTempo());
		
		return devolucion;
	}
	
	//done
	public boolean embarca(Dophraki n){
		boolean devolucion=false;
		
		if(n!=null){
			if(!enrolado() && this.getPasaje()==-1){
				if(n.solicitudAdmision(this)==true){
					devolucion=true;
				}else{
					if(super.embarca(n)){
						devolucion=true;
					}
				}
			}
		}
		return devolucion;
	}
	
	
	
	//done - i think
	public boolean desembarca(){
		boolean devolucion=false;
		
		this.cobra();
		if(this.getConexion()!=null){
			if(this.getConexion().solicitudDimision(this.getCosecha(), this)){
				devolucion=true;
			}
		}
		return devolucion;
	}
	
	
	//done - devuelve cierto si esta en una nave
	public boolean enrolado(){
		boolean devolucion=false;
		if(conexion!=null){
			devolucion=true;
		}
		return devolucion;
	}
	
	
	
	//done
	public void setConexion(Dophraki d){
		conexion=d;
	}
	
	
	//done
	public String getRango(){
		return rango;
	}
	
	
	//done 
	public Dophraki getConexion(){
		return conexion;
	}
	
	
	//done
	public boolean iguales(Tripulante t){
		boolean devolucion=false;
		
		if(this.rango.equalsIgnoreCase(t.getRango())){
			if(this.getCosecha()==t.getCosecha()){
				if(this.getEspecia()==t.getEspecia()){
					if(this.getNombre().equalsIgnoreCase(t.getNombre())){
						if(this.getPasaje()==t.getPasaje()){
							if(this.getTempo()==t.getTempo()){
								devolucion=true;
							}
						}
					}
				}
			}
		}
		return devolucion;
	}
	
}
