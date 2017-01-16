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

/**
 * @author aftabhassan
 *
 */
public class ReverseIterativeThreePointersIterative {
    public static void main( String[] args ) {
LinkList linkedList = new LinkList();
        
        for(int i =0;i<6;i++)
            linkedList.insert( i );
        linkedList.display();
        
        ReverseIterativeThreePointersIterative reverse = new ReverseIterativeThreePointersIterative();
        reverse.reverseIterativeTwoPointers( linkedList );
        System.out.println( "" );
        linkedList.display();
    }
    
    public void reverseIterativeTwoPointers(LinkList linkedList)
    {
        Node prev = null;
        Node current = linkedList.head;
        Node next = current.next;
        while(current != null)
        {
            current.next = prev;
            prev = current;
            current = next;
            
            if(next != null)
                next = next.next;
        }
        linkedList.head = prev;
    }
}
