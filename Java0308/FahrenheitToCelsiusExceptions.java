import java.util.Scanner;
import java.util. InputMismatchException;

public class FahrenheitToCelsiusExceptions {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean success = false;
	 int fahrenheit = 0;//if deleted, will meet compile error // wrapped in try block and can not be found in compiletime
	 //SCOPE!

		while(!success){ //Exception control loop
			try {
				System.out.println("Enter a Fahrenheit Tempreture: ");
				fahrenheit = input.nextInt();
				success = true;
			} catch (InputMismatchException e){
				input.nextLine();//NECESSARY: this line is to clear the new line and spaces
				System.out.println("Sorry, wrong type entered, please enter integer.");				
			} finally {
				input.nextLine();
			}

		}

		System.out.println("Enter a day of the week: ");
		String day = input.nextLine();
		double celsius = (5D/9) * (fahrenheit - 32);
		System.out.printf("%s Fahrenheit Tempreture: %d.\n", day, fahrenheit);
		System.out.printf("%s Celsius Tempreture: %.1f.\n", day, celsius);
	}
}