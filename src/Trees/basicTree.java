package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class basicTree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(100);
		tree.insert(120);
		tree.insert(130);
		tree.insert(140);
		tree.insert(150);
		tree.insert(3);
		tree.insert(8);
		tree.insert(9);
	
		/* recursive depth-first search */
		System.out.print("Printing inorder...");
		tree.inorder(tree.root);
		System.out.println("");
	
		System.out.print("Printing preorder...");
		tree.preorder(tree.root);
		System.out.println("");
		
		System.out.print("Printing postorder...");
		tree.postorder(tree.root);
		System.out.println("");
		
		System.out.print("Printing reverese inorder...");
		tree.reverseinorder(tree.root);
		System.out.println("");
		
		/* iterative depth-first search */
		Tree tree11 = new Tree();
		tree11.root = new Node(10);
		tree11.root.left = new Node(11);
		tree11.root.right = new Node(16);
		tree11.root.left.left = new Node(2);
		tree11.root.left.right = new Node(-1);
		tree11.root.right.left = new Node(10);
		tree11.root.right.left.left = new Node(9);
		tree11.root.right.left.right = new Node(11);
		System.out.print("Printing iterative inorder...");
		tree11.iterativeinorder(tree11.root);
		System.out.println("");
	
		System.out.print("Printing iterative preorder...");
		tree11.iterativepreorder(tree11.root);
		System.out.println("");
		
		System.out.print("Printing iterative postorder...");
		tree11.iterativepostorder(tree11.root);
		System.out.println("");
		tree.iterativepostorder(tree.root);
		System.out.println("");
		
		System.out.print("Printing iterative reverese inorder...");
		tree.iterativereverseinorder(tree.root);
		System.out.println("");
		
		System.out.println("height of the tree == "+tree.height(tree.root));
		
		System.out.println("Printing level order traversal...");
		tree.printAllLevels(tree.root);
		System.out.println("");
		tree.printLevelOrderTraversal2(tree.root);
		System.out.println("");
		tree.printLevelOrderTraversalpractice(tree.root);
		System.out.println("");
		tree.printLevelOrderTraversalpracticeLevelbyLevel(tree.root);
		
		System.out.println("");
//		https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversalInSpiralOrder.java
		//Obviously didn't use his code
		System.out.println("Printing spiral order traversal...");
		tree.printSpiral2Stacks(tree.root);
		System.out.println("");
		tree.printSpiral2ArrayLists(tree.root);
		System.out.println("");
		tree.printAllLevelsSpiral(tree.root);
		System.out.println("");
		tree.printSpiralDequeAndCounter(tree.root);
		System.out.println("");
		tree.printSpiralDequeAndnull(tree.root);
		System.out.println("");
		
		System.out.println("");
		System.out.println("Sum of the nodes of the binary tree == "+tree.sumOfNodes(tree.root));
		System.out.println("");
		
		System.out.println("");
		int key = 5;
		System.out.println("Level of node " + key + " == "+tree.getLevel(tree.root,key));
		System.out.println("Level2 of node " + key + " == "+tree.getLevel2(tree.root,key));
		
		Tree tree2 = new Tree();
		tree2.insert(10);
		tree2.insert(20);
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(100);
		tree2.insert(120);
		tree2.insert(130);
		tree2.insert(140);
		tree2.insert(150);
		tree2.insert(3);
		tree2.insert(8);
