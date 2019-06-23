//DNI 20084606 Rubio Martinez, Ruben


public abstract class Rau {
	private boolean sexo;
	private int[] energia;
	//true = hembra       false = macho
	
	//constructor
	public Rau(boolean b,int i){
		sexo=b;
		
		if(i>0){
			energia = new int[i];
		}else{
			energia = new int[9];
		}
	}
	
	
	//done
	public boolean come(int i, int j){
		boolean devolucion = false;
		//la i es la posicion del array
		
		if(i>=0 && i<energia.length){
			if(j>0){
				energia[i]=energia[i] + j;
				devolucion=true;
			}
		}
		
		return devolucion;
	}
	
	//done
	public abstract Rau reproduce();
	
	
	
	//done
	public abstract Rau reproduce(Rau r,String n) throws IncompatiblesException;
	
	
	
	//done
	public abstract int interacciona(int i);
	
	
	
	//done
	public int nivelEnergetico(){
		int devolucion=0;
		
		for (int i = 0; i < energia.length; i++) {
			devolucion=devolucion+energia[i];
		}
		
		return devolucion;
	}
	
	
	
	//done
	public boolean getSexo(){
		return sexo;
	}
	
	
	
	//done
	public int[] getEnergia(){
		return energia;
	}
	
	
	
	public void setEnergia(int pos, int valor){
		energia[pos]=valor;
	}
}
