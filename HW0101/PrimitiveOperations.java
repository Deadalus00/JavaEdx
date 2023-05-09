//HW01 Section 1: Primative Operations
public class PrimitiveOperations{
	public static void main(String[] args){
		//First requirement
		int examInt = 42;
		System.out.println(examInt);
		double examFloat = 12.34;
		System.out.println(examFloat);
		//Second
		double examMulti = examFloat * examInt;
		System.out.println(examMulti);
		//Third
		double examInt2F = (double)examInt;
		System.out.println(examInt2F);
		//Forth
		int examF2Int = (int)examFloat;
		System.out.println(examF2Int);
		//Fifth
		char examChar = 'Q';
		System.out.println(examChar);
		//Sixth
		System.out.println((char)(examChar + 32));
	}
}