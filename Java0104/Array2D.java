public class Array2D {
	public static void main(String[] args){
		double[][] array2d = {{74,78,91},{90,72,84}};
		
		final double MaxTemp = 90;
		final double MinTemp = 75;

		for (int row = 0; row < array2d.length; row++){
			for (int col = 0; col < array2d[row].length; col++){
				if (array2d[row][col] <= MaxTemp && array2d[row][col] >= MinTemp){
					System.out.printf("It's %.2f out there, let's go to park! \nNote: row %d column %d. \n", array2d[row][col], row, col);
				}
			}
		}
	}
}