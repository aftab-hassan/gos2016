package Array;

import java.util.ArrayList;

public class doublesize {
	public static void main(String[] args) {
		long[] a = {1, 2, 3, 1, 2};
		long b = 1;
		System.out.println(doubleSize(a, b));
	}

	 static long doubleSize(long[] a, long b) {
		  String myString = "";
		 for(int i = 0;i<a.length;i++)
		 {
			 myString += (a[i] + "");
		 }
		 
		 ArrayList<String> al = new ArrayList<>();
		 permutation("", myString, al);
		 
		 Long max = b;
		 for(int i = 0;i<al.size();i++)
		 {
			 max = b;
			 for(int j = 0;j<al.get(i).length();j++)
			 {
				 if(String.valueOf(al.get(i).charAt(j)).equals(Long.toString(b)))
					 b*=2;
				 
				 max = Math.max(max, b);
			 }
			 System.out.println("string=="+al.get(i)+",b=="+b);
		 }
		 
		 return max;
	   }
	 
	 private static void permutation(String prefix, String str, ArrayList<String> al) {
		    int n = str.length();
		    if (n == 0){
		    	al.add(prefix);
		    }
		    else {
		        for (int i = 0; i < n; i++)
		            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), al);
		    }
		}
}
