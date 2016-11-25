package Array;

class SortedRotatedArray_Chandan {
	   public static void main(String[] args) {
	      String pramp = "Practice Makes Perfect";
	      System.out.println(pramp);
	      
	      int[] a = {3,4,5,6,1};
	      for(int i = 0;i<a.length;i++)
	    	  System.out.println(find(a, a[i]));
	   }
	   
	   static int find(int[] a, int key)
	   {
	      int pivot = findPivot(a, 0, a.length-1);
	      int left = binarysearch(a, 0, pivot, key);
	      int right = binarysearch(a, pivot, a.length-1, key);
	      
	      return left>right?left:right;   
	   }
	   
	   //{1, 2, 3, 4, 5}
	   //{3, 4, 5, 1, 2}
	   //{}
	   
	   // 1,2,3,4,5,6
	   //3,4,5,6,1,2
	   //4,5,6,1,2,3
	   //5,6,1,2,3,4
	   //6,1,2,3,4,5
	   
	   // 1,1,1,1,1,2,2,2,0,0,0,0,1,1,1
	   // 0,0,1,1,1,2,2,2,0,0
	   static int findPivot(int[] a, int low, int high)
	   {
	      //low>high condition
	      
	      if(low == high)
	         return low;
	      
	      int mid = (low + high)/2;
	      
	      //line 17
	      if(a[mid] > a[high])
	         return findPivot(a, mid+1, high);
	      else//line 20
	         return findPivot(a, low, mid);
	   }
	   
	   static int binarysearch(int[] a, int low, int high, int key)
	   {
	      if(low > high)
	         return -1;
	      
	      int mid = (low + high)/2;
	      
	      if(a[mid] == key)
	         return mid;
	      
	      else if(key > a[mid])
	         return binarysearch(a, mid+1, high, key);
	      
	      else 
	         return binarysearch(a, low, mid-1, key);
	   }
}
	//5,5,5,5,5,5,5,5,1,2