//		tree2.insert(9);
		System.out.println("Is tree1 identical to tree2 ? "+tree.checkIdentical(tree.root,tree2.root));
		System.out.println("Is tree1 identical to tree2 ? "+tree.checkIdentical2(tree.root,tree2.root));
		
		System.out.println("");
		Tree tree3 = new Tree();
		tree3.root = new Node(50);
		tree3.root.left = new Node(10);
		tree3.root.right = new Node(60);
		tree3.root.right.left = new Node(70);
		tree3.root.right.left.left = new Node(65);
		tree3.root.right.left.right = new Node(80);
		tree3.root.right.right = new Node(70);
		tree3.root.right.right.right = new Node(80);
		tree3.root.right.right.left = new Node(65);
		tree3.root.left.right = new Node(20);
		tree3.root.left.left = new Node(5);
		System.out.println("Printing inorder traveral of tree3");
		tree3.inorder(tree3.root);
		System.out.println("");
		System.out.println("LargestSubtreeIdenticalLeftAndRight == "+ tree3.findLargestSubtreeIdenticalLeftAndRight(tree3.root).identicalTree);
		System.out.println("");
		
		System.out.println("");
		System.out.println("printing cousins of "+tree3.root.right.left.left.data);
		tree3.printCousins(tree3.root.right.left.left);
		System.out.println("");
		
		System.out.println("");
		System.out.println("printing Extreme nodes : ");
		tree3.printExtremeNodes(tree3.root);
		System.out.println("");
		
		System.out.println("");
		System.out.println("printing Extreme nodes (height not used): ");
		tree3.printExtremeNodesWithoutHeight(tree3.root);
		System.out.println("");
		
		System.out.println("");
		Tree tree4 = new Tree();
		tree4.insert(10);
		tree4.insert(10);
		tree4.insert(20);
		tree4.insert(5);
		tree4.insert(15);
		tree4.insert(100);
		tree4.insert(3);
		tree4.insert(8);
		tree4.insert(80);
		tree4.insert(120);
		tree4.insert(7);
		tree4.insert(9);
		tree4.insert(130);
		tree4.insert(125);
		tree4.insert(140);
		tree4.insert(135);
		tree4.insert(150);
		
		System.out.println("Checking if the tree is balanced...");
		System.out.println("tree "+tree.checkBalance(tree.root));
		System.out.println("tree2 "+tree2.checkBalance(tree2.root));
		System.out.println("tree3 "+tree3.checkBalance(tree3.root));
		System.out.println("tree4 "+tree4.checkBalance(tree4.root));
		Tree tree5 = new Tree();
		tree5.insert(100);
		tree5.insert(50);
		tree5.insert(150);
		tree5.insert(25);
		tree5.insert(75);
		tree5.insert(125);
		tree5.insert(175);
		tree5.insert(10);
		tree5.insert(30);
		tree5.insert(60);
		tree5.insert(90);
		System.out.println("tree5 "+tree5.checkBalance(tree5.root));
		System.out.println("");
		
		/* http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/ */
		System.out.println("sortedarrayToBST : ");
		int[] a = {1,2,3,4,5,6,7};
		tree5.postorder(tree5.sortedarrayToBST(a, 0, a.length-1));
		System.out.println("");
		System.out.println("");
		
		/* http://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/ */
		Tree tree6 = new Tree();
		tree6.insert(1);
		tree6.insert(2);
		tree6.insert(3);
		tree6.insert(4);
		tree6.insert(5);
		tree6.insert(6);
		tree6.insert(7);
		System.out.println("Return array(list) of inorder traveral of tree : ");
		tree6.printArrayList(tree6.inordertoal(tree6.root, new ArrayList<Integer>()));
		System.out.println("");
		tree6.printArrayList(tree6.inordertoal_correctway(tree6.root));
		System.out.println("");
		System.out.println("");
		System.out.println("Convert a normal BST to Balanced BST : ");
		tree6.inorder(tree6.convertnormalBSTtoBalancedBST(tree6.root));
		System.out.println("");
		tree6.preorder(tree6.convertnormalBSTtoBalancedBST(tree6.root));
		System.out.println("");
		tree6.postorder(tree6.convertnormalBSTtoBalancedBST(tree6.root));
		System.out.println("");
		
		/* Sorted order printing of a given array that represents a BST */
		System.out.println("Printing inorder, given level order in an array...");
		int[] b = {10, 6, 15, 4, 8, 12, 18, 3, 5, 7, 9, 11, 13, 17, 20};
		tree6.printInorderGivenLevelOrderArray(b, 0, b.length-1);
		System.out.println("");
		
		System.out.println("Finding closest node to a given key...");
		Tree tree7 = new Tree();
		tree7.insert(90);
		tree7.insert(9);
		tree7.insert(100);
		System.out.println(tree7.closestValue(tree7.root,11));
		System.out.println(tree7.searchClosest(tree7.root,11));
		System.out.println(tree7.findClosestaftab(tree7.root, 11, Integer.MAX_VALUE));
		System.out.println(tree5.findClosestaftab2(tree5.root, 51));
		System.out.println("");
		
		System.out.println("Printing all root-to-leaf paths...");
		Tree tree8 = new Tree();
		tree8.insert(4);
		tree8.insert(2);
		tree8.insert(1);
		tree8.insert(3);
		tree8.insert(6);
		tree8.insert(5);
		tree8.insert(7);
		System.out.println(tree8.roottoleafpaths(tree8.root));
		tree8.printroottoleafpaths(tree8.root,"");
		System.out.println();
		
		System.out.println("Root to leaf path sum equal to a given number");
		System.out.println(tree8.Roottoleafpathsum(tree8.root, 17));
		System.out.println(tree8.Roottoleafpathsumboolean(tree8.root, 17));
		System.out.println("");
		 
		System.out.println("Max sum root-to-leaf path in a BST - GE...");
		System.out.println(tree8.maxsumRoottoleafpath(tree8.root));
		System.out.println("");
		
		System.out.println("Print path from root to dest with target sum ...");
		Tree tree9 = new Tree();
		tree9.insert(10);
		tree9.insert(6);tree9.insert(14);
		tree9.insert(4);tree9.insert(8);tree9.insert(12);tree9.insert(18);
		tree9.insert(4);tree9.insert(5);tree9.insert(7);tree9.insert(10);tree9.insert(11);tree9.insert(13);tree9.insert(17);tree9.insert(20);
		System.out.println("Ideally you should be printing a Node as dest, just lazy now...");
		System.out.println(tree9.Roottodestpathsum(tree9.root, 12, 36));
		System.out.println(tree9.Roottodestpathsum(tree9.root, 8, 24));
		System.out.println(tree9.Roottodestpathsum(tree9.root, 4, 20));
		System.out.println("");
		
		System.out.println("Find path from �any node� to �its child node� such that the pathsum is equal to the target sum");
		System.out.println(tree9.anynodetochildnodetargetsum_n2(tree9.root, 24));
		System.out.println("");
		
		System.out.println("Find path from �any node� to �any node� such that the pathsum is equal to the target sum");
		System.out.println(tree9.anynodetoanynodetargetsum_n2(tree9.root, 24));
		System.out.println("");
		
		System.out.println("Root to leaf target sum - but pure leaf");
		Tree tree10 = new Tree();
		tree10.insert(10);
		tree10.root.left = new Node(16);
		tree10.root.right = new Node(5);
		tree10.root.left.right = new Node(-3);
		tree10.root.right.left = new Node(6);
		tree10.root.right.right = new Node(11);
		tree10.inorder(tree10.root);
		System.out.println(tree10.roottopureleaf(tree10.root, 26));
		
		System.out.println("find two numbers in the BST that add up to the given target.");
//		System.out.println(tree5.twosumbst_nlogn(tree5.root,tree5.root,185));
//		System.out.println("");
		
		/* lowest common ancestor from leaf in Binary tree, not BST */
		System.out.println("find common ancestor in Binary tree, not BST");
		Tree tree12 = new Tree();
		tree12.root = new Node(3);
		tree12.root.left = new Node(6);
		tree12.root.right = new Node(8);
		tree12.root.left.left = new Node(2);
		tree12.root.left.right = new Node(11);
		tree12.root.left.right.left = new Node(9);
		tree12.root.left.right.right = new Node(5);
		tree12.root.right.right = new Node(13);
		tree12.root.right.right.left = new Node(7);
		System.out.println(tree12.findCommonAncestorInBT_listmethod(tree12.root, tree12.root.left.left, tree12.root.left.right.right).data);
		System.out.println(tree12.findCommonAncestorInBT(tree12.root, tree12.root.left.left, tree12.root.left.right.right).data);
		System.out.println(tree12.findCommonAncestorInBT(tree12.root, tree12.root.right, tree12.root.left.right).data);
		System.out.println(tree12.findCommonAncestorInBT(tree12.root, tree12.root.right, tree12.root.right.right.left).data);
		
		/* lowest common ancestor from leaf in Binary search tree */
		System.out.println("find common ancestor in BST");
		Tree tree13 = new Tree();
		tree13.insert(10);
		tree13.insert(-10);tree13.insert(30);
		tree13.insert(8);tree13.insert(25);tree13.insert(60);
		tree13.insert(6);tree13.insert(9);tree13.insert(28);tree13.insert(78);
		System.out.println(tree13.findCommonAncestorInBST(tree13.root, 6, 6).data);
		
		/* largest BST in a Binary tree */
		System.out.println("Find the largest BST in a Binary tree");
		Tree tree14 = new Tree();
		tree14.root = new Node(25);
		tree14.root.left = new Node(18);
		tree14.root.left.left = new Node(19);
		tree14.root.left.right = new Node(20);
		tree14.root.left.left.right = new Node(15);
		tree14.root.left.right.left = new Node(18);
		tree14.root.left.right.right = new Node(25);
		
		tree14.root.right = new Node(50);
		tree14.root.right.left = new Node(35);
		tree14.root.right.right = new Node(60);
		tree14.root.right.left.left = new Node(20);
		tree14.root.right.left.right = new Node(40);
		tree14.root.right.left.left.right = new Node(25);
		tree14.root.right.right = new Node(60);
		tree14.root.right.right.left = new Node(55);
		tree14.root.right.right.right = new Node(70);
