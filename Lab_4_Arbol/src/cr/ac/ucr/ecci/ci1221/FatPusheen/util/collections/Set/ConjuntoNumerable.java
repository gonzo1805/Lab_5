package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

public interface ConjuntoNumerable<T extends Enumerable> {

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	ConjuntoNumerable<T> union(BitsVectorSetImpl<T> A, BitsVectorSetImpl<T> B, BitsVectorSetImpl<T> C);

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	ConjuntoNumerable<T> intersection(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B, ConjuntoNumerable<T> C);

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	ConjuntoNumerable<T> difference(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B, ConjuntoNumerable<T> C);

	/**
	 * 
	 * @param dato
	 * @param A
	 * @return
	 */
	boolean contains(T dato, ConjuntoNumerable<T> A);
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	boolean contains(T dato);

	/**
	 * 
	 * @param A
	 */
	void clear(ConjuntoNumerable<T> A);

	/**
	 * 
	 * @param dato
	 * @param A
	 */
	void add(T dato, ConjuntoNumerable<T> A);

	/**
	 * 
	 * @param dato
	 * @param A
	 */
	void remove(T dato, ConjuntoNumerable<T> A);

	/**
	 * 
	 * @param A
	 * @return
	 */
	boolean Equals(ConjuntoNumerable<T> A);
}
