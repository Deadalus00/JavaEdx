import java.util.Scanner;

public class CondStatement {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a Fahrenheit Tempreture value: ");
		float fahrenheit = input.nextFloat();
		System.out.println("Enter a day of the week: ");
		String day = input.next();
		float celsius = (5F/9) * (fahrenheit - 32);
		System.out.printf("The tempreture for %-9s is %4.1f Fahrenheit Degree or %4.1f Celsius Degree.\n",day,fahrenheit,celsius);
		
		boolean raining = false;
		System.out.println("Is it raining out there? (y/n) : ");
		String isRain = input.next().toLowerCase();
		
		if (isRain.startsWith("y"))
			raining = true;


		if (celsius <= 28 && celsius >= 25 && raining != true ){
			System.out.println("It seems to be a good day for a trip!");
		}
		else if(celsius < 25 && raining != true){
			System.out.printf("'Seems that there is only %.1f Celsius Degree out there, You'd better get back home and learn Java.\n",celsius);
		}
		else if(celsius > 28 && raining != true){
			System.out.printf("It is %.1f Celsius Degree out there, too hot to stay outside.\n",celsius);
		}
		else{
			System.out.println("It's raining! Get back home now.");
		}
		System.out.println("Program execution completed.");
	}
}
