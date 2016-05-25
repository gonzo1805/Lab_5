package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

public interface Conjunto<T> {

	/**
	 * 
	 * @return
	 */
	Conjunto<T> union();
	
	/**
	 * 
	 * @return
	 */
	Conjunto<T> intersection();
	
	/**
	 * 
	 * @return
	 */
	Conjunto<T> difference();
	
	/**
	 * 
	 * @return
	 */
	Conjunto<T> contains();
	
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
	boolean Equals(Conjunto<T> dato);
}
