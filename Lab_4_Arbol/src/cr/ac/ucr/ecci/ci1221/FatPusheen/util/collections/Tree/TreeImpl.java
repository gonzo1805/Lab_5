package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class TreeImpl<T> implements Tree<T> {

	Node<T> raiz;
	int cantidadNodos;
	
	public TreeImpl() {
		raiz = new NodeImpl();
		cantidadNodos = 0;
	}
	
	public TreeImpl(Node<T> padreDeTodo){
		raiz = new NodeImpl(padreDeTodo.getData(), padreDeTodo);
		cantidadNodos = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return cantidadNodos == 0;
	}

	@Override
	public Node<T> getRoot() {
		return raiz;
	}

	@Override
	public boolean exists(T key) {
		
		return false;
	}
	
	public boolean existsRec(Node<T> nodo, T key){
		if (nodo.getData() == key){
			return true;
		} else if (nodo.getChildren() != null){
			LinkedList<Node<T>> lista = (LinkedList<Node<T>>) nodo.getChildren();
			boolean comprobacion = false;
			for (int i=1; i<=lista.size(); i++){
				comprobacion = existsRec(lista.get(i), key);
			}
			return comprobacion;
		}
		return false;
	}

	@Override
	public int getNumberOfNodes() {
		return cantidadNodos;
	}

	@Override
	public int getNumberOfDescendants(Node<T> node) {
		return (node.getChildren()).size();
	}

	@Override
	public List<Node<T>> getPreOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node<T>> getInOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node<T>> getPostOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node<T>> getLongestPathFromRootToAnyLeaf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<List<Node<T>>> getPathsFromRootToAnyLeaf() {
		// TODO Auto-generated method stub
		return null;
	}

}
