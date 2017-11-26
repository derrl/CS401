import java.util.Scanner;

public class testPalindrome
{
	public static void main(String[] args)
	{
		Scanner conIn = new Scanner (System.in) ;
		String candidate = null; // s t r i ng t o be eval uat ed
		String more = null; // us ed t o s t op or cont i nue pr oces s i ng
		do
		{
			// Get next candi dat e s t r i ng t o be pr oces s ed.
			System.out.println( "Enter a string to be evaluated: ") ;
			candidate = conIn.nextLine() ;
			// Obt ai n and out put r es ul t of pal i ndr ome t es t i ng.
			if (Palindrome.test(candidate))
				System.out.println( "is a palindrome. ") ;
			else
				System.out.println( "is NOT a palindrome. ") ;
			// Det er mi ne i f t her e i s anot her candi dat e s t r i ng t o pr oces s .
			System.out.println();
			System.out.print("Evaluate another string? (Y=Yes): ") ;
			more=conIn.nextLine();
			System.out.println();
		}
		while(more.equalsIgnoreCase("y")) ;
	}
}
