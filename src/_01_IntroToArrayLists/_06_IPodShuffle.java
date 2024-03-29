package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle extends JPanel implements ActionListener{
	JFrame frame;
	JPanel panel;
	JButton button;
	ArrayList <Song> songs;
	Random rand = new Random();
	int temp = 0;
	public _06_IPodShuffle() {
		frame = new JFrame("Music");
		panel = this;
		button = new JButton("Suprise Me");
		
		frame.add(panel);
		panel.add(button);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		button.addActionListener(this);
		
		songs = new ArrayList<Song>();
		// 1. Use the Song class the play the demo.mp3 file.
		
		Song derp = new Song("Hello.mp3");
		Song herp = new Song("Old.mp3");
		Song gerp = new Song("Wow.mp3");
				
		songs.add(derp);
		songs.add(herp);
		songs.add(gerp);
		
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Song stopThis = songs.get(temp);
		stopThis.stop();
		temp = rand.nextInt(3);
		Song playThis = songs.get(temp);
		playThis.play();
	}
}