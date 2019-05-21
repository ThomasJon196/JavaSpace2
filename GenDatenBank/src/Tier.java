

public abstract class Tier extends Lebewesen implements Comparable<Tier>{
	private int size;
	private int weight;
	
	public Tier(int size, int weight) {
		this.size = size;
		this.weight = weight;
		setMaxId(getMaxId() + 1);
		setId(getMaxId());
	}
	
	public int size() {
		return size;
	}
	
	public int weight() {
		return weight;
	}
	
	public String toString() {
		return "" + weight;
	}
	
	public static <T extends Tier> T getLarger(T tier1, T tier2) {
		/* Alte version mit Typeinschränkung
		int w1 = Integer.valueOf(tier1.toString());
		int w2 = Integer.valueOf(tier2.toString());
		if(w1 >= w2) {
			return tier1;
		} else {
			return tier2;
		}
		*/
		if(tier1.weight() >= tier2.weight()) {
			return tier1;
		} else {
			return tier2;
		}
	}
	
	public int compareTo(Tier t2) {
		return this.size - t2.size();
	}
}