//		tree14.inorder(tree14.findLargestBSTinaBT(tree14.root).root);
		System.out.println("");
		
		/* Printing boundary of a binary tree */
		
		System.out.println("Printing boundary of a binary tree...");
		Tree tree15 = new Tree();
		tree15.root = new Node(20);
		tree15.root.left = new Node(8);
		tree15.root.left.left = new Node(4);
		tree15.root.left.right = new Node(12);
		tree15.root.left.right.left = new Node(10);
		tree15.root.left.right.right = new Node(14);
		tree15.root.right = new Node(22);
		tree15.root.right.left = new Node(21);
		tree15.root.right.right = new Node(25);
		
//		tree15.root = new Node(20);
//		tree15.root.left = new Node(0);
//		tree15.root.right = new Node(22);
//		
//		tree15.root.left.left = new Node(10);
//		tree15.root.left.left.left = new Node(9);
//		tree15.root.left.left.left.left = new Node(8);
//		tree15.root.left.left.left.left.left = new Node(7);
		
		tree15.printBoundary(tree15.root);
		
		/*http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/ */
		System.out.println("Printing inordersuccessor...");
		Tree tree16 = new Tree();
		tree16.insert(100);
		tree16.insert(50);tree16.insert(150);
		tree16.insert(25);tree16.insert(75);tree16.insert(125);tree16.insert(175);
		tree16.insert(12);tree16.insert(40);tree16.insert(60);
		System.out.println(tree16.inordersuccessor(60));
		System.out.println(tree16.prededecessor(125));
	}
}

class Tree
{
	Node root;
	
	public Tree() {
		// TODO Auto-generated constructor stub
		this.root = null;
	}
	
	public void insert(int data)
	{
		Node node = new Node(data);
		if(this.root == null)
			this.root = node;
		else
		{
			Node trav = root;
			Node pretrav = root;
			while(trav != null)
			{
				pretrav = trav;
				if(node.data <= trav.data)
					trav = trav.left;
				else
					trav = trav.right;
			}
			if(node.data <= pretrav.data)
				pretrav.left = node;
			else
				pretrav.right = node;
		}
	}
	
