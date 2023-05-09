import java.util.Scanner;
import java.util. InputMismatchException;

public class FahToCelMultipleExceptions {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	 int fahrenheit = 0;//if deleted, will meet compile error // wrapped in try block and can not be found in compiletime
	 //SCOPE!
		
		try{
			System.out.println("Enter a Fahrenheit Tempreture: ");
			fahrenheit = input.nextInt();
			double celsius = (5D/9) * (fahrenheit - 32);
			System.out.printf("Fahrenheit Tempreture: %d.\n", fahrenheit);
			System.out.printf("Celsius Tempreture: %.1f.\n", celsius);
				//update code--Defining an Exception and using the throw operator
				if (fahrenheit == 0){
					throw new DivideByZeroException();//create a DZE object; how do throw an exception
				}
			double x = 1331/fahrenheit;		
		} catch (InputMismatchException ie) {
			input.nextLine();//NECESSARY: this line is to clear the new line and spaces
			System.out.printf("Sorry, wrong type entered: %s, please enter integer.\n", ie.getMessage());				
		} catch (/*ArithmeticException ae*/ DivideByZeroException dze) {
			input.nextLine();
			System.out.printf("Invalid value entered: %s.\n", ae.getMessage());
		} catch (Exception e) {
			input.nextLine();
			System.out.printf("Exception occured: %s.\n", e.getMessage());
		}
	}	
}