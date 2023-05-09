public class Wolf extends Canine{ // Never forget about "extends" when inheriting
	//subclass instance variables
	protected int rank;

	public Wolf(int rank, double size){ //Constructors have no void type and will take in several parameters 
										//that align with instance variables of both superclass and itself.
		super(size);
		this.rank = rank;
		//super(size);
			// This line not here; check Dogs.java
			// super means superclass when used as method, it means parent class constuctor.
	}

	public int getRank(){
		return rank;
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
		System.out.println("Rank " + rank + " Wolf licks itself.")
	}

	public static void main(String[] args){
		Wolf alpha = new Wolf(1, 19.2); 
			//never forget "new" when creating an instance using constuctor.
		alpha.bark();
	}
}