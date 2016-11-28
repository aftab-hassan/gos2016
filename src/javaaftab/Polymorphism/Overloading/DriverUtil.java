/*
 * DriverUtil.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.Polymorphism.Overloading;

/**
 * @author aftabhassan
 *
 */
public class DriverUtil {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        DriverUtil obj = new DriverUtil();
        
        obj.fun();
        obj.fun(1);
        obj.fun( 1, 2 );
    }

    /* All this is overloading */
    public void fun()
    {
        System.out.println( "zero args" );
    }
    
    public void fun(int a)
    {
        System.out.println( "one arg" );
    }
    
    public void fun(int a, int b)
    {
        System.out.println( "two args" );
    }
}
