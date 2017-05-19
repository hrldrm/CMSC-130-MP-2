package Sequential;

import java.util.ArrayList;
import java.util.Hashtable;

public class SequentialCircuit {
	ArrayList<String> input = new ArrayList<String>();
	Hashtable<String, String> output = new Hashtable<String, String>();
	ArrayList<String> keys = new ArrayList<String>();
	Hashtable<String, FlipFlop> flipFlops = new Hashtable<String, FlipFlop>();
	Hashtable<String, Hashtable<String, Integer>> StateTable = new Hashtable<String, Hashtable<String, Integer>>();
	
	/**
	 * <tt>detKeys()</tt> determines the keys (column headers) for the state table.
	 * It is dependent on the number of flip-flop equations, number of input variables,
	 * and an output variable (if any)
	 */
	public void detKeys(){
		for(int i = 0; i < flipFlops.keySet().toArray().length; i++){
			//TODO Optimize?
			keys.add(flipFlops.keySet().toArray()[i].toString());
		}
		if(input.size() > 0){ //Get all input variable names
			for(String currInput : input){
				keys.add(currInput);
			}
		}
		for(Object currKey : flipFlops.keySet().toArray()){ //Iterate thorugh all flip-flops
			for(Object currFlipFlopEq : flipFlops.get(currKey).flipflopEquations.keySet().toArray()){ //Iterate through all flip-flop input equations
				keys.add(currFlipFlopEq.toString());
			}
		}
		for(int i = 0; i < flipFlops.keySet().toArray().length; i++){
			//TODO Optimize?
			keys.add(flipFlops.keySet().toArray()[i].toString() + "(t + 1)"); //Next state
		}
		if(output.size() == 1){
			keys.add(output.keySet().toArray()[0].toString());
		}
	}
	
	//TEST
	public static void main(String[] args){
		SequentialCircuit DFF = new SequentialCircuit();
		String DA = "X||Y";
		Hashtable<String,String> Dinput = new Hashtable<String,String>();
		Dinput.put("DA", DA);
		FlipFlop A = new FlipFlop(FlipFlopType.D, Dinput);
		DFF.flipFlops.put("A", A);
		DFF.input.add("X");
		DFF.input.add("Y");
		DFF.output.put("Z", "X&&!Y||!A!B");
		DFF.detKeys();
		System.out.println(DFF.keys);
	}
}
