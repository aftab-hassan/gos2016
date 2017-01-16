/*
 * RLE_AliAyyash.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author aftabhassan
 *
 */
/*
 * Given a string like below, where the characters are in sorted order, find the k most frequent characters
 * in descending order of their counts
 * aaaabbbbbccdddeee, k=3 : {{b:5},{a:4},{d:3}}
 */
public class FindTopKRepeatingCharacters_AliAyyash_next {

    public static void main( String[] args ) {
        FindTopKRepeatingCharacters_AliAyyash_next obj = new FindTopKRepeatingCharacters_AliAyyash_next();
        
        String str = "qqqqqqwwwwwweeeeeeerrrrtttyuuoooopppppiiiiilllkkkkssaaadddkkkjjjggghhhhhbbbbnnnvvcccmmnnnzzz";
        int k = 4;
        ArrayList<Tuple> output = obj.findTopKRepeatingCharacters( str, k );
        System.out.println( output );
    }
    
    /* algorithm : O(n) + O(k) + O(n-k)logk + O(n-reverse) */
    public ArrayList<Tuple> findTopKRepeatingCharacters (String str, int k)
    {
        ArrayList<Tuple> output = new ArrayList<>();
        
        int count = 1;
        PriorityQueue<Tuple> myPriorityQueue = new PriorityQueue<>(new AscendingComparator());
        for(int i =0;i<str.length();i++)
        {
            char current = str.charAt( i );
//            char next = ' ';
//            if(i+1 != str.length())
//                next = str.charAt( i+1 );
//            if( (i+1) == str.length() || current != next)
            if( (i+1) == str.length() || current != str.charAt( i+1 ))
            {
                if(myPriorityQueue.size() < k)
                {
                    myPriorityQueue.add( new Tuple( current, count ) );
                }
                
                else if(myPriorityQueue.peek().count < count)
                {
                    myPriorityQueue.poll();
                    myPriorityQueue.add( new Tuple( current, count ) );      
                }
                
                count = 1;
            }
            else
            {
                count++;             
            }          
        }
        
        /* displaying */
        int size = myPriorityQueue.size();
        for(int i = 0;i<size;i++)
        {
            output.add( myPriorityQueue.poll() );
        }
        Collections.reverse( output );
        
        return output;
    }
}

class Tuple
{
    char ch;
    int count;
    
    /**
     * 
     */
    public Tuple(char ch, int count) {
        // TODO Auto-generated constructor stub
        this.ch = ch;
        this.count = count;
    }
    
    @Override
    public String toString()
    {
        return this.ch+":"+this.count;
    }
}

class AscendingComparator implements Comparator<Tuple>
{
    @Override
    public int compare (Tuple t1, Tuple t2)
    {
        return t1.count - t2.count;
    }
}