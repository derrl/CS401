import queues.*;
import java.util.*;

public class Palindrome{
	public static boolean test(String candidate){
		char ch; // current candidate character being processed
		int length; // length of candidate string
		char fromStack; // current character popped from stack
		char fromQueue; // current character dequeued from queue
		boolean stillPalindrome; // true if string might still be a palindrome
		QueueInterface<Character> queue; // also holds non blank string characters
		length = candidate.length();
		Stack<Character> stack = new Stack<Character>();
		queue = new ArrayBoundedQueue<Character>(length);

		for (int i = 0; i < length; i++){
			ch = candidate.charAt(i);
			if (Character.isLetter(ch)){
				ch = Character.toLowerCase(ch);
				stack.push(ch);
				queue.enqueue(ch);
			}
		}

		stillPalindrome = true;
		while (stillPalindrome && !queue.isEmpty()){
			fromStack = stack.peek();
			stack.pop();
			fromQueue = queue.dequeue();
			if (fromStack != fromQueue)
				stillPalindrome = false;
		}
		return stillPalindrome;
	}
}
