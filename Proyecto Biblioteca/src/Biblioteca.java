/**
 * 
 * @author ap
 * * Adelina Trejo 168135
	 * Clase que tiene como atributo una lista arreglo desordenada
	 * de Materiales 07/12/16
 */
public class Biblioteca {

	private String nombre;
	private String direccion;
	private int telefono;
	private ListaArregloDesordenada <Material> materiales;
	
	public Biblioteca() {
		materiales=new ListaArregloDesordenada <Material> (100);
	}

	public Biblioteca(String nombre, String direccion, int telefono) {
		this();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biblioteca other = (Biblioteca) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public int compareTo(Biblioteca otra){
		return nombre.compareTo(otra.getNombre());
	}
	
	public String toString(){
		StringBuilder sb;
		sb= new StringBuilder();
		sb.append("Biblioteca \n");
		sb.append("   Nombre: "+nombre+"\n");
		sb.append("   Direccion: "+direccion+"\n");
		sb.append("   Telefono: "+telefono+"\n");
		sb.append(    materiales.toString());
		return sb.toString();
	}
	
	/**
	 * Funcion para dar de alta un material en la Biblioteca
	 * @param tipo indica el tipo de material que se quiere dara de alta
	 * @param titulo indica el titulo del material
	 * @param autor indica el autor del material
	 * @param indica el anio en que fue publicado el material
	 * @param editorial indica la casa editora del material
	 * @param clasificaicon indica de que clase es el objeto
	 * @param indica el estante en que sta ubicado el material
	 * @param restriccionPrestamo indica esta restringido de prestamos
	 * @return contesta verdadero si el alta fue exitoso y falso si no fue exitoso
	 */
	public boolean altaMaterial(String tipo, String titulo, String autor, int anioPublicacion, 
	String editorial, String clasificacion,char estante,boolean restriccionPrestamo){
		boolean resp;
		Material nuevo;
		nuevo=new Material(tipo,titulo,autor,anioPublicacion,
		editorial,clasificacion,estante,restriccionPrestamo);		
		resp=materiales.add(nuevo);
		return resp;
	}
	
	/**
	 * Funcion para dar de baja un material en la Biblioteca
	 * @param unaClave indica la clave del material que se quiere dar de baja
	 * @return contesta con un texto en panatalla diciendo si la baja fue exitosa o no
	 */
	public String bajaMaterial(int unaClave){
		int i, ocupados;
		Material uno;
		String info;
		ocupados= materiales.getOcupados();
		i=0;
		while (i<ocupados && unaClave!=materiales.getElement(i).getClave())
			i++;
		if(i<ocupados){
			uno= materiales.getElement(i);
			uno=materiales.remove(uno);
			if(uno!=null)
				info=("SE ELIMINO CORRECTAMENTE: \n"+uno.toString());
			else
				info= "BAJA NO EXITOSA, EL MATERIAL NO EXISTE";
		}
		else
			info= "NO EXISTE";
		return info;	
	}
	
	/**
	 * Funcion para contar cuantos materiales de una clacificacion especifica existen en la biblioteca
	 * @param clasificacion indica la clasificacion de la cual se quiere saber los materiales existentes en la biblioteca
	 * @return indica la cantidad de materiales que hay de la clasificacion solicitada
	 */
	public int cuantosXClasificacion(String clasificacion){
		int cuantos, i , ocupados;
		cuantos=0;
		ocupados= materiales.getOcupados();
		for(i=0;i<ocupados;i++)
			if(materiales.getElement(i).getClasificacion().equals(clasificacion))
				cuantos++;
		return cuantos;
	}
	
	/**
	 * Funcion para contar cuantos materiales de un ejemplar especifico existen en la biblioteca
	 * @param titulo indica el titulo del ejemplar del cual se quiere saber los materiales existentes en la biblioteca
	 * @return indica la cantidad de materiales que hay del ejemplar solicitado
	 */
	public int cuantosXEjemplar(String titulo){
		int cuantos, i , ocupados;
		cuantos=0;
		ocupados= materiales.getOcupados();
		for(i=0;i<ocupados;i++)
			if(materiales.getElement(i).getTitulo().equals(titulo))
				cuantos++;
		return cuantos;
	}
	
	/**
	 * Funcion para contar cuantos materiales de un tipo especifico existen en la biblioteca
	 * @param tipo indica el tipo del ejemplar del cual se quiere saber los materiales existentes en la biblioteca
	 * @return indica la cantidad de materiales que hay del tipo solicitado
	 */
	public int cuantosXTipo(String tipo){
		int cuantos, i , ocupados;
		cuantos=0;
		ocupados= materiales.getOcupados();
		for(i=0;i<ocupados;i++)
			if(materiales.getElement(i).getTipo().equals(tipo))
				cuantos++;
		return cuantos;
	}
	
	/**
	 * Funcion para ver la clave de los materiales disponibles de un ejemplar especifico
	 * @param titulo indica el titulo del ejemplar del cual se quiere saber cuantos materiales disponibles hay
	 * @return indica la cantidad de materiales disponibles del ejemplar solicitado
	 */
	public String verClaveDDisponiblesXEjemplar(String titulo){
		int aux, ocupados, i;
		String info;
		info= "";
		aux= cuantosXEjemplar(titulo);
		ocupados= materiales.getOcupados();
		if(aux!=0){		
			for(i=0;i<ocupados; i++){
				if(materiales.getElement(i).getTitulo().equals(titulo) &&
				   materiales.getElement(i).getStatus()==true && 
				   materiales.getElement(i).getRestriccionPrestamo()==false)
						info= info+"Clave de Ejemplar Disponible: "
				              +materiales.getElement(i).getClave()+"\n";
			}
		if(info=="")
			info= "No hay ejemplares disponibles";
		}
		else
			info= "No hay ejemplares disponibles";		
		return info;
	}
	
	/**
	 * Funcion para realizar la busqueda de un Material dada su clave
	 * @param clave indica la clave del material que se desea buscar
	 * @return muestra los datos del material buscado si este se encuentra registrado
	 */
	public String mostrarDatosDMaterial (int clave){
		String resp;
		int i, ocupados;
		i=0;
		ocupados= materiales.getOcupados();
		while(i<ocupados && materiales.getElement(i).getClave()!=clave)
			i++;
		if(i>=ocupados)
			resp= "Material no encontrado";
		else
			resp= materiales.getElement(i).toString();
		return resp;	
	}

	/**
	 * Funcion para realizar el prestamo de un material
	 * @param clave indica la clave del material que se desea prestar
	 * @return muestra mensaje en pantalla si el prestamo se realizo con exito
	 */
	public String prestarMaterial(int clave){
		int i, ocupados;
		String resp;
		i=0;
		ocupados= materiales.getOcupados();
		while(i<ocupados && materiales.getElement(i).getClave()!=clave)
			i++;
		if(i>=ocupados)
			resp= "Material no encontrado";
		else{
			if(materiales.getElement(i).getStatus()==true && 
			   materiales.getElement(i).getRestriccionPrestamo()==false){
				resp= "Prestamo exitoso: "+materiales.getElement(i).toString();	
				materiales.getElement(i).setStatus(false);
			}
			else
				resp= "Material no disponible";	
		}
		return resp;
	}
	
	/**
	 * Funcion para generar multa por retraso en la devolucion de un material
	 * @param diasRetraso indica los dias de retraso en la devolucion del material
	 * @return valor de la multa generada 
	 */
	public double generarMulta(int diasRetraso){
		double multa;
		multa= 20;
		if(diasRetraso<1)
			multa= 0;
		else
			multa= diasRetraso*multa;
		return multa;	
	}	
	
	/**
	 * Funcion para realizar la devolcion de un material
	 * @param clave indica la clave del material que se va a devolver
	 * @param diasRetraso indica los dias de retraso en la devolucion del material
	 * @return muestra mensaje en pantalla si la devolucion se realizo con exito
	 */
	public String devolverMaterial(int clave, int diasRetraso){
		int i, ocupados;
		String resp;
		double multa;
		multa= generarMulta(diasRetraso);
		ocupados= materiales.getOcupados();
		i=0;
		while(i<ocupados && materiales.getElement(i).getClave()!= clave)
			i++;
		if(i>=ocupados || materiales.getElement(i).getRestriccionPrestamo()==true ||  materiales.getElement(i).getStatus()==true)
			resp= "Devolucion NO exitosa";
		else
			if(diasRetraso>0){
				resp="Devolucion exitosa, acredora a una Multa de: $"+multa;
				materiales.getElement(i).setStatus(true);
			}
			else{
				resp= "Devolucion exitosa, libre de Multas";
				materiales.getElement(i).setStatus(true);
			}
		return resp;
	}
	
}
