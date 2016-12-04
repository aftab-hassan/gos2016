package ReadFromStdin;

import java.util.Scanner;

public class NextInt {
	public static void main(String[] args) {
		
		/*Input form : 1 2 3 4 5 6 7 8 9 */
		nextInt();
	}
	
	static void nextInt()
	{
		Scanner stdin = new Scanner(System.in);
		
		while(stdin.hasNext())
		{
			System.out.println(stdin.nextInt());
		}
	}
}
