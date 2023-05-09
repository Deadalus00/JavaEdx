public class Insect{
	//instance variables
	private double weight;
	private int x;
	private int y;
	//Why you should not miss "static" here:
	//Note that static variables are shared by whole class, it's bit of like "global" variables,
	//and it is SHARED BY ALL INSTANCES of the class.
	//So an "non-static" variable cannot be directly called in constructors as long as the instance hasn't been created
	//but a static variable can be accessed anywhere within the scope of that class.
	private static final int DEFAULT_X = 0;
	private static final int DEFAULT_Y = 0;


	//static constants/variables
	private final double WeightLossFactor = .0001;
	public static int population = 0;
	private static final String[] Factos = {
		"The two main groups of insects are winged and wingless.",
		"There are more than 1 million insect species in the world.",
		"Insects are cold-blooded.",
		"Spiders are not considered insects.",
	};

	//constructors
		
		//METHOD OVERLOADING 
		//In constructor chaining; a more specific constructor is always called by a less specific.
		
	public Insect(double initWeight){
		this(initWeight, DEFAULT_X, DEFAULT_Y);//this(parameter1, 2, 3, ....)
	}

	//using "this" as a reference is mainly about disambiguation.
	//And it does strengthen the readability especially when there are many parameters and instances.
	//this.instanceVariables = instanceVariables
	public Insect(double weight, int x, int y){
		this.weight = weight;
		this.x = x;
		this.y = y;
		population++;	//static variables, do not use "this."
	}


	//methods

		//getters:
		//templates: public typeName getVarName()
		public int getX(){
			return x;
		}

		public int getY(){
			return y;
		}

		public double getWeight(){
			return weight;
		}

		public static int getPopulation(){ //static var getters
			return population;
		}

		//setters:
		//templates: public void setVarname(varType varName)
		public void setX(int newX){
			if (isLegalX(newX)){
				x = newX;
			} else {
				System.out.println("Illegal X value.");
			}
		}

		public void setY(int newY){
			if (isLegalY(newY)){
				y = newY;
			} else {
				System.out.println("Illegal Y value.");
			}
		}

		/*public void setWeight(double newWeight){
			if (isLegalY(newY)){
				y = newY;
			} else {
				System.out.println("Illegal Y value.");
			}
		}*/	
		//Update: we can know from this instance that not all 


		//value validition for setters 
		public static boolean isLegalX(int newX){
			return (newX >= 0 ? true : false);
		}

		public static boolean isLegalY(int newY){
			return (newY >= 0 ? true : false);
		}

	public void eat(double amount){
		System.out.println("Kachikachikachi.");
		weight = weight + amount;
	}

	public void move(int newX, int newY){
		double distance	= calculateDistance(x, y, newX, newY);
		if (distance > 0){
			x = newX;
			y = newY;
			weight = weight * WeightLossFactor * distance;
			System.out.printf("Moved %.2f units.\n", distance);	
		} else {
			System.out.println("Staying put.");
		}

	}

	private static double calculateDistance(double x, double y, double newX, double newY){
		return Math.sqrt((newY - y) * (newY - y) + (newX - x) * (newX - x));
	}

	public static String produceRandomFact(){
		int index = (int)(Math.random() * ((Factos.length - 1) + 1));
		return Factos[index];
	}

	public String toString(){
		return "Weight: " + weight + ", X axis: " + x + ", Y axis: " + y ;
	}

	//test method
	public static void main(String[] args){
		Insect bug1 = new Insect(100, 50, 50);
		Insect bug2 = new Insect(80, 40, 40);

		bug1.move(10,40);
		bug2.move(40,40);
	}

}
/*behaviors eat move
data/state xy Weight; Same identifiers but different weight w*/