package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterable;

public interface ConjuntoNumerable<T extends Enumerable<T>> extends Iterable<T> {

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	ConjuntoNumerable<T> union(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B);

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	ConjuntoNumerable<T> intersection(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B);

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	ConjuntoNumerable<T> difference(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B);

	/**
	 * 
	 * @param dato
	 * @param A
	 * @return
	 */
	boolean contains(T dato);

	/**
	 * 
	 * @param A
	 */
	void clear();

	/**
	 * 
	 * @param dato
	 * @param A
	 */
	void add(T dato);

	/**
	 * 
	 * @param dato
	 * @param A
	 */
	void remove(T dato);

	/**
	 * 
	 * @param A
	 * @return
	 */
	boolean Equals(ConjuntoNumerable<T> A);
	
	/**
	 * 
	 * @return
	 */
	boolean isEmpty();

	
}