	/* recursive depth-first search implementations */
	public void inorder(Node node)
	{
		if(node == null)
			return;
			
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public void preorder(Node node)
	{
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node)
	{
		if(node == null)
			return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	
	public void reverseinorder(Node node)
	{
		if(node == null)
			return;
		
		reverseinorder(node.right);
		System.out.print(node.data+ " ");
		reverseinorder(node.left);
	}
	
	/* iterative depth-first search implementations */
	public void iterativeinorder(Node root)
	{
		Stack<Node> myStack = new Stack<>();
		
		while(true)
		{
			if(root != null)
			{
				myStack.push(root);
				root = root.left;
			}
			else
			{
				if(myStack.size() == 0)
					break;
				Node parent = myStack.pop();
				System.out.print(parent.data + " ");
				root = parent.right;
			}
		}
	}
	
	public void iterativepreorder(Node node)
	{
		Stack<Node> myStack = new Stack<>();
		
		while(true)
		{
			if(node != null)
			{
				System.out.print(node.data + " ");
				myStack.push(node);
				node = node.left;
			}
				
			else
			{
				if(myStack.size() == 0)
					break;
				node = myStack.pop();
				node = node.right;
			}
		}
	}
	
	public void iterativepostorder(Node node)
	{
		Stack<Node> myStack = new Stack<>();
		ArrayList<Node> visited = new ArrayList<>();
		
		while(true)
		{
			if(node != null)
			{
				myStack.push(node);
				node = node.left;
			}
			else
			{
				if(myStack.size() == 0)
					break;
				
				Node parent = myStack.peek();
				if( (parent.right != null) && !(visited.contains(parent)))
				{
					visited.add(parent);
					myStack.push(parent.right);
					node = parent.right.left;
				}
					
				else
				{
					parent = myStack.pop();
					System.out.print(parent.data + " ");
				}		
			}
		}
	}
	
	public void iterativereverseinorder(Node node)
	{
		
	}
	
	public int height(Node node)
	{
		if(node == null)
			return 0;
		return 1 + max(height(node.left), height(node.right));
	}
	
	/* printLevelOrderTraversal */
	public void printAllLevels(Node node)
	{
		for(int i = 0;i<this.height(node);i++)
			printLevel(node, i);
	}
	public void printLevel(Node node, int level)
	{
		if(node == null)
			return;
		
		if(level == 0)
			System.out.print(node.data + " ");
		else
		{
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}
	
	/* printLevelOrderTraversal2 - using Queue */
	public void printLevelOrderTraversal2(Node node)
	{
		Queue<Node> myQueue = new LinkedList<>();
		
		myQueue.add(node);
		while(myQueue.size()>0)
		{
			if(myQueue.peek().left != null)
				myQueue.add(myQueue.peek().left);
			if(myQueue.peek().right != null)
				myQueue.add(myQueue.peek().right);
			System.out.print(myQueue.peek().data + " ");
			
			myQueue.poll();
		}
	}
	
	/* just practice - using Queue */
	public void printLevelOrderTraversalpractice(Node node)
	{
		Queue<Node> myQueue = new LinkedList<>();
		
		myQueue.add(node);
		while(myQueue.size() > 0)
		{
			Node current = myQueue.poll();
			System.out.print(current.data+ " ");
			
			if(current.left != null)
				myQueue.add(current.left);
			
			if(current.right != null)
				myQueue.add(current.right);
		}
	}

	/* just practice - level by level */
	public void printLevelOrderTraversalpracticeLevelbyLevel(Node node)
	{
		int height = getHeightpractice(node);
		for(int i = 0;i<height;i++)
		{
			this.printLevelpractice(node, i);
		}
	}
	public int getHeightpractice(Node node)
	{
		if(node==null)
			return 0;
		
		return 1 + max(getHeightpractice(node.left),getHeightpractice(node.right));
	}
	public void printLevelpractice(Node node, int level)
	{
		if(node == null)
			return;
		
		if(level == 0)
		{
			System.out.print(node.data + " ");
			return;
		}
		
		printLevelpractice(node.left,level-1);
		printLevelpractice(node.right,level-1);
	}

	/* spiral tree printing - using odd and even stacks
	 * You need two because - from one you're reading, and onto one you're populating
	 * You need a stack because - the direction at next level is always opposite of current level
	 * (Could use two ArrayLists as well but reverse the order every time, ie read in forward dirn or
	 * backward depending on the level) */
	public void printSpiral2Stacks(Node root)
	{
		Stack<Node> oddStack = new Stack<Node>();
		Stack<Node> evenStack = new Stack<Node>();
		int level = 0;
		evenStack.add(root);
		while(oddStack.size() > 0 || evenStack.size() > 0)
		{
			/* even level - you pop(display) from even stack and push into odd stack */
			if(level%2 == 0)
			{
				while(evenStack.size() > 0)
				{
					Node node = evenStack.pop();
					System.out.print(node.data + " ");
					if(node.right != null)
						oddStack.push(node.right);
					if(node.left != null)
						oddStack.push(node.left);
				}
			}
			/* odd level - you pop(display) from odd stack and push into even stack */
			else
			{
				while(oddStack.size() > 0)
				{
					Node node = oddStack.pop();
					System.out.print(node.data + " ");
					if(node.left != null)
						evenStack.push(node.left);
					if(node.right != null)
						evenStack.push(node.right);
				}
			}
			level++;
		}
	}
	/* using two ArrayLists instead of 2 stacks */
	public void printSpiral2ArrayLists(Node root)
	{
		ArrayList<Node> aleven = new ArrayList<>();
		ArrayList<Node> alodd = new ArrayList<>();
		aleven.add(root);
		
		for(int i = 0;i<height(root);i++)
		{
			if(i%2 == 0)
			{
				for(int e = aleven.size()-1;e>=0;e--)
				{
					Node node = aleven.get(e);
					System.out.print(node.data + " ");
					if(node.right != null)
						alodd.add(node.right);
					if(node.left != null)
						alodd.add(node.left);
				}	
				aleven.clear();
			}
			else
			{
				for(int o = alodd.size()-1;o>=0;o--)
				{
					Node node = alodd.get(o);
					System.out.print(node.data + " ");
					if(node.left != null)
						aleven.add(node.left);
					if(node.right != null)
						aleven.add(node.right);
				}
				alodd.clear();
			}
		}
	}
	/* printing level by level */
	public void printAllLevelsSpiral(Node root)
	{
		for(int i = 0;i<this.height(this.root);i++)
		{
			printCurrentLevelSpiral(root, i, i%2);
		}
	}
	public void printCurrentLevelSpiral(Node node, int level, int direction)
	{
		if(node == null)
			return;
		if(level == 0)
			System.out.print(node.data + " ");
		else if (level > 0)
		{
			if(direction == 0)
			{
				printCurrentLevelSpiral(node.right, level-1, direction);
				printCurrentLevelSpiral(node.left, level-1, direction);
			}
			else
			{
				printCurrentLevelSpiral(node.left, level-1, direction);
				printCurrentLevelSpiral(node.right, level-1, direction);
			}
		}
	}
	/* using Deque and counter */
	public void printSpiralDequeAndCounter(Node node)
	{
		Deque<Node> myDeque = new LinkedList<>();
		myDeque.addLast(null);
		myDeque.addLast(node);
		int prevCount = 1; int currentCount = 0;
		for(int i = 0;i<height(node);i++,currentCount = 0)
		{
			while(prevCount > 0)
			{
				if(i%2 == 0)/* even */
				{
					Node currentNode = myDeque.pollLast();prevCount--;
					System.out.print(currentNode.data + " ");
					if(currentNode.right != null)
					{
						myDeque.addFirst(currentNode.right);
						currentCount++;
					}
					if(currentNode.left != null)
					{
						myDeque.addFirst(currentNode.left);
						currentCount++;
					}	
				}
				else
				{
					Node currentNode = myDeque.pollFirst();prevCount--;
					System.out.print(currentNode.data + " ");
					if(currentNode.left != null)
					{
						myDeque.addLast(currentNode.left);
						currentCount++;
					}
					if(currentNode.right != null)
					{
						myDeque.addLast(currentNode.right);
						currentCount++;
					}
				}		
			}//while(count > 0)
			
			prevCount = currentCount;
		}
	}
	/* using Deque and null */
	public void printSpiralDequeAndnull(Node node)
	{
		Deque<Node> myDeque = new LinkedList<>();
		myDeque.addLast(null);
		myDeque.addLast(node);
		for(int i = 0;i<height(node);i++)
		{
			if(i%2 == 0)/* even */
			{
				while(true)
				{
					Node currentNode = myDeque.peekLast();
					if(currentNode == null)
						break;
					currentNode = myDeque.pollLast();
					System.out.print(currentNode.data + " ");
					if(currentNode.right != null)
						myDeque.addFirst(currentNode.right);
				
					if(currentNode.left != null)
						myDeque.addFirst(currentNode.left);
				}
			}
			else
			{
				while(true)
				{
					Node currentNode = myDeque.peekFirst();
					if(currentNode == null)
						break;
					currentNode = myDeque.pollFirst();
					System.out.print(currentNode.data + " ");
					if(currentNode.left != null)
						myDeque.addLast(currentNode.left);
					
					if(currentNode.right != null)
						myDeque.addLast(currentNode.right);
				}
			}
		}
	}
	
	/* sum of nodes in a binary tree */
	public int sumOfNodes(Node node)
	{
		int sum = 0;
		
		if(node == null)
			return sum;
		
		sum += node.data;
		sum += sumOfNodes(node.left);
		sum+= sumOfNodes(node.right);
		return sum;
	}
	
	/* getLevel of a node */
	public int getLevel(Node node, int key)
	{
		if(node == null)
			return Integer.MAX_VALUE-100;
		
		if(node.data == key)
			return 1;
		else return 1 + min(getLevel(node.left, key), getLevel(node.right, key));
	}
	public int getLevel2(Node node, int key)/*http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/*/
	{/* This method is better for a BST, to find level in a BST, you don't need to do min(left and right)
	 	because the node will be either in the left or in the right depending on where it is
	 	But, if the question is to find level in a Binary Tree, and find the minimum level in it,
	 	you have to as above.*/
		if(node == null)
			return -1;
		
		if(node.data == key)
			return 1;
		else
		{
			int left = getLevel2(node.left, key);
			int right = getLevel2(node.right, key);
			return (left==-1)?((right==-1)?right:1+right):1+left;
		}
	}
	
	/* check if two trees are identical
	 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/*/
	public boolean checkIdentical(Node node1, Node node2)
	{
		/* These are returns at entry */
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null)
			return false;
		if(node2 == null)
			return false;
		if(node1.data != node2.data)
			return false;
		
		boolean left = checkIdentical(node1.left, node2.left);
		boolean right = checkIdentical(node1.right, node2.right);
		if(left == true && right == true)/* These are returns at exit */
			return true;
		return false;
	}
	public boolean checkIdentical2(Node node1, Node node2)/* same as above, but shorter code */
	{
		/* These are returns at entry */
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
	
		return checkIdentical(node1.left, node2.left) && checkIdentical(node1.right, node2.right) && (node1.data == node2.data); 
	}
	
	/* findLargestSubtreeIdenticalLeftAndRight */
	public StringString findLargestSubtreeIdenticalLeftAndRight(Node node)
	{
		if(node == null)
			return new StringString("", "");
		
		StringString left = findLargestSubtreeIdenticalLeftAndRight(node.left);
		StringString right = findLargestSubtreeIdenticalLeftAndRight(node.right);
		if(left.tree.equals(right.tree))
			return new StringString(left.tree+""+node.data+""+right.tree, left.tree+""+node.data+""+right.tree);
		else
			return left.identicalTree.length()>right.identicalTree.length()?new StringString(left.tree+""+node.data+""+right.tree, left.identicalTree):new StringString(left.tree+""+node.data+""+right.tree, right.identicalTree);
	}
	
	/* print Cousins */
	public void printCousins(Node keyNode)
	{
		int level = findLevel(this.root, keyNode);
		System.out.println("level == "+level);
		printLevel2(this.root, this.root, keyNode, level);
	}
	public int findLevel(Node node, Node keyNode)
	{
		if(node == null)
			return Integer.MAX_VALUE-100;
		if(node == keyNode)
			return 0;
		
		return 1 + min(findLevel(node.left, keyNode), findLevel(node.right, keyNode));
	}
	public void printLevel2(Node parent, Node node, Node keyNode, int level)
	{
		if(node == null)
			return;
		
		if(parent.left != keyNode && parent.right != keyNode && level == 0 && node!=this.root)
			System.out.print(node.data + " ");
		
		printLevel2(node, node.left, keyNode, level-1);
		printLevel2(node, node.right, keyNode, level-1);
	}
	
	/* printExtremeNodes */
	public void printExtremeNodes(Node node)
	{
		Stack<Node> evenStack = new Stack<>();
		Stack<Node> oddStack = new Stack<>();
		evenStack.push(node);
		int height = findHeight(node);
		int count = 0;
		
		for(int i = 0;i<height;i++, count=0)
		{
			/* even */
			if(i %2 == 0)
			{
				while(evenStack.size() > 0)
				{
					Node currentNode = evenStack.pop();
					if(count == 0)
					{
						System.out.print(currentNode.data + " ");
						count++;
					}
					if(currentNode.left != null)
						oddStack.push(currentNode.right);
					if(currentNode.right != null)
						oddStack.push(currentNode.left);
				}
			}
			else/* odd */
			{
				while(oddStack.size() > 0)
				{
					Node currentNode = oddStack.pop();
					if(count == 0)
					{
						System.out.print(currentNode.data + " ");
						count++;
					}
					if(currentNode.left != null)
						evenStack.push(currentNode.left);
					if(currentNode.right != null)
						evenStack.push(currentNode.right);
				}
			}
			System.out.println("");
		}
	}
	public int findHeight(Node node)
	{
		if(node == null)
			return 0;
		return 1 + max(findHeight(node.left), findHeight(node.right));
	}
	
	public void printExtremeNodesWithoutHeight(Node node)
	{
		Stack<Node> even = new Stack<>();
		Stack<Node> odd = new Stack<>();
		
		even.push(node);
		int i = 0;
		while(even.size() > 0 || odd.size() > 0)
		{
			int count = 0;
			/* even */
			if(i%2 == 0)
			{
				while(even.size() > 0)
				{
					Node current = even.pop();
					if(count ==0)
					{
						System.out.println(current.data);
						count++;
					}
					if(current.right != null)
						odd.push(current.right);
					if(current.left != null)
						odd.push(current.left);
				}
			}
			/* odd */
			else
			{
				while(odd.size() > 0)
				{
					Node current = odd.pop();
					if(count ==0)
					{
						System.out.println(current.data);
						count++;
					}
					if(current.left != null)
						even.push(current.left);
					if(current.right != null)
						even.push(current.right);	
				}
			}
			i++;
		}
	}
	
	public Node findNode(Node root, int key)
	{
		if(root == null)
			return null;
		
		if(key == root.data)
			return root;
		if(key < root.data)
			return findNode(root.left, key);
		else
			return findNode(root.right, key);
	}
	
	/* check if the tree is balanced */
	public int checkBalance(Node node)
	{
		if(node == null)
			return 0;
		
		int left = checkBalance(node.left);
		int right = checkBalance(node.right);
		if(left == -1 || right == -1)
			return -1;
		if( Math.abs(left - right) <= 1)
			return max(left, right) + 1;
		else
			return -1;
	}
	
	/* create BST from sorted array */
	public Node sortedarrayToBST(int[] a, int l, int h)
	{
		if(l > h || h <0 || l == a.length)
			return null;
		
		int mid = (l+h)/2;
		
		Node current = new Node(a[mid]); 
		current.left = sortedarrayToBST(a, l, mid-1);
		current.right = sortedarrayToBST(a, mid+1, h);
		return current;
	}
	
	/* convert normal BST to Balanced BST */
	public Node convertnormalBSTtoBalancedBST(Node node)
	{
		/* get inorder traversal of tree */
		ArrayList<Integer> al = inordertoal_correctway(this.root);
		int[] a = new int[al.size()];
		for(int i = 0;i<a.length;i++)
			a[i] = al.get(i);
		/* convert inorder traveral to balanced BST */
		return sortedarrayToBST(a, 0, a.length-1); 
	}
	
	/* return an ArrayList containing the inorder traversal of a BST */
	public ArrayList<Integer> inordertoal(Node node, ArrayList<Integer> al)
	{
		if(node == null)
			return al;
		
		inordertoal(node.left, al);
		al.add(node.data);
		inordertoal(node.right, al);
		
		return al;
	}
	public ArrayList<Integer> inordertoal_correctway(Node node)
	{
		if(node == null)
			return new ArrayList<Integer>();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		ArrayList<Integer> left = inordertoal_correctway(node.left);
		int current = node.data;
		ArrayList<Integer> right = inordertoal_correctway(node.right);
		
		al.addAll(left);
		al.add(current);
		al.addAll(right);
		
		return al;
	}
	
	/* Sorted order printing of a given array that represents a BST */
	public void printInorderGivenLevelOrderArray(int[] a, int l, int h)
	{
		if(l > h)
			return;
		 
		/* print left subtree */
		printInorderGivenLevelOrderArray(a, l*2 + 1, h);
		 
		/* print root */
		System.out.println(a[l]);
	 
		/* print right subtree */
		printInorderGivenLevelOrderArray(a, l*2 + 2, h);  
	}
	
	/* 'find'ing value closes to a key in a binary search tree */
	public int closestValue(Node root, int target) {
	    int ret = root.data;   
	    while(root != null){
	        if(Math.abs(target - root.data) < Math.abs(target - ret)){
	            ret = root.data;
	        }      
	        root = root.data > target? root.left: root.right;
	    }     
	    return ret;
	}
	int searchClosest(Node root,int key)
	{
		 int close = Integer.MAX_VALUE;
		 if(root==null)
		  return 0;
		 if(key == root.data)
		  return key;
	
		 close = min_diff(close,root.data,key);
	
		 if(key > root.data && root.right != null)
		   close = min_diff(close,searchClosest(root.right,key),key);
		 if(key < root.data && root.left != null)
		   close = min_diff(close,searchClosest(root.left,key),key);
	
		 return close;
	}
	int min_diff(int a, int b,int key)
	{
		 if( Math.abs(a-key)  <= Math.abs(b-key) )
		  return a;
		 else
		  return b;
	}
	/* The following two methods work on the principle that : 
	 * 1. If key is less than root, then there is no value in the right sub tree that is any closer to
	 *    the key than (any element in left sub-tree / root). Worst case, it would be the root because
	 *    it's bounded by the root
	 * 2. If key is higher than root, then there is no value in the left sub tree that is any closer to
	 *    the key than (any element in right sub-tree / root). Worst case, it would be the root because
	 *    it's bounded by the root
	 *     */
	int findClosestaftab(Node node, int key, int val)
	{
		if(node == null)
			return val;
		
		if(Math.abs(key-node.data) < val)
			val = node.data;
		
		if(key == node.data)
			return key;
		if(key < node.data)
			return findClosestaftab(node.left, key, val);
		if(key > node.data)
			return findClosestaftab(node.right, key, val);
		
		return val;
	}
	int findClosestaftab2(Node node, int key)
	{
		if(node == null)
			return Integer.MAX_VALUE;
		
		if(key == node.data)
			return key;
		else if(key < node.data)
		{
			int left = findClosestaftab2(node.left, key); 
			return Math.abs(left-key)<Math.abs(node.data-key)?left:node.data;
		}
		else
		{
			int right = findClosestaftab2(node.right, key);
			return Math.abs(right-key)<Math.abs(node.data-key)?right:node.data;
		}
	}
	
	/* Given a binary tree, print all root-to-leaf paths */
	public ArrayList<String> roottoleafpaths(Node node)
	{
		if(node == null)
			return new ArrayList<String>();
		
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> left = roottoleafpaths(node.left);
		ArrayList<String> right = roottoleafpaths(node.right);
		
		for(int i = 0;i<left.size();i++)
		{
			String test = left.get(i);
			test = node.data + " " + test;
			ret.add(test);
		}
		for(int i = 0;i<right.size();i++)
		{
			String test = right.get(i);
			test = node.data + " " + test;
			ret.add(test);
		}
			
		if(ret.size() == 0)
			ret.add(node.data + " ");
		
		return ret;
	}
	public void printroottoleafpaths(Node node, String path)
	{
		if(node == null)
		{
			System.out.println(path);
			return;
		}
		printroottoleafpaths(node.left, path+node.data+" ");
		printroottoleafpaths(node.right, path+node.data+" ");
	}
	
	/* Root to leaf path sum equal to a given number
	 * Having the ending condition like below, will cause the result to be printed twice.
	 * From 3, it would go left, hit null, come back to 3. Also, right, hit null, and come back to 3
	 * So, I've made code changes as below - 
	 * public ArrayList<String> Roottoleafpathsum(Node node, int target) is now correct
	 * 
	 * if(node == null)
		{
			if(target==0)
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add("");
				return al;
			}
				
			else
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add("invalid");
				return al;
			}
		}
	 * */
	public ArrayList<String> Roottoleafpathsum(Node node, int target)
	{
		if(node.left == null || node.right == null)
		{
			if(target==node.data)
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add(node.data+"");
				return al;
			}
				
			else
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add("invalid");
				return al;
			}
		}
			
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> left = Roottoleafpathsum(node.left, target-node.data);
		ArrayList<String> right = Roottoleafpathsum(node.right, target-node.data);
		
		for(int i = 0;i<left.size();i++)
		{
			String test = left.get(i);
			if(test != "invalid")
			{
				test = node.data + "" + test;
				ret.add(test);	
			}
		}
		
		for(int i = 0;i<right.size();i++)
		{
			String test = right.get(i);
			if(test != "invalid")
			{
				test = node.data + "" + test;
				ret.add(test);
			}
		}
		
		return ret;
	}
	public boolean Roottoleafpathsumboolean(Node node, int target)
	{
		if(node.left == null || node.right == null)
		{
			if(target == node.data)
				return true;
			return false;
		}
		
		return Roottoleafpathsumboolean(node.left,target-node.data) || Roottoleafpathsumboolean(node.right,target-node.data);
	}
	
