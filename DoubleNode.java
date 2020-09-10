public class DoubleNode<T>{
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	private T element;

	/**
	 * Constructor with no input parameters.
	 */
	public DoubleNode(){
		next = null;
		previous = null;
		element = null;
	}
	/**
	 * Constructor with one input parameter representing the node's data element.
	 * @param elem
	 */
	public DoubleNode (T elem){
		next = null;
		previous = null;
		element = elem;
	}
	/**
	 * Get the next node.
	 * @return next node
	 */
	public DoubleNode<T> getNext(){
		return next;
	}
	/**
	 * Get the previous node.
	 * @return previous node
	 */
	public DoubleNode<T> getPrevious(){
		return previous;
	}
	/**
	 * Set the next node.
	 * @param node
	 */
	public void setNext (DoubleNode<T> node){
		next = node;
	}
	/**
	 * Set the previous node.
	 * @param node
	 */
	public void setPrevious (DoubleNode<T> node){
		previous = node;
	}
	/**
	 * Get the data element.
	 * @return data element.
	 */
	public T getElement(){
		return element;
	}
	/**
	 * Set the data element.
	 * @param elem
	 */
	public void setElement (T elem){
		element = elem;
	}
	/**
	 * Return the node's data element for printing purposes.
	 * @return string of node's data element
	 */
	public String toString () {
		return element.toString();
	}
}

