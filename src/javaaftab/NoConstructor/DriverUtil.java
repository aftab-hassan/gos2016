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
package javaaftab.NoConstructor;

/**
 * @author aftabhassan
 *
 */
/*
 * If there is no constructors at all, it will assume there is a default constructor
 * However, if you declare only one constructor and that is a parametrized constructor, then it will throw an error
 */

public class DriverUtil {

    /**
     * 
     */
    public DriverUtil(int a, int b) {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 
     */
    public DriverUtil() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        DriverUtil obj = new DriverUtil();
        
        obj.fun();
    }

    public void fun()
    {
        
    }
}
