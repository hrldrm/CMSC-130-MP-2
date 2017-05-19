package GUI;

import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;

import Sequential.FlipFlop;
import Sequential.FlipFlopType;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * <tt>Main_Window</tt> is the class containing the Graphical User Interface (GUI)
 * of the program
 * @author Harold Mansilla
 * @author Sean Pineda
 *
 */

//TODO Accept all user equations
public class Main_Window {
	String inputEquation;
	FlipFlopType type;
	Hashtable<String, Hashtable<String, FlipFlop>> flipFlops = new Hashtable<String, Hashtable<String, FlipFlop>>();
	Hashtable<String, String> outputEquations = new Hashtable<String, String>();
	private JFrame frmClockedSequentialCircuits;
	
	private JPanel TypeAndNumberPanel;
	private JPanel DInputPanel;
	private JPanel TInputPanel;
	private JPanel OutputVarPanel;
	
	private JTextField eqnDA;
	private JTextField eqnDB;
	private JTextField eqnDC;
	private JTextField eqnTA;
	private JTextField eqnTB;
	private JTextField eqnTC;
	private JTextField eqnJA;
	private JTextField eqnKA;
	private JTextField eqnJB;
	private JTextField eqnKB;
	private JTextField eqnJC;
	private JTextField eqnKC;
	private JTextField eqnRA;
	private JTextField eqnSA;
	private JTextField eqnRB;
	private JTextField eqnSB;
	private JTextField eqnRC;
	private JTextField eqnSC;
	private JTextField eqnZ;
	
	private JComboBox cbNumberOfFlipFlops;
	private JComboBox cbFFType;
	private JComboBox cbNumberInput;
	private JComboBox cbNumberOutput;
	
	private JLabel lblTypeOfFlipflop;
	private JLabel lblNumberOfFlipFlops;
	private JLabel lblEquationsForOutput;
	private JLabel lblNumberOfInput; 
	private JLabel lblNumberOfOutput;
	private JLabel lblEquationsForD;
	private JLabel lblDA;
	private JLabel lblDB;
	private JLabel lblDC;
	private JLabel lblTA;
	private JLabel lblTB;
	private JLabel lblTC;
	private JLabel lblJA;
	private JLabel lblJB;
	private JLabel lblKB;
	private JLabel lblJC;
	private JLabel lblKC;
	private JLabel lblRA;
	private JLabel lblSA;
	private JLabel lblRB;
	private JLabel lblSB;
	private JLabel lblRC;
	private JLabel lblSC;
	private JLabel lblZ;
	
	private JButton backOutput;
	private JButton btnFinish;
	
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClockedSequentialCircuits = new JFrame();
		frmClockedSequentialCircuits.setTitle("Clocked Sequential Circuits");
		frmClockedSequentialCircuits.setBounds(100, 100, 410, 370);
		frmClockedSequentialCircuits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClockedSequentialCircuits.getContentPane().setLayout(new CardLayout(0, 0));
		
		TypeAndNumberPanel = new JPanel();
		TypeAndNumberPanel.setBackground(new Color(0, 153, 255));
		TypeAndNumberPanel.setForeground(Color.WHITE);
		frmClockedSequentialCircuits.getContentPane().add(TypeAndNumberPanel, "name_1046520533931");
		TypeAndNumberPanel.setLayout(null);
		
		lblTypeOfFlipflop = new JLabel("Type of flip-flop");
		lblTypeOfFlipflop.setForeground(new Color(0, 0, 0));
		lblTypeOfFlipflop.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblTypeOfFlipflop.setBounds(10, 11, 150, 38);
		TypeAndNumberPanel.add(lblTypeOfFlipflop);
		
		cbFFType = new JComboBox();
		cbFFType.setModel(new DefaultComboBoxModel(FlipFlopType.values()));
		cbFFType.setSelectedIndex(0);
		cbFFType.setBounds(264, 22, 84, 20);
		flipFlopTypeListener fftl = new flipFlopTypeListener();
		cbFFType.addActionListener(fftl);
		TypeAndNumberPanel.add(cbFFType);
		
