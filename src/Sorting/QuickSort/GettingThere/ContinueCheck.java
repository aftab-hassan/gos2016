/*
 * ContinueCheck.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Sorting.QuickSort.GettingThere;

/**
 * @author aftabhassan
 *
 */
public class ContinueCheck {
    public static void main( String[] args ) {
        ContinueCheck obj = new ContinueCheck();
        
        obj.continueCheck();
    }
    
    public void continueCheck()
    {
        int i = 0;
        
        while ( i < 10 )
        { 
            if(i%2 == 0)
            {
                i++;
                continue;
            }
            
            System.out.println( i + " - odd" );
            i++;
        }
    }
}
