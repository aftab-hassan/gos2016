/*
 * ReverseLinkedListIterativeConceptButTailRecursion.java
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
public class ReverseLinkedListIterativeConceptButTailRecursion {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        LinkList linkedList = new LinkList();
        
        for(int i =0;i<6;i++)
            linkedList.insert( i );
        linkedList.display();
        
        ReverseLinkedListIterativeConceptButTailRecursion reverseLinkedListIterativeConceptButTailRecursion = new ReverseLinkedListIterativeConceptButTailRecursion();
        reverseLinkedListIterativeConceptButTailRecursion.reverse( linkedList, null, linkedList.head );
        System.out.println( "" );
        linkedList.display();
    }
    
    public void reverse(LinkList linkedList, Node prev, Node curr)
    {
        if(curr == null)
            linkedList.head = prev;
        
        else
        {
            Node next = curr.next;
            curr.next = prev;
            
            reverse( linkedList, curr, next );
        }   
    }

}
