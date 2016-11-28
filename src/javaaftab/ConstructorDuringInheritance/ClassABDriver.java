/*
 * ClassABDriver.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.ConstructorDuringInheritance;

/**
 * @author aftabhassan
 *
 */

/*
 * 1. the sub class should have everything that the super class, plus it's own thing.
 So, it has to initialize the components that are common to both, which is done by using the constructor of the super class.
 
   2. If there is a default constructor in the super class or if there are no constructors at all, it does not complain.
   
   3. if ClassB extends ClassA, then A's constructor will be called first using super(whether you do it or the JVM does it)
   and only then will the Base class' constructor called
 */
public class ClassABDriver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        ClassB bObj = new ClassB(5);
        
        
    }

}
