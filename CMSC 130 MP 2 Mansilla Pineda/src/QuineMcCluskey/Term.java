package QuineMcCluskey;

import java.util.ArrayList;

/**
 * <tt>Term</tt> is the class that holds the representation of a Term 
 * in a Boolean function
 * @author Harold Mansilla, Sean Pineda
 *
 */
public class Term {
	/**
	 * <tt>numOnes</tt> is the number of "1'"s in the binary representation
	 * of the minterm
	 */
	int numOnes;
	/**
	 * <tt>decimalRep</tt> is the <tt>ArrayList</tt> that holds
	 * the decimal representation of the Term
	 */
	ArrayList<Integer> decimalRep = new ArrayList<Integer>(); 
	/**
	 * <tt>binaryRep</tt> is the binary representation of the Term
	 */
	String binaryRep;
	/**
	 * <tt>termRep</tt> is the variable representation of the Term
	 */
	String termRep = "";
	/**
	 * <tt>numVar</tt> is the number of variables
	 */
	int numVar;
	/**
	 * <tt>isUsed</tt> is the boolean variable that dictates whether
	 * the Term has been used in forming succeeding terms. Hence, is
	 * not a Prime implicant
	 */
	boolean isUsed = false;
	/**
	 * <tt>termsThatCover</tt> is an <tt>ArrayList</tt> that contains the
	 * Minterms that a Prime Implicant covers
	 */
	ArrayList<Term> termsThatCover = new ArrayList<Term>();
	
	/**
	 * Single-argument constructor for initialization of a Minterm
	 * @param mintermNumber The number corresponding to the minterm
	 */
	public Term(int mintermNumber, int numVar){
		this.decimalRep.add(mintermNumber);
		this.numVar = numVar;
		this.binaryRep = Integer.toBinaryString(mintermNumber);
		String zeroes = "";
		for(int i = 0; i < numVar; i++){
			zeroes += "0";
		}
		this.binaryRep = zeroes.substring(this.binaryRep.length()) + this.binaryRep;
		countOnes(this.binaryRep);
	}
	
	/**
	 * Two-argument constructor for the initialization of a Term
	 * @param involvedMinterms An <tt>ArrayList</tt> that contains the minterms involved
	 * in the creation of this term
	 * @param binaryRep The binary representation of the term
	 */
	public Term(ArrayList<Integer> involvedMinterms, String binaryRep){
		this.decimalRep.addAll(involvedMinterms);
		this.binaryRep = binaryRep;
	}
	
	/**
	 * <tt>countOnes</tt> counts the number of "1" in the binary representation
	 * @param numberRep
	 */
	private void countOnes(String numberRep){
		for(int i = 0; i < numberRep.length(); i++){
			if(numberRep.charAt(i) == '1'){
				numOnes++;
			}
		}
	}
}
