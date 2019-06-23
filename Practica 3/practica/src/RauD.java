//DNI 20084606 Rubio Martinez, Ruben


public class RauD extends Rau{
	private String nombre;
	private Rau[] progenie;
	
	
	
	//constructor
	public RauD(boolean b, int i, String n){
		super(b, i);
		nombre=n;
		progenie = new Rau[4];
		
	}
	
	
	//done
	public int interacciona(int i){
		int devolucion=0;

		
		if(i<0){
			i=Math.abs(i);
			devolucion=getEnergia()[i%getEnergia().length];
			super.setEnergia(i%getEnergia().length, 0);
		}else{
			devolucion=getEnergia()[i%getEnergia().length];
			super.setEnergia(i%getEnergia().length, 0);
		}
		
		
		return devolucion;
	}
	
	
	
	//done
	public Rau reproduce(){
		RauD devolucion = new RauD(super.getSexo(),super.getEnergia().length,nombre);
		int[] energia = this.getEnergia();
		
		for (int i = 0; i < energia.length; i++) {
			devolucion.setEnergia(i, energia[i]);
		}
		
		
		return devolucion;
	}
	
	
	
	//done i think
	public Rau reproduce(Rau r,String n) throws IncompatiblesException{
		RauD devolucion=null;
		String sexo_error=null;
		if(r.getSexo()==true){
			sexo_error="hembra";
		}
		if(r.getSexo()==false){
			sexo_error="macho";
		}
		
		
		
		int energia_length=this.getEnergia().length+r.getEnergia().length;
		boolean sexo=false;
		
		if(this.getSexo()!=r.getSexo()){
			if(r instanceof RauD){
				if(this.nivelEnergetico()>r.nivelEnergetico()){
					sexo=this.getSexo();
				}else if(this.nivelEnergetico()<r.nivelEnergetico()){
					sexo=r.getSexo();
				}else if(this.nivelEnergetico()==r.nivelEnergetico()){
					sexo=false;
				}
				
				devolucion = new RauD(sexo,energia_length,n);
				
				//comprobamos si hay que redimensionar el array
				for (int i = 0; i < progenie.length; i++) {
					
					if(progenie[i]!=null && i==progenie.length-1){
						int k = 0;
						Rau[] tmp = new Rau[progenie.length+3];
						
						for (int j = 0; j < progenie.length; j++) {
							tmp[j]=progenie[k];
							k++;
						}
						tmp[i+1]=devolucion;
						progenie=tmp;
					}
					
					if(progenie[i]==null){
						progenie[i]=devolucion;
						i=progenie.length;
					}
					
				}
				
				if(r.getSexo()==true){
					for (int i = 0; i < r.getEnergia().length; i++) {
						devolucion.come(i, r.getEnergia()[i]);
						r.setEnergia(i, 0);
					}
				}
				
				if(this.getSexo()==true){
					for (int i = 0; i < this.getEnergia().length; i++) {
						devolucion.come(i, this.getEnergia()[i]);
						this.setEnergia(i, 0);
					}
				}
			}else{
				throw new IncompatiblesException(sexo_error, "RauC");
			}
			
		//no tienen sexo opuesto	
		}else{
			throw new IncompatiblesException(sexo_error);
		}
		
		
		return devolucion;
		
	}
	
	
	
	//todo
	public String[] arbolGenealogico(){
		String[] devolucion;
		devolucion = new String[1];
		int contador = 0;
		
		devolucion=arbol(devolucion,contador);
		
		
		
		
		return devolucion;
	}
	
	
	
	public String[] arbol(String[] arbolge,int cont){
		
		//redimension
		if(arbolge.length==cont){
			String[] tmp = new String[arbolge.length+1];
			for (int j = 0; j < arbolge.length; j++) {
				tmp[j]=arbolge[j];
			}
			arbolge=tmp;
		}
		arbolge[cont]=this.getNombre();
		cont++;
		
		if(this.getProgenieExistente()>0){ //Caso recursivo
			for (int i = 0; i < progenie.length; i++) {
				
				
				
				if(progenie[i]!=null){
					arbolge=((RauD) progenie[i]).arbol(arbolge,cont);
					cont=arbolge.length;
				}
				
			}
	
		}
		return arbolge;
	}
	
	
	
	//done
	public Rau[] getProgenie(){
		return progenie;
	}
	
	
	
	//numero de descendencia que tiene
	public int getProgenieExistente(){
		int devolucion=0;
		
		for (int i = 0; i < progenie.length; i++) {
			if(progenie[i]!=null){
				devolucion=devolucion+1;
			}
		}
		
		return devolucion;
	}
	
	
	//done
	public String getNombre(){
		return nombre;
	}


	
}
