package stacks;

public class StackOverflowException extends RuntimeException {
	StackOverflowException(){
		super();
	}
	StackOverflowException(String a){
		super(a);
	}
}
