
/*
 * Created by wxn
 * 2018/7/26 9:19
 */


import java.util.Stack;

class Solution {
	boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for (char c:s.toCharArray()){
			if (c == '(' || c=='[' || c=='{'){
				stack.push(c);
			}
			else {
				if (stack.isEmpty()){
					return false;
				}
				char topChar = stack.pop();
				if (c == ')' && topChar!='(')
					return false;
				if (c == ']' && topChar!='[')
					return false;
				if (c == '}' && topChar!='{')
					return false;
			}
		}
		return stack.isEmpty();
	}
}
