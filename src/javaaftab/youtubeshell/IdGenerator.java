/*
 * IdGenerator.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.youtubeshell;

/**
 * @author aftabhassan
 *
 */
public abstract class IdGenerator {
    int id;
    
    /**
     * 
     */
    public IdGenerator() {
        // TODO Auto-generated constructor stub
        this.id = 0;
    }
    
//    public int getId()
//    {
//        System.out.println( "came inside IdGenerator.getId() method" );
//        this.id = this.id + 1;
//        return this.id;
//    }

    public String getId() {
        // TODO Auto-generated method stub
        this.id = this.id + 1;
        return this.id + "";
    }
}
