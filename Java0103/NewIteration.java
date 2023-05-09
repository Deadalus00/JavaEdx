public class NewIteration{
	public static void main(String[] args) {

		int counter = 0;
		do{
			
			counter ++;
			System.out.printf("This is No.%d printout.\n",counter);
			System.out.printf("==========Now we have countdown.==========\n");

			int powerCount = 0;
			for (powerCount = 1; powerCount <= 40; powerCount *= counter + 1) {
				System.out.printf("This is powerCount %d when counter is %d.\n",powerCount,counter + 1);
			}

		}while (counter < 5);

	}
}