	/* Max sum root-to-leaf path in a BST - GE */
	public int maxsumRoottoleafpath(Node node)
	{
		if(node == null)
			return 0;
		
		return max(maxsumRoottoleafpath(node.left),maxsumRoottoleafpath(node.right)) + node.data;
	}
	
	/* Find path from �root� to �destination� such that the pathsum is equal to the target sum. */
	public String Roottodestpathsum(Node node, int dest, int target)
	{
		if(node == null)
			return "doesnotexist";
		if(node.data == dest)
		{
			if(target == node.data)
				return node.data+"";
			else
				return "doesnotexist";
		}

		String left = Roottodestpathsum(node.left, dest, target-node.data);
		String right = Roottodestpathsum(node.right, dest, target-node.data);
		if(left != "doesnotexist")
			return node.data+left;
		else if(right != "doesnotexist")
			return node.data+right;
			
		return "doesnotexist";
	}

	/* Find path from �any node� to �its child node� such that the pathsum is equal to the target sum */
	public ArrayList<String> anynodetochildnodetargetsum_n2(Node node, int target)
	{
		if(node == null)
			return new ArrayList<String>();
		
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(this.Roottoleafpathsum(node, target));
		ret.addAll(this.Roottoleafpathsum(node.left, target));
		ret.addAll(this.Roottoleafpathsum(node.right, target));
		
		return ret;
	}
	
