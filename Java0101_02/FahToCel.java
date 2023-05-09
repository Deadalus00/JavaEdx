import java.util.*;//or import java.util.Scanner. Asterisk means all members of java.util. can be used
public class FahToCel {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);//read keyboard input
		System.out.println("Enter a Fahrenheit Tempreture value and a day of the week: ");
		float fahrenheit = input.nextFloat();
		String day = input.nextLine();
		float celsius = (5F/9) * (fahrenheit - 32);
		System.out.printf("The Celcius    tempreture for this %10s is %.1f\n", day, celsius);
		System.out.printf("The Fahrenheit tempreture for this %10s is %.1f\n", day, fahrenheit);//%[flag][width][.precision]type
	}
}