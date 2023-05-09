public class NewAverager {
	public static void main(String[] args){
		double sum = 0;
		for (String num : args) {
			sum += Double.parseDouble(num);//convert to double
		}
		double average = (args.length > 0) ? (sum / args.length) : 0;// (if condition) ? (if-true Statement) : (else statement)
		System.out.printf("The average for %d numbers in args is: %.2f \n", args.length, average);
	}
}