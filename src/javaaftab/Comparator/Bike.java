/*
 * Vehicle.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.Comparator;

/**
 * @author aftabhassan
 */
public class Bike {
    String title;
    int wheels;

    public Bike( String title ) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " ";
    }
}
