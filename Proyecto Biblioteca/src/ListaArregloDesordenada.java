
public class ListaArregloDesordenada <T extends Comparable <T>>{
	/*
	 * Adelina Trejo Espinoza 168135
	 * Proyecto Final BIBLIOTECA CENTRAL
	 * Clase para el manejo general de arreglos
	 * del tipo T generico donde el orden NO importa
	 * 07/12/16
	 */
	private T datos[];
	private int ocupados;
	private int MAX=100;
	
	public ListaArregloDesordenada(){
		ocupados=0;
		datos= (T[]) new Comparable[MAX]; 
	}
	
	public ListaArregloDesordenada(int tamanio){
		ocupados=0;
		datos= (T[]) new Comparable[MAX];
		MAX=tamanio;
	}
	
	public int getOcupados() {
		return ocupados;
	}
	
	public int getMAX() {
		return MAX;
	}
	
	public T getElement(int pos){
		T aux;
		if(pos<MAX && pos>=0)
			aux=datos[pos];
		else
			aux=null;
		return aux;
	}
	
	public String toString(){
		StringBuilder sb;
		int i;
		sb= new StringBuilder();
		sb.append("Numero de elementos"+ ocupados+"\n");
		for(i=0; i<ocupados; i++)
			sb.append(datos[i].toString());
		return sb.toString();
	}
	
	public int buscaSec(T unDato){
		int pos,i;
		i=0;
		while(i<ocupados && !datos[i].equals(unDato))
			i++;
		if(i<ocupados)
			pos=i;
		else
			pos=-1;
		return pos;
	}
	
	public boolean contains(T unDato){
		int pos;
		boolean resp;
		pos=buscaSec(unDato);
		if(pos<0)
			resp=false;
		else
			resp=true;
		return resp;
	}
	
	public boolean add(T unDato){
		boolean resp;
		int pos;
		if(ocupados<MAX){
			pos=buscaSec(unDato);
			if(pos<0){
				datos[ocupados]=unDato;
				ocupados++;
				resp=true;
			}
			else
				resp=false;		
		}
		else
			resp=false;
		return resp;
	}
	
	public void recorreIzq(int pos){
		int i;
		for(i=pos;i<ocupados-1; i++)
			datos[i]=datos[i+1];
		datos[ocupados-1]=null;
	}
	
	public T remove(T unDato){
		int pos;
		T aux;
		pos=buscaSec(unDato);
		if(pos>=0){
			aux=datos[pos];
			recorreIzq(pos);
			ocupados--;
		}
		else
			aux=null;
		return aux;
	}
	
	public int indexOf(T unDato){
		return buscaSec(unDato);
	}
	
	public void clear(){
		ocupados=0;
		datos= (T[]) new Comparable[MAX];
	}

}
