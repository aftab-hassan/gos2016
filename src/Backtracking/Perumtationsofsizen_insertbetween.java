package Backtracking;

import java.util.ArrayList;

public class Perumtationsofsizen_insertbetween {
	public static void main(String[] args) {
//		char[] str = {'a','b','c','d','e'};
		char[] str = {'a','b','c'};
		int n = 2;
		System.out.println(fun(str, n));
	}
	
	static ArrayList<String> fun(char[] str, int j)
	{
		if(j == -1)
		{
			ArrayList<String> ret = new ArrayList<String>();
			ret.add("");
			return ret;
		}
		
		ArrayList<String> rec = fun(str, j-1);
		ArrayList<String> ret = new ArrayList<String>();
		for(int i = 0;i<rec.size();i++)
		{
			for(int k = 0;k<=rec.get(i).length();k++)
			{
				String here = rec.get(i);
				here = here.substring(0, k) + str[j] + here.substring(k, here.length());
				ret.add(here);
			}	
		}
		
		return ret;
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
