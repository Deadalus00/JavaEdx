import java.util.*;
import java.io.*;

public class Wolf extends Canine implements Groomable, Comparable<Wolf>{ // Never forget about "extends" when inheriting
	//subclass instance variables // check the <> and Java module06lesson13 NO.11 Generic types and comparable
	protected int rank;

	public Wolf(int rank, double size){ //Constructors have no void type and will take in several parameters 
										//that align with instance variables of both superclass and itself.
		super(size);
		this.rank = rank;
		//super(size);
			// This line not here; check Dogs.java
			// super means superclass when used as method, it means parent class constuctor.
	}


	//getters and setters
	public int getRank(){
		return rank;
	}

	public double getSize(){
		return size;
	}

	//method override
	//notice that overriding has to be the SAME SIGNATURE. 
	//Signatures includes identifiers and parameters' types
	public void bark(){ //barks three times as canine does
		for (int i = 0; i < 3; i++){
			super.bark();
		}
	}

	public void bark(int barkCycle){ //barks three times as canine does
		for (int i = 1; i <= barkCycle; i++){
			super.bark();
		}
	}

	public void groom(){
		System.out.println("Rank " + rank + " Wolf licks itself.");
	}

	public void pay(){
		System.out.println("No, we don't pay, we are wolves.");
	}
	/*public void quicksort(Object[] arr){
		((sometype)arr[someIndex]).compareTo(arr[otherIndex]);  
			//here we have to cast element on types other than index since Object class has no compareTo method
			//using compareTo method to retrieve the 2 elements are equal bigger or smaller
	}*/

	public int compareTo(Wolf anotherWolf){
		return anotherWolf.rank - rank;
	}

	public String toString(){
		return "Rank: " + rank + ", Size: " + size ;
	}

	public static int linearSearch(Comparable target, Comparable[] input){
		for (int i = 0; i < input.length; i++){
			if (input[i].compareTo(target) == 0){ // DO NOT forget about compareTo method when implement Comparable
				return i;
			}
		}
		return -1;
	}	

	public static int binarySearch(Comparable target, Comparable[] inputList){
		int start = 0, end = inputList.length - 1, mid = 0;

		while (start <= end){
			mid = (start + end) / 2;
			if (inputList[mid].compareTo(target) == 0){
				return mid;
			} else if (inputList[mid].compareTo(target) < 0){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		//Wolf alpha = new Wolf(1, 19.2);
		//Wolf puppy = new Wolf(5, 3); 
		Wolf[] pack = {
			new Wolf(1,17),
			new Wolf(3,16),
			new Wolf(2,19),
			new Wolf(2,18.4),
			new Wolf(4,8),
			new Wolf(3,12),
			new Wolf(4,7),
		};
		System.out.println("Unsorted Pack: " + Arrays.toString(pack));//using arrays toString method(override method here): simply iterates each elements of an array can call toString method then.
		Arrays.sort(pack);//Array sort method here.
		System.out.println("Sorted Pack: " + Arrays.toString(pack));

		File fileOut = new File("SortedWolves.csv");
		PrintWriter filePrint = null;

		try{
			filePrint = new PrintWriter(fileOut);//must be in catch block since there is possible FileNotFoundException for all I/O 
			for (Wolf wolf: pack){
				filePrint.println(wolf.getRank() + "," + wolf.getSize());
			}
		} catch (FileNotFoundException fe){
			System.out.println(fe.getMessage());
		} finally {
			if (filePrint != null){
				filePrint.close();
			}
		}

		Integer[] intArray = new Integer[1000000];
		Random rand = new Random();
		for (int i = 0; i < intArray.length; i++){
			intArray[i] = rand.nextInt(1000000); //rand.nextInt(bound) = get a random Int within bound
		}
		Arrays.sort(intArray);
		System.out.println("We have target at index: " + binarySearch(42, intArray));
	}

			//never forget "new" when creating an instance using constuctor.
		
		//alpha.bark();
		//System.out.println(alpha.compareTo(puppy));
	
}