
public class Compilador {

	public static void main(String[] args) {
		int i,j,k;
		i=1;
		j=2;
		k=3;
		int[] coordenada;
		coordenada= new int[3];
		double p=2.5;
		double p2= 4.5;
		double[] d;
		d=null;
		d=new double[4];
		d[0]=2.42;
		d[1]=5.44;
		double[] d2;
		d2=null;
		d2=new double[2];
		int[] coor;
		coor=new int[3];
		String agua = "Agua";
		int n=5;
		boolean res;
		String etiqueta;
		
		int[][][] espacio;
		espacio=null;
		espacio=new int [2][3][4];
	
		int[] dimension;
		dimension=null;
		dimension=new int[3];
		
		Coordenada c = new Coordenada(i,j,k);
		Coordenada c2 = new Coordenada(0,0,1);
		Mercancia m = new Mercancia(1000,d);
		Mercancia m2 = new Mercancia(p2,d2);
		Sector s = new Sector(1);
		Sector s2 = new Sector(n);
		Sector s3 = new Sector(3);
		Galaxia g = new Galaxia("Via lactea",10,10,10);
		s.situa(i, j, k);
		s2.situa(1, 2, 1);
		
		g.coloca(s);
		g.coloca(s2);
		
		s.almacena(m);
		s2.almacena(m2);
		
		Romskip.setMapa(g);
		Romskip r = new Romskip("Nave 1", 10, 100);
		Romskip r2=new Romskip("Nave 2",10,120);
		
		Skrogem sk = new Skrogem(1,d,2);
		Dophraki dh = new Dophraki("Dophraki 1", 4,10.1,2,3,4.1);
		
		r.setMapa(g);
		dh.setMapa();
		System.out.println(dh.getNombreMapa());
		
	}

}


