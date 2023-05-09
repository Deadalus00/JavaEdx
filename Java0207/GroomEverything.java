public class GroomEverything{
	public static void main(String[] args){
		Groomable[] groomer = { 	 //Canine class is abstract
			new Wolf(2, 15.1),
			new Poodle("Dandeline", 5,"Lux","Glowing"),
			new Wolf(3, 13),
			new Poodle("Daisy", 4.5,"Shinny","Splendid"),
			new Car("Toyota","GR yaris", 2023)

		};	// array different types shows flexibility in inheritance.

		for (Groomable g : groomer){  //for (TypeElement Array : Element) //oboemashou
			g.groom();
			g.pay();
		}
	}

}

//line 10:
// note that if you set type as Object here and call groom() method will meet a compile time error
// cannot find symbol
// because it's clear that there is no such groom method in Object class but we want to implement it
// and even take other classes that have no inheritance relationship with Canine array here.
// We'll need interface then.
// In a nutshell, interface == when you want to call similar methods to different non-inherited classes.
// like grooming poodle and wolves inherited from Canine and cars that obviously a non-Canine.