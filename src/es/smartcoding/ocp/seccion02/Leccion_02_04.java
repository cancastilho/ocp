/**
 * 
 */
package es.smartcoding.ocp.seccion02;

/**
 * @author pep
 * 
 *         Principios de diseño.
 * 
 *         Un principio de diseño es una idea preestablecida o practica
 *         recomendada que facilita el proceso de diseño de software.
 * 
 *         En general es recomendable seguir unos buenos principio de diseño
 *         porque:
 * 
 *         1. Se produce código más lógico.
 * 
 *         2. Se produce código que es más fácil de entender.
 * 
 *         3. Se facilita el reuso de clases.
 * 
 *         4. El código es más fácil de mantener y de adaptar a cambios en los
 *         requerimientos de las aplicaciones.
 * 
 *         La encapsulación es uno de los principios básicos de diseño. De hecho
 *         es tan relevante que existe un standard llamado JavaBeans.
 * 
 *         Un JavaBean es un principio de diseño para encapsular datos en Java
 *         que sigue unas normas sencillas:
 * 
 *         1. Las propiedades tienen que ser privadas.
 * 
 *         2. Los métodos de lectura deben empiezar por get o is si el método retorna
 *         un valor lógico.
 * 
 *         3. Los métodos de escritura deben empiezar por set.
 * 
 *         4. Después de set/is/get escribiremos el nombre de la propiedad
 *         empezando con una mayúscula.
 * 
 *         La relación es-un expresa una relación de herencia.
 * 
 *         La relación tiene-un expresa una relación de composición.
 * 
 */

enum Tamaño {
	PEQUEÑO, MEDIANO, GRANDE
}

class Aspecto {
	private String color;
	private double peso;
	private Tamaño tamaño;
	
	// ...
}

class Mascota {
	/*
	 * Propiedades privadas
	 */
	private String nombre;
	private boolean exotico;
	/*
	 * Relacion tiene-un. Has-a
	 */
	private Aspecto aspecto;

	/*
	 * No hay constructor por defecto
	 */
	public Mascota(String nombre, boolean exotico, Aspecto aspecto) {
		super();
		this.nombre = nombre;
		this.exotico = exotico;
		this.aspecto = aspecto;
	}

	/*
	 * Métodos accesores
	 */
	public String getNombre() {
		return nombre;
	}

	/*
	 * El cambio de nombre de una mascota sigue unas normas.
	 * Cualquier nombre no es válido. 
	 * 
	 * Si la propiedad nombre fuera public se podría poner un nomber arbitrario.
	 */
	public void setNombre(String nombre) {
		if (nombre == null || nombre.length() < 5) {
			throw new IllegalArgumentException("Nombre nulo o demasiado corto");
		}
		this.nombre = nombre;
	}

	public boolean isExotico() {
		return exotico;
	}

	public void setExotico(boolean exotico) {
		this.exotico = exotico;
	}

	@Override
	public String toString() {
		return "AnimalDomestico [nombre=" + nombre + ", exotico=" + (exotico ? "Sí" : "No") + "]";
	}

}

public class Leccion_02_04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mascota mascota = new Mascota("El gato con botas", false, null);
		// mascota.setNombre(null);
		System.out.println(mascota);
	}

}
