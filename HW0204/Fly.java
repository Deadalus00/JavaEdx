public class Fly{
	//instance variables
	private double mass = 5;
	private double speed = 10;

	//constructor
	public Fly(){
		this(5);
	}

	public Fly(double mass){
		this(mass, 10);
	}

	public Fly(double mass, double speed){
		this.mass = mass;
		this.speed = speed;
	}

	//setters and getters
	public double getMass(){
		return mass;
	}

	public double getSpeed(){
		return speed;
	}

	public void setMass(double mass){
		this.mass = mass;
	}

	public void setSpeed(double speed){
		this.speed = speed;
	}	

	public String toString(){
		if (mass == 0){
			return "I’m dead, but I used to be a fly with a speed of " + String.format("%.2f",speed) + ".";
		} else {
			return "I’m a speedy fly with " + String.format("%.2f",speed) + " speed and " + String.format("%.2f",mass) + " mass.";
		}
	}

	public void grow(int addMass){
		
		if (addMass != 0){
			if (addMass + mass < 20){
				speed = speed + addMass;
			} else if (mass < 20 && addMass + mass >= 20){
				speed = speed + (20 - mass);
				speed = speed - (mass + addMass - 20) * 0.5;
			} else {
				speed = speed - (addMass) * 0.5;
			}
		} 
		mass = addMass + mass;
	}

	public boolean isDead(){
		if (mass == 0){
			return true;
		} else {
			return false;
		}
	}
}