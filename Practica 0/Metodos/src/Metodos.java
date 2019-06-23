//DNI 20084606 Rubio Martinez, Ruben
public class Metodos {
	
	public static int []divisores(int i){

		int []vEnteros;
		int k = 0;
		int aux;
		int contador;
		vEnteros = null;
		vEnteros = new int [i];
		contador=0;
		//Ciclo para calcular sus divisores
		for (int j=1;j<=i;j++){
			if(i%j==0){
				vEnteros[k]=j;
			}
			
			k++;
		}
		//Ciclo para ordenar el vector
		k=0;
		for(int j=0;j<vEnteros.length-1;j++){
			for(k=j+1;k<vEnteros.length;k++){
				if(vEnteros[j]<vEnteros[k]){
					aux=vEnteros[j];
					vEnteros[j]=vEnteros[k];
					vEnteros[k]=aux;
				}
			}
		}
			//Calcular tamano del nuevo array
			for (int j2 = 0; j2 < vEnteros.length; j2++) {
				if(vEnteros[j2]!=0){
					contador++;
				}
			}
			
			//Redimensionar array
			int []tmp=new int[contador];
			
			for (int j = 0; j < contador; j++) {
				if(vEnteros[j]!=0){
					tmp[j]=vEnteros[j];
				}
			}
			
		    
			vEnteros=tmp;
			
		
		return vEnteros;
	}
	
	public static char []impares(String s1){
		char []vChar;
		int j=0;
		int contador = 0;
		vChar = null;
		vChar = new char[s1.length()];
		vChar = s1.toCharArray();
		
		char []vAux;
		vAux = null;
		vAux = new char[s1.length()];
		
		
		for (int i = 0; i < vChar.length; i++) {
			if(i%2!=0){
				vAux[j]=vChar[i];
			}
			j++;
		}
		//Contador
		for (int i = 0; i < vAux.length; i++) {
			if(vAux[i]!='\u0000'){
				contador++;
			}
		}
		char[] vChar2;
		vChar2 = null;
		vChar2 = new char[contador];
		j=0;
		for (int i = 0; i < vAux.length; i++) {
			if(vAux[i]!='\u0000'){
				vChar2[j]=vAux[i];
				j++;
			}
		}
		
		
		return vChar2;
	}
	
	public static int []primos(int i){
		int []vEnteros;
		int k,j,l,aux,contador;
		int tam=i;
		if(i<0){
			tam=i*(-1);
		}
		boolean no_primos = false;
		vEnteros = null;
		vEnteros = new int[tam];
		contador=0;
		
		l=0;
		//Modulo para calcular los numeros primos
		if(i>0){
			for (j = 2; j <= i; j++) {
				for(k = 2; k < j; k++){
					if(j%k==0){
						no_primos=true;
					}
				}
				k = 2;
				if(no_primos==false){
					vEnteros[l]=j;
				}
				l++;
				no_primos=false;
			}
		}else{
			for (j = -2; j >= i; j--) {
				for(k = -2; k > j; k--){
					if(j%k==0){
						no_primos=true;
					}
				}
				k = -2;
				if(no_primos==false){
					vEnteros[l]=j;
				}
				l++;
				no_primos=false;
			}	
		}
		//Modulo para ordenar el vector
		k=0;
		
		for(j=0;j<vEnteros.length-1;j++){
			for(k=j+1;k<vEnteros.length;k++){
				if(vEnteros[j]<vEnteros[k]){
					aux=vEnteros[j];
					vEnteros[j]=vEnteros[k];
					vEnteros[k]=aux;
				}
			}
		}
		
		//Calcular tamano del nuevo array
		for (int j2 = 0; j2 < vEnteros.length; j2++) {
			if(vEnteros[j2]!=0){
				contador++;
			}
		}
		
		//Redimensionar array
		int []tmp=new int[contador];
		
		for (int j3 = 0; j3 < contador; j3++) {
			if(vEnteros[j3]!=0){
				tmp[j3]=vEnteros[j3];
			}
		}
		
	    
		vEnteros=tmp;
		
		//Modulo para ordenar el vector
				k=0;
				
				for(j=0;j<vEnteros.length-1;j++){
					for(k=j+1;k<vEnteros.length;k++){
						if(vEnteros[j]>vEnteros[k]){
							aux=vEnteros[j];
							vEnteros[j]=vEnteros[k];
							vEnteros[k]=aux;
						}
					}
				}
		return vEnteros;
		
	}
	
