//DNI 20084606 Rubio Martinez, Ruben

public class Coordenada {
	private int i;
	private int j;
	private int k;
	
	public Coordenada(int i, int j, int k){
		this.i=i;
		this.j=j;
		this.k=k;
		
	}
	
	public int[] getCoordenadas(){
		int[] coordenadas;
		coordenadas=null;
		coordenadas = new int[3];
		
		coordenadas[0]=i;
		coordenadas[1]=j;
		coordenadas[2]=k;
		
	

		return coordenadas;
	}
}