import java.util.*;
import stacks.LinkedStack;

public class InftoPostf{
	public static void main(String arg[]){
//		System.out.println(toPostfix("1+3*8"));
//		System.out.println(toPostfix("8-2+8/4+6-1-6/2"));
//		System.out.println(toPostfix("8-3-4*6+3"));
		System.out.println(toPostfix("1 + 3 * 8"));
		System.out.println(toPostfix("8 - 2 + 8 / 4 + 6 - 1 - 6 / 2"));
		System.out.println(toPostfix("8 - 3 - 4 * 6 + 3"));
	}

	private static String toPostfix(String infix){

		LinkedStack<Character> stack = new LinkedStack<Character>();
		stack.push(' ');
		StringBuffer postfix =new StringBuffer(infix.length());
		char[] infixArray = infix.toCharArray();
		char t;
		int i,k,stacksize;
		for(k = 1;k <= infixArray.length;k++){
			t = infixArray[k-1];
//			System.out.println(t);
			if(t == ' ') continue;
			if(isNum(t))
				postfix.append(t);
			else if(isOpter(t)){
//				System.out.println(preValue(stack.peek()));
				if (preValue(t) > preValue(stack.peek()))
					stack.push(t);		
				else{ 
					stacksize = stack.getSize();
					for(i = 2;i <= stacksize;i++){
						postfix.append(stack.peek());
						stack.pop();
					}
					stack.push(t);
				}
			}
			else
				System.out.println("fault");
		}			
			stacksize = stack.getSize();
			for(i = 2;i <= stacksize;i++){
				postfix.append(stack.peek());
				stack.pop();
			}
			return postfix.toString();
	}
	
	static boolean isNum(char c){
		int a = Character.getNumericValue(c);
		return (a >= 0 && a <= 9);	
	}
	
	static boolean isOpter(char c){
		return (c=='-'||c=='+'||c=='/'||c=='*');	
	}
//	static boolean isOpter(String c){
//		return (c=="-"||c=="+"||c=="/"||c=="*");	
//	}

	static int preValue(char c){
		if(c == '-'||c =='+')
			return 1;
		else if(c == '*'||c == '/')
			return 2;
		else
			return -1;
	}
}
