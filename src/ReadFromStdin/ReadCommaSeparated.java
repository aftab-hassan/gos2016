package ReadFromStdin;

import java.util.Scanner;

public class ReadCommaSeparated {
	public static void main(String[] args) {
		
		/* Give input in this form : 1,2,3,4,5,6,7,8,9 */
		readCommaSeparatedLine();
	}
	
	static void readCommaSeparatedLine()
	{
		Scanner stdin = new Scanner(System.in);
		
		while(stdin.hasNext())
		{
			String string = stdin.nextLine();
			String[] stringarr = string.split(",");
			for(int i = 0;i<stringarr.length;i++)
				System.out.print(stringarr[i] + "_");
		}
	}
}
