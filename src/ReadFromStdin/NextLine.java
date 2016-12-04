package ReadFromStdin;

import java.util.Scanner;

public class NextLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* paste this
		 * Created V_1
Created V_2
Created V_3
Created V_4
Created V_5
Created V_6
Created V_7
Created V_8
Created V_9
Created V_10*/
		nextLine();
	}

	static void nextLine()
	{
		Scanner stdin = new Scanner(System.in);
		
		while(stdin.hasNext())
		{
			System.out.println(stdin.nextLine());
		}
	}
}
