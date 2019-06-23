//DNI 20084606 Rubio Martinez, Ruben


public class IncompatiblesException extends Exception {
	
	//todo
	public IncompatiblesException(String n){
		super(n);
	}
	
	
	
	//todo
	public IncompatiblesException(String n, String m){
		super(n+"-"+m);
	}
}
