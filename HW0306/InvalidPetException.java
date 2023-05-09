import java.io.IOException;
public class InvalidPetException extends IOException{
	public InvalidPetException(){
		super("Your pet is invalid!");
	} 

	public InvalidPetException(String s){
		super(s);
	} 
}