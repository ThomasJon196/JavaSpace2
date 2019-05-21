import java.util.Iterator;

public class DBUtil {
	public static<T extends DB<Tier>> Tier min(T db) {
		Iterator<Tier> it = db.iterator();
		Tier kleinstes = it.next();
		
		Tier temp = null;
		while(it.hasNext()) {
			temp = it.next();
			if(kleinstes.compareTo(temp) < 0) kleinstes = temp; 
		}
		
		return kleinstes;
	}
}
