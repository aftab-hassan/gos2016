package Stack;

import java.util.Stack;

public class Reversestack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack);
		fun(stack);
		System.out.println(stack);
	}
	
	static void fun(Stack<Integer> s)
	{
		if(s.size() > 0)
		{
			int temp = s.pop();
			fun(s);
			insertatbottom(temp, s);
		}
	}
	
	static void insertatbottom(int key, Stack<Integer> s)
	{
		if(s.size() > 0)
		{
			int temp = s.pop();
			insertatbottom(key, s);
			s.push(temp);
		}
		else
		{
			s.push(key);
		}
	}
}
