//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: Node class - P08 DNA Transcription 

// Course: CS 300 Spring 2022

//

// Author: Naman Parekh

// Email: ncparekh@wisc.edu

// Lecturer: Hobbes Legault

//

//

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////

//

// Persons: NONE

// Online Sources: NONE

//

///////////////////////////////////////////////////////////////////////////////



/**
 * A generic class specifying the basics of a singly-linked node for a linked queue.
 */
public class Node<T> {

    private T data; // The data contained in the Node
    private Node<T> next; // The Node following this one

    /**
     * Basic constructor; creates a node that contains the provided data and no linkages.
     * 
     * @param data - the data contained in the node
     */
    public Node(T data) { 
		
		this.data = data; 
}

	
    /**
     * A constructor that allows specification of the next node in the chain
     * 
     * @param data - the data contained in the node
     * @param next - the node following this one
     */
	public Node(T data, Node<T> next) { 
		
		this.data = data;
		this.next = next;
}

	/**
     * Accessor method for this node's data
     * 
     * @return the data contained in this node
     */
    public T getData() { 
		
		return this.data;
}

    /**
     * Accessor method for the node following this one
     * 
     * @return the next node
     */
    public Node<T> getNext() { 
		
		return this.next;
}
	
    /**
     * Mutator method for the node following this one
     * 
     * @param next - the node to follow this one
     */
    public void setNext(Node<T> next) { 
		
		this.next = next;
}


}
