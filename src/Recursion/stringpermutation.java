package Recursion;

import java.util.ArrayList;

public class stringpermutation {
	public static void main(String[] args) {
		String string = "abc";
		
		System.out.println(fun(string, string.length()));
	}
	
	static ArrayList<String> fun(String string, int j)
	{
		if(j == 0)
		{
			ArrayList<String> ret = new ArrayList<String>();
			ret.add("");
			return ret; 
		}
			
		ArrayList<String> rec = fun(string, j-1);
		ArrayList<String> ret = new ArrayList<String>();
		for(int i = 0;i<rec.size();i++)
		{
			for(int k = 0;k<string.length();k++)
			{
				String here = rec.get(i);
				here += string.charAt(k);
				ret.add(here);
			} 
		}
		return ret;
	}
}
