/**
 * 
 */
package es.smartcoding.ocp.seccion03;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pep
 * 
 *         Genéricos y Colecciones
 * 
 *         Comparator vs Comparable
 * 
 *         Así como los números tienen un orden natural y las cadenas se ordenan en función de su código UNICODE, las
 *         clases también pueden ordenarse.
 * 
 *         La interfaz Comparable porporciona el orden natural de una clase. Cuando queremos ordenar un conjunto de
 *         objetos por algún otro campo, utilizamos la interfaz Comparator.
 * 
 *         Si tus clases implementan Comparable, debes observar cierta coherencia entre el método compareTo() y el
 *         método equals(). Cuando compareTo() retorna 0 el método equals debería retornar true porque no todas las
 *         clases funcionan de forma precedible si no se da esta condición.
 * 
 *         Aunque ambas interfaces son funcionales no tiene sentido utilizar lambdas para implementar la interfaz
 *         Comparable porque esta interfaz esta pensada para ser implementada dentro de la propia clase. En cambio, sí
 *         que tiene sentido implementar la interfaz Comparator con una expresión lambda.
 * 
 *         Hay algunas diferencias entre ambas interfaces:
 * 
 *         Diferencia Comparable Comparator
 * 
 *         Paquete java.lang java.util
 * 
 *         Implementación en la propia clase Sí No
 * 
 *         Nombre del método compareTo compare
 * 
 *         Número de parámetros 1 2
 * 
 *         Recomendado usar expresiones lambda No Sí
 * 
 *         Recuerda que los números vienen antes, a continuación las letras mayúsculas y después las letras minúsculas.
 * 
 */

/*
 * Este comparador compara por un campo: altura
 */
class HobbitAlturaComparator implements java.util.Comparator<Hobbit> {

    @Override
    public int compare(Hobbit hobbit1, Hobbit hobbit2) {
	return hobbit1.altura - hobbit2.altura;
    }

}

/*
 * Este Comparator compara por dos campos: altura y peso
 */
class HobbitAlturaPesoComparator implements java.util.Comparator<Hobbit> {

    @Override
    public int compare(Hobbit hobbit1, Hobbit hobbit2) {
	Comparator<Hobbit> c = Comparator.comparingInt(s -> s.altura);
	c = c.thenComparingDouble(s -> s.peso);
	return c.compare(hobbit1, hobbit2);
    }

}

class Hobbit implements java.lang.Comparable<Hobbit> {

    String nombre;
    int altura;
    double peso;

    public Hobbit(String nombre, int altura, double peso) {
	this.nombre = nombre;
	this.altura = altura;
	this.peso = peso;
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
	Hobbit other = (Hobbit) obj;
	if (nombre == null) {
	    if (other.nombre != null)
		return false;
	} else if (!nombre.equals(other.nombre))
	    return false;
	return true;
    }

    @Override
    public int compareTo(Hobbit hobbit) {
	return nombre.compareTo(hobbit.nombre);
    }

    @Override
    public String toString() {
	return String.format("Hobbit [nombre=%s, altura=%s, peso=%s]", nombre, altura, peso);
    }

}

public class Leccion_03_04 {
    /**
     * @param args
     */
    public static void main(String[] args) {

	Comparator<Hobbit> alturaComparator = (h1, h2) -> h1.altura - h2.altura;

	List<Hobbit> hobbits = new LinkedList<>();
	// List<Hobbit> hobbits = new ArrayList<>(); // No ordenada
	hobbits.add(new Hobbit("Tom", 120, 109.90));
	hobbits.add(new Hobbit("Heiss", 115, 89.78));
	hobbits.add(new Hobbit("Timy", 120, 101.12));
	hobbits.add(new Hobbit("Tomy", 122, 123.22));
	hobbits.add(new Hobbit("Jossu", 127, 140.23));
	for (Hobbit hobbit : hobbits) {
	    System.out.println(hobbit);
	}
	System.out.println("================");
	// Collections.sort(hobbits, alturaComparator);
	Collections.sort(hobbits, new HobbitAlturaPesoComparator());
	for (Hobbit hobbit : hobbits) {
	    System.out.println(hobbit);
	}
    }

}







