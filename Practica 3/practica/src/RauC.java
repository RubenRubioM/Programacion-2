//DNI 20084606 Rubio Martinez, Ruben


public class RauC extends Rau{
	String[] parejas;
	
	//contrsuctor
	public RauC(boolean b,int i,int j){
		super(b,i);
		
		if(j>=3){
			parejas = new String[j];
		}else{
			parejas = new String[3];
		}
	}
	
	
	
	//done i think
	public Rau reproduce() {
		RauC devolucion = new RauC(super.getSexo(),super.getEnergia().length,this.getParejas().length);
		int[] energia = this.getEnergia();
		
		for (int i = 0; i < energia.length; i++) {
			devolucion.setEnergia(i, energia[i]);
		}
		
		
		return devolucion;
	}

	
	
	//done i think
	public Rau reproduce(Rau r, String n) throws IncompatiblesException {
		String sexo_error=null;
		
		
		if(r.getSexo()==true){
			sexo_error="hembra";
		}
		if(r.getSexo()==false){
			sexo_error="macho";
		}
		
		
		
		if(r.getSexo()!=this.getSexo()){
			if(r instanceof RauD){
				//Guardamos el nombre del Rau pasado por parametro en el array de parejas
					if(parejas!=null){
						for (int i = 0; i < parejas.length; i++) {
							//redimensionar el array de parejas
							if(parejas[i]!=null && i==parejas.length-1){
								int k = 0;
								
								String[] tmp = new String[parejas.length+3];
								
								for (int j = 0; j < parejas.length; j++) {
									tmp[j]=parejas[k];
									k++;
								}
								tmp[i+1]=((RauD) r).getNombre();
								parejas=tmp;
								
								
							}
							
							if(parejas[i]==null){
								parejas[i]=((RauD) r).getNombre();
							}
						}
					}
					
					
					if(r.getSexo()==true){
						//Si entra es que r es la madre y this es el padre
						RauD devolucion = new RauD(r.getSexo(),r.getEnergia().length,n);
						
						for (int i = 0; i < this.getEnergia().length; i++) {
							devolucion.come(i, this.getEnergia()[i]);
							this.setEnergia(i, 0);
						}
						
						
						//hago el return dentro
						return devolucion;
					}else{
						throw new IncompatiblesException(sexo_error, "RauD");
					}
				//No tienen el mismo sexo
				
			//es un RauC	
			}else if(r instanceof RauC){
			
				RauC padre = null;
				RauC madre = null;
				
				//Comprobacion de cuales de los dos son el padre
				if(r.getSexo()==false){
					padre = (RauC) r;
				}else{
					madre = (RauC) r;
				}
				if(this.getSexo()==false){
					padre = this;
				}else{
					madre = this;
				}
				
				boolean sexo=false;
				
				if(this.nivelEnergetico()>r.nivelEnergetico()){
					sexo=this.getSexo();
				}else if(this.nivelEnergetico()<r.nivelEnergetico()){
					sexo=r.getSexo();
				}else if(this.nivelEnergetico()==r.nivelEnergetico()){
					sexo=false;
				}
			
				RauC devolucion = new RauC(sexo,padre.getEnergia().length,madre.getParejas().length);
				
				for (int i = 0; i < devolucion.getEnergia().length; i++) {
					devolucion.come(i, madre.getEnergia()[i]);
					madre.setEnergia(i, 0);
				}
				
				//hago el return dentro 
				return devolucion;
				
			
			}
		//No tienen el mismo sexo	
		}else{
			throw new IncompatiblesException(sexo_error);
		}
				
		
		return null;
	}

	
	
	//done
	public int interacciona(int i) {
		int devolucion=0;
		int posicion=0;
		
		if(i>=0){
			posicion=i/this.getEnergia().length;
			if(posicion<this.getEnergia().length){
				devolucion=this.getEnergia()[posicion];
				devolucion=devolucion-(2*devolucion);
				this.setEnergia(posicion, 0);
			}
			
		}
		
		return devolucion;
	}

	
	
	//done
	public String[] getParejas(){
		return parejas;
	}
}
