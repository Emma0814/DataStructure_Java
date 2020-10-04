package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author emmajing
 *
 */
public class Arithmetic {

	public static int calculate(String strExpression){
		strExpression = strExpression.replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0") + "#";
		strExpression = strExpression.replace('[', '(');
		strExpression = strExpression.replace('{', '(');
		strExpression = strExpression.replace(']', ')');
		strExpression = strExpression.replace('}', ')');
		Stack<Integer> num = new Stack<>();
		Stack<Character> op = new Stack<>();
		String temp = "";
		for (int i = 0; i < strExpression.length(); i++) {
			if(Character.isDigit(strExpression.charAt(i))) {  // num
				temp += strExpression.charAt(i);
			} else { // op
				if (temp.length() != 0) {
					num.push(Integer.parseInt(temp));
					temp = "";
				}
				if(strExpression.charAt(i) == '#') {
					break;
				}
				if (strExpression.charAt(i) == '+' || strExpression.charAt(i) == '-') {
					if (op.isEmpty() || op.peek() == '(') {
						op.push(strExpression.charAt(i));
					} else {  // priority <= top
						while(!op.isEmpty() && op.peek() != '(') 
                            popAndCal(num, op);
						op.push(strExpression.charAt(i)); 
					}
				} else if(strExpression.charAt(i) == '*' || strExpression.charAt(i) == '/') {
					if(op.isEmpty() || op.peek() == '(' || op.peek() == '+' || op.peek() == '-') {
						op.push(strExpression.charAt(i));
					} else { // priority <= top
						while(!op.isEmpty() && op.peek() != '+' && op.peek() != '-'
								&& op.peek() != '(')
							popAndCal(num, op);
						op.push(strExpression.charAt(i));  
					}
				} else if(strExpression.charAt(i) == '(') {
					op.push(strExpression.charAt(i));
				} else { // ')' 
					while(op.peek() != '(')
						popAndCal(num, op);
					op.pop();  // pop '('
				}
			}
		} 
		while(!op.isEmpty())
			popAndCal(num, op);
		return num.pop();
    }
	
	public static void popAndCal(Stack<Integer> num, Stack<Character> op) {
		int right = num.pop();
		int left = num.pop();
		char mid = op.pop();
		switch(mid) {
		case '+':
			num.push(left + right);
			break;
		case '-':
			num.push(left - right);
			break;
		case '*':
			num.push(left * right);
			break;
		default:
			num.push(left / right);
		}
	}
	
    public static void main(String[] args){
        String line = "4*5+2-{-1+9/(3*2)}+2";
        System.out.println(calculate(line));
    }
}
