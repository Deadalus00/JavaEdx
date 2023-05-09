public class Cat extends Pet{
	protected int miceCaught;
	private static final int DEFAULT_MICECAUGHT = 0;

	//Constructor
	public Cat(String name, double health, int painLevel){
		this(name, health, painLevel, DEFAULT_MICECAUGHT);
	}


	public Cat(String name, double health, int painLevel, int miceCaught){
		super(name, health, painLevel);
		if (miceCaught < 0){
			this.miceCaught = 0;
		} else {
			this.miceCaught = miceCaught;
		}
		
	}

	//methods
		//getters
	public double getMiceCaught(){
		return miceCaught;
	}

	public int treat(){
		
		int treatTime = 0;

		if (miceCaught < 4){
			treatTime = (int)((painLevel * 2)/health);
		} else if (miceCaught >= 4 && miceCaught <= 7){
			treatTime = (int)(painLevel/health);
		} else if (miceCaught > 7){
			treatTime = (int)(painLevel/(health * 2));
		}
		super.heal();
		return treatTime;
	}

	public void speak(){
		super.speak();

		String meower = "meow";
		for (int i = 0 ; i < painLevel - 1 ; i++){
			meower = meower.concat(" meow");
		}
		
		if (painLevel > 5) {
			meower = meower.toUpperCase();
		} 
		
		System.out.println(meower);
	}

	public boolean equals(Object o){
		boolean isPetObject = super.equals(o);
		
		if (isPetObject && (o instanceof Cat)){
			return miceCaught == ((Cat)o).miceCaught;
		} 
		return false;
	}

}