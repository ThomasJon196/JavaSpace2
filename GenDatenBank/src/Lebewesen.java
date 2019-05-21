
abstract class Lebewesen {
	private static int maxId;
	private int id;
	
	abstract public int size();
	abstract public int weight();
	public static int getMaxId() {return maxId;}
	public static void setMaxId(int x) {maxId = x;}
	public int getId() {return id;}
	public void setId(int x) {id = x;}
	
}