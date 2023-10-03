package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> txtStack = new Stack<Character>();
    	for(int i =0; i<b.length();i++) {
    		
    		if(b.charAt(i)=='{') {
    			txtStack.push(b.charAt(i));
    			System.out.println();
    		}
    		
    		if(b.charAt(i)=='}'&& i>0) {
    			txtStack.pop();
    		}
    		
    		
    		
    	}
    	if(txtStack.size()==0) {
    		return true;
    	}
    	return false;
    	
    }
}