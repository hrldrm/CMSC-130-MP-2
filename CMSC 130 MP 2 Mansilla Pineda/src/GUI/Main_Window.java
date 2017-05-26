package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Sequential.FlipFlop;
import Sequential.FlipFlopType;
import javax.swing.JTextArea;

/**
 * <tt>Main_Window</tt> is the class containing the Graphical User Interface (GUI)
 * of the program
 * @author Harold Mansilla
 * @author Sean Pineda
 *
 */

//TODO Accept all user equations
public class Main_Window {
	
	String A1="";
	String A2="";
	String B1="";
	String B2="";
	String C1="";
	String C2="";
	String X="";
	String Y="";
	String Z="";
	
	private int numFlip=0;
	private int numInput=0;
	private int numOutput=0;
	private int numIndex=0;
	String inputEquation;
	FlipFlopType type;
	Hashtable<String, Hashtable<String, FlipFlop>> flipFlops = new Hashtable<String, Hashtable<String, FlipFlop>>();
	Hashtable<String, String> outputEquations = new Hashtable<String, String>();
	private JFrame frmClockedSequentialCircuits;
	
	private JPanel CanvasPanel;
	private JPanel TypeAndNumberPanel;
	private JPanel DInputPanel;
	private JPanel TInputPanel;
	private JPanel OutputVarPanel;
	private JPanel DynamicPanel;
	
	JButton generateButton;
	JButton openButton;
	
	private JComboBox cbNumberOfFlipFlops;
	private JComboBox cbFFType;
	private JComboBox cbNumberInput;
	private JComboBox cbNumberOutput;
	
	private JLabel lblTypeOfFlipflop;
	private JLabel lblNumberOfFlipFlops;
	private JLabel lblEquationsForOutput;
	private JLabel lblNumberOfInput; 
	private JLabel lblNumberOfOutput;
	private JTextArea A2TextArea;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblZ;
	private JTextArea A1TextArea;
	private JTextArea XTextArea;
	private JTextArea YTextArea;
	private JTextArea ZTextArea;
	private JLabel lblA1;
	private JLabel lblA2;
	private JLabel lblB1;
	private JTextArea B1TextArea;
	private JTextArea B2TextArea;
	private JLabel lblB2;
	JTextArea C1TextArea;
	JLabel lblC1;
	JTextArea C2TextArea;
	JLabel lblC2;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window window = new Main_Window();
					window.frmClockedSequentialCircuits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Window() {
		initialize();
	}
	
