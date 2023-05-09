public abstract class Pet{
	protected String name;
	protected double health;
	protected int painLevel;

	//Constructor
	public Pet(String name, double health, int painLevel){
		this.name = name;
		
		if (health > 1.0) {
			this.health = 1.0;
		} else if (health < 0.0) {
			this.health = 0.0;
		} else {
			this.health = health;
		}

		if (painLevel > 10) {
			this.painLevel = 10;
		} else if (painLevel < 1) {
			this.painLevel = 1;
		} else {
			this.painLevel = painLevel;
		}
	}

	//methods 
		//getters
	public String getName(){
		return name;
	}

	public double getHealth(){
		return health;
	}

	public int getPainLevel(){
		return painLevel;
	}	

	public abstract int treat();

	public void speak(){
		String speakString = "Hello! My name is " + name;
		if (painLevel > 5){
			speakString = speakString.toUpperCase();
		}

		System.out.println(speakString);
		
	}

	public boolean equals(Object o) {
		if(!(o instanceof Pet)){
			return false;
		} 
		Pet other = (Pet) o;
    	return this.name.equals(other.name);
	}

	protected void heal(){
		this.health = 1.0;
		this.painLevel = 1;
	}
}