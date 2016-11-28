/*
 * BaseClass.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.Polymorphism.Overriding;

/**
 * @author aftabhassan
 *
 */
public class BaseClass extends SuperClass{

    /**
     * 
     */
    public BaseClass() {
        // TODO Auto-generated constructor stub
        System.out.println( "inside the constructor of BaseClass" );
    }
    
    @Override
    public void fun()
    {
        System.out.println( "inside the fun of base class" );
    }
}
