//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: DNA class - P08 DNA Transcription 

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

public class DNA extends Object {
	
	protected LinkedQueue<Character> DNA = new LinkedQueue<Character>(); 
	
	protected static String[][] mRNAtoProteinMap =
		  {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
		   {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
		   {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
		   {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
		   {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
		   {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
		   {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
		   {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
		   {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
		   {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
		   {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};
	
	/**
	   * Creates the DNA queue from the provided String. Each Node contains a single Character from the sequence.
	   *
	   * @param sequence - a String containing the original DNA sequence
	   */
	public DNA (String sequence) {
		
		for (int a = 0; a < sequence.length(); a++) {
		      char dnaSequencing = sequence.charAt(a);
		      DNA.enqueue(dnaSequencing);
		    }
	}
	
	/**
	   * Creates and returns a new queue of mRNA characters from the stored DNA. The transcription is done 
	   * one character at a time, as (A->U, T->A, C->G, G->C).
	   *
	   * @return newDNA - the queue containing the mRNA sequence corresponding to the stored DNA sequence
	   */
	public LinkedQueue <Character> transcribeDNA() {

	    LinkedQueue <Character> newDNA = new LinkedQueue <Character> ();

	    for (int a = 0; a < DNA.size(); a++) {
	      
	      char dnaLetter = this.DNA.dequeue();

	      if (dnaLetter == 'A') {
	        newDNA.enqueue('U');
	      }
	      else if (dnaLetter == 'T') {
	        newDNA.enqueue('A');
	      }
	      else if (dnaLetter == 'G') {
	        newDNA.enqueue('C');
	      }
	      else if (dnaLetter == 'C') {
	        newDNA.enqueue('G');
	      }
	      else {
	        System.out.println("the given letter is invalid");
	      }
	      
	      this.DNA.enqueue(dnaLetter);
	    }
	    
	    return newDNA;
	  }
	
	/**
	   * Creates and returns a new queue of amino acids from a provided queue of mRNA characters. 
	   * The translation is done three characters at a time, according to the static mRNAtoProteinMap 
	   * provided above. Translation ends either when you run out of mRNA characters OR when a STOP 
	   * codon is reached (i.e. the three-character sequence corresponds to the word STOP in the map, rather 
	   * than a single amino acid character).
	   * 
	   * @param mRNA - a queue containing the mRNA sequence corresponding to the stored DNA sequence
	   *
	   * @return aminoAcidsQueue - the queue containing the amino acid sequence corresponding to the provided mRNA sequence
	   */
	public LinkedQueue <String> mRNATranslate(LinkedQueue <Character> mRNA) {
		
		int dnaLoop = mRNA.size();
		
		LinkedQueue <String> aminoAcidsQueue = new LinkedQueue <String>();
		
	    for (int a = 0; a < dnaLoop; a++) { 
	      String stringMRNA = "";
	      
	      if (mRNA.size() >= 3) {
	        for (int b = 0; b < 3; b++) {
	          
	          Character dnaLetter = mRNA.dequeue();
	          stringMRNA = stringMRNA + dnaLetter;
	        }

	        for (int c = 0; c < (mRNAtoProteinMap.length); c++) {
	          if (mRNAtoProteinMap[c][0].equals(stringMRNA)) {
	            if (mRNAtoProteinMap[c][1].equals("STOP")) {
	              return aminoAcidsQueue;
	            } 
	            else {
	              aminoAcidsQueue.enqueue(mRNAtoProteinMap[c][1]);
	            }
	          }
	        }
	      }
	    }
	    
		return aminoAcidsQueue;
	}
	
	/**
	   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using 
	   * the other two methods in this class
	   *
	   * @return mRNATranslator - the queue containing the amino acid sequence corresponding to the stored DNA 
	   * sequence, via its mRNA transcription
	   */
	public LinkedQueue <String> translateDNA() {

	    LinkedQueue <Character> DNAtranscriber = transcribeDNA();
	    
	    LinkedQueue <String> mRNATranslator = mRNATranslate(DNAtranscriber);

	    return mRNATranslator;

	  }
	
}
	
	
	
	
	
	
	
	



	
	

	
	



