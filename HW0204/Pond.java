public class Pond{
	

	public static void main(String[] args){
		Frog frogPeepo = new Frog("Peepo");
		Frog frogPepe = new Frog("Pepe", 10, 15);
		Frog frogPeepaw = new Frog("Peepaw", 4.6, 5);
		Frog frogHermit = new Frog("Hermit",8, 10);

		Fly fly1 = new Fly(1, 3);
		Fly fly2 = new Fly(6);
		Fly fly3 = new Fly();

		System.out.println(frogHermit.toString());
		frogHermit.grow();
		System.out.println(frogHermit.toString());

		/*frogPeepo.setSpecies("1331 Frogs");
		System.out.println(frogPeepo.toString());
		frogPeepo.eat(fly2);
		System.out.println(fly2.toString());

		frogPeepo.grow(8);
		frogPeepo.eat(fly2);
		System.out.println(fly2.toString());
		System.out.println(frogPeepo.toString());
		System.out.println(frogHermit.toString());

		frogPeepaw.grow(4);
		System.out.println(frogPeepaw.toString());
		System.out.println(frogPepe.toString());*/
	}
}