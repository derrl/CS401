package stacks;

public class StackUnderflowException extends RuntimeException {
	StackUnderflowException(){
		super();
	}
	StackUnderflowException(String a){
		super(a);
	}
}
