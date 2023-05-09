public class Car implements Groomable{
	private String make;
	private String model;
	private int year;
	private int speed;
	private int charge;
	private boolean powered;

	public Car(String make, String model, int year){
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public void start(){
		if (charge > 0){
			System.out.println("Good to go.");
			powered = true;
		}
	}

	public void groom(){
		if (speed == 0){
			System.out.println("Auto car washing now.");
		}
	}
}