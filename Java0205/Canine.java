public abstract class Canine{
		// abstract key word added
		// abstract classes CANNOT be instantiated
/*=============================================================================================================
	Notice that for Access Modifiers, we have visiability of each modifiers provide:
				Class	 Package	Subclass	World			
Public			  Y 		Y		   Y 		  Y
Protected		  Y 		Y		   Y 		  N
none/default*	  Y 		Y		   N 		  N
private			  Y 		N		   N 		  N

So the encapsulation level of visibility modifiers we have:
	Public > Protected > none/default > private;
*: Yes, it is LEGAL to create a method without giving it an access modifier. But don't use it haphazardly.
===============================================================================================================*/

	protected double size;

	public Canine(double size){
		this.size = size;
	}

	public void bark(){
		System.out.println("Woof Woof.");
	}

	public abstract void groom();
	//different subclasses have no common inheritance behaviors for the method, but such method must be 
	//inherited from superclasses, we use abstract modifiers.
	//why use abstract? An abstract class allow us to effectively use generic and undefined concepts.
	//But sometimes such behaviors varies among different subclass and share little consistency;
	//we'll just leave the concrete and undefined abstract method here and let subclasses to the details.

}