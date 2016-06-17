import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.Node;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.NodeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.Tree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree.TreeImpl;

public class MainArbol {
	public static void main(String args[]) {
		Tree<String> arbol = new TreeImpl<String>(new NodeImpl<String>("r", null));
		Node<String> raiz2 = arbol.getRoot();
		System.out.println(arbol.getRoot().getData() + " GetRoot GetData");
		/**
		 * Todos los nodos se usaron para testeo de metodos
		 */
		Node<String> nodo1 = new NodeImpl<String>("v", (NodeImpl<String>) arbol.getRoot());
		Node<String> nodo2 = new NodeImpl<String>("s", (NodeImpl<String>) arbol.getRoot());
		Node<String> nodo3 = new NodeImpl<String>("u", (NodeImpl<String>) nodo1);
		Node<String> nodo4 = new NodeImpl<String>("w", (NodeImpl<String>) nodo1);
		Node<String> nodo5 = new NodeImpl<String>("x", (NodeImpl<String>) nodo4);
		Node<String> nodo6 = new NodeImpl<String>("y", (NodeImpl<String>) nodo4);
		Node<String> nodo7 = new NodeImpl<String>("z", (NodeImpl<String>) nodo4);
		Node<String> nodo8 = new NodeImpl<String>("p", (NodeImpl<String>) nodo2);
		Node<String> nodo9 = new NodeImpl<String>("q", (NodeImpl<String>) nodo2);

		System.out.println(arbol.exists("x") + " Exists");
		System.out.println(arbol.getNumberOfDescendants(arbol.getRoot()) + " GetNumberOfDes... de raiz");
		System.out.println(arbol.getNumberOfDescendants(nodo1) + " GetNumberOfDes... de nodo1(10)");
		System.out.println(arbol.getNumberOfNodes() + " GetNumberOfNodes");
		System.out.println(arbol.isEmpty() + " Vacio?");
		List<Node<String>> lista = new LinkedList<Node<String>>();
		lista = arbol.getPreOrderTraversal();
		System.out.print("Lista de recorrido: ");
		for (int i = 1; i <= lista.size(); i++) {
			System.out.print(lista.get(i).getData() + " ");
		}
		System.out.println();
		System.out.println(arbol.getMaxDepth() + " Profundidad maxima");
		List<Node<String>> caminoLargo = new LinkedList<Node<String>>();
		caminoLargo = arbol.getLongestPathFromRootToAnyLeaf();
		for (int i = 1; i <= caminoLargo.size(); i++) {
			System.out.print(caminoLargo.get(i).getData() + " ");
		}
		System.out.println();
		List<List<Node<String>>> lista2 = arbol.getPathsFromRootToAnyLeaf();
		for (int i = 1; i <= lista2.size(); i++) {
			for (int x = 1; x <= lista2.get(i).size(); x++) {
				System.out.print(lista2.get(i).get(x).getData() + " ");
			}
			System.out.println();
		}
		
		Tree<String> arbol2 = new TreeImpl<String>("TTY", arbol);
		lista = arbol2.getPreOrderTraversal();
		System.out.print("Lista de recorrido: ");
		for (int i = 1; i <= lista.size(); i++) {
			System.out.print(lista.get(i).getData() + " ");
		}

	}
}
