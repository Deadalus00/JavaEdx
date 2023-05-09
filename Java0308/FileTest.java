import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileTest {
	
	public static void main(String[] args) /*throws FileNotFoundException*/{ //will have to declare this exception if not catching one.
		String inputFileName = args[0];
		String word = args[1];

		File fileIn = new File(inputFileName);//create an object for the designated file
		File fileOut = new File(word+"In"+inputFileName);//#1 create the File type object for print write

		Scanner fileScan = null;
		PrintWriter filePrint = null; //#2 declare and create the PrintWrite object, set to null

		try {
			fileScan = new Scanner(fileIn);//scanning lines in file
			filePrint = new PrintWriter(fileOut);//#3 assign the PrintWriter object to a File Type object; it's like link (File)fileOut to (PrintWritier)

			int lineCount = 1;
			System.out.printf("Lines in %s containing %s:\n", inputFileName, word);

			while (fileScan.hasNextLine()){// filename.hasNextLine()
				String line = fileScan.nextLine();// fileName.nextLine() method
				if (line.contains(word)){// NOTE: String method that check if certain string contains a substring.
					System.out.printf("On line %d, we have: %s.\n", lineCount, word);
					System.out.println("This is the line: " + line);

					filePrint.printf("On line %d, we have: %s.\n", lineCount, word);//#4 Output by calling PrintWriter instance method .println/f()
					filePrint.println("This is the line: " + line);
						//FILE OUTPUT: Note the DIFFERENCE of this line from the others					
				}
				lineCount++;
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fileScan != null){
				fileScan.close();//Very IMPORTANT. it indicates if the file scanning/inputing ends.
			}
			if (filePrint != null){
				filePrint.close();//#5 never forget about closing the file
			}
			
		}
	}
}