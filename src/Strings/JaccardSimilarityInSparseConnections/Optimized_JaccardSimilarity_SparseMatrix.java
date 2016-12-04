/*
 * Optimized_JaccardSimilarity_SparseMatrix.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Strings.JaccardSimilarityInSparseConnections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * @author aftabhassan
 *
 *
 *The similarity of two documents (each with distinct words) is defined to be the size of the 
intersection divided by the size of the union. For example, if the documents consist of integers, the similarity of 
{1, 5, 3} and {1, 7, 2, 3} is 0.4, because the intersection has size 2 and the union has size 5.

We have a long list of documents (with distinct values and each with an associated ID) where the similarity is believed to be "sparse." That is, any two arbitrarily selected documents are very likely to have similarity 0. 
Design an algorithm that returns a list of pairs of document IDs and the associated similarity.

Print only the pairs with similarity greater than 0. Empty documents should not be printed at all. 
For simplicity, you may assume each document is represented as an array of distinct integers.

EXAMPLE

*Input*:
13: {14, 15, 100, 9, 3} 
16: {32, 1, 9, 3, 5}
19: {15, 29, 2, 6, 8, 7} 
24: {7, 10}

*Output*:
ID1, ID2 - SIMILARITY
13, 19 - 0.1
13, 16 - 0.25
19, 24 - 0.14285714285714285 (edited)

souptikji [7:25 PM]  
I am having an idea

[7:25]  
of inverting the table and finding out

[7:25]  
since you say that the similarity is  mostly 0, so there is no need to traverse O(n^2) pairs and doing linear operation on each

[7:26]  
instead of saving that ID 13 has docs {14, 15, 100, 9, 3}

[7:26]  
we can store that which doc is associated with what ID

[7:27]  
for instance in the example above, the docs which are replicated across IDs are-

[7:28]  
Doc-> {IDs}
15 -> {13, 19}
3->{13,16}
9->{13,16}
7->{19,24}

[7:28]  
So we know that we have to check only these 3 pairs {13,19} {13,16} and {19,24}


 */
public class Optimized_JaccardSimilarity_SparseMatrix {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        Hashtable<Integer, ArrayList<Integer>> input = new Hashtable<>();
        
        /*
         *  13: {14, 15, 100, 9, 3} 
            16: {32, 1, 9, 3, 5}
            19: {15, 29, 2, 6, 8, 7} 
            24: {15, 7, 10}
         */
        
        input.put(13, new ArrayList<Integer>(Arrays.asList(14,15,100,9,3)));
        input.put(16, new ArrayList<Integer>(Arrays.asList(32,1,9,3,5)));
        input.put(19, new ArrayList<Integer>(Arrays.asList(15,29,2,6,8,7)));
        input.put(24, new ArrayList<Integer>(Arrays.asList(7,10)));
        input.put(27, new ArrayList<Integer>(Arrays.asList(9, 29, 4, 6, 11)));
        
        Optimized_JaccardSimilarity_SparseMatrix obj = new Optimized_JaccardSimilarity_SparseMatrix();
        obj.unionComputation( input );
    }

    public void unionComputation(Hashtable<Integer, ArrayList<Integer>> input)
    {   
        /* input        : doc -> list of ids in that doc
           reverseInput : id  -> list of docs containing that id 
           This is what this part of the code does */
        Hashtable<Integer, ArrayList<Integer>> reverseInput = reverse(input);

        /* finding pairs where similarity computation would yield a non-zero result */
        Set<Tuple> pairsOfInterest = findPairsOfInterest(reverseInput);
        
        /* computing similarity for the pairs we're interested in */
        for(Tuple tuple : pairsOfInterest)
        {
            System.out.println("similarity for " + tuple + " : " + similarity(tuple.doc1, tuple.doc2, input));
            System.out.println( "" );
        }
    }

    /* input        : doc -> list of ids in that doc
           reverseInput : id  -> list of docs containing that id 
           This is what this part of the code does */
    public Hashtable<Integer, ArrayList<Integer>> reverse(Hashtable<Integer, ArrayList<Integer>> input)
    {
        Hashtable<Integer, ArrayList<Integer>> reverseInput = new Hashtable<Integer, ArrayList<Integer>>();
        for(int i : input.keySet())
        {
            ArrayList<Integer> integers = input.get(i);

            /* inserting this value into the reverseInput Hashtable */
            for(int j : integers)
            {
                ArrayList<Integer> contents;
                if(reverseInput.containsKey(j))
                {
                    contents  = reverseInput.get(j);
                }
                else
                {
                    contents = new ArrayList<Integer>();
                }

                contents.add(i);
                reverseInput.put( j, contents );
            }
        }
        
        return reverseInput;
    }

    /* finding pairs where similarity computation would yield a non-zero result */
    public HashSet<Tuple> findPairsOfInterest(Hashtable<Integer, ArrayList<Integer>> reverseInput)
    {
        HashSet<Tuple> toComputeSimilarity = new HashSet<Tuple>();
        for(int k : reverseInput.keySet())
        {
            ArrayList<Integer> contents = reverseInput.get(k);

            if(contents.size() > 1)
            {
                for(int i = 0;i<contents.size();i++)
                {
                    for(int j = i+1;j<contents.size();j++)
                    {
                        int doc1 = contents.get(i);
                        int doc2 = contents.get(j);
                        toComputeSimilarity.add(new Tuple(Math.min( doc1, doc2 ), Math.max( doc1, doc2 )));
                    }
                }
            }
        }
        
        return toComputeSimilarity;
    }

    /* computing similarity for the pairs we're interested in */
    public double similarity(int doc1, int doc2, Hashtable<Integer, ArrayList<Integer>> input)
    {
        ArrayList<Integer> doc1contents = input.get(doc1);
        ArrayList<Integer> doc2contents = input.get(doc2);
        Set<Integer> temp = new HashSet<Integer>();

        double union = doc1contents.size();
        double intersection = 0;
        temp.addAll(doc1contents);
        for(int i : doc2contents)
        {
            int originalSize = temp.size();
            temp.add(i);
            if(temp.size() > originalSize)
                union++;
            else
                intersection++;
        }

//        union += intersection;
        System.out.println( "{" + doc1 + "," + doc2 + "} : union == "+union+", intersection=="+intersection );

        return intersection/union;
    }
}

class Tuple
{
    int doc1;
    int doc2;

    public Tuple(int doc1, int doc2)
    {
        this.doc1 = doc1;
        this.doc2 = doc2;
    }

    @Override
    public boolean equals(Object o)
    {
        return this.doc1 == ((Tuple)o).doc1 && this.doc2 == ((Tuple)o).doc2;
    }
    
    @Override
    public int hashCode()
    {
        return 31*this.doc1 + this.doc2;
    }
    
    @Override
    public String toString()
    {
        return "{" + this.doc1 + "," + this.doc2 + "}";
    }
}
