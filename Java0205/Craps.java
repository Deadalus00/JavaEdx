
/*====================================================================================================
				Hey, before you continue reading, be sure to compare this file to 
			Insect.java in the same path/folder.
				You'll recall what you have missed in the code and the whole 
			construct of the program.
======================================================================================================*/
public class Craps{

	//Instance variables
		//Notice that it's not static so you cannot directly use it before instantiation!
	private Die die1, die2;
	private int points;

	//Constructor
	public /*220308deleted:private*/ Craps(){ // Update:CANNOT have private access modifier here since CrapsLauncher will meet access error
												// Never forget about the visiblity that access modifiers offer
		die1 = new Die();
		die2 = new Die();
	}


	//Instance methods

		//The VERB: toss() is the previous toll method for this class
		//behavior methods that return certain value other than setters and getters.
		private int toss(){
			int total = die1.roll() + die2.roll();
			System.out.println("Die1: " + die1.getFaceValue() + ", Die 2: " + die2.getFaceValue());
			System.out.println("Total points for this round is: " + total);
			return total;
		}

		//Stage 1 method since we begin with it
		//Notice this should be "public" since we would want to access from external classes()
		//like packing it in a larger package of "games".
		//update: make beginner methods "public"
		public void stage1(){
			System.out.println("Game start! Stage1!");

			points = toss();
			if (points == 11 || points == 7){
				System.out.println("We have a winner!");
			} else if (points == 2 || points == 3 || points == 12){
				System.out.println("You are Lost!");
			} else {
				System.out.println("Getting into Stage 2...");
				stage2();
			}
		}

		//Stage 2 
		//no need to make stage2 public since it's a helper method and will only be initiated
		//when stage1 is called and game cannot finish within stage 1.
		//update: if certain method must follow another method like here -- with different stages
		// we would want to make only the first method to be public so it follows the rule
		// Like (Stage1-->Stage2-->Stage3...), when the sequence for methods have been determined.
		// make successor methods private and call on them within previous successors or beginners
		private void stage2(){
			System.out.println("Game continue! Stage2!");

			points = toss();
			boolean nextRound = true;

			while (nextRound){
				int temp = toss();

				if (temp == points){
					System.out.println("We have a winner!");
					nextRound = false;
					break;
				} else if ((temp == 7)){
					System.out.println("You lost!");
					nextRound = true;
					break;
				}
			}
		}

	//MAIN method. Never forget about it.
		//Notice that a main method is always neccessary for an object class
		//Update:note that it's not neccesarry to create a main method once you just extends or implements it
		//rather than run the class in JVM.
	/*public static void main(String[] args){

		//we need to create an instance for the class to start the game, thus calling constructor.
		//after all, nouns are classes but we will have to instantiate it so that we can run it.
		Craps game1 = new Craps();

		//calling an INSTANCE method to start the game.
		game1.stage1();
	}*/

}


/*====================================================================================================
				Ok, I think you already know the key attributes of the construct now.
				But take a closer look to the access modifiers. And think about why are they
			Privates rather than public? And what would happen if we create a client class outside of 
			this Craps class and call the instance method? 
======================================================================================================*/