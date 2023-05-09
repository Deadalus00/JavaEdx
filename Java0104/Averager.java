public class Averager {
	public static void main(String[] args){
		double[] weekTemp = {70,73,78,76,77,80,83};
		double highsum = 0;
		/*for (int index = 0; index < weekTemp.length; index++){
			highsum = highsum + weekTemp[index];
		}*/
		for (double dayHigh : weekTemp){// for (datatype element : array/collection)
			highsum = highsum + dayHigh;
		}
		double weekAverage = highsum / weekTemp.length ;
		double weekAverageCelsius = (5D/9) * (weekAverage - 32);
		System.out.printf("Average Tempreture for this Week is %5.1f Fahrenheit degrees, which is %5.1f Celsius Degrees.\n", weekAverage, weekAverageCelsius);
	}
}