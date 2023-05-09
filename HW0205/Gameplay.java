public class Gameplay{
	public static void main(String[] args){
		BlueAstronaut Bob = new BlueAstronaut("Bob", 30, 6, 30);
		BlueAstronaut Heath = new BlueAstronaut("Heath", 28, 3, 21);
		BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);
		BlueAstronaut Albert = new BlueAstronaut("Albert", 0, 2, 0);
		RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
		RedAstronaut SusPerson = new RedAstronaut("Suspicious Person", 22, "expert");

		Liam.emergencyMeeting();
		System.out.println("============================");	
		Liam.emergencyMeeting();
		Liam.emergencyMeeting();

		/*//1
		Liam.sabotage(Bob);
		System.out.println(Bob.toString());
		//2
		System.out.println(SusPerson.toString());
		Liam.freeze(SusPerson);
		System.out.println(SusPerson.toString());
		//3
		Liam.freeze(Albert);
		System.out.println(Albert.toString());
		System.out.println(Liam.toString());
		//4
		Albert.emergencyMeeting();
		//5
		Angel.emergencyMeeting();
		System.out.println(Bob.toString() + Heath.toString());
		System.out.println(Liam.toString());
		Angel.emergencyMeeting();
		System.out.println(Bob.toString() + Heath.toString());
		System.out.println(Liam.toString());
		*/
		/*//6
		Bob.emergencyMeeting();
		System.out.println(SusPerson.toString());
		//7
		Heath.completeTask();
		System.out.println(Heath.toString());
		//8
		Heath.completeTask();
		System.out.println(Heath.toString());
		System.out.println("============================");
		//9
		Heath.completeTask();
		System.out.println(Heath.toString());
		//10
		Liam.freeze(Angel);
		System.out.println(Angel.toString());
		System.out.println(Liam.toString());
		//11
			
		Liam.sabotage(Bob);
		System.out.println(Bob.toString());
		Liam.sabotage(Bob);
		System.out.println(Bob.toString());
		//12
		Liam.freeze(Bob);
		System.out.println(Bob.toString());
		System.out.println("============================");		
		//13
		//Angel.emergencyMeeting();
		//System.out.println(Liam.toString());
		//14
		System.out.println(Heath.toString());
		Liam.sabotage(Heath);
		Liam.sabotage(Heath);
		Liam.sabotage(Heath);
		Liam.sabotage(Heath);
		Liam.sabotage(Heath);
		System.out.println(Heath.toString());
		//15
		Liam.freeze(Heath);
		System.out.println(Heath.toString());*/
	}
}