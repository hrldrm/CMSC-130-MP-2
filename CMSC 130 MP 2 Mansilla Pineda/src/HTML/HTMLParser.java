package HTML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Hashtable;

import Sequential.FlipFlop;

/**
 * <tt>HTMLParser</tt> is the class that will create an HTML
 * document from the state table
 * @author Harold Mansilla
 *
 */
public class HTMLParser {
	/**
	 * The State Table
	 */
	Hashtable<String, Hashtable<String, Integer>> StateTable = new Hashtable<String, Hashtable<String, Integer>>();
	/**
	 * The column headers in the State Table
	 */
	ArrayList<String> keys = new ArrayList<String>();
	/**
	 * Output variables and their equations
	 */
	Hashtable<String, String> output = new Hashtable<String, String>();
	/**
	 * The flip-flops
	 */
	Hashtable<String, FlipFlop> flipFlops = new Hashtable<String, FlipFlop>();
	/**
	 * The next state equations
	 */
	Hashtable<String, String> nextStateEquations = new Hashtable<String, String>();
	
	/**
	 * Constructor for this class
	 * @param StateTable The State Table
	 * @param keys The column headers in the State Table
	 * @param flipFlops The flip-flops 
	 * @param output The output variables and their equations
	 * @param nextStateEquations
	 */
	public HTMLParser(Hashtable<String, Hashtable<String, Integer>> StateTable, ArrayList<String> keys, Hashtable<String, FlipFlop> flipFlops, Hashtable<String, String> output, Hashtable<String, String> nextStateEquations){
		this.StateTable = StateTable;
		this.keys = keys;
		this.flipFlops = flipFlops;
		this.output = output;
		this.nextStateEquations = nextStateEquations;
		generateHTML();
	}
	
	/**
	 * <tt>generateHTML</tt> creates the HTML file containing all information for the Sequential Circuit 
	 */
	private void generateHTML(){
		String eqnsHTML = "";
		String nextStateEqnsHTML = "";
		String stateTableHTML = "";
		File file = new File("State Table.html"); //Access the file directly from the folder
		Writer fileWriter = null; //new Writer
		BufferedWriter bufferedWriter = null; //New BufferedWriter
		for(Object currFFKey : this.flipFlops.keySet()){
			for(Object currFFEqKey : this.flipFlops.get(currFFKey).flipflopEquations.keySet()){
				eqnsHTML += "<p>" + currFFEqKey.toString()
						+ " = " + this.flipFlops.get(currFFKey).flipflopEquations.get(currFFEqKey)
						+ "</p></br>";
			}
		}
		if(output.size() == 1){
			eqnsHTML += "<p>Z = " + output.get("Z") + "</br>";
		}
		stateTableHTML += "<div class=\"StateTable\">"
				+ "<table style=\"float: left;\">";
		stateTableHTML += "<tr>";
		for(Object key : this.keys){
			stateTableHTML += "<th colspan=\"2\">" + key.toString() + "</th>";
		}
		stateTableHTML += "</tr>";
		for(int i = 0; i < this.StateTable.size(); i++){
			stateTableHTML += "<tr>";
			for(Object key : this.keys){
				String output = (this.StateTable.get(Integer.toString(i)).get(key) == -1) 
					? "Indeterminate" 
					: Integer.toString(this.StateTable.get(Integer.toString(i)).get(key));
				stateTableHTML += "<td colspan=\"2\">" + output + "</td>";
			}
			stateTableHTML += "</tr>";
		}
		stateTableHTML += "</table>"
			+ "</div>";
		for(Object currKey : this.nextStateEquations.keySet()){
			nextStateEqnsHTML += "<p>" 
					+ currKey.toString() 
					+ " = " 
					+ this.nextStateEquations.get(currKey);
		}
		try{
			fileWriter = new FileWriter(file,false); //Initialize fileWriter with the file and set as overwrite (disregards the existing contents of the file)
			bufferedWriter = new BufferedWriter(fileWriter); //Initialize bufferedWriter
			bufferedWriter.write(""
					+ "<html>"
					+ "<head>"
					+ "<title>State Table</title>"
					+ "<link rel='stylesheet' href='design.css'>"
					+ "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>"
					+ "<body>"
					+ "<h1>Equations</h1>"
					+ eqnsHTML
					+ "<h1>State Table</h1>"
					+ stateTableHTML
					+ "<h1>Next State Equations</h1>"
					+ nextStateEqnsHTML
					+ "</body>"
					+ "</html>");
			bufferedWriter.close(); //Close the file
		}catch (IOException e) {
			e.printStackTrace(); //Catch errors
		}
	}
}
