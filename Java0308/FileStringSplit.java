import java.io.*;
import java.util.Scanner;

public class FileStringSplit {
	public static void main(String[] args){
		File fileIn = new File("SortedWolves.csv");
		Scanner fileScan = null;//take file as input
			Scanner wolfScan = null;//take string(from files) as input
		String[] tokens = null;
			//declare and set to null outside of catch block
		double[] allWeights = new double[10];
		int index = 0;
		
		try{
			fileScan = new Scanner(fileIn);
			//assignment inside for possible FileNotFound
			String line = null;
			while(fileScan.hasNextLine()){
				line = fileScan.nextLine();
				//update:
					wolfScan = new Scanner(line);//create an scanner object using String parameter
					wolfScan.useDelimiter(",");// be sure to use useDelimiter() method since Scanner(string)
					wolfScan.nextInt();//to consume unused ranks
				
				//update:
					allWeights[index] = wolfScan.nextDouble();//to assign allWeights elements to weights using nextDouble()
					System.out.println(allWeights[index]);
				//tokens = line.split(",");	
				//allWeights[index] = Double.parseDouble(tokens[1]);
				index++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fileScan != null) {
				fileScan.close();
			}
		}

		String chant = "Java Is The Best!";
		String[] substring = chant.split("[A-Z]+");
		for (String x: substring){
			System.out.println(x);
		}
	}
}