import java.util.NoSuchElementException;
public class LinkedList<T> implements List<T> {
		// Always write your access modifiers
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	LinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Node<T> getHead(){
		return head;
	}

	public Node<T> getTail(){
		return tail;
	}

	public void clear(){
		/*head.setData(null);
		head.setNext(null);
		tail.setData(null);
		tail.setNext(null);*/
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty(){
		return (head == null);
	}

	public int size(){
		return size;
	}

	public void addAtIndex(T data, int index){
		if (index < 0 || index > size){
			throw new IllegalArgumentException("Your index is out of the list bounds");
		} 

		if (data == null){
			throw new IllegalArgumentException("You cannot add null data to the list");
		}

		if (size == 0){
			head = new Node<T>(data, null);
			tail = new Node<T>(data, null);
			size++;
		} else {
			if (index == 0){
				head = new Node<T>(data, head);
				size++;
			} else if (index == size){
				Node<T> temp = new Node<T>(data, null);
				Node<T> current = head;
				while (current.getNext() != null){
					current = current.getNext();
				}
				current.setNext(temp);
				tail = current.getNext();
				size++;
			} else {
				int count = 0;
				Node<T> current = this.getHead();

				while (count != index - 1){
						current = current.getNext();	
						count++;
				}
				Node<T> temp = current.getNext();
				current.setNext(new Node<T>(data, temp));
				size++;
			}
		}
		
	}

	public T getAtIndex(int index){
		if (index < 0 || index > (size - 1)){
			throw new IllegalArgumentException("Your index is out of the list bounds");
		} 

		if (index == 0){
			return head.getData();
		} else if (index == (size - 1)){
			return tail.getData();
		} else {
			int count = 0;
			Node<T> current = this.getHead();

			while (count != index){
					current = current.getNext();	
					count++;
			}
			return current.getData();
		}
	}

	public T removeAtIndex(int index){
		if (index < 0 || index > (size - 1)){
			throw new IllegalArgumentException("Your index is out of bounds");
		} 

		if (size == 1){
			T temp = tail.getData();
			head = null;
			tail = null;
			size = 0;
			return temp;
		} else { 
			if (index == 0){
				T temp = head.getData();
				Node<T> replaced = head.getNext();
				head.setNext(null);
				head.setData(null);
				head = replaced;
				size--;
				return temp;
			} else if (index == (size - 1)){
				T temp = tail.getData();
				Node<T> current = head;
				while (current.getNext().getNext() != null){
					current = current.getNext();
				}
				current.setNext(null);
				tail = current;
				size--;
				return temp;
			} else {
				int count = 0;
				Node<T> current = this.getHead();
				T temp = null;
				while (count != (index - 1) ){
						current = current.getNext();	
						count++;
				}
				temp = current.getNext().getData();
				current.setNext(current.getNext().getNext());
				size--;
				return temp;
			}
		}
		
	}

	public T remove(T data){
		if (data == null){
			throw new IllegalArgumentException("You cannot remove null data from the list");
		}

		if(isEmpty()){
			throw new NoSuchElementException("The data is not present in the list.");
		} else if (size == 1){
			T temp = tail.getData();
			head = null;
			tail = null;
			size = 0;
			return temp;
		} else {
			if (head.getData().equals(data)){
				T temp = null;	
				temp = head.getData();
				head = head.getNext();
				size--;
				return temp;
			} else if (tail.getData().equals(data)){
				T temp = tail.getData();
				Node<T> current = head;
				while(current.getNext().getNext() != null){
					current = current.getNext();
				}
				tail = current;
				tail.setNext(null);
				size--;
				return temp;
			} else {
				Node<T> current = this.getHead();
				Node<T> temp = null;
				while (current.getNext().getNext() != null){
					if (current.getNext().getData().equals(data)){
						temp = current.getNext().getNext();
						current.getNext().setNext(null);
						current.getNext().setData(null);
						current.setNext(temp);
						size--;
						return data;
					}
					current = current.getNext();
				}
			}
		}
		throw new NoSuchElementException("The data is not present in the list.");
	}
	
	public String toString(){

		Node<T> current = head;
		String result = ""; // better initialize a string type as ""

		while(current != null){
			result = result + current.getData().toString() + "\n";
			current = current.getNext();
		}
		return result;
	}
	
}