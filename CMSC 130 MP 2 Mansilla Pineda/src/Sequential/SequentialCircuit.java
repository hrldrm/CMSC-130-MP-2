package Sequential;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SequentialCircuit {
	ArrayList<String> input = new ArrayList<String>();
	Hashtable<String, String> output = new Hashtable<String, String>();
	ArrayList<String> keys = new ArrayList<String>();
	Hashtable<String, FlipFlop> flipFlops = new Hashtable<String, FlipFlop>();
	Hashtable<String, Hashtable<String, Integer>> StateTable = new Hashtable<String, Hashtable<String, Integer>>();
	
	//TODO Create constructor which will call generateStateTable
	
	public void generateStateTable(){
		this.detKeys();
		int numVar = flipFlops.size() + input.size();
		for(int i = 0; i < Math.pow(2, numVar); i++){
			Hashtable<String, Integer> currRow = new Hashtable<String, Integer>();
			String currNum = getBinaryRep(i, numVar);
			for(int j = 0; j < numVar; j++){ //Iterate through the given variables (flip-flop states and input)
				currRow.put(keys.get(j), Integer.parseInt(currNum.substring(j, j + 1)));
			}
			for(Object currFlipFlopKey : flipFlops.keySet().toArray()){ //Iterate through all flip-flops
				for(Object currFlipFlopEq : flipFlops.get(currFlipFlopKey).flipflopEquations.keySet()){ //Iterate through all flip-flop input equations
					int eqValue = evaluateExpression(flipFlops.get(currFlipFlopKey).flipflopEquations.get(currFlipFlopEq), currRow);
					flipFlops.get(currFlipFlopKey).flipflopEqValues.put(currFlipFlopEq.toString(), eqValue); //Store the value of the flip-flop input equation
					currRow.put(currFlipFlopEq.toString(), eqValue);
				}
				//Get next state
				currRow.put(currFlipFlopKey.toString() + "(t + 1)", calculateNextState(currFlipFlopKey.toString(), currRow.get(currFlipFlopKey),flipFlops.get(currFlipFlopKey)));
			}
			if(output.size() > 0){ //If an output variable is defined
				for(Object currOutputKey : output.keySet().toArray()){
					int outputValue = evaluateExpression(output.get(currOutputKey), currRow);
					currRow.put(currOutputKey.toString(), outputValue);
				}
			}
			StateTable.put(Integer.toString(i), currRow);
		}
	}
	
	private int calculateNextState(String flipFlopName, int presentState, FlipFlop flipFlop){
		if(flipFlop.type == FlipFlopType.D){
			if(flipFlop.flipflopEqValues.get("D" + flipFlopName) == 0){
				return 0;
			}else return 1;
		}else if(flipFlop.type == FlipFlopType.T){
			if(flipFlop.flipflopEqValues.get("T" + flipFlopName) == 0){
				return presentState;
			}else return evaluateExpression("!" + Integer.toString(presentState), null);
		}else if(flipFlop.type == FlipFlopType.JK){
			if(flipFlop.flipflopEqValues.get("J" + flipFlopName) == 0 && flipFlop.flipflopEqValues.get("K" + flipFlopName) == 0){
				return presentState;
			}else if(flipFlop.flipflopEqValues.get("J" + flipFlopName) == 0 && flipFlop.flipflopEqValues.get("K" + flipFlopName) == 1){
				return 0;
			}else if(flipFlop.flipflopEqValues.get("J" + flipFlopName) == 1 && flipFlop.flipflopEqValues.get("K" + flipFlopName) == 0){
				return 1;
			}else if(flipFlop.flipflopEqValues.get("J" + flipFlopName) == 1 && flipFlop.flipflopEqValues.get("K" + flipFlopName) == 1){
				return evaluateExpression("!" + Integer.toString(presentState), null);
			}
		}else if(flipFlop.type == FlipFlopType.RS){
			if(flipFlop.flipflopEqValues.get("S" + flipFlopName) == 0 && flipFlop.flipflopEqValues.get("R" + flipFlopName) == 0){
				return presentState;
			}else if(flipFlop.flipflopEqValues.get("S" + flipFlopName) == 0 && flipFlop.flipflopEqValues.get("R" + flipFlopName) == 1){
				return 0;
			}else if(flipFlop.flipflopEqValues.get("S" + flipFlopName) == 1 && flipFlop.flipflopEqValues.get("R" + flipFlopName) == 0){
				return 1;
			}else if(flipFlop.flipflopEqValues.get("S" + flipFlopName) == 1 && flipFlop.flipflopEqValues.get("R" + flipFlopName) == 1){
				return -1;
			}
		}
		return -1;
	}
	
	private int evaluateExpression(String expression, Hashtable<String, Integer> inputVars){ //Note that this assumes that the expression is already correct in input
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        if(inputVars != null){
        	for(Object currInputKey : inputVars.keySet().toArray()){
            	if(expression.contains(currInputKey.toString())){
            		expression = expression.replace(currInputKey.toString(), inputVars.get(currInputKey).toString());
            	}
            }
        }
        try {
            if (!(engine.eval(expression) instanceof Integer)) {
                return boolToInt((boolean) engine.eval(expression));
            }
            return (int) engine.eval(expression);
        }catch (ScriptException se){
            return -1;
        }
    }
	
	private int boolToInt(boolean result){
		return (result) ? 1 : 0;
	}
	
	private String getBinaryRep(int num, int numVar){
		String binaryRep = Integer.toBinaryString(num);
		String zeroes = "";
		for(int i = 0; i < numVar; i++){
			zeroes += "0";
		}
		return zeroes.substring(binaryRep.length()) + binaryRep;
	}
	
	
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
		String JA = "!A&&(X||Y)";
		String KA = "A||B";
		String JB = "A||(X&&Y)";
		String KB = "A&&B";
		Hashtable<String,String> Ainput = new Hashtable<String,String>();
		Hashtable<String,String> Binput = new Hashtable<String,String>();
		Ainput.put("JA", JA);
		Ainput.put("KA", KA);
		Binput.put("JB", JB);
		Binput.put("KB", KB);
		FlipFlop A = new FlipFlop(FlipFlopType.JK, Ainput);
		FlipFlop B = new FlipFlop(FlipFlopType.JK, Binput);
		DFF.flipFlops.put("A", A);
		DFF.flipFlops.put("B", B);
		DFF.input.add("X");
		DFF.input.add("Y");
		DFF.generateStateTable();
		System.out.println(DFF.keys);
		System.out.println(DFF.StateTable.size());
		System.out.println(DFF.StateTable);
//		DFF.detKeys();
	}
}
