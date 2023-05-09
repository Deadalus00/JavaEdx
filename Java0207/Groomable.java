public interface Groomable{
	public void groom();
	default void pay(){
		System.out.println("Cha-Ching!");
	}

	static String calculateTip(double price, double rate){
		double rawTip = price * rate;
		return String.format("$%,.2f",rawTip);// comma means thousand seperator
	}
}