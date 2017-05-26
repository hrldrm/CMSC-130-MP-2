package QuineMcCluskey;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;

/**
 * <tt>QuineMcCluskey</tt> is the class containing the algorithm and
 * implementation of the Quine-McCluskey method in simplifying Boolean 
 * functions. 
 * 
 * @author Harold Mansilla, Sean Pineda
 *
 */
public class QuineMcCluskey{
	/**
	 * <tt>numVar</tt> is the number of variables that is essential in
	 * dictating the range of minterms (i.e. If there are n number of 
	 * variables, the only allowable minterms are from minterm 0 to minterm
	 * 2^n - 1 
	 */
	/**
	 * <tt>allNumbers</tt> is all the Primes input by the user
	 * to be used in the branching method
	 * **/
	public ArrayList<Integer> allNumbers = new ArrayList<Integer>();
	
	ArrayList<String> Solutions = new ArrayList <String>();
	
	public int numVar;
	
	/**
	 * <tt>allCovered</tt> is a boolean variable that stores information on
	 * the nature of the coverage of minterms by essential prime implicants.
	 * A value of FALSE means not all minterms are covered and vice versa.
	 */
	public boolean allCovered = false; 
	
	/**
	 * <tt>comparisonTable</tt> is a <tt>Hashtable</tt> of <tt>Hashtables</tt>
	 * of <tt>ArrayLists</tt>. It is simply the representation of the comparison
	 * table in the formation of Essential Prime Implicants. 
	 */
	Hashtable<String, Hashtable<String, ArrayList<Term>>> comparisonTable = new Hashtable<String, Hashtable<String, ArrayList<Term>>>();

	/**
	 * <tt>primeImplicantTable</tt> is the <tt>Hashtable</tt> of <tt>ArrayLists</tt> that
	 * represents the Prime Implicants selected from the comparison
	 */
	Hashtable<String, ArrayList<Term>> primeImplicantTable = new Hashtable<String, ArrayList<Term>>();
	
	/**
	 * <tt>essentialPrimeImplicants</tt> is the <tt>ArrayList</tt> that represents
	 * Essential Prime Implicants
	 */
	ArrayList<Term> essentialPrimeImplicants = new ArrayList<Term>();
	
	/**
	 * <tt>simplifiedExpression</tt> is the String that will hold the final simplified
	 * Boolean function after performing the Quine-McCluskey method
	 */
	public String simplifiedExpression = "";
	
	/**
	 * <tt>alphabet</tt> is the <tt>String</tt> that represents the variables
	 */
	public String alphabet;
	
	/*
	 * TODO This can be omitted if a solution is possible where the function collectSucceedingTerms also takes into account 
	 * the first column, therefore eliminating the need for a separate hashtable for the first column
	 */
	/**
	 * <tt>column1</tt> is the <tt>Hashtable</tt> of <tt>ArrayLists</tt> that represents the
	 * first column of comparison, which contain the grouping of minterms based on the 
	 * number of 0's in their binary representation
	 */
	Hashtable<String, ArrayList<Term>> column1 = new Hashtable<String, ArrayList<Term>>(); 
	
	/**
	 * <tt>minterms</tt> is the <tt>ArrayList</tt> that represents the minterms that form
	 * the boolean function
	 */
	public ArrayList<Term> minterms = new ArrayList<Term>();
	
	public QuineMcCluskey(String alphabet, ArrayList<Term> minterms){
		this.alphabet = alphabet;
		this.minterms = minterms;
		this.numVar = alphabet.length();
		this.performQuineMcCluskey();
	}
	
	/**
	 * <tt>performQuineMcCluskey</tt> is the driver function that calls all processes for
	 * the performance of the Quine-McCluskey method
	 */
	public void performQuineMcCluskey(){
		primeImplicantTable.put("Minterms", this.minterms);
		groupByNumOnes();	
		collectSucceedingTerms(column1, 2);
		detEssentialPrimeImplicants();
	}
	/**
	 * <tt>reset</tt> resets every variable and objects used inside the algorithm**
	 */
	public void reset(){
		essentialPrimeImplicants.clear();
		allNumbers.clear();
		simplifiedExpression="";
		primeImplicantTable.clear();
		comparisonTable.clear();
		allCovered=false;
		minterms.clear();
		column1.clear();
	}
	
	/**
	 * <tt>collectPrimeImplicants</tt> is the method that will collect all Prime Implicants
	 * formed from the Comparison Table. The terms in the Comparison Table are selected as
	 * Prime Implicants if they were not used in the forming of new terms in the next column
	 * of the Comparison Table
	 */
	public void collectPrimeImplicants(){
		ArrayList<Term> primeImplicants = new ArrayList<Term>();
		ArrayList<Object> keys = new ArrayList<Object>();
		keys.addAll(Arrays.asList(comparisonTable.keySet().toArray()));
		keys.sort(null);
		for(Object key : keys){
			ArrayList<Object> groupKeys = new ArrayList<Object>();
			groupKeys.addAll(Arrays.asList(comparisonTable.get(key).keySet().toArray()));
			groupKeys.sort(null);
			for(Object currKey : groupKeys){
				for(Term currTerm : comparisonTable.get(key).get(currKey)){
					if(!currTerm.isUsed) primeImplicants.add(currTerm);
				}
			}
		}
		primeImplicantTable.put("Prime Implicants", primeImplicants);
	}
	

