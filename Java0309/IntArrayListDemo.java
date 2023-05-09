import java.util.ArrayList;

public class IntArrayListDemo {
	public static void main(String[] args){
		ArrayList<Integer> scores = new ArrayList<>();
		//autoboxing using wrapper class: primitive types ---> objects
		for (int i = 0; i < 5; i++){
			scores.add(i);
		}
		System.out.println(scores.toString());
			//.get(Index) to retrieve elements
		int iniElement = scores.get(0); // note that you cannot directly get ArrayList element using [index].		
		scores.remove(0);
		scores.add(iniElement);
		System.out.println(scores.toString());
		//autounboxing, objects --> primitive types
		int sum = 0;
		for (Integer score: scores){
			sum += score;
		}
		System.out.println("Sum of the ArrayList: " + sum);

	} 
}