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
package javaaftab.Comparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author aftabhassan
 */
public class CaravanDriver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        ArrayList<Caravan> caravans = new ArrayList<>();

        caravans.add( new Caravan( "abc" ) );
        caravans.add( new Caravan( "bac" ) );
        caravans.add( new Caravan( "ebc" ) );
        caravans.add( new Caravan( "cab" ) );
        caravans.add( new Caravan( "dbc" ) );

        System.out.println( caravans );

        // Method 2
        Collections.sort( caravans );

        System.out.println( caravans );
    }

}
