import java.util.Comparator;
import java.util.Iterator;

public class DBFeldDyn<T> extends DB<T>{
	private T[] elementData;
	
	public DBFeldDyn() {
		elementData = (T[])new Object[1];
		size = 0;
	}

	public void appendLast(T tier) {
		if(size == elementData.length) {
			T[] newArray = (T[])new Object[size*2];
			for(int i=0; i<size; i++) {
				newArray[i] = elementData[i];
			}
			newArray[size++] = tier;
			elementData = newArray;		
		} else {
			elementData[size++] = tier;
		}
	}

	public T removeLast() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		T temptier = elementData[--size];
		elementData[size] = null;
		if(size*4 <= elementData.length) {
			T[] newDB = (T[])new Object[elementData.length / 2];
			for(int i=0; i<size; i++) {
				newDB[i] = elementData[i];
			}
		}
		
		return temptier;
	}

	public T get(int i) {
		return elementData[i-1];
	}

	public void swap(int x, int y) { // Hier am besten noch überprüfen ob der Index auch im Feld existiert!
		T tempObj = elementData[x-1];
		elementData[x-1] = elementData[y-1];
		elementData[y-1] = tempObj;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sort(Comparator<T> c) {
		// TODO Auto-generated method stub
		
	}
	
	
}
