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

/**
 * @author aftabhassan
 *
 */
// https://leetcode.com/problems/palindrome-linked-list/
public class CheckPalindrome_ReverseSecondHalf {

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
        
        LinkList linkedList3 = new LinkList();
        linkedList3.insert( 1 );
        
        CheckPalindrome_ReverseSecondHalf checkPalindromePushToStack = new CheckPalindrome_ReverseSecondHalf();
//        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList ) );
//        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList2 ) );
        System.out.println( checkPalindromePushToStack.checkPalindrome( linkedList3 ) );
    }
    
    /*
     * 1. reverse the second half of the linked list
     * 2. Now you can traverse from the start as well as end.
     * 3. Traverse simultaneously and make sure they're the same
     * 
     */
    public boolean checkPalindrome(LinkList linkList)
    {
        int length = 0;
        
        Node start = linkList.head;
        Node trav = linkList.head;
        while(trav != null)
        {
            length++;
            trav = trav.next;
        }
        
        trav = linkList.head;
        for(int i = 0;i<length/2;i++)
            trav = trav.next;
        
        reverse( trav, linkList );
        
        Node end = linkList.head;
        for(int i = 0;i<length/2;i++)
        {
            if(start.data != end.data)
                return false;
            start = start.next;
            end = end.next;
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