		lblNumberOfFlipFlops = new JLabel("Number of flip-flops");
		lblNumberOfFlipFlops.setForeground(new Color(0, 0, 0));
		lblNumberOfFlipFlops.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNumberOfFlipFlops.setBounds(10, 53, 204, 38);
		TypeAndNumberPanel.add(lblNumberOfFlipFlops);
		
		cbNumberOfFlipFlops = new JComboBox();
		cbNumberOfFlipFlops.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cbNumberOfFlipFlops.setSelectedIndex(0);
		cbNumberOfFlipFlops.setBounds(264, 64, 84, 20);
		flipFlopNumberListener ffnl = new flipFlopNumberListener();
		cbNumberOfFlipFlops.addActionListener(ffnl);
		TypeAndNumberPanel.add(cbNumberOfFlipFlops);
		
		lblNumberOfInput = new JLabel("Number of input variables");
		lblNumberOfInput.setForeground(new Color(0, 0, 0));
		lblNumberOfInput.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNumberOfInput.setBounds(10, 102, 244, 38);
		TypeAndNumberPanel.add(lblNumberOfInput);
		
		lblNumberOfOutput = new JLabel("Number of output variables");
		lblNumberOfOutput.setForeground(new Color(0, 0, 0));
		lblNumberOfOutput.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNumberOfOutput.setBounds(10, 151, 242, 38);
		TypeAndNumberPanel.add(lblNumberOfOutput);
		
		DInputPanel = new JPanel();
		DInputPanel.setLayout(null);
		DInputPanel.setForeground(Color.WHITE);
		DInputPanel.setBackground(new Color(0, 153, 255));
		frmClockedSequentialCircuits.getContentPane().add(DInputPanel, "name_2876874532757");
		
		JButton btnBack = new JButton("Back");
		btnBack.setEnabled(false);
		btnBack.setBounds(99, 285, 89, 23);
		TypeAndNumberPanel.add(btnBack);
		
