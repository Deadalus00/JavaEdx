public /*abstract*/ class Dogs extends Canine { // extends means the class inherit its parent class on the right side
		// Only the superclasses with abstract methods or those you want want them to represent generic ideas
		//have to be tagged with "abstract". Not for subclasses that inherit abstract superclasses.
	protected String name;

	public Dogs(String name, double size){
		super(size);
		this.name = name;
		//this.size = size; 
			//wrong line! You can clear the comment and try compile it. See what's the error report
		//super(size); 
			//Still wrong! remember that super() method means constructor of the parent class. Try compile it.
			//Java automatically calls the parameterless super constructor at the very start of the child's constuctor
			//if you don't explicitly call the super's constructors in a child class constructor.
	}

	public void fetch(){
		System.out.println("Run");
		System.out.println("Clinch");
		System.out.println("Return");
	}

	public static void main(String[] args){
		Dogs dog1 = new Dogs("Tushy",12.5);	// Abstract classes cannot be instantiated.
		dog1.bark();
		Dogs dog2 = new Dogs("Tushy",12.5);
		System.out.println(dog1.equals(dog2));
	}

	public /*abstract*/ void groom(){
		System.out.println("Clean boy/girl.");
	} // think about why there should not be an "abstract"


	
	public boolean equals(Object o){
		if (/*o == null*/!(o instanceof Dogs)){ //because o can be an instance of other classes
			return false;
		}
		Dogs doggy = (Dogs) o;//using casting 
    	return ((doggy.size == size) && (doggy.name.equals(name)));
	}
	//line 34:equals():
		// line 35: if (!(o instanceof Dog)){ ; Operator: instanceof 
		// The operand on the left must be an object (or reference) and the one on the right must be a type.
		// The instanceof operator: Object instanceof Type;
	//line 38, 39: instantiation and equalty check
		// note that even the if block is passed, we still don't know if the name and size of this object o
		// is equal to the instance that is calling this method. Hence we should 1.assign object o to an instance
		// and then compare their size and name. Then return the boolean value that shows if they are equal.
		// Casting o to a Dog.
}