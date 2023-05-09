import java.util.Scanner;
import java.util.Locale;//Locale API that can be used in NumberFormat methods
import java.text.NumberFormat;

public class CurrencyDemo{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of items and the cost per item:");
		int items = input.nextInt();
		Float total, itemCost = input.nextFloat();
		total = items * itemCost;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);// create a new variable and assign it by calling a NumberFormat instance
		System.out.printf("(Unformatted)You have bought %d items, and your total expenditure would be %f\n", items,total);
		System.out.printf("(Formatted)You have bought %d items, and your total expenditure would be %s\n", items, currencyFormat.format(total));
	}
}