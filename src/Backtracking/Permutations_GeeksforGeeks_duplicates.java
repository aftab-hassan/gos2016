package Backtracking;

public class Permutations_GeeksforGeeks_duplicates {
	public static void main(String[] args) {
//		char[] str = {'a','b','c','d','e'};
//		char[] str = {'a','b','c'};
//		char[] str = {'a','b','a'};
		char[] str = {'a','a','b','c'};

		fun(str, 0);
	}
	
	static void fun(char[] str, int start)
	{
		if(start == str.length)
			System.out.println(str);
		
		for(int i = start;i<str.length;i++)
		{
			if( (i== start) || (str[start] != str[i]) )
			{
				swap(str, start, i);
				fun(str, start+1);
				swap(str, start, i);	
			}
		}
	}
	
	static void swap(char[] str, int i, int j)
	{
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}
}
