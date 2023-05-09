public abstract class Mascot{//update: instance variables are not allowed in interfaces
	//static variables
	public static double Max_Celebration_Sec = 30;
	public static int Max_Volume =100;
	public static int Max_Speed = 10;
	
	//instance variables
	private int speed;
	private int volume;
	private String name;

	//abstract methods
	public abstract void celebrate();
	public abstract void whine();
	public abstract void chant();
	public abstract void run();

	//getters and setters
	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVolume(int volume) {
        if (volume <= MAX_VOLUME) {
            this.volume = volume;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setSpeed(int speed) {
        if (speed <= MAX_SPEED) {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }	

	// In interface, all variables are inherently public, static and final.
}