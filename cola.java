//JAIME MALDONADO GARCÍA
package mini_p;

public class cola {

	
	/*
	 * Condiciones:
	 * 1. Se agrega un valor
	 * 2. Por cada valor agregado
	 * 	  se debe comparar con los 
	 * 	  anteriores e irse acomodando
	 * 	  según su valor ASCII u otra
	 * 	  manera
	 * 3. Se debe eliminar en especifico
	 * 	  el dato
	 * 4. Si dos datos coinciden, su orden
	 * 	  de llegada será como se han ido
	 * 	  agregado
	 * 5. Al final debe mostrarse el orden
	 * 	  de los elementos
	 */
	
	nodo inicio;
	nodo fin;
	int size;
	
	public boolean vacio() {
		if(inicio == null && fin == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void agregar(String nombre) {
		
		nodo nuevo = new nodo();
		nuevo.setNombre(nombre);
		nuevo.setLiga(null);
		
		
		if(vacio()) {
			inicio = nuevo;
			fin = nuevo;
			size ++;
		}else {
			verificar(nombre, nuevo);
		}
				
	}
	
	

	public boolean verificar(String nombre, nodo nuevo) {
		

		nodo aux = inicio;
		nodo anterior = inicio;
		
		
		while(aux != null) {
			if(aux.getNombre().compareToIgnoreCase(nombre)>0) { //NOMBRE > AUX
				
				if(aux == inicio) {
					nuevo.setLiga(inicio);
					inicio = nuevo;
					return false;
				}else{
					nuevo.setLiga(aux);
					anterior.setLiga(nuevo);
					return false;
				}
				
			}else if(aux.getNombre().compareToIgnoreCase(nombre)<0) { //NOMBRE < AUX  || ERNESTO < JUAN
				
				if(aux == fin) {
					aux.setLiga(nuevo);
					fin = nuevo;	
					return true;
				}
				
				
			}
			anterior = aux;
			aux = aux.getLiga();
		}
		size++;
		return true;
		
	}
	
	public boolean buscar(String valor) {
		nodo aux = inicio;
			if(!vacio()) {	
				while(aux != null) {
								if(aux.getNombre() == valor) {
								System.out.println("Se encontro [" + aux.getNombre() + "]");
								return true;
								} 
								aux=aux.getLiga(); // toma una copia de la información
													// si no encuentra el valor
													// toma la referencia para moverse
				}
		}else {
			System.out.println("No hay nada que buscar, la cola esta vacia");	
		}
			return false;

	}
	
	
	public void eliminarEspecifico(String valor) {
		
		if(buscar(valor)) { //toma la forma de buscar o conviertelo en bool
			nodo aux=inicio;
			nodo anterior=inicio;
			
			while(aux!=null){
				if(aux.getNombre() == valor) {
					//tres posibles casos
					if(aux==inicio) {//primer elemento
						eliminar();
					}else if(aux==fin) {
						
						anterior.setLiga(null);
						fin=anterior;
						
					}else {
						anterior.setLiga(aux.getLiga());
					}
				}
				anterior=aux;
				aux=aux.getLiga();
				
			}
			
		}else {
			System.out.println("No existe el valor");
		}
		
	}
	
	public String eliminar() {
		
		if(!vacio()) {
			//eliminar
			//para eliminar necesitamos el inicio
			//pero hay que ver que no sea un único valor como el primero
			String valor = inicio.getNombre();//guardamos el valor a eliminar
			if(inicio == fin) {
				inicio = null;
				fin=null; //vaciamos la cola esta sola
			}else {
				System.out.println("Se elimino: [" + valor + "]");
				inicio=inicio.getLiga();
			}
			size--;
			return valor;
			
		}else {
			System.out.println("No se puede eliminar está vacia");
			return ("Es nulo");
		}
		
	}

	
	public void mostrar() {
		
		nodo aux = inicio;
		System.out.println("Cola para una beca unu: ");
			while(aux != null) {
				System.out.println("[" + aux.getNombre() + "]");
				aux=aux.getLiga();
			}
			System.out.println("\n");
	}

	
}

