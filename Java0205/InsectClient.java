public class InsectClient {
	public static void main(String args[]){
		System.out.println(Insect.produceRandomFact());

		Insect bug1 = new Insect(50,30,40);

		Insect bug2 = new Insect(100);
		//bug1.weight = 40;
			//can not compile. Since weight has PRIVATE access in Insect class.

		//Insect.population = 0;
			//can not compile too. Same reason.
		
		//Now it's time to bring in getters and setters.
		//for instance methods, just call them by VarName.methodName();
		//for static methods, call them by className.methodName(); and static methods for static variables.

		//java will automatically call toString method for us when we call certain non-string object.
		//check the following printout
		System.out.println(bug1);
		System.out.println(bug2.toString());
		
		System.out.println("Population for Insects: " + Insect.getPopulation());

	}
}