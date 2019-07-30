package _04_HangMan;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.*;


public class HangMan implements KeyListener{
	JFrame frame;
	JPanel panel;
	JButton button;
	static String word;
	static String blank;
	int lives = 100;
	static JLabel label;
	static JLabel livesLabel;
	static int counter = 0;
	static int num;

	static Stack<String> usedWords = new Stack<String>();
	
	public void start() {
		frame = new JFrame("Hangman");
		panel = new JPanel();
		label = new JLabel();
		livesLabel = new JLabel("Lives: " + Integer.toString(lives));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		panel.add(livesLabel);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		String in = JOptionPane.showInputDialog("How many words?");
		num = Integer.parseInt(in);

		frame.addKeyListener(this);
		newWord();
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		new HangMan().start();
		
		
	}
	
	
	public static String getWord() {
		String words = Utilities.readRandomLineFromFile("dictionary.txt");
		for(int i = 0; i < usedWords.size(); i++) {
			String s = usedWords.get(i);
			if(words == s) {
				words = Utilities.readRandomLineFromFile("dictionary.txt");
				i = 0;
			}
		}
		usedWords.push(words);
		return words;
		
	}
	public static void newWord() {
		if(counter < num) {
			word = getWord();
			blank = "";
			for (int i = 0; i < word.length(); i++) {
				blank += "_";
			}
			label.setText(blank);
		}
	}




	@Override
	public void keyTyped(KeyEvent e) {
		char compare = e.getKeyChar();
		boolean right = false;
		String temp = "";
		for(int i = 0; i < word.length(); i++) {
			if(compare == word.charAt(i)) {
				temp += e.getKeyChar();
				right = true;
			}
			else {
				temp += blank.charAt(i);
			}
		}
		if(right == false) {
			lives--;
			livesLabel.setText("Lives: " + Integer.toString(lives));
		}
		
		blank = temp;
		System.out.print(temp);
		label.setText(blank);
		if(lives <= 0) {
			livesLabel.setText("You Lose");
			
		}
		if(blank.equals(word)) {
			livesLabel.setText("You Win");
			counter++;
			newWord();
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
