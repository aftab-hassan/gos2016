package javaaftab;

/*
 * LRU.java
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
public class PassByReference {
    
    /**
     * @param args
     */
    /* If you change the pointer, that is okay. But if you change the value, it reflects across all pointers */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
             
        Node node = new Node( 5 );
        Node temp = node;
        System.out.println( node.value +"_" + temp.value );
        
        node.value = 10;
        System.out.println( node.value +"_" + temp.value );
        
        node = null;
        System.out.println( temp.value );
        
        node = new Node( 6 );
        temp = node;
        System.out.println( node.value +"_" + temp.value );
    }

}

class Node
{
    int value;
    Node next;
    Node prev;
    
    /**
     * 
     */
    public Node( int value) {
        // TODO Auto-generated constructor stub
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}