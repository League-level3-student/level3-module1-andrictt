package _06_Intro_To_Hash_Maps;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class _02_LogSearch extends JPanel implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.start();
	}
	
	public void start() {
		
		frame = new JFrame("Fuck you andrew");
		panel = this;
		button1 = new JButton("Add Entry");
		button2 = new JButton("Search by ID");
		button3 = new JButton("View List");
		button4 = new JButton("Remove Entry");
		
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		frame.pack();
		frame.setVisible(true);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton)e.getSource();
		
		if(buttonClicked == button1) {
			String in = JOptionPane.showInputDialog("use an input dialog to ask the user to enter an ID number.");
			int ID = Integer.parseInt(in);
			String Name = JOptionPane.showInputDialog("use another input dialog to ask the user to enter a name.");
			
			
			hm.put(ID, Name);
		}
		if(buttonClicked == button2) {
			String in = JOptionPane.showInputDialog("use an input dialog to ask the user to enter an ID number.");
			int ID = Integer.parseInt(in);
			
			
			for(int i : hm.keySet()) {
				if(ID == i) {
					JOptionPane.showMessageDialog(null, hm.get(i));
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Otherwise, tell the user that that entry does not exist.");
		}
		if(buttonClicked == button3) {
			String[] arr = new String[hm.size()];
			int counter = 0;
			for(int i : hm.keySet()) {
				arr[counter] = hm.get(i);
				counter++;
			}
			counter = 0;
			for(int i : hm.keySet()) {
				arr[counter] = ("ID: " + i + " Name: " + arr[counter]);
				counter++;
			}
			JOptionPane.showMessageDialog(null, arr);
			
		}
		if(buttonClicked == button4) {
			String in = JOptionPane.showInputDialog("prompt the user to enter an ID using an input dialog.");
			int ID = Integer.parseInt(in);
			
			
			for(int i : hm.keySet()) {
				if(ID == i) {
					hm.remove(i);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Otherwise, notify the user that the ID is not in the list. ");
		}
	}
	
}

/* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
