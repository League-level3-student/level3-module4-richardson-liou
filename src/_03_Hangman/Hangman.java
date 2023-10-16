package _03_Hangman;

import java.util.Stack;

import javax.swing.JLabel;

public class Hangman {
	public static void main(String[] args) {
		Stack <String> wordsStack = new Stack<String>();
	    while (true) {

	        String word = wordsStack.pop();
	        JLabel wordDisplayLabel = new JLabel(word);

	        int lives = 6;

	        while (lives > 0) {
	            
	        }


	}
	}
	
}
