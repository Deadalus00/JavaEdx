public class GenericLinkedList<E>{ // we don't implement interfaces here
		//Inner class Node
	private class Node<E>{	//Inner class, it's LEGAL.
		E data;
		Node<E> next;

		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}

	//create instance var using Inner Class:
	private Node<E> head; // the only ins var of the list;

	//Constructor
	public GenericLinkedList(){
		head = null; // This means the list starts off empty.
	}

	public boolean isEmpty(){
		return (head == null); //list is empty if the head is null;
	}

	public void addToFront(E newdata){
		head = new Node<E>(newdata, head); // set this as head
	}

	public void addToRear(E newdata){
			//: create node and current at first.
			Node<E> node = new Node<>(newdata, null);
			Node<E> current = head;
		if (isEmpty()){
			//head = new Node<E>(newdata, head); // such modification would make code easier to read
			head = node;
		} else {
			//E current = head;
			while (current.next != null){
				current = current.next;
			}
			current.next = node;
		}
	}

	public String toString(){

		Node<E> current = head;
		String result = ""; // better initialize a string type as ""

		while(current != null){
			result = result + current.data.toString() + "\n";
			current = current.next;
		}
		return result;
	}

	public boolean contains(E target){
			//: simply check if the list is empty first, if so return false.
			if (isEmpty()){
				return false;
			}

		Node<E> current = head;
		//boolean found = false; // I think it's not neccesary to put a boolean here

		while ((current != null) /*&& !found*/){
			if (target.equals(current.data)){
				//found = true;
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}

	public E removeFromFront(){
		if (isEmpty()){
			return null;
		} else {
			E removeData = head.data;
		
			head.data = head.next.data;
			head.next = head.next.next;
			return removeData;
		}
		
	}

	public E removeFromRear(){
		if (isEmpty()){
			return null;
		} else {
			Node<E> current = head;
			E removeData;
			while (current.next != null){
				if (current.next.next == null){
					removeData = current.next.data;
					current.next = null;
					return removeData;
				}
				//: NOTE: You forgot this line below, which makes the loop stays at the head and cannot continue.
					current = current.next;	
			}
			removeData = head.data;
			head.data = null;
			return removeData;
		}
		
	}

	public static void	main(String[] args){
		GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
        favBabySongs.addToFront("Humpty Dumpty");
        favBabySongs.addToRear("Swing Low Sweet Chariot");
        favBabySongs.addToFront("Itsy Bitsy Spider");
        favBabySongs.addToRear("Twinkle, Twinkle Little Star");
        favBabySongs.addToFront("Wheels on the Bus");
        favBabySongs.removeFromFront();
        favBabySongs.removeFromRear();
        System.out.println(favBabySongs.toString());
        System.out.println(favBabySongs.contains("Humpty Dumpty"));
        System.out.println(favBabySongs.contains("Baby Shark"));
	}
}

//Node is an example of a private inner class. 
//It has no application beyond its use as a storage element of GenericLinkedList, 
//so it is contained in that very class. 