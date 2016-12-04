package Strings;

public class Substring_hopefullylast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "agoodday";
		
		substrings(str);
	}

	/*Working of substring method
	 * 2,2 - ""
	 * 2,3 - prints str.charAt(2)
	 * 2,1 - NPE
	 * 
	 * Assume len = str.length()
	 * len-1,len-1 - ""
	 * len-1,len   - str.charAt(len-1)
	 */
	public static void substrings(String str)
	{
		for(int i = 1;i<str.length();i++)
		{
			System.out.println(str.substring(0,i) + "_" + str.substring(i, str.length()));
		}
	}
}
