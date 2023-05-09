import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
	private File patientFile;
	private int day;

	//constructor
	public Clinic(File file){
		this.patientFile = file;
		day = 1;
	}

	public Clinic(String fileName){
		this(new File(fileName));
	}

	//methods

	public String nextDay(File f) throws FileNotFoundException{
		day++;//position updated
		String outString = "";
		Scanner fileScan = new Scanner(f);//updated
		Scanner input = new Scanner(System.in);
		String line = null;

		/*String[] tokens = new String[4];
		int painLevel = 0;
		int initPainLevel = 0;
		double health = 0.0;
		double initHealth = 0.0;
		String name,typeOfPet,time, timeOut;	
		int miceCaught = 0;
		double droolRate = 0.0;
		

		fileScan = new Scanner(f);
		String line = null;*/

		while(fileScan.hasNextLine()){
			line = fileScan.nextLine();
			//update
				String pInfo = line.split(",");
				String name = pInfo[0];
				String species = pInfo[1];
				String stat = pInfo[2];
				String timeIn = pInfo[3];
			
			/*tokens = line.split(",");
			name = tokens[0];
			typeOfPet = tokens[1];
			time = tokens[3];*/
			
			//update
			if (!(species.equals("Cat") || species.equals("Dog"))){
				throw new InvalidPetException();
			}
			
			System.out.printf("Consultation for %s the %s at %s.\n", name, species, timeIn);
			double

			boolean repeatHealth = true;
			while (repeatHealth){
				if (input.hasNextDouble()){
					health = input.nextDouble();
					initHealth = health;
					input.nextLine();
					repeatHealth = false;
				} else {
					System.out.println("Please enter a number");
				}
				
			}
			
			System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
			boolean repeatPain = true;
			while (repeatPain){
				if (input.hasNextInt()){
					painLevel = input.nextInt();
					initPainLevel = painLevel;
					input.nextLine();
					repeatPain = false;
				} else {
					System.out.println("Please enter a number");
				}
			}
			
			Pet pet;
			if (typeOfPet.equals("Dog")){
				pet = new Dog(name, health, painLevel, droolRate);
				pet.speak();
				timeOut = this.addTime(time, pet.treat());
				outString = outString.concat(String.format("%s,%s,%f,%d,%s,%d,%f,%d\n", name, typeOfPet, droolRate, day, time, timeOut, initHealth, initPainLevel));
			} else if (typeOfPet.equals("Cat")){
				pet = new Cat(name, health, painLevel, miceCaught);
				pet.speak();
				timeOut = this.addTime(time, pet.treat());
				outString = outString.concat(String.format("%s,%s,%d,%d,%s,%d,%f,%d\n", name, typeOfPet, miceCaught, day, time, timeOut, initHealth, initPainLevel));
			}
		
			


		}
		day++;
		return outString;
	}

	public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException{
		File file = new File(fileName);
		return nextDay(file);
	}

	/*public boolean addToFile(String patientInfo){

	}*/

	private String addTime(String timeIn, int treatmentTime){
		int minute, hour;

		int minuteIn = Integer.parseInt(timeIn.substring(0,2));
		int houtIn = Integer.parseInt(timeIn.substring(2,4));
		
		int	hourOut = (houtIn + (minuteIn + treatmentTime) / 60) % 24;
		int minuteOut = (minuteIn + treatmentTime) % 60;

		String timeOut = String.format("%02d%2d", hourOut, minuteOut);
		return timeOut;
	}
}