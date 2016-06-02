package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public interface Conjunto<T> {

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	Conjunto<T> union(Conjunto<T> A, Conjunto<T> B);

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B);

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B);

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
	boolean Equals(Conjunto<T> A);

	boolean isEmpty();

	Iterator<T> iterador();

}
