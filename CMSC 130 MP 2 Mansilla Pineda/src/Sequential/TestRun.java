package Sequential;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestRun {
	public static void main(String args[]){
		TestRun test = new TestRun();
		System.out.println(test.evaluateExpression("~(0||1)"));
	}
	
	private int evaluateExpression(String expression){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            /*if (!(engine.eval(expression) instanceof Integer)) {
                return boolToInt((boolean) engine.eval(expression));
            }*/
            return (int) engine.eval(expression);
        }catch (ScriptException se){
            return -1;
        }
    }
}

//package Sequential;
//
//import java.util.ArrayList;
//import java.util.Hashtable;
//
//public class TestRun {
//	public static void main(String args[]){
//		Hashtable<String, String> flipflopEqs = new Hashtable<String, String>();
//		ArrayList<String> inputs = new ArrayList<String>();
//		inputs.add("X");
//		inputs.add("Y");
//		String DA = "A+B";
//		String DB = "A&B+X'Y'";
//		String Z = "X+Y+AB";				
//	}
//}
