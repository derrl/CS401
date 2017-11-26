import java.util.*;

public class Minimum{

	public static int minimum(int A[],int size){
		if (size == 2)
			return Math.min(A[0],A[1]);
		else
			return Math.min(minimum(A, --size), A[--size]);

	}

	public static void main(String args[]){
		int A[] = {10, -20, 1, 2, 0, 5, 100};

		int s = minimum(A, A.length);
		System.out.println(s);
	}
}
