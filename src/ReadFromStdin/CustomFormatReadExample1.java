package ReadFromStdin;

import java.util.Scanner;

public class CustomFormatReadExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Input form : 
		 * 3
5
1 2 3 4 5
6
1 2 3 4 5 6
7
1 2 3 4 5 6 7*/
		customRead();
	}
	
	static void customRead()
	{
		Scanner stdin = new Scanner(System.in);
        
        int testcases = stdin.nextInt();
        System.out.println("testcases == "+testcases);
        
        for(int i = 0;i<testcases;i++)
        {
            int length = stdin.nextInt();
            System.out.println("length == "+length);
            int[] a = new int[length];
            for(int j = 0;j<length;j++)
            {
                a[j++] = stdin.nextInt();
            }
            
            printArray(a);
        }
	}

	static void printArray(int[] a)
	{
		for(int i : a)
			System.out.print(i + "_");
	}
	
}
