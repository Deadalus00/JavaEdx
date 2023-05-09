public class Test{
	public static void main(String[] args){
		LinkedList myList = new LinkedList<>();
		myList.addAtIndex("Yes",0);
		myList.addAtIndex("Head",0);		
		myList.addAtIndex("Test Index 1",1);
		myList.addAtIndex("TAIL",myList.size());
		myList.addAtIndex("MEDIAN",myList.size()/2);
		System.out.println(myList.toString());
		System.out.println("Current Head: " + String.valueOf(myList.getHead().getData()) + myList.size());
		System.out.println("Current Tail: " + String.valueOf(myList.getTail().getData()) + myList.size());
	}
}
