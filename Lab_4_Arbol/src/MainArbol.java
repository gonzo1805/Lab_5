import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.Tree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.TreeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.Node;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.NodeImpl;

public class MainArbol {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {
		Tree<String> arbol = new TreeImpl(new NodeImpl("r", null));
		Node<String> raiz2 = arbol.getRoot();
		System.out.println(arbol.getRoot().getData() + " GetRoot GetData");
		
		Node<String> nodo1 = new NodeImpl("v", (NodeImpl) arbol.getRoot());
		Node<String> nodo2 = new NodeImpl("s", (NodeImpl) arbol.getRoot());
		Node<String> nodo3 = new NodeImpl("u", (NodeImpl) nodo1);
		Node<String> nodo4 = new NodeImpl("w", (NodeImpl) nodo1);
		Node<String> nodo5 = new NodeImpl("x", (NodeImpl) nodo4);
		Node<String> nodo6 = new NodeImpl("y", (NodeImpl) nodo4);
		Node<String> nodo7 = new NodeImpl("z", (NodeImpl) nodo4);
		Node<String> nodo8 = new NodeImpl("p", (NodeImpl) nodo2);
		Node<String> nodo9 = new NodeImpl("q", (NodeImpl) nodo2);
		
		System.out.println(arbol.exists("x") + " Exists");
		System.out.println(arbol.getNumberOfDescendants(arbol.getRoot()) + " GetNumberOfDes... de raiz");
		System.out.println(arbol.getNumberOfDescendants(nodo1) + " GetNumberOfDes... de nodo1(10)");
		System.out.println(arbol.getNumberOfNodes() + " GetNumberOfNodes");
		System.out.println(arbol.isEmpty() + " Vacio?");
		List<Node<String>> lista = new LinkedList();
		lista = arbol.getInOrderTraversal();
		System.out.print("Lista de recorrido: ");
		for (int i = 1; i <= lista.size(); i++) {
			System.out.print(lista.get(i).getData() + " ");
		}
		System.out.println();
		System.out.println(arbol.getMaxDepth() + " Profundidad maxima");
		List<Node<String>> caminoLargo = new LinkedList();
		caminoLargo = arbol.getLongestPathFromRootToAnyLeaf();
		for (int i = 1; i <= caminoLargo.size(); i++) {
			System.out.print(caminoLargo.get(i).getData() + " ");
		}
		System.out.println();
		List<List<Node<String>>> lista2 = arbol.getPathsFromRootToAnyLeaf(); 
		for (int i=1; i<=lista2.size(); i++){
			for (int x=1; x<=lista2.get(i).size(); x++){
				System.out.print(lista2.get(i).get(x).getData() + " ");
			}
			System.out.println();
		}
	}
}
