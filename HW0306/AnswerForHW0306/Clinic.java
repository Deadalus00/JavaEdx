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
				String[] pInfo = line.split(",");
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
				double health = 0;
				int painLevel = 0;

			boolean repeatHealth = true;
			while (repeatHealth){
				//update:
					System.out.printf("What is the health of %s?\n",name);
				if (input.hasNextDouble()){
					health = input.nextDouble();
					//update:
					/*initHealth = health;
					input.nextLine();*/
					repeatHealth = false;
				} else {
					//update:
						input.nextLine();//clear the line
					System.out.println("Please enter a number");
				}
				
			}
			//:
			//System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
			boolean repeatPain = true;
			while (repeatPain){
				//:
					System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
				if (input.hasNextInt()){
					painLevel = input.nextInt();
					//initPainLevel = painLevel;
					//input.nextLine();
					repeatPain = false;
				} else {
					//:
						input.nextLine();
					System.out.println("Please enter a number");
				}
			}
			
			Pet pet;
			if (species.equals("Dog")){
				//:
				pet = new Dog(name, health, painLevel, Double.parseDouble(stat)/*droolRate*/);
				/*pet.speak();
				timeOut = this.addTime(time, pet.treat());
				outString = outString.concat(String.format("%s,%s,%f,%d,%s,%d,%f,%d\n", name, species, droolRate, day, time, timeOut, initHealth, initPainLevel));*/
			} else if (species.equals("Cat")){
				//:
				pet = new Cat(name, health, painLevel, Integer.parseInt(stat)/*miceCaught*/);
				/*pet.speak();
				timeOut = this.addTime(time, pet.treat());
				outString = outString.concat(String.format("%s,%s,%d,%d,%s,%d,%f,%d\n", name, typeOfPet, miceCaught, day, time, timeOut, initHealth, initPainLevel));*/
			} //:
				else {
					throw new InvalidPetException();
				}
			//:
				health = pet.getHealth();
				painLevel = pet.getPainLevel();
				pet.speak();
				int treatmentTime = pet.treat();
				String timeOut = addTime(timeIn, treatmentTime);
				outString += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n", name, species, stat, day, timeIn, timeOut, String.valueOf(health), painLevel);
		}
		//day++;
		//:
			fileScan.close();
			input.close();
		//:
		return outString.trim(); //.trim()added
	}

	public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException{
		//File file = new File(fileName);
		//:
			return nextDay(new File(fileName));
	}

	//:
	public boolean addToFile(String patientInfo){
		Scanner fileScan = null;
		PrintWriter filePrint = null;
		String stringOutput = "";

		try{
			//:
			fileScan = new Scanner(patientFile);

			boolean newPatient = true;
			int firstDelimiter = patientInfo.indexOf(",");
			String name = patientInfo.substring(0,firstDelimiter);

			while(fileScan.hasNextLine()){
				String line = fileScan.nextLine();
				if (line.startsWith(name)){
					newPatient = false;
					//add only new patients
					int currentDelim = firstDelimiter;
					for (int i = 2; i <= 3; i++){
						int nextDelim = patientInfo.indexOf(",",currentDelim + 1);
						currentDelim = nextDelim;
					}
					line += patientInfo.substring(currentDelim);
				}
				stringOutput += (line + "\n");
			}
			if(newPatient){
				stringOutput += patientInfo;
			}

			fileScan.close();
			filePrint = new PrintWriter(patientFile);
			filePrint.print(stringOutput);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(fileScan != null){
				fileScan.close();
			}
			if(filePrint != null){
				filePrint.close();
			}
		}
	}

	//:
	private static String addTime(String timeIn, int treatmentTime){ //static method
		int minute, hour;
		//:
		int minuteIn = Integer.parseInt(timeIn.substring(2,4));
		int houtIn = Integer.parseInt(timeIn.substring(0,2));
		
		int	hourOut = (houtIn + (minuteIn + treatmentTime) / 60) % 24;
		int minuteOut = (minuteIn + treatmentTime) % 60;

		String timeOut = String.format("%02d%2d", hourOut, minuteOut);
		return timeOut;
	}
}