import cr.ac.ucr.ecci.ci1221.FatPusheen.model.Estudiante;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.BinarySearchTree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.BitsVectorSetImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.Conjunto;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.ConjuntoNumerable;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.HashTableSetImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.LinkedListSetImpl;

public class MainSet {

	public static void main(String args[]) {

		Estudiante est1 = new Estudiante("B35584", 116060413, 21, 1);
		Estudiante est2 = new Estudiante("B22558", 125485710, 21, 5);
		Estudiante est3 = new Estudiante("B64858", 145497891, 22, 3);
		Estudiante est4 = new Estudiante("B42157", 124687912, 18, 4);
		Estudiante est5 = new Estudiante("B64879", 213456784, 23, 2);
		Estudiante est6 = new Estudiante("B46548", 402421020, 25, 6);
		Estudiante est7 = new Estudiante("B45645", 120124564, 21, 8);
		Estudiante est8 = new Estudiante("B31246", 512345454, 20, 7);

		Conjunto<Estudiante> hash = new HashTableSetImpl<Estudiante>(9);
		ConjuntoNumerable<Estudiante> bits = new BitsVectorSetImpl<Estudiante>(11);
		Conjunto<Estudiante> lista = new LinkedListSetImpl<Estudiante>();
		Conjunto<Estudiante> arbol = new BinarySearchTree<Estudiante>(est1);

		hash.add(est1);
		hash.add(est8);
		hash.add(est2);
		hash.add(est3);
		hash.add(est4);
		hash.add(est5);
		hash.add(est6);
		hash.add(est7);

		Iterator<Estudiante> itLista = hash.iterator();

		while (itLista.hasNext()) {

			Estudiante dato = itLista.next();
			System.out.println(dato.getCarne() + "," + dato.getCedula() + "," + dato.getEdad() + "," + dato.getIndex());
		}
		System.out.println(est1.hashCode());
		
		Conjunto<Estudiante> lista2 = new HashTableSetImpl<Estudiante>();
		lista2.add(new Estudiante("B32156", 124687910, 21, 10));
		
		Conjunto<Estudiante> lista3 = hash.union(hash, lista2);
		
		itLista = lista3.iterator();

		while (itLista.hasNext()) {
			Estudiante dato = itLista.next();
			System.out.println(dato.getCarne() + "," + dato.getCedula() + "," + dato.getEdad() + "," + dato.getIndex());
		}
		
	}
}
