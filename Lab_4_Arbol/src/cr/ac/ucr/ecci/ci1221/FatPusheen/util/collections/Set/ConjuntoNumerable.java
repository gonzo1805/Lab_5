package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

public interface ConjuntoNumerable<T extends Enumerable> {

	/**
	 * 
	 * @return
	 */
	ConjuntoNumerable<T> union();
	
	/**
	 * 
	 * @return
	 */
	ConjuntoNumerable<T> intersection();
	
	/**
	 * 
	 * @return
	 */
	ConjuntoNumerable<T> difference();
	
	/**
	 * 
	 * @return
	 */
	ConjuntoNumerable<T> contains();
	
	/**
	 * 
	 */
	void clear();
	
	/**
	 * 
	 * @param dato
	 */
	void add(T dato);
	
	/**
	 * 
	 * @param dato
	 */
	void remove(T dato);
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	boolean Equals(ConjuntoNumerable<T> dato);
}
