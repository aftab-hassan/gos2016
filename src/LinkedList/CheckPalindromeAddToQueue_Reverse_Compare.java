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

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aftabhassan
 *
 */
public class CheckPalindromeAddToQueue_Reverse_Compare {

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
//        linkedList2.insert( 0 );
        
        CheckPalindromeAddToQueue_Reverse_Compare checkPalindromePushToStack = new CheckPalindromeAddToQueue_Reverse_Compare();
        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList ) );
        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList2 ) );
    }
    
    public boolean checkPalindrome(LinkList linkList)
    {
        Queue<Node> myQueue = new LinkedList<>();
        
        Node trav = linkList.head;
        while(trav != null)
        {
            myQueue.add( trav );
            trav = trav.next;
        }
        
        reverse( linkList.head, linkList );
        
        trav = linkList.head;
        while(myQueue.size() > 0)
        {
            Node front = myQueue.poll();
            Node end = trav;
            
            if(front.data != end.data)
                return false;
            trav = trav.next;
        }
        
        return true;   
    }

    public Node reverse(Node node, LinkList linkList)
    {
        if(node.next == null)
        {
            linkList.head = node;
            return node;
        }
        
        Node rec = reverse( node.next, linkList );
        rec.next = node;
        node.next = null;
        
        return node;
    }
}
