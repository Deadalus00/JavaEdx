private class Node<E>{
	E data;
	Node<E> next;//next instance variable is self-referential
		//because logically speaking, the next object is exactly another Node<E> type instance

	Node(E data, Node<E> next){
		this.data = data;
		this.next = next;
	}
}

//note that the node class is private so no access modifiers
//if list is empty, head, the very first node of list, will be null.
