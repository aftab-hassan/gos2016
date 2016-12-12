package DP.PrintParen;

import java.util.HashSet;
import java.util.Set;

/*
 * PrintParen.java
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
public class PrintParen {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        PrintParen obj = new PrintParen();
        Set<String> output = obj.printParen( 3 );
        for(String string : output)
            System.out.println( string );
    }
    
    public Set<String> printParen(int n)
    {
        if(n == 0)
        {
                Set<String> ret = new HashSet<String>();
                ret.add("");//remember, there is 1 element in the set, not 0 //Rajvi, Microsoft Punjabi lady
                return ret;     
        }

        Set<String> rec = printParen(n-1);
        Set<String> ret = new HashSet<>();
        for(String str : rec)
        { 
            String newStr = "";
            for(int i = 0;i<str.length();i++)
            {
                if(str.charAt(i) == '(')
                {
                    System.out.println( "(0,"+(i+1)+"),("+i+str.length()+")" );
                    newStr = str.substring(0,i+1) + "()" +  str.substring(i+1, str.length());
                    ret.add(newStr);
                }
            }

            ret.add("()" + str); 
        }
        
        return ret;
    }

}
