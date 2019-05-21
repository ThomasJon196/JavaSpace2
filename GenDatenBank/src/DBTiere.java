import java.util.Comparator;
import java.util.Iterator;

public class DBTiere<T extends Tier> extends DBFeldFix<T>{
	
	public DBTiere(int dbsize) {
		super(dbsize);
	}
	
	public DBTiere(T[] db) {
		super(db);
	}
	
	public int totalWeight() {
		int total = 0;
		for(int i=0; i<size; i++) {
			
			get(i).weight();
		}
		return total;
	}
	
	public void sort(Comparator<T> c) {
		boolean sorted = false;
		int counter = 1;
		while(!sorted) {
			sorted = true;
			for(int i=counter; i<size; i++) {
				if(c.compare(get(i), get(i+1)) > 0) {
					swap(i, i+1);
					sorted = false;
				}
			}
			if(counter >= size) {
				for(int i=1; i<size; i++) {
					if(c.compare(get(i), get(i+1)) > 0) {
						sorted = false;
						//counter = 1;
					}
				}
			}
			
		}
	}
}
