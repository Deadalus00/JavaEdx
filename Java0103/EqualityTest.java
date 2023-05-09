public class EqualityTest{
	public static void main(String[] args){
		String x = new String("park");
		String y = "park";
		String z = "Park";

		if (x == y)
			System.out.println("x and y are aliases, which means they have same memory address.");
		
		if (x != y)
			System.out.println("x and y are not aliases, which means different memory address(e.g. heap and constant string pool).");

		if (x.equals(y)){
			System.out.println("x and y have same value");
			System.out.println("x : " + x);
			System.out.println("y : " + y);
		}

		if (y.compareTo(z) > 0){
			System.out.println("y is greater than z.");
			System.out.printf("And y is \"%s\", z is \"%s\".\n",y,z);
		}


	}
}