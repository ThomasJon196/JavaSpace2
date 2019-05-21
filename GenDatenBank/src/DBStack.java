import java.util.Stack;
import java.util.Comparator;

public class DBStack<T> extends Stack<T> implements DBIF<T>{

	public boolean isEmpty() {
		return empty();
	}
	
	public int size() {
		return elementCount;
	}
	public void appendLast(T tier) {
		push(tier);
	}
	public T removeLast() {
		T temp = pop();
		return temp;
	}
	public T get(int i) {
		return (T)elementData[i];
	}
	public void swap(int x, int y) {
		Object tempObj = elementData[x-1];
		elementData[x-1] = elementData[y-1];
		elementData[y-1] = tempObj;
	}
	
	public void sort(Comparator<? super T> c) {
		
	}
}