	/**
	 *<tt>branchingMethod</tt> this function retrieves the remaining optimal solution
	 *from the remainingPrimeImplicants that are non essential
	 **/
	
	 
	public void branchingMethod(ArrayList<Term> terms){
		int counter;
		ArrayList<Term> temp = new ArrayList<Term>(essentialPrimeImplicants);
		for(int i=0; i!= temp.size();i++){
			terms.remove(temp.get(i));
		}
		for(int i=0; i!= terms.size();i++){
			for(counter = 0; counter!=terms.get(i).decimalRep.size();counter++){
				if(!allNumbers.contains(terms.get(i).decimalRep.get(counter))) break;
			}
			if(counter == terms.get(i).decimalRep.size()){
				temp.add(terms.get(i));
				for(int co = 0; co != counter; co++){
					allNumbers.remove(terms.get(i).decimalRep.get(co));
				}
			}
		}
			
		for(int k = 0; k != temp.size(); k++){
			terms.remove(temp.get(k));
		}
		
		for(int j=0; j!=terms.size();j++){
			for(counter=0; counter!=terms.get(j).decimalRep.size();counter++){
				if(allNumbers.contains(terms.get(j).decimalRep.get(counter))){
					allNumbers.remove(terms.get(j).decimalRep.get(counter));
				}	
			}
		}
		essentialPrimeImplicants.addAll(terms);
	}

	/**
	 * <tt>detEssentialPrimeImplicants</tt> is the method that will determine the Essential Prime
	 * Implicants from the previously collected Prime Implicants. This function will go through
	 * all the Prime Implicants to check if they constitute a minterm that only they cover, which
	 * is the determining factor in the selection of Essential Prime Implicants
	 */
	public void detEssentialPrimeImplicants(){
		collectPrimeImplicants();
		ArrayList<Term> mintermsTemp = new ArrayList<Term>(); //Just to keep track of minterms not yet covered
		mintermsTemp.addAll(minterms);
		/*
		 * Iterate through Prime Implicants to "cross out" minterms involved 
		 */
		for(Term currTerm : primeImplicantTable.get("Prime Implicants")){ 
			for(int j = 0; j < currTerm.binaryRep.length(); j++){
				if(currTerm.binaryRep.charAt(j) == '0') currTerm.termRep += this.alphabet.charAt(j) + "\'"; 
				else if (currTerm.binaryRep.charAt(j) == '1') currTerm.termRep += this.alphabet.charAt(j);

			}
			for(int currTermIter : currTerm.decimalRep){
				for(Term currMinterm : primeImplicantTable.get("Minterms")){
					if(currMinterm.decimalRep.contains(currTermIter)){
						currMinterm.termsThatCover.add(currTerm);
					}
				}
			}
		}
		//Iterate through all Minterms to determine which are essential prime implicants
		for(Term currMinterm : primeImplicantTable.get("Minterms")){
			if(currMinterm.termsThatCover.size() == 1){ //If there's only one "X" in the column. Meaning only one prime implicant covers this minterm
				int termIndex = primeImplicantTable.get("Prime Implicants").indexOf(currMinterm.termsThatCover.get(0));
				if(!essentialPrimeImplicants.contains(primeImplicantTable.get("Prime Implicants").get(termIndex))){ //Duplicate handling
					essentialPrimeImplicants.add(primeImplicantTable.get("Prime Implicants").get(termIndex));				
				}
				for(Term curr : minterms){
					if(primeImplicantTable.get("Prime Implicants").get(termIndex).decimalRep.contains(curr.decimalRep.get(0))){
						mintermsTemp.remove(curr);
					}
				}
			}
		}
		if(mintermsTemp.size() > 0){
			mintermsTemp = new ArrayList<Term>(primeImplicantTable.get("Prime Implicants"));
			branchingMethod(mintermsTemp);
		}else{ //Generate simplified boolean function
			allCovered = true;
		}
		for(int i = 0; i < essentialPrimeImplicants.size(); i++){
			simplifiedExpression += essentialPrimeImplicants.get(i).termRep;
			if(i < essentialPrimeImplicants.size() - 1) simplifiedExpression += "+";
		}
	}
	
