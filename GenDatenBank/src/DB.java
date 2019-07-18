import java.util.Comparator;

abstract class DB<T> implements DBIF<T>, Iterable<T>{
	public int size;
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
	public int size() {
		return size;
	}
	
	abstract public void sort(Comparator<T> c);
}
