public class Bin<T> { //T means type; E for Elements...so on.
	private T content;

	public Bin(T content){
		this.content = content;
	}

	public T getContent(){
		return content;
	}

	public void setContent(T content){
		this.content = content;
	}

	public String toString(){
		//:
		return content.toString(); 
			//return this.toString();
		//NOTE: this. means call method from where the code is written, i.e. in this situation the Bin class
		// and content. means call method from the actual class of the variable, i.e. the Dog class.
	}

	public static void main(String[] args){
			//:
			Bin<String> test = new Bin<>("A test string.");
			test.setContent("Tall and tanned.");
			System.out.println(test);
		/*test.setContent(new YellowJacket(1,4));
		test.setContent(new Car("A","B",123));
		((Cat)test.getContent()).groom();
		System.out.println(test.getContent());*/
		//:
			Bin<Dog> testDog = new Bin<>(new Dog("Daisy", 4.0, 4));
			System.out.println(testDog.toString());
	}
}