	/**
	 * <tt>generateBinaryRep</tt> generates the binary representation of a formed
	 * term from 2 other terms from a previous column of comparison
	 * @param term1 The first term
	 * @param term2 The second term
	 * @return The binary representation of the newly-formed term
	 */
	public String generateBinaryRep(String term1, String term2){
		String binaryRep = "";
		for(int i = 0; i < term1.length(); i++){
			if(term1.charAt(i) == term2.charAt(i)) binaryRep += term1.charAt(i);
			else binaryRep += "-";
		}
		return binaryRep;
	}

	/**
	 * <tt>collectSucceedingTerms</tt> forms the comparison table initially from the first
	 * column. Recursive in nature, this function 
	 * @param currColumn
	 * @param key
	 */
	public void collectSucceedingTerms(Hashtable<String, ArrayList<Term>> currColumn, int key){
		ArrayList<Object> keys = new ArrayList<Object>();
		keys.addAll(Arrays.asList(currColumn.keySet().toArray()));
		keys.sort(new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2) {
				if(Integer.parseInt(o1.toString()) > Integer.parseInt(o2.toString())) return 1;
				else return -1;
			}
		});
		Hashtable<String, ArrayList<Term>> fromCurrKeyTerms = new Hashtable<String, ArrayList<Term>>();
		ArrayList<String> uniqueTerms = new ArrayList<String>();
		for(int i = 0; i < keys.size() - 1; i++){
			Object currKey = keys.get(i);
			Object nextKey = keys.get(i + 1); 
			ArrayList<Term> terms = new ArrayList<Term>();
			for(int j = 0; j < currColumn.get(currKey).size(); j++){ //Iterate through the ArrayList identified by current key
				for(int k = 0; k < currColumn.get(nextKey).size(); k++){ //Iterate through the next immediate ArrayList
					ArrayList<Integer> involvedTerms = new ArrayList<Integer>();
					boolean isValidTerm = false;
					int currDifference = 0;
					for(int l = 0; l < currColumn.get(currKey).get(j).decimalRep.size(); l++){	
						int currNum = currColumn.get(currKey).get(j).decimalRep.get(l);
						int numToCompare = currColumn.get(nextKey).get(k).decimalRep.get(l);
						/*
						 * Checks if number to compare (the one below) is greater than the
						 * current number and their difference is a power of 2.
						 * 
						 * Note that for the 3rd comparison onwards, ALL the constituent minterms
						 * involved in the prime implicants are to be checked. The condition is that
						 * their differences must be equal and a power of 2.
						 */
						if((numToCompare > currNum) && ((numToCompare - currNum) & (numToCompare - currNum - 1)) == 0){
							if(key >= 3){
								if (l == 0){
									currDifference = numToCompare - currNum;
								}else if(l > 0){
									if((numToCompare - currNum) != currDifference) break;
									else{
										if(l == currColumn.get(currKey).get(j).decimalRep.size() - 1) isValidTerm = true;
										else continue;
									}
								} 
							}else if(l == currColumn.get(currKey).get(j).decimalRep.size() - 1) isValidTerm = true;
						}else break;	
					}
					if(isValidTerm){
						involvedTerms.addAll(currColumn.get(currKey).get(j).decimalRep);
						involvedTerms.addAll(currColumn.get(nextKey).get(k).decimalRep);
						involvedTerms.sort(null);
						Term toAdd = new Term(involvedTerms, generateBinaryRep(currColumn.get(currKey).get(j).binaryRep, currColumn.get(nextKey).get(k).binaryRep));
						currColumn.get(currKey).get(j).isUsed = true;
						currColumn.get(nextKey).get(k).isUsed = true;
						if(!uniqueTerms.contains(toAdd.binaryRep)){ //Duplicate handling
							uniqueTerms.add(toAdd.binaryRep);
							terms.add(toAdd);
						}
					}	
				}
			}
			if(terms.size() > 0) fromCurrKeyTerms.put(currKey.toString(), terms);
		}
		if(fromCurrKeyTerms.size() > 0){
			this.comparisonTable.put(Integer.toString(key), fromCurrKeyTerms);
			collectSucceedingTerms(fromCurrKeyTerms, key + 1);
		}
	}
	
	/**
	 * <tt>groupByNumOnes</tt> is the method that groups the first column (the minterms)
	 * according to number of the number of ones.
	 */
	public void groupByNumOnes(){
		minterms.sort(new Comparator<Term>(){
			@Override
			public int compare(Term t1, Term t2) {
				if(t1.decimalRep.get(0) > t2.decimalRep.get(0)) return 1;
				else return -1;
			}
	    });
		for(int i = 0; i <= numVar; i++){
			ArrayList<Term> currNumList = new ArrayList<Term>();
			for(Term currTerm : minterms){
				if(currTerm.numOnes == i) currNumList.add(currTerm);
			}
			if(currNumList.size() > 0) this.column1.put(Integer.toString(i), currNumList);
		}
		comparisonTable.put("1", this.column1);
	}
}