		JButton backD = new JButton("Back");
		backD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DInputPanel.setVisible(false);
				TypeAndNumberPanel.setVisible(true);
			}
		});
		backD.setBounds(99, 285, 89, 23);
		DInputPanel.add(backD);
		
		JButton nextD = new JButton("Next");
		nextD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbNumberOutput.getSelectedIndex() == 1){
					//TODO Check if correct input for equations
					DInputPanel.setVisible(false);
					OutputVarPanel.setVisible(true);
				}
			}
		});
		nextD.setBounds(210, 285, 89, 23);
		DInputPanel.add(nextD);
		
		lblEquationsForD = new JLabel("Equations for D flip flops:");
		lblEquationsForD.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblEquationsForD.setBounds(10, 11, 250, 38);
		DInputPanel.add(lblEquationsForD);
		
		lblDA = new JLabel("A");
		lblDA.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblDA.setBounds(30, 60, 31, 23);
		DInputPanel.add(lblDA);
		
		eqnDA = new JTextField();
		eqnDA.setBounds(68, 64, 243, 20);
		DInputPanel.add(eqnDA);
		eqnDA.setColumns(10);
		
		lblDB = new JLabel("B");
		lblDB.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblDB.setBounds(30, 116, 31, 23);
		DInputPanel.add(lblDB);
		
		eqnDB = new JTextField();
		eqnDB.setColumns(10);
		eqnDB.setBounds(68, 120, 243, 20);
		DInputPanel.add(eqnDB);
		
		lblDC = new JLabel("C");
		lblDC.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblDC.setBounds(30, 168, 31, 23);
		DInputPanel.add(lblDC);
		
		eqnDC = new JTextField();
		eqnDC.setColumns(10);
		eqnDC.setBounds(68, 172, 243, 20);
		DInputPanel.add(eqnDC);
		
		TInputPanel = new JPanel();
		TInputPanel.setLayout(null);
		TInputPanel.setForeground(Color.WHITE);
		TInputPanel.setBackground(new Color(0, 153, 255));
		frmClockedSequentialCircuits.getContentPane().add(TInputPanel, "name_3983271322165");
		
		JButton backT = new JButton("Back");
		backT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TInputPanel.setVisible(false);
				TypeAndNumberPanel.setVisible(true);
			}
		});
		backT.setBounds(99, 285, 89, 23);
		TInputPanel.add(backT);
		
		JButton nextT = new JButton("Next");
		nextT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbNumberOutput.getSelectedIndex() == 1){
					//TODO Check if correct input for equations
					TInputPanel.setVisible(false);
					OutputVarPanel.setVisible(true);
				}
			}
		});
		nextT.setBounds(210, 285, 89, 23);
		TInputPanel.add(nextT);
		
		JLabel lblEquationsForT = new JLabel("Equations for T flip flops:");
		lblEquationsForT.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblEquationsForT.setBounds(10, 11, 250, 38);
		TInputPanel.add(lblEquationsForT);
		
		lblTA = new JLabel("A");
		lblTA.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblTA.setBounds(30, 60, 31, 23);
		TInputPanel.add(lblTA);
		
		eqnTA = new JTextField();
		eqnTA.setColumns(10);
		eqnTA.setBounds(68, 64, 243, 20);
		TInputPanel.add(eqnTA);
		
		lblTB = new JLabel("B");
		lblTB.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblTB.setBounds(30, 116, 31, 23);
		TInputPanel.add(lblTB);
		
		eqnTB = new JTextField();
		eqnTB.setColumns(10);
		eqnTB.setBounds(68, 120, 243, 20);
		TInputPanel.add(eqnTB);
		
		lblTC = new JLabel("C");
		lblTC.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblTC.setBounds(30, 168, 31, 23);
		TInputPanel.add(lblTC);
		
		eqnTC = new JTextField();
		eqnTC.setColumns(10);
		eqnTC.setBounds(68, 172, 243, 20);
		TInputPanel.add(eqnTC);
		
		JPanel JKInputPanel = new JPanel();
		JKInputPanel.setLayout(null);
		JKInputPanel.setForeground(Color.WHITE);
		JKInputPanel.setBackground(new Color(0, 153, 255));
		frmClockedSequentialCircuits.getContentPane().add(JKInputPanel, "name_4302603228099");
		
		JButton backJK = new JButton("Back");
		backJK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JKInputPanel.setVisible(false);
				TypeAndNumberPanel.setVisible(true);
			}
		});
		backJK.setBounds(99, 285, 89, 23);
		JKInputPanel.add(backJK);
		
		JButton nextJK = new JButton("Next");
		nextJK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbNumberOutput.getSelectedIndex() == 1){
					//TODO Check if correct input for equations
					JKInputPanel.setVisible(false);
					OutputVarPanel.setVisible(true);
				}
			}
		});
		nextJK.setBounds(210, 285, 89, 23);
		JKInputPanel.add(nextJK);
		
		JLabel lblEquationsForJk = new JLabel("Equations for JK flip flops:");
		lblEquationsForJk.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblEquationsForJk.setBounds(10, 11, 250, 38);
		JKInputPanel.add(lblEquationsForJk);
		
		lblJA = new JLabel("JA");
		lblJA.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblJA.setBounds(30, 50, 31, 23);
		JKInputPanel.add(lblJA);
		
		eqnJA = new JTextField();
		eqnJA.setColumns(10);
		eqnJA.setBounds(68, 54, 243, 20);
		JKInputPanel.add(eqnJA);
		
		JLabel lblKA = new JLabel("KA");
		lblKA.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblKA.setBounds(30, 84, 31, 23);
		JKInputPanel.add(lblKA);
		
		eqnKA = new JTextField();
		eqnKA.setColumns(10);
		eqnKA.setBounds(68, 88, 243, 20);
		JKInputPanel.add(eqnKA);
		
		eqnJB = new JTextField();
		eqnJB.setColumns(10);
		eqnJB.setBounds(68, 133, 243, 20);
		JKInputPanel.add(eqnJB);
		
		lblJB = new JLabel("JB");
		lblJB.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblJB.setBounds(30, 129, 31, 23);
		JKInputPanel.add(lblJB);
		
		lblKB = new JLabel("KB");
		lblKB.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblKB.setBounds(30, 163, 31, 23);
		JKInputPanel.add(lblKB);
		
		eqnKB = new JTextField();
		eqnKB.setColumns(10);
		eqnKB.setBounds(68, 167, 243, 20);
		JKInputPanel.add(eqnKB);
		
		eqnJC = new JTextField();
		eqnJC.setColumns(10);
		eqnJC.setBounds(68, 204, 243, 20);
		JKInputPanel.add(eqnJC);
		
		lblJC = new JLabel("JC");
		lblJC.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblJC.setBounds(30, 200, 31, 23);
		JKInputPanel.add(lblJC);
		
		lblKC = new JLabel("KC");
		lblKC.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblKC.setBounds(30, 234, 31, 23);
		JKInputPanel.add(lblKC);
		
		eqnKC = new JTextField();
		eqnKC.setColumns(10);
		eqnKC.setBounds(68, 238, 243, 20);
		JKInputPanel.add(eqnKC);
		
		JPanel RSInputPanel = new JPanel();
		RSInputPanel.setLayout(null);
		RSInputPanel.setForeground(Color.WHITE);
		RSInputPanel.setBackground(new Color(0, 153, 255));
		frmClockedSequentialCircuits.getContentPane().add(RSInputPanel, "name_4954141897527");
		
		JButton backRS = new JButton("Back");
		backRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RSInputPanel.setVisible(false);
				TypeAndNumberPanel.setVisible(true);
			}
		});
		backRS.setBounds(99, 285, 89, 23);
		RSInputPanel.add(backRS);
		
		JButton nextRS = new JButton("Next");
		nextRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbNumberOutput.getSelectedIndex() == 1){
					//TODO Check if correct input for equations
					RSInputPanel.setVisible(false);
					OutputVarPanel.setVisible(true);
				}
			}
		});
		nextRS.setBounds(210, 285, 89, 23);
		RSInputPanel.add(nextRS);
		
		JLabel lblEquationsForRs = new JLabel("Equations for RS flip flops:");
		lblEquationsForRs.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblEquationsForRs.setBounds(10, 11, 250, 38);
		RSInputPanel.add(lblEquationsForRs);
		
		lblRA = new JLabel("RA");
		lblRA.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblRA.setBounds(30, 50, 31, 23);
		RSInputPanel.add(lblRA);
		
		eqnRA = new JTextField();
		eqnRA.setColumns(10);
		eqnRA.setBounds(68, 54, 243, 20);
		RSInputPanel.add(eqnRA);
		
		lblSA = new JLabel("SA");
		lblSA.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblSA.setBounds(30, 84, 31, 23);
		RSInputPanel.add(lblSA);
		
		eqnSA = new JTextField();
		eqnSA.setColumns(10);
		eqnSA.setBounds(68, 88, 243, 20);
		RSInputPanel.add(eqnSA);
		
		eqnRB = new JTextField();
		eqnRB.setColumns(10);
		eqnRB.setBounds(68, 135, 243, 20);
		RSInputPanel.add(eqnRB);
		
		lblRB = new JLabel("RB");
		lblRB.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblRB.setBounds(30, 131, 31, 23);
		RSInputPanel.add(lblRB);
		
		lblSB = new JLabel("SB");
		lblSB.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblSB.setBounds(30, 165, 31, 23);
		RSInputPanel.add(lblSB);
		
		eqnSB = new JTextField();
		eqnSB.setColumns(10);
		eqnSB.setBounds(68, 169, 243, 20);
		RSInputPanel.add(eqnSB);
		
		eqnRC = new JTextField();
		eqnRC.setColumns(10);
		eqnRC.setBounds(68, 220, 243, 20);
		RSInputPanel.add(eqnRC);
		
		lblRC = new JLabel("RC");
		lblRC.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblRC.setBounds(30, 216, 31, 23);
		RSInputPanel.add(lblRC);
		
		lblSC = new JLabel("SC");
		lblSC.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblSC.setBounds(30, 250, 31, 23);
		RSInputPanel.add(lblSC);
		
		eqnSC = new JTextField();
		eqnSC.setColumns(10);
		eqnSC.setBounds(68, 254, 243, 20);
		RSInputPanel.add(eqnSC);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeAndNumberPanel.setVisible(false);
				switch(cbFFType.getSelectedIndex()){
					case 0: DInputPanel.setVisible(true);break;
					case 1: TInputPanel.setVisible(true);break;
					case 2: JKInputPanel.setVisible(true);break;
					case 3: RSInputPanel.setVisible(true);break;
				}
			}
		});
		btnNext.setBounds(210, 285, 89, 23);
		TypeAndNumberPanel.add(btnNext);
		
		cbNumberInput = new JComboBox();
		cbNumberInput.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		cbNumberInput.setSelectedIndex(0);
		cbNumberInput.setBounds(264, 113, 84, 20);
		inputNumberListener inl = new inputNumberListener();
		cbNumberInput.addActionListener(inl);
		TypeAndNumberPanel.add(cbNumberInput);
		
		cbNumberOutput = new JComboBox();
		cbNumberOutput.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		cbNumberOutput.setSelectedIndex(0);
		cbNumberOutput.setBounds(264, 162, 84, 20);
		outputNumberListener onl = new outputNumberListener();
		cbNumberOutput.addActionListener(onl);
		TypeAndNumberPanel.add(cbNumberOutput);
		
		JLabel lblInputVariable = new JLabel("1 input variable: x; 2 input vars: x, y");
		lblInputVariable.setForeground(Color.BLACK);
		lblInputVariable.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblInputVariable.setBounds(26, 223, 338, 38);
		TypeAndNumberPanel.add(lblInputVariable);
		
		OutputVarPanel = new JPanel();
		OutputVarPanel.setLayout(null);
		OutputVarPanel.setForeground(Color.WHITE);
		OutputVarPanel.setBackground(new Color(0, 153, 255));
		frmClockedSequentialCircuits.getContentPane().add(OutputVarPanel, "name_8984940687669");
		
		backOutput = new JButton("Back");
		backOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Check if correct input for equations
				OutputVarPanel.setVisible(false);
				switch(cbFFType.getSelectedIndex()){
					case 0: DInputPanel.setVisible(true);break;
					case 1: TInputPanel.setVisible(true);break;
					case 2: JKInputPanel.setVisible(true);break;
					case 3: RSInputPanel.setVisible(true);break;
				}
			}
		});
		backOutput.setBounds(99, 285, 89, 23);
		OutputVarPanel.add(backOutput);
		
		btnFinish = new JButton("Finish");
		btnFinish.setBounds(210, 285, 89, 23);
		OutputVarPanel.add(btnFinish);
		
		lblEquationsForOutput = new JLabel("Equation for Output Variable:");
		lblEquationsForOutput.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblEquationsForOutput.setBounds(10, 11, 289, 38);
		OutputVarPanel.add(lblEquationsForOutput);
		
		lblZ = new JLabel("Z");
		lblZ.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblZ.setBounds(30, 50, 31, 23);
		OutputVarPanel.add(lblZ);
		
		eqnZ = new JTextField();
		eqnZ.setColumns(10);
		eqnZ.setBounds(68, 54, 243, 20);
		OutputVarPanel.add(eqnZ);
	}
	
	class flipFlopTypeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			JComboBox cb = (JComboBox) evt.getSource();
			int newIndex = cb.getSelectedIndex();
			cbFFType.setSelectedIndex(newIndex);
		}
		
	}
	
	class flipFlopNumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			 JComboBox cb = (JComboBox) evt.getSource();
			 int newIndex = cb.getSelectedIndex();
			 System.out.println(newIndex);
			 cbNumberOfFlipFlops.setSelectedIndex(newIndex);
				if(newIndex == 0){
					lblDB.setVisible(false);
					eqnDB.setVisible(false);
					lblTB.setVisible(false);
					eqnTB.setVisible(false);
					lblJB.setVisible(false);
					eqnJB.setVisible(false);
					lblKB.setVisible(false);
					eqnKB.setVisible(false);
					lblRB.setVisible(false);
					eqnRB.setVisible(false);
					lblSB.setVisible(false);
					eqnSB.setVisible(false);
					lblDC.setVisible(false);
					eqnDC.setVisible(false);
					lblTC.setVisible(false);
					eqnTC.setVisible(false);
					lblJC.setVisible(false);
					eqnJC.setVisible(false);
					lblKC.setVisible(false);
					eqnKC.setVisible(false);
					lblRC.setVisible(false);
					eqnRC.setVisible(false);
					lblSC.setVisible(false);
					eqnSC.setVisible(false);
				}else if(newIndex == 1){
					lblDB.setVisible(true);
					eqnDB.setVisible(true);
					lblTB.setVisible(true);
					eqnTB.setVisible(true);
					lblJB.setVisible(true);
					eqnJB.setVisible(true);
					lblKB.setVisible(true);
					eqnKB.setVisible(true);
					lblRB.setVisible(true);
					eqnRB.setVisible(true);
					lblSB.setVisible(true);
					eqnSB.setVisible(true);
					lblDC.setVisible(false);
					eqnDC.setVisible(false);
					lblTC.setVisible(false);
					eqnTC.setVisible(false);
					lblJC.setVisible(false);
					eqnJC.setVisible(false);
					lblKC.setVisible(false);
					eqnKC.setVisible(false);
					lblRC.setVisible(false);
					eqnRC.setVisible(false);
					lblSC.setVisible(false);
					eqnSC.setVisible(false);
				}else{
					lblDB.setVisible(true);
					eqnDB.setVisible(true);
					lblTB.setVisible(true);
					eqnTB.setVisible(true);
					lblJB.setVisible(true);
					eqnJB.setVisible(true);
					lblKB.setVisible(true);
					eqnKB.setVisible(true);
					lblRB.setVisible(true);
					eqnRB.setVisible(true);
					lblSB.setVisible(true);
					eqnSB.setVisible(true);
					lblDC.setVisible(true);
					eqnDC.setVisible(true);
					lblTC.setVisible(true);
					eqnTC.setVisible(true);
					lblJC.setVisible(true);
					eqnJC.setVisible(true);
					lblKC.setVisible(true);
					eqnKC.setVisible(true);
					lblRC.setVisible(true);
					eqnRC.setVisible(true);
					lblSC.setVisible(true);
					eqnSC.setVisible(true);
				}
		}
		
	}
	
	class inputNumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			 JComboBox cb = (JComboBox) evt.getSource();
			 int newIndex = cb.getSelectedIndex();
			 cbNumberInput.setSelectedIndex(newIndex);
		}
	}
	
	class outputNumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			 JComboBox cb = (JComboBox) evt.getSource();
			 int newIndex = cb.getSelectedIndex();
			 cbNumberOutput.setSelectedIndex(newIndex);
		}
	}
}
