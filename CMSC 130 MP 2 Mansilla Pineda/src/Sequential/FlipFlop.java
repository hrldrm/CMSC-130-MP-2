package Sequential;

import java.util.Hashtable;

public class FlipFlop {
	public FlipFlopType type;
	public Hashtable<String, String> flipflopEquations = new Hashtable<String, String>();
	public Hashtable<String, Integer> flipflopEqValues = new Hashtable<String, Integer>();
	
	
	public FlipFlop(FlipFlopType type, Hashtable<String, String> inputEquations){
		this.type = type;
		for(Object currKey : inputEquations.keySet().toArray()){
			this.flipflopEquations.put(currKey.toString(), inputEquations.get(currKey));
		}
	}	
}
