package _03_IntroToStacks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class _02_TextUndoRedo implements ActionListener, KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame window;
	JPanel panel;
	JLabel label;
	String temp = "";
	Stack<Character> texts = new Stack<Character>();
	
	Stack<Character> undo = new Stack<Character>();

	public static void main(String[] args) {
		new _02_TextUndoRedo().start();
	}

	public void start() {
		window = new JFrame("Find the Button");
		panel = new JPanel();
		label = new JLabel();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);

		window.addKeyListener(this);
		panel.add(label);

	}

	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			temp = "";
			undo.push(texts.pop());
			for (int i = 0; i < texts.size();i++) {
				char s = texts.get(i);
				temp += s;
			}
			label.setText(temp);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			temp = "";
			texts.push(undo.pop());
			for (int i = 0; i < texts.size();i++) {
				char s = texts.get(i);
				temp += s;
			}
			label.setText(temp);
		}
		else {
			temp = "";
			texts.push(e.getKeyChar());
			for (int i = 0; i < texts.size();i++) {
				char s = texts.get(i);
				temp += s;
			}
			label.setText(temp);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
