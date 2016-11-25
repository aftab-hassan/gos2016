package Stack;

public class TowerOfHanoi {
	public static void main(String[] args) {
		fun(3, "source", "destination", "intermediate");
	}
	
	static void fun(int n, String source, String destination, String intermediate)
	{
		if(n == 0)
			return;
		
		fun(n-1, source, intermediate, destination);
		System.out.println("Move from "+source+" to "+destination);
		fun(n-1, intermediate, destination, source);
	}
}
