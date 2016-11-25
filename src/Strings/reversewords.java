package Strings;

class reversewords {
	   public static void main(String[] args) {
	      String pramp = "[   Practice  Makes Perfect]";
	      System.out.println(reverseDriver(pramp.toCharArray()));
	   }
	   
	   //Input : abc def ghi jkl
	   //Rev   : lkj ihj fed cba
	   //rvword: jkl jhi def abc
	   //Output: jkl ghi def abc
	   
	   //cond1 :a b c d e
	   //e d c b a
	   //cond2 : _ abc def
	   static String reverseDriver(char[] a)
	   {
	      //reverse entire string
	      int i = 0;
	      int j = a.length-1;
	      reverse(a, i, j);
	      
	      //reverse individual words
	      //i=0;
	      for(j = 0;j<a.length;j++)
	      {
	         if(a[j] == ' ')
	         {
	            reverse(a, i, j-1);
	            i = j +1;
	         }
	      }
	      //for the last word
	      reverse(a, i, j-1);
	      
	      return String.valueOf(a);
	   }
	   
	   static void reverse(char[] a, int i, int j)
	   {
	      while(i<j)
	      {
	         char t = a[i];
	         a[i] = a[j];
	         a[j] = t;
	         
	         i++;
	         j--;
	      }
	   }
	}