	public static boolean opuesta(int [][]a,int [][]b){
		boolean respuesta = true;
		
		if(a.length==b.length && a[0].length==b[0].length){
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if(a[i][j]!=-b[i][j]){
						respuesta = false;
					}
				}
			}
		}else{
			respuesta = false;
		}
		
		return respuesta;
	}
	
	public static String []fechada(int i,int j,String s){
		int dia = 0;
		String lunes = "lunes";
		String martes = "martes";
		String miercoles = "miercoles";
		String jueves = "jueves";
		String viernes = "viernes";
		String sabado = "sabado";
		String domingo = "domingo";
		String []res;
		res = null;
		res = new String[2];
		
		//Cambio de dia de string a entero para mayor comodidad
		if(s.compareToIgnoreCase(lunes)==0){
			dia=1;
		}
		if(s.compareToIgnoreCase(martes)==0){
			dia=2;
		}
		if(s.compareToIgnoreCase(miercoles)==0){
			dia=3;
		}
		if(s.compareToIgnoreCase(jueves)==0){
			dia=4;
		}
		if(s.compareToIgnoreCase(viernes)==0){
			dia=5;
		}
		if(s.compareToIgnoreCase(sabado)==0){
			dia=6;
		}
		if(s.compareToIgnoreCase(domingo)==0){
			dia=7;
		}
		
		dia=(dia+7+i)-1;
		
		if((j==1 || j==3 || j==5 || j==7 ||j ==8 || j==10 || j==12) && i<=31){
			if(j==1){
				res[1]="enero";
			}
			if(j==3){
				res[1]="marzo";
			}
			if(j==5){
				res[1]="mayo";
			}
			if(j==7){
				res[1]="julio";
			}
			if(j==8){
				res[1]="agosto";
			}
			if(j==10){
				res[1]="octubre";
			}
			if(j==12){
				res[1]="diciembre";
			}
		}else if ((j==4 || j==6 || j==9 || j==11) && i<=30){
			if(j==4){
				res[1]="abril";
			}
			if(j==6){
				res[1]="junio";
			}
			if(j==9){
				res[1]="septiembre";
			}
			if(j==11){
				res[1]="noviembre";
			}
		}else if (j==2 && i<=28){
			
		}else{
			res[1]=null;
		}
		
		if(dia%7==1){
			res[0]=lunes;
		}
		if(dia%7==2){
			res[0]=martes;
		}
		if(dia%7==3){
			res[0]=miercoles;
		}
		if(dia%7==4){
			res[0]=jueves;
		}
		if(dia%7==5){
			res[0]=viernes;
		}
		if(dia%7==6){
			res[0]=sabado;
		}
		if(dia%7==0){
			res[0]=domingo;
		}
		
		return res;
	}
	
	public static String []extrae(String s){
		int contador = 0;
		String comparador = new String ("");
		String []noNum;
		noNum = null;
		noNum = new String [s.length()];
		noNum = s.split(";");
		
		//Ciclo para poner en cadena vacia las cadenas que contienen numeros
		for (int i = 0; i < noNum.length; i++) {
			if(noNum[i].contains("1") || noNum[i].contains("2") || noNum[i].contains("3") || noNum[i].contains("4") || noNum[i].contains("5") ||
			   noNum[i].contains("6") || noNum[i].contains("7") || noNum[i].contains("8") || noNum[i].contains("9")){
				
				noNum[i]="";
			}
		}
		//Ciclo para contar el numero de cadenas no vacias
		for (int i = 0; i < noNum.length; i++) {
			if(noNum[i].compareTo(comparador)!=0){
				contador++;
			}
		}
		
		//Ordenar el array
		int i,j,k;
		String aux;
		
		k=0;
		while(k<noNum.length-1){
			i=k;
			j=k+1;
			while(j<noNum.length){
				if(noNum[j].compareTo(noNum[i])>0){
					i=j;					
				}
				j=j+1;
			}
			aux=noNum[k];
			noNum[k]=noNum[i];
			noNum[i]=aux;
			k=k+1;
		}
		
		//Redimensionar el array
		String []tmp=new String[contador];
		
		for (j = 0; j < contador; j++) {
				tmp[j]=noNum[j];
			}
		noNum=tmp;
		
		//Volver a ordenar el array
		
		k=0;
		while(k<noNum.length-1){
			i=k;
			j=k+1;
			while(j<noNum.length){
				if(noNum[j].compareTo(noNum[i])<0){
					i=j;					
				}
				j=j+1;
			}
			aux=noNum[k];
			noNum[k]=noNum[i];
			noNum[i]=aux;
			k=k+1;
		}
		
		return noNum;
	}
	
	public static char []hexadecimal(int i){
		char []hexa;
		int dig = 0;
		int aux = i;
		while(aux>0){
			aux=aux/10;
			dig++;
		}
		hexa = null;
		hexa = new char [dig];
		
		//Ciclo para pasar de decimal a hexadecimal
		for (int j = 1; j <= hexa.length; j++) {
		
				if(i%16==0){
					hexa[dig-j]='0';
				}
				if(i%16==1){
					hexa[dig-j]='1';
				}
				if(i%16==2){
					hexa[dig-j]='2';
				}
				if(i%16==3){
					hexa[dig-j]='3';
				}
				if(i%16==4){
					hexa[dig-j]='4';
				}
				if(i%16==5){
					hexa[dig-j]='5';
				}
				if(i%16==6){
					hexa[dig-j]='6';
				}
				if(i%16==7){
					hexa[dig-j]='7';
				}
				if(i%16==8){
					hexa[dig-j]='8';
				}
				if(i%16==9){
					hexa[dig-j]='9';
				}
				if(i%16==10){
					hexa[dig-j]='a';
				}
				if(i%16==11){
					hexa[dig-j]='b';
				}
				if(i%16==12){
					hexa[dig-j]='c';
				}
				if(i%16==13){
					hexa[dig-j]='d';
				}
				if(i%16==14){
					hexa[dig-j]='e';
				}
				if(i%16==15){
					hexa[dig-j]='f';
				}
				i=i/16;
		}
		
		//Ciclo para calcular el numero de digitos sin 0 a la izquierda para poder redimensionar
		int dig2 = 0;
		for (int k = 0; k < hexa.length; k++) {
			if(hexa[k]=='0'){
				dig2++;
			}else{
				k=hexa.length;
			}
		}
	
		//Redimension del Array
		char []auxiliar;
		auxiliar=null;
		auxiliar=new char[dig-dig2];
		
		for (int k = 1; k <= auxiliar.length; k++) {
			auxiliar[auxiliar.length-k]=hexa[hexa.length-k];
		}
		hexa=auxiliar;
		
		return hexa;
	}
	
	public static int []ordena(double []v){
		
		int []enteros;
		enteros=null;
		enteros=new int[v.length];
		
		//Transformacion del array de double a int
		for (int i = 0; i < enteros.length; i++) {
			enteros[i]=(int) v[i];
		}
		//Ordenacion del array de menor a mayor
		int aux;
		int k=0;
		for(int j=0;j<enteros.length-1;j++){
			for(k=j+1;k<enteros.length;k++){
				if(enteros[j]>enteros[k]){
					aux=enteros[j];
					enteros[j]=enteros[k];
					enteros[k]=aux;
				}
			}
		}
		return enteros;		
		
	}
	
	public static int suma(int n){
		int []vEnteros;
		int k,j,l,i,contador,suma;
		int fin = 100000;
		boolean no_primos = false;
		vEnteros = null;
		vEnteros = new int[1000];
		contador=0;
		
		l=0;
		//Modulo para calcular los "n" numeros primos
		
		for (j = 2; j <= fin; j++) {
			
			for(k = 2; k < j; k++){
				if(j%k==0){
					no_primos=true;
				}
			}
			if(contador<n){
				k = 2;
				if(no_primos==false){
					vEnteros[l]=j;
					contador++;
				}
				l++;
				no_primos=false;
			}else{
				j=fin;
			}
		}
		contador=0;
		
		//Calcular tamano del array
		for (i = 0; i < vEnteros.length; i++) {
			if(vEnteros[i]!=0){
				contador++;
			}
		}
		k=0;
		//Redimensionar array
		int []tmp=new int[contador];
		
		for (j = 0; j < vEnteros.length; j++) {
			if(vEnteros[j]!=0){
				tmp[k]=vEnteros[j];
				k++;
			}
		}
		vEnteros=tmp;
		
		//Suma de todo
		suma=0;
		for (int m = 0; m < vEnteros.length; m++) {
			suma=suma+vEnteros[m];
		}
		
		return suma;
		
	}

	public static double euclidea(int []x,int []y){
		double euclidea = 0;
		double resx = 0; 
		double resy = 0;
		double resz = 0;
		double elevadox = 0;
		double elevadoy = 0;
		double elevadoz = 0;
		
		if(x.length==y.length){
			if(x.length==1){
				resx=y[0]-x[0];
				elevadox=Math.pow(resx, 2);
				euclidea=Math.sqrt(elevadox);
			}
			if(x.length==2){
				resx=y[0]-x[0];
				resy=y[1]-x[1];
				elevadox=Math.pow(resx, 2);
				elevadoy=Math.pow(resy, 2);
				euclidea=Math.sqrt(resx-resy);
			}
			if(x.length==3){
				resx=y[0]-x[0];
				resy=y[1]-x[1];
				resz=y[2]-x[2];
				elevadox=Math.pow(resx, 2);
				elevadoy=Math.pow(resy, 2);
				elevadoz=Math.pow(resz, 2);
				euclidea=Math.sqrt(resx-resy-resz);
			}
		}else{
			euclidea=-1;
		}
		return euclidea;
	}
}
