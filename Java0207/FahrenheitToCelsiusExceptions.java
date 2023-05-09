import java.util.Scanner;
import java.util. InputMismatchException;

public class FahrenheitToCelsiusExceptions {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean success = false;

		while(!success){ //Exception control loop
			try{
				System.out.println("Enter a Fahrenheit Tempreture: ");
				fahrenheit = input.nextInt();
				success = true;
			} catch (InputMismatchException e){
				input.nextLine();//this line is to clear the new line and spaces
				System.out.println("Sorry, wrong type entered, please enter integer.")				
			}
		}

		double celsius = (5D/9) * (fahrenheit - 32);
		System.out.printf("Fahrenheit Tempreture: %d.\n", fahrenheit);
		System.out.printf("Celsius Tempreture: %.1f.\n", celsius);
	}
}