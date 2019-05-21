import java.util.*;

public class ComparatorWeight<T extends Tier> implements Comparator<T>{
	
	public int compare(T t1, T t2) {
		
		return (t1.weight() - t2.weight());
	}
}