	/* Find a path from �any node� to �any node� such that the pathsum is equal to the target sum. */
	public ArrayList<String> anynodetoanynodetargetsum_n2(Node node, int target)
	{
		if(node == null)
			return new ArrayList<String>();
		
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(anynodetoanynodetargetsum_n2_worker(node,target));
		ret.addAll(anynodetoanynodetargetsum_n2_worker(node.left,target));
		ret.addAll(anynodetoanynodetargetsum_n2_worker(node.right,target));
		return ret;
	}
	public ArrayList<String> anynodetoanynodetargetsum_n2_worker(Node node, int target)
	{
		/* path does not exist */
		if(node == null)
				return new ArrayList<String>();
		
		/* path exists */
		if(target == node.data)
		{
			ArrayList<String> ret = new ArrayList<String>();
			ret.add(node.data+"");
			return ret;
		}
			
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> left = anynodetoanynodetargetsum_n2_worker(node.left, target-node.data);
		ArrayList<String> right = anynodetoanynodetargetsum_n2_worker(node.right, target-node.data);
		for(int i = 0;i<left.size();i++)
		{
			String test = left.get(i);
			test = node.data + test;
			ret.add(test);
		}
		for(int i = 0;i<right.size();i++)
		{
			String test = right.get(i);
			test = node.data + test;
			ret.add(test);
		}
		return ret;
	}
	
