package Recursion;

/* http://stackoverflow.com/questions/40336309/which-of-these-recursive-implementations-consume-less-memory */
public class stringpalindrome {
	public static void main(String[] args) {
		String s = "mam";
		System.out.println(checkPalindrome(s, 0, s.length()-1));
		System.out.println(checkPalindrome(s));
	}
	
	static boolean checkPalindrome(String s, int i, int j)
	{
		if(i >= j)
			return true;
		
		return checkPalindrome(s, i+1, j-1) && (s.charAt(i)==s.charAt(j));
	}
	
	static boolean checkPalindrome(String s)
	{
		if(s.length() <= 1)
			return true;
		
		return checkPalindrome(s.substring(1,s.length()-1)) && (s.charAt(0) == s.charAt(s.length()-1)); 
	}
}
