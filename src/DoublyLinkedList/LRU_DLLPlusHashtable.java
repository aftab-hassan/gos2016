package DoublyLinkedList;
import java.util.Hashtable;

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
public class LRU_DLLPlusHashtable {
    
    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
             
//        Node node = new Node( 5 );
//        Node temp = node;
//        System.out.println( node.value +"_" + temp.value );
//        
//        node.value = 10;
//        System.out.println( node.value +"_" + temp.value );
//        
//        node = null;
//        System.out.println( temp.value );
//        
//        node = new Node( 6 );
//        temp = node;
//        System.out.println( node.value +"_" + temp.value );
      
//        Check 1
//        LRU lru = new LRU(10);
//        for(int i = 1; i < 11; i++) {
//            lru.set(i, 10*i);
//          }
//        
//        lru.printLruCache();
//        lru.set(11, 110);
//        lru.set(10, 120);
//        lru.printLruCache();
//          
//        System.out.println( lru.get( 3 ) );
//        lru.printLruCache();
        
        //Check 2
//        LRU lru = new LRU( 4 );
//        lru.set(1,11);
//        lru.set(2,22);
//        lru.set(3,33);
//        lru.set(4,44);
//        System.out.println( lru.get( 4 ) );
//        System.out.println( lru.get( 3 ) );
//        lru.set(5,55);
//        lru.set(6,66);
//        System.out.println( lru.get( 6 ) );
        
        //Check 3
        LRU lru = new LRU( 5 );
        System.out.println( lru.get( 5 ) );
        lru.set(5, 55);
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 24 ) );
        lru.set(1, 11);
        lru.set(2, 22);
        lru.set(3, 33);
        System.out.println( lru.get( 1 ) );
        System.out.println( lru.get( 2 ) );
        System.out.println( lru.get( 3 ) );
        System.out.println( lru.get( 5 ) );
        
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 3 ) );
        System.out.println( lru.get( 2 ) );
        System.out.println( lru.get( 1 ) );
        
        lru.set(4, 44);
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 4 ) );
        System.out.println( lru.get( 3 ) );
        System.out.println( lru.get( 2 ) );
        System.out.println( lru.get( 1 ) );
        
        lru.set(6, 66);
        System.out.println( lru.get( 1 ) );
        System.out.println( lru.get( 2 ) );
        System.out.println( lru.get( 3 ) );
        System.out.println( lru.get( 4 ) );
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 6 ) );
        
        lru.set( 6, 676 );
        System.out.println( lru.get( 6 ) );
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 4 ) );
        System.out.println( lru.get( 3 ) );
        System.out.println( lru.get( 2 ) );
        System.out.println( lru.get( 1 ) );
        
        lru.set( 7, 77 );
        lru.set( 8, 88 );
        System.out.println( lru.get( 1 ) );
        System.out.println( lru.get( 2 ) );
        System.out.println( lru.get( 3 ) );
        System.out.println( lru.get( 4 ) );
        System.out.println( lru.get( 5 ) );
        System.out.println( lru.get( 6 ) );
        System.out.println( lru.get( 7 ) );
        System.out.println( lru.get( 8 ) );
    }

}

class LRU
{
    Hashtable<Integer, Node> LRU;
    Node head;
    Node tail;
    int size;
    
    /**
     * 
     */
    public LRU(int size) {
        // TODO Auto-generated constructor stub
        LRU = new Hashtable<>();
        head = null;
        tail = null;
        this.size = size;
    }
    
    public void set(int key, int value)
    {
        Node node = this.LRU.get( key );
        if(node == null)
        {
            node = new Node( key, value );
            if(this.LRU.size() == size)
            {
                LRU.remove( tail.key );
                remove( tail );
                makehead( node );
            }
            else
            {
                makehead( node );
            }
        }
        else
        {
            node.value = value;
            remove( node );
            makehead( node );
        }
        
        LRU.put( key, node );
    }
    
    public int get(int key)
    {
        Node node = LRU.get( key );
        if(node == null)
            return -1;
        
        remove( node );
        makehead( node );
        return head.value;
    }
    
    /* utility methods */
    public void remove(Node node)
    {
        if(head == node)
        {
            head = node.next;
            return;
        }
            
        
        if(tail == node)
        {
            if(tail.prev != null)
            {
                tail = tail.prev;
                tail.next = null;
            }
                
            else
                tail = null;
            
            return;
        }
           
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void makehead(Node node)
    {
        if(head == null)
        {
            head = tail = node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    public void printLruCache()
    {
        Node node = head;
        while(node != null)
        {
            System.out.println( node );
            node = node.next;
        }
    }
}

class Node
{
    int key;
    int value;
    Node next;
    Node prev;
    
    /**
     * 
     */
    public Node(int key, int value) {
        // TODO Auto-generated constructor stub
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    
    @Override
    public String toString()
    {
        return "Key:"+this.key+",Value:"+this.value;
    }
}