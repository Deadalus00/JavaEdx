public class Dog extends Pet{
	protected double droolRate;
	private static final double DEFAULT_DROOLRATE = 5.0;

	//Constructor
	public Dog(String name, double health, int painLevel){
		this(name, health, painLevel, DEFAULT_DROOLRATE);
	}


	public Dog(String name, double health, int painLevel, double droolRate){
		super(name, health, painLevel);
		this.droolRate = droolRate;
	}

	//methods
		//getters
	public double getDroolRate(){
		return droolRate;
	}

	public int treat(){
		
		int treatTime = 0;

		if (droolRate < 3.5) {
			treatTime = (int)((painLevel*2)/health);
		} else if (droolRate >= 3.5 && droolRate <= 7.5) {
			treatTime = (int)(painLevel/health);
		} else if (droolRate > 7.5) {
			treatTime = (int)(painLevel/(health*2));
		}
		super.heal();
		return treatTime;

	}

	public void speak(){
		super.speak();

		String barker = "bark";
		for (int i = 0 ; i < painLevel - 1 ; i++){
			barker = barker.concat(" bark");
		}
		
		if (painLevel > 5) {
			barker = barker.toUpperCase();
		} 
		
		System.out.print(barker);
	}

	public boolean equals(Object o){
		boolean isPetObject = super.equals(o);
		
		if (isPetObject && (o instanceof Dog)){
			return droolRate == ((Dog)o).droolRate;
		} 
		return false;
	}

	public String toString(){
		return String.format("Hi! I am %s the Dog with %s level of health and %s drool rate.\n", name, String.valueOf(health), String.valueOf(droolRate));
	}
}