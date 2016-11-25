package Backtracking;

public class Perumtationsofsizen {
	public static void main(String[] args) {
		char[] str = {'a','b','c','d','e'};
//		char[] str = {'a','b','c'};
		int n = 20;
		char[] output = new char[n];
		fun(str, 0, output);
	}
	
	static void fun(char[] str, int j, char[] output)
	{
		if(j == output.length)
		{
			System.out.println(output);
			return;
		}
		
		for(int i = 0;i<str.length;i++)
		{
			if(isValid(output, str[i]))
			{
				output[j] = str[i];
				fun(str, j+1, output);
				output[j] = ' ';//backtracking is super importante
			}
		}
	}
	
	static boolean isValid(char[] str, char a)
	{
		for(int i = 0;i<str.length;i++)
		{
			if(str[i] == a)
				return false;
		}
		
		return true;
	}
}
