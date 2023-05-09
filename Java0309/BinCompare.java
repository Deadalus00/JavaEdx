public class BinCompare<T extends Comparable>{ // restrict the type taken in by implementing interfaces
	private T content1;
	private T content2;

	public BinCompare(T content1, T content2){
		this.content1 = content1;
		this.content2 = content2;
	}

	public T greaterValue(){
		return (content1.compareTo(content2) >= 0 ? content1 : content2);
	}

	public static void main(String[] args){
		BinCompare<String> testString = new BinCompare<>("It's a test String!","Guess which one is larger!");// be sure to use <Type> to limit the type
			//Note never forget about when creating a new object:
			 		//Class<Type> ... = new Class<>(...);
		System.out.println(testString.greaterValue());
	}
}