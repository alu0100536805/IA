
public class Celda {

	private String color;
	
	private int tipoactual;
	private int tiposiguiente;
	//private int[] tipocelda = {0,1,2,3};
	
	public void setcelda(int valor){
		this.tipoactual = valor;
	}
	
	public void setceldassiguiente(int valor){
		this.tiposiguiente = valor;
	}
	
	public int getcelda(){
		return tipoactual;
	}
	
	public int getceldassiguiente(){
		return tiposiguiente;
	}
	
	public Celda(int valorinicial){
		setcelda(valorinicial);		
	}
	
}
