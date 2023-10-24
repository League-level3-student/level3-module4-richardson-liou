package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman {
	public static void main(String[] args) {
		Stack <String> wordsStack = new Stack<String>();
		String input = JOptionPane.showInputDialog("Enter a number less than 266");    
		int userNum = Integer.parseInt(input);
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		JPanel panel = new JPanel();
		JLabel livenum = new JLabel();

		panel.add(livenum);
		panel.add(label);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.add(panel);
		
		for(int i = 0; i<userNum; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if(wordsStack.contains(word)!=true) {
				wordsStack.push(word);
			}
		}
		while(true) {
			
			//resets solved and lives
			boolean solved = false;
			int lives = 7;
			livenum.setText("Lives: " +lives);
			//gets next word
			String currWord = wordsStack.pop();
			// number of blanks
			String blanks ="";
			for (int i = 0; i< currWord.length(); i++) {
				blanks += "_";
			}
			System.out.print(currWord);
			label.setText(blanks);

			while(solved == false) {
				String guess = JOptionPane.showInputDialog("Guess a letter in the word");
				char letter = guess.charAt(0);
				StringBuilder str = new StringBuilder(blanks);
				//if the word contains the letter guessed
				if(currWord.contains(guess)) {
					System.out.print("Correct letter");
					for(int i = 0; i< currWord.length(); i++) {
						if(currWord.charAt(i)== letter) {
							System.out.print("Found index at "+ i);
							//replace blank in label text
							str.replace(i, i+1, guess);
							blanks = str.toString();
							label.setText(str.toString());
						}
					}
				}
				//incorrect than -1 life
				else {
					lives -=1;
					livenum.setText("Lives: " +lives);
					if (lives<=0) {
						JOptionPane.showMessageDialog(null, "Game Over!");
						String yorn = JOptionPane.showInputDialog("Play Again? Yes or no");
						if (yorn.toLowerCase().equals("no")) {
							break;
						}
					}
				}
				
				if(label.getText().contains("_")) {
					solved = false;
				}
				
				
				else if (currWord.equals(label.getText())) {
					solved = true;
					JOptionPane.showMessageDialog(null,"You got the word");
				}
				
				
			}
			
		}
		


	}
	}
	

