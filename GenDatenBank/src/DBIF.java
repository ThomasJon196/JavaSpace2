import java.util.*;

interface DBIF <T>{
	public boolean isEmpty();
	public int size();
	public void appendLast(T tier);
	public T removeLast();
	public T get(int i);
	public void swap(int x, int y);
}
