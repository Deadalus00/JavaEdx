import java.util.Scanner;
// Java is CASE SENSITIVE
public class Fah2Cel{
	public static void main(String[] args){
		int saturdayFahrenheit = 89; //Variable Declaration Statement: <type> <identifier>
		int sundayFahrenheit = 64;//VDS is used so the computer would know where to find/store the data
		/*int 32bits from negative 2bils to positive 2bils
		saturdayFahrenheit = 89;// 89 here is a literal or say constant; each literal has a default type associated with it
		sundayFahrenheit = 64;*/
		double saturdayCelsius = (5F/9) * (saturdayFahrenheit - 32);//be sure to use decimal literal so float is float here
		double sundayCelsius = (5F/9) * (sundayFahrenheit - 32);//double wide range of real number
		System.out.println("Weekend Average Tempretures in Celcius");
		System.out.println("Sat:" + saturdayCelsius);// plus operator here does not mean arithmatic calculation but appending 2 strings
		System.out.println("Sun:" + sundayCelsius);
		long intTestVariable = 9999999999L;
		System.out.println("Float and Double percision test:\n" + "Float:" + 5F/9 + "\nDouble:" + 5D/9);
		System.out.println("Integert Test:" + intTestVariable);
		double average = (int)4.0;
		int gpa = (int)average;
		System.out.println("Average:" + average + "\nGPA:" + gpa);
		String textString = "Reference Variables Test Succeeded";
		int lenText = textString.length();
		System.out.println(textString + ": Length = "+ lenText);
		//String method
		String text1 = "Recursive";
		String text2 = text1.toLowerCase();
		String text3 = text1.concat(" " + text2);
		String text4 = text3.replace("i","1");
		System.out.println(text1 + "\n" + text2 + "\n" + text3 + "\n" + text4);
/***************************************************************************************
 *************************************************************************************/		
		// Scanner Object
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Fahrenheit value: ");
		float fahrenheit = input.nextFloat();
		float celsius = (5F/9) * (fahrenheit - 32);
		System.out.println("Celsius: " + celsius);
		float newFahrenheit = celsius/(5F/9) + 32;
		System.out.println("You have entered: " + fahrenheit);
		System.out.println("Check if it matches the input: " + newFahrenheit);
	}
}