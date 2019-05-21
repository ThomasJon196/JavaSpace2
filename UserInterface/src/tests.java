
import java.io.IOException;
import java.util.ArrayList;

public class tests {  
	public static void main(String[] args) {
		
		final ArrayList<String> commands = new ArrayList<String>();                

		String program = "youtube-dl.exe";
		String format = "--format 140";
		String adress = "https://www.youtube.com/watch?v=LR3GQfryp9M&list=RDda3r8WHZnB4&index=31";
		
		try {
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
				+ "\"cd C:\\Users\\Thomas\\Desktop\\Music\\ && "
				+ program + " "
				+ format + " "
				+ adress 
				+ "\"");
		}catch(IOException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}
}