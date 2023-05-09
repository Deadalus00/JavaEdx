import java.util.ArrayList;

public class StringArrayListDemo {
	public static void main(String[] args){
		ArrayList<String> playlist = new ArrayList<>();

		for (int i = 0; i < 5; i++){
			playlist.add("Lullaby No." + i);
		}
		System.out.println(playlist.toString());
			//.get(Index) to retrieve elements
		String iniElement = playlist.get(0); // note that you cannot directly get ArrayList element using [index].		
		playlist.remove(0);
		System.out.println(playlist.toString());
		playlist.add(iniElement);
		System.out.println(playlist.toString());
	} 
}