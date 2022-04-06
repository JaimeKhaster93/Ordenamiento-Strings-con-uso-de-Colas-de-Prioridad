//JAIME MALDONADO GARCÍA
package mini_p;

public class main {
	
	public static void main(String args[]) {
		
		cola name = new cola();
		//			(Nombre , Edad)
		
		
		String nombre = "Jaime";
		String apellido = "Khaster";
		String cadena = nombre + " " +apellido;
		
		name.agregar(cadena);
		name.agregar("Paulette, 27");
		name.agregar("Vania, 19");
		name.agregar("Mikasa, 22");
	    name.agregar("Alfonso, 24");
	    name.agregar("Alan, 22");
	    name.agregar("Andrea, 24");
		name.agregar("Alan, 23");
		
		name.mostrar();
		
	}
	
	

}
