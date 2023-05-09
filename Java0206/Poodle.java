public class Poodle extends Dogs {
	//instance var
	private String favoriteShampoo;
	private String favoriteConditioner;
	
	//constructor
	public Poodle(String name, double size, String favoriteShampoo, String favoriteConditioner){
		super(name, size);//inherit superclass' constructor
		this.favoriteShampoo = favoriteShampoo;
		this.favoriteConditioner = favoriteConditioner;
	}

	//helper methods
	public void groom(){
		System.out.println(name + " loves: " + favoriteConditioner + " and " + favoriteShampoo);
	}
	
}