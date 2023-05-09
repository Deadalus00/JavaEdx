import java.util.Random;


public class TrySearch implements Comparable{
	public static void main(String[] args){
		Integer[] intArray = new Integer[1000000];
		Random rand = new Random();
		for (int i = 0; i < intArray.length; i++){
			intArray[i] = rand.nextInt(1000000); //rand.nextInt(bound) = get a random Int within bound
		}
		
		System.out.println("We have target at index: " + linearSearch(42, intArray));
	}

	public static int linearSearch(Comparable target, Comparable[] input){
		for (int i = 0; i < input.length; i++){
			if (input[i].compareTo(target) == 0){ // DO NOT forget about compareTo method when implement Comparable
				return i;
			}
		}
		return -1;
	}
}