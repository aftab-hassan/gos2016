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

import java.util.Comparator;

/**
 * @author aftabhassan
 */
public class Bus {
    String title;
    int wheels;

    public Bus( String title ) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " ";
    }

    public static Comparator<Bus> BusComparator = new Comparator<Bus>() {
        public int compare( Bus d1, Bus d2 ) {
            return d2.title.compareTo( d1.title );
        }
    };
}
