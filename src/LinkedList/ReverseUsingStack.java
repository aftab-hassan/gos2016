/*
 * Reverse.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package LinkedList;

import java.util.Stack;

/**
 * @author aftabhassan
 *
 */
public class ReverseUsingStack {
    public static void main( String[] args ) {
LinkList linkedList = new LinkList();
        
        for(int i =0;i<6;i++)
            linkedList.insert( i );
        linkedList.display();
        
        ReverseUsingStack reverse = new ReverseUsingStack();
        reverse.reverseUsingStack( linkedList );
        System.out.println( "" );
        linkedList.display();
    }
    
    public void reverseUsingStack(LinkList linkedList)
    {
        Stack<Node> stack = new Stack<>();
        Node trav = linkedList.head;
        while( trav != null )
        {
            stack.push( trav );
            trav = trav.next;
        }
        
        Node prev = stack.pop();
        linkedList.head = prev;
        while(stack.size() > 0)
        {
            Node current = stack.pop();
            prev.next = current;
            prev = current;
        }
        prev.next = null;
    }
}
