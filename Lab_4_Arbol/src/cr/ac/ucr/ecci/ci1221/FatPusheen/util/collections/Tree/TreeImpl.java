package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;


public class TreeImpl<T> implements Tree<T> {

	Node<T> raiz;
	
	public TreeImpl(Node<T> padreDeTodo){
		raiz = padreDeTodo;
	}
	
	@Override
	public boolean isEmpty() {
		return getNumberOfNodes() == 0;
	}

	@Override
	public Node<T> getRoot() {
		return raiz;
	}

	@Override
	public boolean exists(T key) {	
		return existsRec(raiz, key);
	}
	
	public boolean existsRec(Node<T> nodo, T key){
		if (nodo.getData().equals(key)){
			return true;
		} else if (nodo.getChildren() != null){
			List<Node<T>> lista = nodo.getChildren();
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
		int contador = 0;
		return getNumberOfNodesRec(contador, raiz);
	}
	
	public int getNumberOfNodesRec(int contador, Node<T> nodo){
		contador++;
		if (nodo.getChildren() != null){
			List<Node<T>> lista = nodo.getChildren();
			for (int i=1; i<=lista.size(); i++){
				contador = getNumberOfNodesRec(contador, lista.get(i));
			}
		}
		return contador;
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
	
	public List<Node<T>> auxiliarRecorrido(Node<T> nodo, LinkedList<Node<T>> lista){
		lista.add(nodo);
		return lista;
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
