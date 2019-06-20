
public class DBBinBaum<T extends Comparable<T>> {
	Node root;

	private class Node {
		T element;
		Node left;
		Node right;

		Node(T element) {
			this.element = element;
			left = null;
			right = null;
		}
	}

	public DBBinBaum() {
		root = null;
	}
	// -------------------------------------------------
	// Methods for binary trees
	// Da diese Aufgabe Sinnfrei ist wurde sie übersprungen und stattdessen
	// direkt beim DBBinBaumTier weitergemacht

	public void add(T element) {
		root = addRecursive(root, element);
	}
	
	private Node addRecursive(Node current, T element) {
		if(current == null) {
			return new Node(element);
		}else if(current.element.compareTo(element) > 0) {
			current.left = addRecursive(current.left, element);
		}else if(current.element.compareTo(element) < 0){
			current.right = addRecursive(current.right, element);
		}
		
		return current;
	}

	private T findBiggestValue(Node current) {
		return (current.right == null ? current.element : findBiggestValue(current.right));
	}

	private Node removeRecursive(Node current, T element) {
		if(current == null) {
			return null;
		}
		
		if(current.element.compareTo(element) == 0) {
			
			
			
		}
		if(current.element.compareTo(element) > 0) {
			current.left = removeRecursive(current.left, element);
		}
		if(current.element.compareTo(element) < 0) {
			current.right = removeRecursive(current.right, element);
		}
		return current;
	}

	public boolean remove(T element) {
		//root = removeRecursive(root, element);
		Node current = root;
		Node mother = null;
		
		while(current != null) {
			if(current.element.compareTo(element) == 0) {
				break;
			}
			mother = current;
			if(current.element.compareTo(element) > 0) {
				current = current.left;
			}else {
				current = current.right;
			}
		}
		if(current == null) { // Couldn't find the value -> Cancel method
			return false;
		}
		
		if(current == root) {
			root = (current.left != null ? current.left : current.right);
		}else if(current.left == null || current.right == null) {
			if(mother.element.compareTo(element) > 0) {
				mother.left = (current.left != null ? current.left : current.right);
			}else if(mother.element.compareTo(element) < 0) {
				mother.right = (current.left != null ? current.left : current.right);
			}
		}else {
			Node replacement = current.left;
			while(replacement.right != null) {
				replacement = replacement.right;
			}
			remove(replacement.element);
			mother = replacement;
			replacement.left = current.left;
			replacement.right = current.right;			
		}
		return true;
	}
		

	public boolean search(T element) {
		Node current = root;

		current = searchRecursive(root, element);
		if (current == null) {
			return false;
		} else {
			return true;
		}
	}

	private Node searchRecursive(Node current, T element) {
		if (current == null) {
			return null;
		}
		if (current.element.compareTo(element) == 0) {
			return current;
		} else if (current.element.compareTo(element) > 0) {
			return searchRecursive(current.left, element);
		} else {
			return searchRecursive(current.right, element);
		}
	}

	public void printTree(Node start) {
		if (start != null) {
			System.out.println(start.element);
			printTree(start.left);
			printTree(start.right);
		}
	}

	// -------------------------------------------------
	// Im Comperator wird der erste Wert des Tieres verglichen

	public static void main(String[] args) {
		DBBinBaum<Tier> binbaum = new DBBinBaum<>();
		Igel i1 = new Igel(15, 15);
		binbaum.add(new Igel(5,5));
		binbaum.add(new Igel(10, 10));
		binbaum.add(new Katze(20, 20));
		binbaum.add(new Igel(30, 30));
		binbaum.add(i1);
		binbaum.printTree(binbaum.root);
		binbaum.remove(new Igel(20, 20));
		binbaum.printTree(binbaum.root);
		binbaum.remove(new Igel(5,5));
		binbaum.printTree(binbaum.root);

	}
}
