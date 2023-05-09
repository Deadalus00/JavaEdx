import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
	private String skill;

	public String getSkill(){
		return skill;
	}

	public void setSkill(String skill){
		this.skill = skill;
	}
	public RedAstronaut(String name){
		this(name, 15, "experienced");
	}

	public RedAstronaut(String name,int susLevel,String skill){
		super(name, susLevel);
		this.skill = skill;
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
				} else if (players[starter].getName() == this.getName() || players[starter].getSusLevel() == players[starter - 1].getSusLevel()) {
					return;
				} else if (players[starter].getSusLevel() > players[starter - 1].getSusLevel()){
					players[starter].setFrozen(true);
					return;
				} 
			}
		}

		gameOver();
	}

	public void freeze(Player p){
		if ((p instanceof RedAstronaut) || this.isFrozen() || p.isFrozen()){ //note: check whether an object is an instance of certain class, use "instanceof"
			return;
		} 

		if (p.getSusLevel() > this.getSusLevel()){
			p.setFrozen(true);
		} else {
			this.setSusLevel(this.getSusLevel() * 2);
		}

		gameOver();
	}

	public void sabotage(Player p){
		if ((p instanceof RedAstronaut) || this.isFrozen() || p.isFrozen()){ //note: check whether an object is an instance of certain class, use "instanceof"
			return;
		} 

		if (this.getSusLevel() < 20){
			p.setSusLevel((int)(p.getSusLevel() * 1.5));
		} else {
			p.setSusLevel((int)(p.getSusLevel() * 1.25));
		}


	}

	public boolean equals(Object o){
		return (super.equals(o) && (this.getSkill() == ((RedAstronaut)o).getSkill()));
	}

	public String toString(){
		String skillString = this.getSkill();
		String returnString = super.toString() + String.format(" I am an %s player!", skillString);

		if (this.getSusLevel() > 15){
			return returnString.toUpperCase();
		} else {
			return returnString;
		}
	}
}