	/* root to pure leaf - target sum - tushar roy https://www.youtube.com/watch?v=Jg4E4KZstFE */
	public ArrayList<String> roottopureleaf(Node node, int target)
	{
		if(node == null)
			return new ArrayList<String>();
		if(node.left == null && node.right == null)
		{
			if(target == node.data)
			{
				ArrayList<String> ret =  new ArrayList<String>();
				ret.add(node.data + "");
				return ret;
			}
			return new ArrayList<String>();
		}
			
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> left = roottopureleaf(node.left, target-node.data);
		ArrayList<String> right = roottopureleaf(node.right, target-node.data);
		for(int i = 0;i<left.size();i++)
		{
			String test = left.get(i);
			test = node.data + test;
			ret.add(test);
		}
		for(int i = 0;i<right.size();i++)
		{
			String test = right.get(i);
			test = node.data + test;
			ret.add(test);
		}
		return ret;
	}
	
	/* find two numbers in the BST that add up to the given target. */
	public String twosumbst_nlogn(Node root, Node node, int target)
	{
		if(node == null)
			return "";
		
		boolean complementpresent = findcomplement(root, target-node.data);
		if(complementpresent == true)
			return "(" + node.data + "," + (target-node.data) + ")";
		else
		{
			String left = twosumbst_nlogn(root, node.left, target);
			String right = twosumbst_nlogn(root, node.right, target);
			return left.length() > right.length()?left:right;
		}
	}
	public boolean findcomplement(Node node, int key)
	{
		if(node == null)
			return false;
		if(node.data == key)
			return true;
		return findcomplement(node, key) || findcomplement(node.left, key) || findcomplement(node.right, key);
	}
	
	/* find Lowest common ancestor in binary tree, not BST - list method mentioned in https://www.youtube.com/watch?v=13m9ZCB8gjw 
	 * Also on gfg - http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/ */
	public Node findCommonAncestorInBT_listmethod(Node node, Node node1, Node node2)
	{
		ArrayList<Node> path1 = findPath(node, node1);
		ArrayList<Node> path2 = findPath(node, node2);
		Node lca = null;
		for(int i = 0;i<Math.min(path1.size(), path2.size());i++)
		{
			if(path1.get(i) != path2.get(i))
				return lca;	
			lca = path1.get(i);
		}
		return lca;
	}
	static ArrayList<Node> findPath(Node node, Node dest)
	{
		if(node == null)
			return null;
		if(node == dest)
		{
			ArrayList<Node> ret = new ArrayList<Node>();
			ret.add(node);
			return ret;
		}
 		
		ArrayList<Node> left = findPath(node.left, dest);
		ArrayList<Node> right = findPath(node.right, dest);
		if(left != null)
		{
			left.add(0,node);
			return left;
		}
		else if(right != null)
		{
			right.add(0, node);
			return right;
		}
		return null;
	}
	
