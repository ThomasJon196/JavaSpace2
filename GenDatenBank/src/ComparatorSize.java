import java.util.*;

public class ComparatorSize<T extends Tier> implements Comparator<T> {
	
	public int compare(T t1, T t2) {
		return t1.size() - t2.size();
	}
}
