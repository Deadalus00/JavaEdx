public class Repeater {
	
	public static void main(String[] args) {
		repeatString("Something",1024);
	}

	public static void repeatString(string toRepeat, int times){
		if (times <= 0){. // terminating logic must above recursive call so we can reach it
			return ;
		}
		System.out.println(toRepeat);
		repeatString(toRepeat, times--); // recursive call; and decrementing of parameter.
	}
}