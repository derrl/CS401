import java.util.*;

public class Jacobsthal{

	public static void main(String[] arg){

		int n,i;
		double start,end;

		System.out.print("Please input n: ");
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine());
		System.out.println();

		start = System.currentTimeMillis();
		System.out.print("Recursive version: ");
		for (i = 0; i <= n; i++){
			System.out.print(Jacobsthal_recursive(i) + ", ");
		}
		System.out.println("...");
		end = System.currentTimeMillis() - start;
		System.out.println();
		System.out.println("Time taken to execute recursive version: " + end + "msec");
		System.out.println();

		start = System.nanoTime();
		System.out.print("Iterative version: ");
		for (i = 0; i <= n; i++){
			System.out.print(Jacobsthal_iterative(i) + ", ");
		}
		System.out.println("...");
		end = System.nanoTime() - start;
		System.out.println();
		System.out.println("Time taken to execute iterative version: " + end + "nsec");
	}

	static long Jacobsthal_recursive(int n){
		if(n < 0)
			return(-1);
		else if(n == 0)
			return(0);
		else if(n == 1)
			return(1);
		else
		return(Jacobsthal_recursive(n-1) + 2 * Jacobsthal_recursive(n-2));
	}
	
	static long Jacobsthal_iterative(int n){
		if(n < 0)
			return(-1);
		else if(n == 0)
			return(0);
		else if(n == 1)
			return(1);
		else{
			long a = 0;
			long b = 1;
			long c = 0;
			for(int i = 2; i <= n; i++){
				c = b + 2 * a;
				a = b;
				b = c;
			}
			return c;
		}
	}
}
