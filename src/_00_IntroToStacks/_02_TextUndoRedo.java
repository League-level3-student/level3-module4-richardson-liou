package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	 private static JFrame frame;
	 private static JPanel panel;
	 private static JLabel label;
	 Stack <Character> txtStack = new Stack<Character>();
	 public void setup() {
		frame = new JFrame("Text Editor");
		panel = new JPanel();
		label = new JLabel();
		
		panel.add(label);
		frame.add(panel);
		
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setVisible(true);
	 }
	

	public void keyPressed(KeyEvent e) {
		char typedChar = e.getKeyChar();
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String labelText = label.getText();
			char last = labelText.charAt(labelText.length()-1);
			txtStack.push(last);
			labelText = labelText.substring(0, labelText.length()-1);
            label.setText(labelText);
            frame.pack();
            System.out.println(labelText);
		}
		if (typedChar != KeyEvent.VK_BACK_SPACE) {
			String labelText = label.getText()+typedChar;
            label.setText(labelText);
            frame.pack();
            System.out.println(labelText);
        }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
        
		
	}

}

