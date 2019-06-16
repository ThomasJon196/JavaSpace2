
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class DBBinBaum<T extends Comparable<T>> extends DB<T> {
	Node root;
	
	private class Node{
		T element;
		Node left;
		Node right;
		
		Node previous;
		Node(T element){
			this.element = element;
			left = null;
			right = null;
			previous = null;
		}
	}
	
	public DBBinBaum() {
		root = null;
	}
	//-------------------------------------------------
	// Methods for binary trees
	
	public void add(T element) {
		appendLast(element);
	}
	
	public boolean remove(T element) {
		// TODO
		return false;
	}
	
	public boolean search(T element) {
		// TODO
		return false;
	}
	
	//-------------------------------------------------
	
	
	
	@Override
	public void appendLast(T element) {
		addRecursive(root, element);
	}
	
	void addRecursive(Node n, T element) {
		Random rand = new Random();
		if(rand.nextBoolean()) {
			if(n.left == null) n.left = new Node(element);
			else addRecursive(n.left, element);
		}else {
			if(n.right == null) n.right = new Node(element);
			else addRecursive(n.right, element);
		}
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swap(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sort(Comparator<T> c) {
		// TODO Auto-generated method stub
		
	}

	
}