	public void morph(){
		switch(numIndex){
		case 0:// D 
				switch(numFlip){
				case 0:
					lblA1.setText("DA");
					lblA1.setBounds(15, 16, 69, 20);
					A1TextArea.setVisible(true);
					A1TextArea.setBounds(59, 16, 541, 20);
					lblX.setBounds(15, 52, 69, 20);
					XTextArea.setBounds(59, 52, 541, 22);
					lblA2.setVisible(false);
					A2TextArea.setVisible(false);
					lblB1.setVisible(false);
					B1TextArea.setVisible(false);
					lblB2.setVisible(false);
					B2TextArea.setVisible(false);
					lblC1.setVisible(false);
					C1TextArea.setVisible(false);
					lblC2.setVisible(false);
					C2TextArea.setVisible(false);
					switch(numInput){
					case 0:
						switch(numOutput){
						case 0:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 318);
							openButton.setBounds(309, 92, 115, 29);
							generateButton.setBounds(184, 92, 115, 29);
							lblY.setVisible(false);
							YTextArea.setVisible(false);
							lblZ.setVisible(false);
							ZTextArea.setVisible(false);
							;
							break;
						case 1:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
							openButton.setBounds(309, 128, 115, 29);
							generateButton.setBounds(184, 128, 115, 29);
							lblY.setVisible(false);
							YTextArea.setVisible(false);
							lblZ.setBounds(15, 88, 69, 20);
							lblZ.setVisible(true);
							ZTextArea.setBounds(59, 88, 541, 22);
							ZTextArea.setVisible(true);
							break;
						default: break;
						}
						break;
					case 1:
						switch(numOutput){
						case 0:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
							openButton.setBounds(309, 128, 115, 29);
							generateButton.setBounds(184, 128, 115, 29);
							lblY.setBounds(15, 88, 69, 20);
							lblY.setVisible(true);
							YTextArea.setBounds(59, 88, 541, 22);;
							YTextArea.setVisible(true);
							lblZ.setVisible(false);
							ZTextArea.setVisible(false);
							;
							break;
						case 1:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
							openButton.setBounds(309, 164, 115, 29);
							generateButton.setBounds(184, 164, 115, 29);
							lblY.setBounds(15, 88, 69, 20);
							lblY.setVisible(true);
							YTextArea.setBounds(59, 88, 541, 22);;
							YTextArea.setVisible(true);
							lblZ.setBounds(15, 124, 69, 20);
							lblZ.setVisible(true);
							ZTextArea.setBounds(59, 124, 541, 22);
							ZTextArea.setVisible(true);
							break;
						default: break;
						}
						break;
					default: break;
					}
					break;
				case 1:
					lblA1.setText("DA");
					lblA1.setBounds(15, 16, 69, 20);
					A1TextArea.setVisible(true);
					A1TextArea.setBounds(59, 16, 541, 20);
					lblB1.setText("DB");
					lblB1.setBounds(15, 52, 69, 20);
					lblB1.setVisible(true);
					B1TextArea.setBounds(59, 52, 541, 20);
					B1TextArea.setVisible(true);
					lblX.setBounds(15, 88, 69, 20);
					XTextArea.setBounds(59, 88, 541, 22);
					lblC1.setVisible(false);
					C1TextArea.setVisible(false);
					lblA2.setVisible(false);
					A2TextArea.setVisible(false);
					lblB2.setVisible(false);
					B2TextArea.setVisible(false);
					lblC2.setVisible(false);
					C2TextArea.setVisible(false);
					switch(numInput){
					case 0:
						switch(numOutput){
						case 0:						
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
							openButton.setBounds(309, 128, 115, 29);
							generateButton.setBounds(184, 128, 115, 29);
							lblY.setVisible(false);
							YTextArea.setVisible(false);
							lblZ.setVisible(false);
							ZTextArea.setVisible(false);
							;
							break;
						case 1:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
							openButton.setBounds(309, 164, 115, 29);
							generateButton.setBounds(184, 164, 115, 29);
							lblY.setVisible(false);
							YTextArea.setVisible(false);
							lblZ.setBounds(15, 124, 69, 20);
							lblZ.setVisible(true);
							ZTextArea.setBounds(59, 124, 541, 22);
							ZTextArea.setVisible(true);
							break;
						default: break;
						}
						break;
					case 1:
						switch(numOutput){
						case 0:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
							openButton.setBounds(309, 164, 115, 29);
							generateButton.setBounds(184, 164, 115, 29);
							lblY.setBounds(15, 124, 69, 20);
							lblY.setVisible(true);
							YTextArea.setBounds(59, 124, 541, 22);;
							YTextArea.setVisible(true);
							lblZ.setVisible(false);
							ZTextArea.setVisible(false);
							;
							break;
						case 1:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
							openButton.setBounds(309, 200, 115, 29);
							generateButton.setBounds(184, 200, 115, 29);
							lblY.setBounds(15, 124, 69, 20);
							lblY.setVisible(true);
							YTextArea.setBounds(59, 124, 541, 22);;
							YTextArea.setVisible(true);
							lblZ.setBounds(15, 160, 69, 20);
							lblZ.setVisible(true);
							ZTextArea.setBounds(59, 160, 541, 22);
							ZTextArea.setVisible(true);
							break;
						default: break;
						}
						break;
					default: break;
					}
					break;
				case 2:
					lblA1.setText("DA");
					lblA1.setBounds(15, 16, 69, 20);
					A1TextArea.setVisible(true);
					A1TextArea.setBounds(59, 16, 541, 20);
					lblB1.setText("DB");
					lblB1.setBounds(15, 52, 69, 20);
					lblB1.setVisible(true);
					B1TextArea.setBounds(59, 52, 541, 20);
					B1TextArea.setVisible(true);
					lblC1.setText("DC");
					lblC1.setBounds(15, 88, 69, 20);;
					lblC1.setVisible(true);
					C1TextArea.setBounds(59, 88, 541, 22);
					C1TextArea.setVisible(true);
					lblA2.setVisible(false);
					A2TextArea.setVisible(false);
					lblB2.setVisible(false);
					B2TextArea.setVisible(false);
					lblC2.setVisible(false);
					C2TextArea.setVisible(false);
					lblX.setBounds(15, 124, 69, 20);
					XTextArea.setBounds(59, 124, 541, 22);
					switch(numInput){
					case 0:
						switch(numOutput){
						case 0:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
							openButton.setBounds(309, 164, 115, 29);
							generateButton.setBounds(184, 164, 115, 29);
							lblY.setVisible(false);
							YTextArea.setVisible(false);
							lblZ.setVisible(false);
							ZTextArea.setVisible(false);
							;
							break;
						case 1:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
							openButton.setBounds(309, 200, 115, 29);
							generateButton.setBounds(184, 200, 115, 29);
							lblY.setVisible(false);
							YTextArea.setVisible(false);
							lblZ.setBounds(15, 160, 69, 20);
							lblZ.setVisible(true);
							ZTextArea.setBounds(59, 160, 541, 22);
							ZTextArea.setVisible(true);
							break;
						default: break;
						}
						break;
					case 1:
						switch(numOutput){
						case 0:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
							openButton.setBounds(309, 200, 115, 29);
							generateButton.setBounds(184, 200, 115, 29);
							lblY.setBounds(15, 160, 69, 20);
							lblY.setVisible(true);
							YTextArea.setBounds(59, 160, 541, 22);;
							YTextArea.setVisible(true);
							lblZ.setVisible(false);
							ZTextArea.setVisible(false);
							;
							break;
						case 1:
							frmClockedSequentialCircuits.setBounds(100, 100, 670, 462);
							openButton.setBounds(309, 236, 115, 29);
							generateButton.setBounds(184, 236, 115, 29);
							lblY.setBounds(15, 160, 69, 20);
							lblY.setVisible(true);
							YTextArea.setBounds(59, 160, 541, 22);;
							YTextArea.setVisible(true);
							lblZ.setBounds(15, 196, 69, 20);
							lblZ.setVisible(true);
							ZTextArea.setBounds(59, 196, 541, 22);
							ZTextArea.setVisible(true);
							break;
						default: break;
						}
						break;
					default: break;
					}
					break;
				default: break;
				}
			break;
		case 1:// T
			switch(numFlip){
			case 0:
				lblA1.setText("TA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblX.setBounds(15, 52, 69, 20);
				XTextArea.setBounds(59, 52, 541, 22);
				lblA2.setVisible(false);
				A2TextArea.setVisible(false);
				lblB1.setVisible(false);
				B1TextArea.setVisible(false);
				lblB2.setVisible(false);
				B2TextArea.setVisible(false);
				lblC1.setVisible(false);
				C1TextArea.setVisible(false);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 318);
						openButton.setBounds(309, 92, 115, 29);
						generateButton.setBounds(184, 92, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
						openButton.setBounds(309, 128, 115, 29);
						generateButton.setBounds(184, 128, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 88, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 88, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
						openButton.setBounds(309, 128, 115, 29);
						generateButton.setBounds(184, 128, 115, 29);
						lblY.setBounds(15, 88, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 88, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setBounds(15, 88, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 88, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 124, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 124, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			case 1:
				lblA1.setText("TA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblB1.setText("TB");
				lblB1.setBounds(15, 52, 69, 20);
				lblB1.setVisible(true);
				B1TextArea.setBounds(59, 52, 541, 20);
				B1TextArea.setVisible(true);
				lblX.setBounds(15, 88, 69, 20);
				XTextArea.setBounds(59, 88, 541, 22);
				lblC1.setVisible(false);
				C1TextArea.setVisible(false);
				lblA2.setVisible(false);
				A2TextArea.setVisible(false);
				lblB2.setVisible(false);
				B2TextArea.setVisible(false);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:						
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
						openButton.setBounds(309, 128, 115, 29);
						generateButton.setBounds(184, 128, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 124, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 124, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setBounds(15, 124, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 124, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setBounds(15, 124, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 124, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 160, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 160, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			case 2:
				lblA1.setText("TA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblB1.setText("TB");
				lblB1.setBounds(15, 52, 69, 20);
				lblB1.setVisible(true);
				B1TextArea.setBounds(59, 52, 541, 20);
				B1TextArea.setVisible(true);
				lblC1.setText("TC");
				lblC1.setBounds(15, 88, 69, 20);;
				lblC1.setVisible(true);
				C1TextArea.setBounds(59, 88, 541, 22);
				C1TextArea.setVisible(true);
				lblA2.setVisible(false);
				A2TextArea.setVisible(false);
				lblB2.setVisible(false);
				B2TextArea.setVisible(false);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				lblX.setBounds(15, 124, 69, 20);
				XTextArea.setBounds(59, 124, 541, 22);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 160, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 160, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setBounds(15, 160, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 160, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 462);
						openButton.setBounds(309, 236, 115, 29);
						generateButton.setBounds(184, 236, 115, 29);
						lblY.setBounds(15, 160, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 160, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 196, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 196, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			default: break;
			}
			break;
		case 2: // JK
			switch(numFlip){
			case 0:
				lblA1.setText("JA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblA2.setText("KA");
				lblA2.setBounds(15, 52, 69, 20);
				A2TextArea.setBounds(59, 52, 541, 22);
				lblX.setBounds(15, 88, 69, 20);
				XTextArea.setBounds(59, 88, 541, 22);
				lblA2.setVisible(true);
				A2TextArea.setVisible(true);
				lblB1.setVisible(false);
				B1TextArea.setVisible(false);
				lblB2.setVisible(false);
				B2TextArea.setVisible(false);
				lblC1.setVisible(false);
				C1TextArea.setVisible(false);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
						openButton.setBounds(309, 128, 115, 29);
						generateButton.setBounds(184, 128, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 124, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 124, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setBounds(15, 124, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 124, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setBounds(15, 124, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 124, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 160, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 160, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			case 1:
				lblA1.setText("JA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblA2.setText("KA");
				lblA2.setBounds(15, 52, 69, 20);
				A2TextArea.setBounds(59, 52, 541, 22);
				lblB1.setText("JB");
				lblB1.setBounds(15, 88, 69, 20);
				lblB1.setVisible(true);
				B1TextArea.setBounds(59, 88, 541, 20);
				B1TextArea.setVisible(true);
				lblB2.setText("KB");
				lblB2.setBounds(15, 124, 69, 20);
				B2TextArea.setBounds(59, 124, 541, 22);
				lblX.setBounds(15, 160, 69, 20);
				XTextArea.setBounds(59, 160, 541, 22);
				lblC1.setVisible(false);
				C1TextArea.setVisible(false);
				lblA2.setVisible(true);
				A2TextArea.setVisible(true);
				lblB2.setVisible(true);
				B2TextArea.setVisible(true);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:						
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 462);
						openButton.setBounds(309, 236, 115, 29);
						generateButton.setBounds(184, 236, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 196, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 196, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 462);
						openButton.setBounds(309, 236, 115, 29);
						generateButton.setBounds(184, 236, 115, 29);
						lblY.setBounds(15, 196, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 196, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 498);
						openButton.setBounds(309, 272, 115, 29);
						generateButton.setBounds(184, 272, 115, 29);
						lblY.setBounds(15, 196, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 196, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 232, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 232, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			case 2:
				lblA1.setText("JA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblA2.setText("KA");
				lblA2.setBounds(15, 52, 69, 20);
				A2TextArea.setBounds(59, 52, 541, 22);
				lblB1.setText("JB");
				lblB1.setBounds(15, 88, 69, 20);
				lblB1.setVisible(true);
				B1TextArea.setBounds(59, 88, 541, 20);
				B1TextArea.setVisible(true);
				lblB2.setText("KB");
				lblB2.setBounds(15, 124, 69, 20);
				B2TextArea.setBounds(59, 124, 541, 22);
				lblC1.setText("JC");
				lblC1.setBounds(15, 160, 69, 20);;
				lblC1.setVisible(true);
				C1TextArea.setBounds(59, 160, 541, 22);
				lblC2.setText("KC");
				lblC2.setBounds(15, 196, 69, 20);;
				C2TextArea.setBounds(59, 196, 541, 22);
				lblX.setBounds(15, 232, 69, 20);
				XTextArea.setBounds(59, 232, 541, 22);
				C1TextArea.setVisible(true);
				lblA2.setVisible(true);
				A2TextArea.setVisible(true);
				lblB2.setVisible(true);
				B2TextArea.setVisible(true);
				lblC2.setVisible(true);
				C2TextArea.setVisible(true);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:						
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 498);
						openButton.setBounds(309, 272, 115, 29);
						generateButton.setBounds(184, 272, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 534);
						openButton.setBounds(309, 308, 115, 29);
						generateButton.setBounds(184, 308, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 268, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 268, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 534);
						openButton.setBounds(309, 308, 115, 29);
						generateButton.setBounds(184, 308, 115, 29);
						lblY.setBounds(15, 268, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 268, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 570);
						openButton.setBounds(309, 344, 115, 29);
						generateButton.setBounds(184, 344, 115, 29);
						lblY.setBounds(15, 268, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 268, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 304, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 304, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			default: break;
			}
			break;
		case 3: // RS
			switch(numFlip){
			case 0:
				frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
				openButton.setBounds(309, 200, 115, 29);
				generateButton.setBounds(184, 200, 115, 29);
				lblA1.setText("RA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblA2.setText("SA");
				lblA2.setBounds(15, 52, 69, 20);
				A2TextArea.setBounds(59, 52, 541, 22);
				lblX.setBounds(15, 88, 69, 20);
				XTextArea.setBounds(59, 88, 541, 22);
				lblA2.setVisible(true);
				A2TextArea.setVisible(true);
				lblB1.setVisible(false);
				B1TextArea.setVisible(false);
				lblB2.setVisible(false);
				B2TextArea.setVisible(false);
				lblC1.setVisible(false);
				C1TextArea.setVisible(false);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 354);
						openButton.setBounds(309, 128, 115, 29);
						generateButton.setBounds(184, 128, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 124, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 124, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 390);
						openButton.setBounds(309, 164, 115, 29);
						generateButton.setBounds(184, 164, 115, 29);
						lblY.setBounds(15, 124, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 124, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setBounds(15, 124, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 124, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 160, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 160, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			case 1:
				lblA1.setText("RA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblA2.setText("SA");
				lblA2.setBounds(15, 52, 69, 20);
				A2TextArea.setBounds(59, 52, 541, 22);
				lblB1.setText("RB");
				lblB1.setBounds(15, 88, 69, 20);
				lblB1.setVisible(true);
				B1TextArea.setBounds(59, 88, 541, 20);
				B1TextArea.setVisible(true);
				lblB2.setText("SB");
				lblB2.setBounds(15, 124, 69, 20);
				B2TextArea.setBounds(59, 124, 541, 22);
				lblX.setBounds(15, 160, 69, 20);
				XTextArea.setBounds(59, 160, 541, 22);
				lblC1.setVisible(false);
				C1TextArea.setVisible(false);
				lblA2.setVisible(true);
				A2TextArea.setVisible(true);
				lblB2.setVisible(true);
				B2TextArea.setVisible(true);
				lblC2.setVisible(false);
				C2TextArea.setVisible(false);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:						
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 426);
						openButton.setBounds(309, 200, 115, 29);
						generateButton.setBounds(184, 200, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 462);
						openButton.setBounds(309, 236, 115, 29);
						generateButton.setBounds(184, 236, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 196, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 196, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 462);
						openButton.setBounds(309, 236, 115, 29);
						generateButton.setBounds(184, 236, 115, 29);
						lblY.setBounds(15, 196, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 196, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 498);
						openButton.setBounds(309, 272, 115, 29);
						generateButton.setBounds(184, 272, 115, 29);
						lblY.setBounds(15, 196, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 196, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 232, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 232, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
			case 2:
				lblA1.setText("RA");
				lblA1.setBounds(15, 16, 69, 20);
				A1TextArea.setVisible(true);
				A1TextArea.setBounds(59, 16, 541, 20);
				lblA2.setText("SA");
				lblA2.setBounds(15, 52, 69, 20);
				A2TextArea.setBounds(59, 52, 541, 22);
				lblB1.setText("RB");
				lblB1.setBounds(15, 88, 69, 20);
				lblB1.setVisible(true);
				B1TextArea.setBounds(59, 88, 541, 20);
				B1TextArea.setVisible(true);
				lblB2.setText("SB");
				lblB2.setBounds(15, 124, 69, 20);
				B2TextArea.setBounds(59, 124, 541, 22);
				lblC1.setText("RC");
				lblC1.setBounds(15, 160, 69, 20);;
				lblC1.setVisible(true);
				C1TextArea.setBounds(59, 160, 541, 22);
				lblC2.setText("SC");
				lblC2.setBounds(15, 196, 69, 20);;
				C2TextArea.setBounds(59, 196, 541, 22);
				lblX.setBounds(15, 232, 69, 20);
				XTextArea.setBounds(59, 232, 541, 22);
				C1TextArea.setVisible(true);
				lblA2.setVisible(true);
				A2TextArea.setVisible(true);
				lblB2.setVisible(true);
				B2TextArea.setVisible(true);
				lblC2.setVisible(true);
				C2TextArea.setVisible(true);
				switch(numInput){
				case 0:
					switch(numOutput){
					case 0:						
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 498);
						openButton.setBounds(309, 272, 115, 29);
						generateButton.setBounds(184, 272, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 534);
						openButton.setBounds(309, 308, 115, 29);
						generateButton.setBounds(184, 308, 115, 29);
						lblY.setVisible(false);
						YTextArea.setVisible(false);
						lblZ.setBounds(15, 268, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 268, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				case 1:
					switch(numOutput){
					case 0:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 534);
						openButton.setBounds(309, 308, 115, 29);
						generateButton.setBounds(184, 308, 115, 29);
						lblY.setBounds(15, 268, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 268, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setVisible(false);
						ZTextArea.setVisible(false);
						;
						break;
					case 1:
						frmClockedSequentialCircuits.setBounds(100, 100, 670, 570);
						openButton.setBounds(309, 344, 115, 29);
						generateButton.setBounds(184, 344, 115, 29);
						lblY.setBounds(15, 268, 69, 20);
						lblY.setVisible(true);
						YTextArea.setBounds(59, 268, 541, 22);;
						YTextArea.setVisible(true);
						lblZ.setBounds(15, 304, 69, 20);
						lblZ.setVisible(true);
						ZTextArea.setBounds(59, 304, 541, 22);
						ZTextArea.setVisible(true);
						break;
					default: break;
					}
					break;
				default: break;
				}
				break;
				
			}
			break;
		default: break;
		
	}
	}
	class openButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("cmd /c start open.bat /c exit");
				Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			openButton.setBackground(Color.decode("#93bad2"));
			openButton.setEnabled(false);
		}
		
	}
	class generateButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(numIndex){
			case 0:
				switch(numFlip){
				case 0:
					switch(numInput){
					case 0:
						switch(numOutput){
						case 0:
							break;
						case 1:
							break;
						}
						break;
					case 1:
						break;
					}
					break;
				case 1:
					break;
				case 2:
					break;
				}
				break;
			case 1:
				break;
			case 2:
				break;
			default: break;
			}
			
		}
		
	}
	class flipFlopTypeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			JComboBox cb = (JComboBox) evt.getSource();
			numIndex = cbFFType.getSelectedIndex();
			cbFFType.setSelectedIndex(numIndex);
			morph();
		
	}
}
	
	class flipFlopNumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			 JComboBox cb = (JComboBox) evt.getSource();
			 numFlip = cb.getSelectedIndex();
			 cbNumberOfFlipFlops.setSelectedIndex(numFlip);
			 morph();
		
	}
}	
	
	class inputNumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			 JComboBox cb = (JComboBox) evt.getSource();
			 numInput = cb.getSelectedIndex();
			 cbNumberInput.setSelectedIndex(numInput);
			 morph();
		}
	}
	
	class outputNumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			 JComboBox cb = (JComboBox) evt.getSource();
			 numOutput = cb.getSelectedIndex();
			 cbNumberOutput.setSelectedIndex(numOutput);
			 morph();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmClockedSequentialCircuits = new JFrame();
		frmClockedSequentialCircuits.setTitle("Clocked Sequential Circuits");
		frmClockedSequentialCircuits.setBounds(100, 100, 670, 318);
		frmClockedSequentialCircuits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClockedSequentialCircuits.getContentPane().setLayout(new CardLayout(0, 0));
		
		TypeAndNumberPanel = new JPanel();
		TypeAndNumberPanel.setBackground(new Color(224, 255, 255));
		TypeAndNumberPanel.setForeground(Color.WHITE);
		frmClockedSequentialCircuits.getContentPane().add(TypeAndNumberPanel, "name_1046520533931");
		TypeAndNumberPanel.setLayout(null);
		
		CanvasPanel = new JPanel();
		CanvasPanel.setBackground(new Color(224, 255, 255));
		CanvasPanel.setBounds(10, 115, 627, 400);
		TypeAndNumberPanel.add(CanvasPanel);
		CanvasPanel.setLayout(null);
		
		DynamicPanel = new JPanel();
		DynamicPanel.setBackground(new Color(224, 255, 255));
		DynamicPanel.setBounds(6, 5, 615, 500);
		CanvasPanel.add(DynamicPanel);
		DynamicPanel.setLayout(null);
		
		A1TextArea = new JTextArea();
		A1TextArea.setBounds(59, 16, 541, 20);
		DynamicPanel.add(A1TextArea);
		
		A2TextArea = new JTextArea();
		A2TextArea.setBounds(59, 52, 541, 22);
		A2TextArea.setVisible(false);
		DynamicPanel.add(A2TextArea);

		lblB1 = new JLabel("DB");
		lblB1.setBounds(15, 90, 69, 20);
		lblB1.setVisible(false);
		DynamicPanel.add(lblB1);
		
		B1TextArea = new JTextArea();
		B1TextArea.setBounds(59, 90, 541, 20);
		B1TextArea.setVisible(false);
		DynamicPanel.add(B1TextArea);
		
		B2TextArea = new JTextArea();
		B2TextArea.setBounds(59, 126, 541, 22);
		B2TextArea.setVisible(false);
		DynamicPanel.add(B2TextArea);
		
		lblB2 = new JLabel("DB");
		lblB2.setBounds(15, 126, 69, 20);
		lblB2.setVisible(false);
		DynamicPanel.add(lblB2);
		
		
		lblA1 = new JLabel("DA");
		lblA1.setBounds(15, 16, 69, 20);
		DynamicPanel.add(lblA1);
		
		lblA2 = new JLabel("DA");
		lblA2.setBounds(15, 52, 69, 20);
		lblA2.setVisible(false);
		DynamicPanel.add(lblA2);
		
		lblC1 = new JLabel("DA");
		lblC1.setBounds(15, 162, 69, 20);
		lblC1.setVisible(false);
		DynamicPanel.add(lblC1);
		
		C1TextArea = new JTextArea();
		C1TextArea.setBounds(59, 162, 541, 20);
		C1TextArea.setVisible(false);
		DynamicPanel.add(C1TextArea);
		
		lblC2 = new JLabel("DA");
		lblC2.setBounds(15, 162, 69, 20);
		lblC2.setVisible(false);
		DynamicPanel.add(lblC2);
		
		C2TextArea = new JTextArea();
		C2TextArea.setBounds(59, 162, 541, 20);
		C2TextArea.setVisible(false);
		DynamicPanel.add(C2TextArea);
		
		lblX = new JLabel("X");
		lblX.setBounds(15, 52, 69, 20);
		DynamicPanel.add(lblX);
		
		lblZ = new JLabel("Z");
		lblZ.setBounds(15, 124, 69, 20);
		lblZ.setVisible(false);
		DynamicPanel.add(lblZ);
		
		lblY = new JLabel("Y");
		lblY.setBounds(15, 88, 69, 20);
		lblY.setVisible(false);
		DynamicPanel.add(lblY);
		
		YTextArea = new JTextArea();
		YTextArea.setBounds(59, 86, 541, 22);
		YTextArea.setVisible(false);
		DynamicPanel.add(YTextArea);
		
		XTextArea = new JTextArea();
		XTextArea.setBounds(59, 52, 541, 22);
		DynamicPanel.add(XTextArea);
		
		ZTextArea = new JTextArea();
		ZTextArea.setBounds(59, 124, 541, 22);
		ZTextArea.setVisible(false);
		DynamicPanel.add(ZTextArea);
		
		generateButton = new JButton("Generate");
		generateButton.setBounds(184, 92, 115, 29);
		DynamicPanel.add(generateButton);
		generateButton.setBackground(Color.decode("#60a6d2"));
		generateButton.setForeground(Color.decode("#ffffff"));
		
		openButton = new JButton("Open");
		openButton.setBounds(309, 92, 115, 29);
		DynamicPanel.add(openButton);
		openButton.setBackground(Color.decode("#93bad2"));
		openButton.setEnabled(false);
		
	
		openButtonListener ob = new openButtonListener();
		openButton.addActionListener(ob);
		
		generateButtonListener gb = new generateButtonListener();
		generateButton.addActionListener(ob);
		
		lblTypeOfFlipflop = new JLabel("Type of flip-flop");
		lblTypeOfFlipflop.setForeground(new Color(0, 0, 0));
		lblTypeOfFlipflop.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblTypeOfFlipflop.setBounds(10, 16, 150, 38);
		TypeAndNumberPanel.add(lblTypeOfFlipflop);
		
		cbFFType = new JComboBox();
		cbFFType.setModel(new DefaultComboBoxModel(FlipFlopType.values()));
		cbFFType.setSelectedIndex(0);
		cbFFType.setBounds(175, 25, 84, 20);
		flipFlopTypeListener fftl = new flipFlopTypeListener();
		cbFFType.addActionListener(fftl);
		TypeAndNumberPanel.add(cbFFType);
		
		lblNumberOfFlipFlops = new JLabel("Flip-Flops");
		lblNumberOfFlipFlops.setForeground(new Color(0, 0, 0));
		lblNumberOfFlipFlops.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNumberOfFlipFlops.setBounds(332, 16, 204, 38);
		TypeAndNumberPanel.add(lblNumberOfFlipFlops);
		
		cbNumberOfFlipFlops = new JComboBox();
		cbNumberOfFlipFlops.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cbNumberOfFlipFlops.setSelectedIndex(0);
		cbNumberOfFlipFlops.setBounds(553, 25, 84, 20);
		flipFlopNumberListener ffnl = new flipFlopNumberListener();
		cbNumberOfFlipFlops.addActionListener(ffnl);
		TypeAndNumberPanel.add(cbNumberOfFlipFlops);
		
		lblNumberOfInput = new JLabel("Input variables");
		lblNumberOfInput.setForeground(new Color(0, 0, 0));
		lblNumberOfInput.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNumberOfInput.setBounds(10, 61, 244, 38);
		TypeAndNumberPanel.add(lblNumberOfInput);
		
		lblNumberOfOutput = new JLabel("Output Variables");
		lblNumberOfOutput.setForeground(new Color(0, 0, 0));
		lblNumberOfOutput.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNumberOfOutput.setBounds(331, 61, 242, 38);
		TypeAndNumberPanel.add(lblNumberOfOutput);
		
		cbNumberInput = new JComboBox();
		cbNumberInput.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		cbNumberInput.setSelectedIndex(0);
		cbNumberInput.setBounds(175, 70, 84, 20);
		inputNumberListener il = new inputNumberListener();
		cbNumberInput.addActionListener(il);
		TypeAndNumberPanel.add(cbNumberInput);
		
		cbNumberOutput = new JComboBox();
		cbNumberOutput.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		cbNumberOutput.setSelectedIndex(0);
		cbNumberOutput.setBounds(553, 70, 84, 20);
		outputNumberListener ol = new outputNumberListener();
		cbNumberOutput.addActionListener(ol);
		TypeAndNumberPanel.add(cbNumberOutput);
	}	
}


