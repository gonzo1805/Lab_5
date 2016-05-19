package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public interface Tree<T> {
	
	/**
	 * Dice si el arbol esta vacio
	 * @return un boolean que denota si el arbol esta vacio
	 */
	boolean isEmpty();
	
	/**
	 * Retorna la raiz del arbol	
	 * @return la raiz del arbol
	 */
	Node<T> getRoot();
	
	/**
	 * Retorna si el valor existe o no dentro del arbol
	 * @param key el valor a buscar en el arbol
	 * @return si existe o no en el arbol
	 */
	boolean exists(T key);
	
	/**
	 * Retorna la cantidad de nodos en el arbol	
	 * @return la cantidad de nodos en el arbol
	 */
	int getNumberOfNodes();
	
	/**
	 * Retorna la cantidad de hijos que tiene un nodo en el arbol
	 * @param node el nodo que se quiere estudiar	
	 * @return la cantidad de hijos que tiene un nodo en el arbol
	 */
	int getNumberOfDescendants(Node<T> node);
	
	/**
	 * Retorna una lista con todos los datos del arbol en Pre-Orden
	 * @return una lista con todos los datos del arbol en Pre-Orden
	 */
	List<Node<T>> getPreOrderTraversal();

	/**
	 * Retorna una lista con todos los datos del arbol en In-Orden
	 * @return una lista con todos los datos del arbol en In-Orden
	 */
	List<Node<T>> getInOrderTraversal();
	
	/**
	 * Retorna una lista con todos los datos del arbol en Post-Orden
	 * @return una lista con todos los datos del arbol en Post-Orden
	 */
	List<Node<T>> getPostOrderTraversal();
	
	/**
	 * Retorna el camino desde la raiz hasta la hoja mas lejana
	 * @return el camino desde la raiz hasta la hoja mas lejana
	 */
	List<Node<T>> getLongestPathFromRootToAnyLeaf();

	/**
	 * Retorna la altura de la hoja mas profunda en el arbol
	 * @return la altura de la hoja mas profunda en el arbol
	 */
	int getMaxDepth();
	
	/**
	 * Retorna una lista con todos los caminos desde la raiz a cada una de las hojas
	 * @return una lista con todos los caminos desde la raiz a cada una de las hojas
	 */
	List<List<Node<T>>> getPathsFromRootToAnyLeaf();

}
