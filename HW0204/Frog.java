public class Frog{
	//instance variables
	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet = false;
	private static String species = "Rare Pepe";

	//constructors
	// the constructors chaining achieved by "this".
	// Remember, it's always less specific one calls more specific one.
	// the following chain is calling, respectively, this way:
	// 1-->3 , 2-->3, so it's 2 levels of hierarchy. rather than 3.
	public Frog(String name){
		this(name, 5, 5.0);
	}

	public Frog(String name, double ageInYears, double tongueSpeed){
		this(name, (int)(ageInYears * 12), tongueSpeed);
	}

	public Frog(String newName, int newAge, double newTongueSpeed){
		this.name = newName;
		this.age = newAge;
		this.tongueSpeed = newTongueSpeed;
	}		
			// Remember when you cast, the value you want to transform must be check if are properly concluded.
			// It's better to use parenteses when casting for both value and type.
	

	//setters and getters
	public void setAge(int addAge){
		age = age + addAge;
	}

	public void setName(String newName){
		name = newName;
	}

	public void setTongueSpeed(double newTongueSpeed){
		tongueSpeed = tongueSpeed + newTongueSpeed;
	}

	public static void setSpecies(String newSpecies){
		species = newSpecies;
	}

	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}

	public double getTongueSpeed(){
		return tongueSpeed;
	}

	public static String getSpecies(){
		return species;
	}


	//helper methods
	public void grow(int months){

		if ((age + months) < 12){
			tongueSpeed = tongueSpeed + months;
			
		} else if (age < 12 && (age + months) >= 12){
			tongueSpeed = tongueSpeed + (12 - age);
			
		}

		


		if (age >= 30){
			tongueSpeed = tongueSpeed - months;

		} else if (age + months > 30) {
			tongueSpeed = tongueSpeed - (age + months - 30);
		}

		if (tongueSpeed < 5){
			tongueSpeed = 5;
		}
		
		age = age + months;
		// the place for this line is important

		if (age > 1 && age < 7){
			isFroglet = true;
		}

		
	}

	public void grow(){
		
		//update:
		grow(1);

		//DRY: don't repeat yourself
		/*if ((age + 1) < 12){
			tongueSpeed = tongueSpeed + 1;
			
		} else if (age < 12 && (age + 1) >= 12){
			tongueSpeed = tongueSpeed + (12 - age);
			
		}


		if (age >= 30){
			tongueSpeed = tongueSpeed - 1;

		} else if (age + 1 > 30) {
			tongueSpeed = tongueSpeed - (age + 1 - 30);
		}

		if (tongueSpeed < 5){
			tongueSpeed = 5;
		}
		
		age++;

		if (age > 1 && age < 7){
			isFroglet = true;
		}*/

		
	}

	public void eat(Fly fly){
		if (fly.isDead()){
		} else if (tongueSpeed <= fly.getSpeed()){
			fly.grow(1);
		} else if (tongueSpeed > fly.getSpeed()){
			if (fly.getMass() >= (0.5 * age)){
				grow();
			}
			fly.setMass(0);
		}

	}

	public String toString(){	
		if (isFroglet || (age > 1 && age < 7)){
			return "My name is " + name + " and I’m a rare froglet! I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f",tongueSpeed) + ".";
		} else {
			return "My name is " + name + " and I’m a rare frog. I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f",tongueSpeed) + ".";
		}
	}

}