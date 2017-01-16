/*
 * CheckPalindrome.java
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
public class CheckPalindromePushToStack {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        LinkList linkedList = new LinkList();
        linkedList.insert( 1 );
        linkedList.insert( 2 );
        linkedList.insert( 3 );
        linkedList.insert( 3 );
        linkedList.insert( 2 );
        linkedList.insert( 1 );
        
        LinkList linkedList2 = new LinkList();
        linkedList2.insert( 1 );
        linkedList2.insert( 2 );
        linkedList2.insert( 3 );
        linkedList2.insert( 2 );
        linkedList2.insert( 1 );
        linkedList2.insert( 0 );
        
        CheckPalindromePushToStack checkPalindromePushToStack = new CheckPalindromePushToStack();
        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList ) );
        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList2 ) );
    }
    
    /*
     * 1. Push half the elements to a queue
     * 2. Reverse the linked list
     * 3. Poll from queue, and see if the first half (ie, the last half from the original list) is same as the queue
     */
    public boolean checkPalindrome(LinkList linkedList)
    {
        Node trav = linkedList.head;
        Stack<Node> myStack = new Stack<>();
        
        while(trav!=null)
        {
            myStack.push( trav );
            trav = trav.next;
        }
        
        trav = linkedList.head;
        while(myStack.size() > 0)
        {
            Node beginning = trav;
            Node end = myStack.pop();
            
            if(beginning.data != end.data)
                return false;
            
            trav = trav.next;
        }
        
        return true;   
    }

}
