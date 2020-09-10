
public class DoubleList<T> {
	
	private DoubleNode<T> front, rear;
	private int count;
	
	public DoubleList () {
		front = null;
		rear = null;
		count = 0;
	}
	
	public void addToRear (T element) {
		
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		
		if (front == null) {
			// Empty list.
			front = newNode;
			rear = newNode;
		} else {
			// Non-empty list.
			rear.setNext(newNode);
			newNode.setPrevious(rear);
			rear = newNode;
		}
		
		count++;
		
	}

	public DoubleNode<T> traverseForwards (int numToTraverse) {
		if (front == null) return null;
		
		DoubleNode<T> curr = front;
		
		for (int i = 0; i < numToTraverse; i++) {
			curr = curr.getNext();
		}

		return curr;
	}
	
	public DoubleNode<T> traverseBackwards (int numToTraverse) {
		if (front == null) return null;
		
		DoubleNode<T> curr = rear;
		
		for (int i = 0; i < numToTraverse; i++) {
			curr = curr.getPrevious();
		}
	
		return curr;
	}

	public DoubleNode<T> getNode (int index) {
		
		if (index < 0 || index >= count) {
			throw new DoubleListException("Invalid index");
		}
		
		
		if (index == 0) {
			return front;
		} else if (index == count - 1) {
			return rear;
		}
		

		if (index <= (count/2)) {
			// First half of list => traverse from front.
			return traverseForwards(index);
		} else {
			// Second half of list => traverse from rear.
			return traverseBackwards(count-index-1);
		}

	}
	
	public void setElement (int index, T element) {
		getNode(index).setElement(element);
	}
	
	public T getElement (int index) {
		return getNode(index).getElement();
	}
	
	
	public String toString () {
		String str = "";
		
		if (front == null) return "Empty list";
		
		DoubleNode<T> curr = front;
		
		while (curr != null) {
			str += curr + " ";
			curr = curr.getNext();
		}
		return str;
	}

}
