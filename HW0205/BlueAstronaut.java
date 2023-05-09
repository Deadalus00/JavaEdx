import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
	private int numTasks;
	private int taskSpeed = 1;
	private boolean taskComplete = false;

	public BlueAstronaut(String name){
		this(name, 15, 6, 10);
	}

	public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
		super(name, susLevel);
		this.numTasks = numTasks;
		this.taskSpeed = taskSpeed;
	}
	
	public void setNumTasks(int numTasks){
		this.numTasks = numTasks;
	}

	public int getNumTasks(){
		return this.numTasks;
	}

	public void setTaskSpeed(int taskSpeed){
		this.taskSpeed = taskSpeed;
	}

	public int getTaskSpeed(){
		return this.taskSpeed;
	}

	public void emergencyMeeting(){	
		Player[] players = Player.getPlayers();	
		Arrays.sort(players);

		if (this.isFrozen()) {
			return;
		} else {
			for (int starter = players.length - 1; starter >= 0; starter--){
				if (players[starter].isFrozen()){
					continue;
				} else if ( players[starter].getSusLevel() == players[starter - 1].getSusLevel()) {
					return;
				} else if (players[starter].getSusLevel() > players[starter - 1].getSusLevel()){
					players[starter].setFrozen(true);
					return;
				} 
			}
		}

		gameOver();
	}

	public void completeTask(){
		if(isFrozen()){
			return;
		}

		if (getTaskSpeed() > 20 && getNumTasks() > 2) {
		    setNumTasks(getNumTasks() - 2);
		} else if (getTaskSpeed() <= 20 && getNumTasks() > 1) {
		    setNumTasks(getNumTasks() - 1);
		} else {
		    setNumTasks(0);
		}

		if (getNumTasks() == 0 && !taskComplete){
			System.out.println("I have completed all my tasks");
			setSusLevel((int)(getSusLevel() * 0.5));
			taskComplete = true;
		}
	}

	public boolean equals(Object o){
		return (super.equals(o) && (this.getTaskSpeed() == ((BlueAstronaut)o).getTaskSpeed()) && (this.getNumTasks() == ((BlueAstronaut)o).getNumTasks()));
	}

	public String toString(){
		int numTasksString = this.getNumTasks();
		String returnString = super.toString() + String.format(" I have %d left over.", numTasksString);

		if (this.getSusLevel() > 15){
			return returnString.toUpperCase();
		} else {
			return returnString;
		}
	}
}