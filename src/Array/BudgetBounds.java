package Array;

import java.util.Arrays;

class BudgetBounds {
	   public static void main(String[] args) {
	      int[] a = {100, 200, 300, 400};
	      int b = 1000;

	      System.out.println(budgetFind(a, b));
	   }
	   
	   static int budgetFind(int[] a, int b)
	   {
	      Arrays.sort(a);
	      
	      int sum = 0;
	      for(int i = 0;i<a.length;i++)
	      {
	         /* found cut point */
	         if( (sum + (a.length-i)*a[i]) > b )
	         {
	        	 
	         }
	         
	         sum += a[i];
	      }
	      
	      return -1;
	   }
	}

	//800/4 == 200
	//Input : int[] a = {100, 200, 300, 400}, b=  800
	//i=1
	//c=200
	//100 +3*200=700
	//c=201?
	//100+3*201=703
	// c=200+x
	//100+3(200+x)=800
	//i=2
	//c=300
	//100+200+2*300=900
	//