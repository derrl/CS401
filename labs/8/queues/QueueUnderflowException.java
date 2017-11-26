package queues;

public class QueueUnderflowException extends RuntimeException {
	QueueUnderflowException(){
		super();
	}
	QueueUnderflowException(String a){
		super(a);
	}
}
