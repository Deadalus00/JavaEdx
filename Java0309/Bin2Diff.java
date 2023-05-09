public class Bin2Diff<X,Y>{ // 2_type compartment type
	private X content1;
	private Y content2;

	public Bin2Diff(X content1, Y content2){
		this.content1 = content1;
		this.content2 = content2;
	}


	public static void main(String[] args){
		Bin2Diff<String,Car> test = new Bin2Diff("Car the String", new Car("String","The car", 2023));
	}
}