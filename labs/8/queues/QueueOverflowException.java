package queues;

public class QueueOverflowException extends RuntimeException {
	QueueOverflowException(){
		super();
	}
	QueueOverflowException(String a){
		super(a);
	}
}
