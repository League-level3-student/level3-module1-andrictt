package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	JFrame window;
	JPanel panel;
	ArrayList <String> names = new ArrayList<String>();
	JButton addNames = new JButton("Add Names");
	JButton viewNames = new JButton("View Names");
	public static void main(String[] args) {
		new _02_GuestBook().start();
	}
	public void start() {
		window = new JFrame("Find the Button");
		panel = new JPanel();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		names.add("Bob Banders");
		names.add("Sandy Summers");
		names.add("Greg Ganders");
		names.add("Donny Doners");
		panel.add(addNames);
		panel.add(viewNames);
		window.add(panel);
		window.pack();
		window.setVisible(true);
		viewNames.addActionListener(this);
		addNames.addActionListener(this);
		
	}
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton)e.getSource();
		
		if(buttonClicked == viewNames) {
			String message = "";
			for(int i = 0; i < names.size(); i++) {
				message += (i+1) + ". " + names.get(i) + " ";
			}
			JOptionPane.showMessageDialog(null, message);
		}
		if(buttonClicked == addNames) {
			String in = JOptionPane.showInputDialog("Enter a name");
			names.add(in);
		}
	}
	
	
	
}
