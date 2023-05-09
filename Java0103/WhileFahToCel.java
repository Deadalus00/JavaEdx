import java.util.Scanner;

public class WhileFahToCel{
	public static void main(String[] args){
		int MaxTemp = 140;

		Scanner input = new Scanner(System.in);
		System.out.printf("Please enter a Fahrenheit Tempreture value: \n");
		float fahrenheit = input.nextFloat	();

		while (fahrenheit > MaxTemp){
			System.out.printf("Please enter a valid Fahrenheit Tempreture value no larger than 140 : \n");
			fahrenheit = input.nextFloat();
		}

		float celsius = (5F/9) * (fahrenheit - 32);
		System.out.printf("The Celsius Tempreture right now is: %f \n",celsius);

	}
}