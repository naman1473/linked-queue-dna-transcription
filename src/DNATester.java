//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: DNATester - P08 DNA Transcription 

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
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {
  
  
  
  /**
   * Tests the enqueue() and dequeue() methods
   * 
   * @return true if the methods work correctly, false otherwise
   */
  public static boolean testEnqueueDequeue() {

	    try {
	      
	    LinkedQueue <Character> dnaTester = new LinkedQueue <Character>();

	      
	      
	    try {
	        dnaTester.dequeue();
	        System.out.println("Error detected: the dequeue() method crashed as there " +
	                " is an empty queue");
	        
	        return false;
	      } 
	    
	    catch (NoSuchElementException err) {
	      }
	    
	      
	      
	      dnaTester.enqueue('G');
	      
	      if (!(dnaTester.toString().trim().equals("G"))) {
	        System.out.println("Error detected: the enqueue() method cannot add the cooresponding " +
	                " DNA letter to the empty queue");
	        
	        return false;
	      }

	      
	      
	      if (!(dnaTester.dequeue().equals('G') && dnaTester.toString().trim().equals(""))) {
	        System.out.println("Error detected: the dequeue() method cannot remove the DNA letter G " +
	                " from a queue with size 1");
	      }
	      
	
	      dnaTester.enqueue('A');
	      dnaTester.enqueue('T');
	      dnaTester.enqueue('G');
	      
	      if (!(dnaTester.toString().trim().equals("A T G"))) {
	        System.out.println("Error detected: the enqueue() method cannot add multiple DNA letters " +
	                " to a queue");
	        
	        return false;
	      }
	    
	     
	      
	      if (!(dnaTester.dequeue().equals('A') && dnaTester.toString().trim().equals("T G"))) {
	        System.out.println("Error detected: the dequeue() method cannot remove the DNA letter " +
	                " from a queue with more than one letter in it");
	        
	        return false;
	      }

	      return true;

	    } catch (Exception err) {
	    	System.out.println("The testEnqueueDequeue method incurred some type of error");
	      
	        return false;
	    }
  }
  
  /**
   * Tests the size() and isEmpty() methods
   * 
   * @return true if the methods work correctly, false otherwise
   */
  public static boolean testQueueSize() {

	    try {
	      
	      LinkedQueue<Character> dnaTester = new LinkedQueue<Character>();
          LinkedQueue<Character> dnaTester2 = new LinkedQueue<Character>();
	      
          dnaTester2.enqueue('A');
	      dnaTester2.enqueue('U');
	      dnaTester2.enqueue('T');
	      dnaTester2.enqueue('G');

	      
	      try {
	        
	       if (!dnaTester.isEmpty()) {
	          
	    	   return false;
	        }
	      } 
	      catch (Exception err) {
	        System.out.println("Error detected: the isEmpty() method doesn't work for an empty queue"); 
	      }
	      
	      try {
		        
		    	if (dnaTester2.isEmpty()) {
		          
		    	  return false;
		        }
		      } 
		      catch (Exception err) {
		        System.out.println("Error detected: the isEmpty() method doesn't work for a " +
		                "non-empty queue");
		      }
	      
	      
	      try {
	        
	    	if (dnaTester.size() != 0) {
	          
	    		return false;
	        }
	      } 
	      catch (Exception err) {
	        System.out.println("Error detected: the size of the singlylinked list dnaTester is incorrect "
	        		+ "for an empty queue"); 
	      }

	      
	      try {
	        
	       if (dnaTester2.size() != 4) {
	          
	    	   return false;
	        }
	      } 
	      catch (Exception err) {
	        System.out.println("Error detected: the size of the singlylinked list dnaTester is incorrect " 
	                + "for a valid queue");
	      }
	      
	      return true;
	    } 
	    catch (Exception err) {
	    	System.out.println("The size() and isEmpty() method incurred some type of error");
	      
	        return false;
	    }
  }
  
  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    
	DNA dnaTest = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(dnaTest.transcribeDNA().toString());
    if (!(dnaTest.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA))) {
      return false;
    }
   
    DNA dnaTest2 = new DNA("");
    String mRNACopy = "";
    System.out.println(dnaTest2.transcribeDNA().toString());
    if (!(dnaTest2.transcribeDNA().toString().replaceAll(" ", "").equals(mRNACopy))) {
      return false;
    }
    
    return true;
  }
  
  /**
   * Tests the testMRNATranslate() method
   * 
   * @return true if and only if the method works correctly, false otherwise
   */
  public static boolean testMRNATranslate() {

    DNA dnaTest = new DNA("GGAGTCAGTTAAGCG");
    
	LinkedQueue <Character> mRNAtester = dnaTest.transcribeDNA();
    
	if (!(dnaTest.mRNATranslate(mRNAtester).toString().trim().
            replaceAll(" ", "").equals("PQSIR"))) {
      System.out.println("Error detected: the testMRNATranslate() method doesn't work for this case");
              
      return false;
    }

    
	DNA dnaTest2 = new DNA("GGAGTCAGTTAAGCGC");
    
	LinkedQueue <Character> mRNAtester2 = dnaTest2.transcribeDNA();
    
	if (!(dnaTest2.mRNATranslate(mRNAtester2).toString().trim().
            replaceAll(" ", "").equals("PQSIR"))) {
      System.out.println("Error detected: the testMRNATranslate() method doesn't work for a " +
              "case whose total number of DNA letters isn't a multiple of 3");
      return false;
    }

    
    DNA dnaTest3 = new DNA("GGAGTCAGTATCTAAGCG");
    
    LinkedQueue <Character> mRNAtester3 = dnaTest3.transcribeDNA();
    
    if (!(dnaTest3.mRNATranslate(mRNAtester3).toString().trim().
            replaceAll(" ", "").equals("PQS"))) {
      System.out.println("Error detected: the testMRNATranslate() method doesn't work for a case with a STOP");
              
      return false;
    }

    return true;
  }
   
  
  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA dnaTest = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(dnaTest.translateDNA().toString());
    if (!(dnaTest.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD"))) {
      return false;
    }
   
    
    DNA dnaTest2 = new DNA("");
    System.out.println(dnaTest2.translateDNA().toString());
    if (!(dnaTest2.translateDNA().toString().replaceAll(" ", "").equals(""))) {
      return false;
    }
   
    
    DNA dnaTest3 = new DNA("GGAGTCAGTTA");
    System.out.println(dnaTest3.translateDNA().toString());
    if (!(dnaTest3.translateDNA().toString().replaceAll(" ", "").equals("PQS"))) {
      return false;
    } 
    
    DNA dnaTest4 = new DNA("GGAGTCACTAGTTAA");
    System.out.println(dnaTest4.translateDNA().toString());
    if (!(dnaTest4.translateDNA().toString().replaceAll(" ", "").equals("PQ"))) {
      return false;
    }

     return true;
  }
  
 /**
   * Runs all the testers
   *
   * @return true if all testers work, false otherwise
   */
  public static boolean runAllTests() {
    return (testEnqueueDequeue() && testQueueSize() && testTranscribeDNA() &&
    		testMRNATranslate() && testTranslateDNA());
  }

  
  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }

}