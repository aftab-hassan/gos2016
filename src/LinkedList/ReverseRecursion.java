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
public class ReverseRecursion {
    public static void main( String[] args ) {
        LinkList linkedList = new LinkList();
        
        for(int i =0;i<6;i++)
            linkedList.insert( i );
        linkedList.display();
        
        ReverseRecursion reverse = new ReverseRecursion();
        reverse.reverseRecursion( linkedList.head, linkedList );
        System.out.println( "" );
        linkedList.display();
    }
    
    /*
     * 1->2->3->4->5->6
     * 1<-2<-3<-4<-5<-6
     */    
    public Node reverseRecursion(Node node, LinkList linkedList)
    {
        if(node == null)
            return null;
        
        Node rec = reverseRecursion( node.next, linkedList );
        if(rec == null)
            linkedList.head = node;
        else
        {
            rec.next = node;
            node.next = null;//this is actually only for node with data 0, so that it does not point to node 1.
                             //the rest of the nodes, which are referred to as, rec in the previous frame, are
                            //already pointing to 'node' in this frame, using the line above.
                            //But, for frame with data 0, there is no previous frame, and so there is no -1 frame,
                            //to make rec(0) point to null. Or you can do it in main(yuck!), or you can save the
                            //head pointer before recursion, at the time of insertion maybe, and make it point to null
                            //inside main, once this method returns to main
        }
        
        return node;
    }
}
