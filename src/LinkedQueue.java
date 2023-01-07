//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: LinkedQueue class - P08 DNA Transcription 

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

import java.util.NoSuchElementException;

/**
 * A generic implementation of a linked queue
 */
public class LinkedQueue<T>
extends Object
implements QueueADT<T> {

protected Node <T> back; // The node at the back of the queue, added MOST recently
protected Node <T> front; // The node at the front of the queue, added LEAST recently
private int n; // The number of elements in the queue

/**
 * Adds the given data to this queue; every addition to a queue is made at the back
 * 
 * @param data - the data to add
 */
@Override
public void enqueue(T data) {
	
	
	Node new_Node = new Node <T>(data); 
	if (this.isEmpty()) { 
		
		this.front = new_Node; 
		this.back = this.front;
	} 
	else { 
		
		this.back.setNext(new_Node);
		this.back = this.back.getNext();
	}
	
	n++;
}

/**
 * Removes and returns the item from this queue that was least recently added
 * 
 * @return front_Node - the item from this queue that was least recently added
 * 
 * @throws NoSuchElementException if this queue is empty
 */
@Override
public T dequeue() throws NoSuchElementException {
	
	if (isEmpty()) { 
		
		throw new NoSuchElementException("the queue is empty"); 
	} 
	
	Node<T> nodalVAL = front;
	
    if (this.n == 1) { 
		
	    this.front = null;
    }
    else {
    	this.front = front.getNext();
    	nodalVAL.setNext(null);
    	
    	this.front.setNext(this.front.getNext());
    }
    
    n--;
    
    return nodalVAL.getData();
} 

/**
 * Returns the item least recently added to this queue without removing it
 * 
 * @return the item least recently added to this queue
 * 
 * @throws NoSuchElementException if this queue is empty
 */
@Override
public T peek() throws NoSuchElementException{
	
	if (isEmpty()) 
		
		throw new NoSuchElementException("the queue is empty");
	
	return front.getData();

}

/**
 * Checks whether the queue contains any elements
 * 
 * @return true if this queue is empty; false otherwise
 */
@Override
public boolean isEmpty() {
	
	if (size() == 0) {
		return true;
	}
	
	return false;
}

/**
 * Returns the number of items in this queue
 * 
 * @return n - the number of items in this queue
 */
@Override
public int size() {
	
	return this.n;

} 

/**
 * Returns a string representation of this queue, beginning at the front (least recently added) 
 * of the queue and ending at the back (most recently added). An empty queue is represented 
 * as an empty string; otherwise items in the queue are represented using their data separated by spaces
 * 
 * @return str - the sequence of items in FIFO order, separated by spaces
 */
public String toString() {
	
	String str = new String("");
	Node<T> node2 = front;
	
	while (node2 != null) {
		
		str = str + node2.getData() + " ";
		node2 = node2.getNext();
	}
	
	return str;
}

}