	/* find Lowest common ancestor in binary tree, not BST - https://www.youtube.com/watch?v=13m9ZCB8gjw */
	public Node findCommonAncestorInBT(Node node, Node node1, Node node2)
	{
		if(node == null)
			return null;
		
		if(node.data == node1.data || node.data == node2.data)
			return node;
		else
		{
			Node left = findCommonAncestorInBT(node.left, node1, node2);
			Node right = findCommonAncestorInBT(node.right, node1, node2);
			if(left != null && right != null)
				return node;
			if(left == null)
				return right;
			return left;
		}
	}
	
	/* find Lowest common ancestor in BST - https://www.youtube.com/watch?v=TIoCCStdiFo */
	public Node findCommonAncestorInBST(Node node, int node1data, int node2data)
	{
//		if(node == null)
//			return null;
		
		if( (node.data <= node1data && node.data >= node2data) || (node.data >= node1data && node.data <= node2data) )
			return node;
		
		if(node.data < node1data && node.data < node2data)
			return findCommonAncestorInBST(node.right, node1data, node2data);
		
		else
			return findCommonAncestorInBST(node.left, node1data, node2data);
	}
	
	/* find largest BST in a BT 
	 * In this question, (Tushar Roy's solution), for every node, we need to save the min and max,
	 * because, we don't know whether we need to compare node with max(if it was the left node), or
	 * max(if it was the right node) */
	public ReturnBSTinaBT findLargestBSTinaBT(Node node)
	{
		if(node == null)
			return null;
		if(node.left == null && node.right == null)
			return new ReturnBSTinaBT(true, 1, node.data, node.data, node);
		
		ReturnBSTinaBT left = findLargestBSTinaBT(node.left);
		ReturnBSTinaBT right = findLargestBSTinaBT(node.right);
		
		if(left != null && right != null && left.bst == true && right.bst == true && node.data>=left.max && node.data <= right.min)
			return new ReturnBSTinaBT(true, left.size + right.size + 1, left.min, right.max, node);
		else if(left !=null && right == null && left.bst == true  && node.data >= left.max)
			return new ReturnBSTinaBT(true, left.size + 1, left.min, node.data, node);
		else if(right != null && left == null && right.bst == true && node.data <= right.min)
			return new ReturnBSTinaBT(true, right.size + 1, node.data, right.max, node); 
		else
		{
			/*if(left.bst == true)
				return new ReturnBSTinaBT(false, left.size, left.min, left.max);
			
			else if(right.bst == true)
				return new ReturnBSTinaBT(false, right.size, right.min, right.max);
			
			else
				return new ReturnBSTinaBT(false, 0, 1121, 3232);*/
			
			/* above commented lines don't work because : it is possible that for this node, 
			 * the left is a BST, and the right is not BST but
			 * there is some subtree wayy down on the right side which is a BST, so finally
			 * you would like that to be reported as the answer */
			if(left.size >= right.size)
				return new ReturnBSTinaBT(false, left.size, left.min, left.max, left.root);
			else
				return new ReturnBSTinaBT(false, right.size, right.min, right.max, right.root);
		}
	}
	
	/* print boundary of BT */
	public void printBoundary(Node root)
	{
	  if (root == null) return;
	  System.out.print(root.data + " ");
	  if (root.left != null)
		  traverseL(root.left ); //special function for outer left
	  if (root.right != null)
		  traverseR(root.right); //special function for outer right
	}

	static void traverseL(Node p)
	{
	  System.out.print(p.data + " ");
	  if (p.left != null)
		  traverseL(p.left ); //still in outer left
	  if (p.right != null)
		  traverseC(p.right); 
	}

	static void traverseR(Node p)
	{
	  if (p.left != null)
		  traverseC(p.left );
	  if (p.right  != null)
		  traverseR(p.right); //still in outer right
	  System.out.print(p.data + " ");
	}

	static void traverseC(Node p)
	{
	  if (p.left == null && p.right == null) //bottom reached
	    System.out.print(p.data + " ");
	  else
	  {
	    if (p.left != null)
	    	traverseC(p.left );
	    if (p.right != null)
	    	traverseC(p.right);
	  }
	}
	
	/* Inorder successor */
	public int inordersuccessor(int key)
	{
		System.out.println("came inside inordersuccessor...");
		
		Node successor = null;
		Node trav = root;
		
		while(trav.data != key)
		{
			if(key < trav.data)
			{
				successor = trav;//we know this trav is definitely > than key, so for now, this is the answer. If next one still happens to be greater than key, (and also we know that will be less than trav), then that will be the answer 
				trav = trav.left;
			}
			else//all of these elements are smaller than key, so they cannot be the successor
				trav = trav.right;
		}
		
		if(trav.right != null)
		{
			trav = trav.right;
			while(trav != null)
			{
				successor = trav;
				trav = trav.left;
			}
		}
		
		return successor.data;
	}
	
	/* Inorder predecessor */
	public int prededecessor(int key)
	{
		Node trav = root;
		Node successor = null;
		
		while(trav.data != key)
		{
			if(trav.data < key)
			{
				successor = trav;
				trav = trav.right;
			}
			else
				trav = trav.left;
		}
		
		if(trav.left != null)
		{
			trav = trav.left;
			successor = trav;
			while(trav != null)
			{
				successor = trav;
				trav = trav.right;
			}
		}
		return successor.data;
	}
	
	/* supporting functions */
	public void printArrayList(ArrayList<Integer> al)
	{
		for(int i = 0;i<al.size();i++)
			System.out.print(al.get(i) + " ");
	}
	
	static int min(int a, int b)
	{
		return a<b?a:b;
	}
	
	static int max(int a, int b)
	{
		return a>b?a:b;
	}
}

class StringString
{
	String tree;
	String identicalTree;
	public StringString(String tree, String identicalTree) {
		// TODO Auto-generated constructor stub
		this.tree = tree;
		this.identicalTree = identicalTree;
	}
}

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class ReturnBSTinaBT
{
	boolean bst;
	int size;
	int min;
	int max;
	Node root;
	
	public ReturnBSTinaBT(boolean bst, int size, int min, int max, Node root) {
		// TODO Auto-generated constructor stub
		this.bst = bst;
		this.size = size;
		this.min = min;
		this.max = max;
		this.root = root;
	}
}