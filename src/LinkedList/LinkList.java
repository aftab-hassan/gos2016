package LinkedList;

/*
 * ReverseLinkedList.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

/**
 * @author aftabhassan
 *
 */
public class LinkList
{
    Node head;
    Node prev;
    
    /**
     * 
     */
    public LinkList() {
        // TODO Auto-generated constructor stub
        head = null;
        prev = null;
    }
     
    public void insert(int data)
    {
        Node node = new Node( data );
        if(head == null)
        {
            head = node;
            prev = node;
        }
        else
        {
            prev.next = node;
            prev = node;
        }
    }
    
    public void display()
    {
        Node trav = head;
        while(trav != null)
        {
            System.out.print( trav.data + " " );
            trav = trav.next;
        }
    }
}

class Node
{
    int data;
    Node next;
    
    /**
     * 
     */
    public Node(int data) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.next = null;
    }
    
    public String toString()
    {
        return data + " ";
    }
}