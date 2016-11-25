/*
 * CarDriver.java
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
public class BikeComparator implements Comparator<Bike> {

    public int compare( Bike b1, Bike b2 ) {
        return b1.title.compareTo( b2.title );
    }

}
