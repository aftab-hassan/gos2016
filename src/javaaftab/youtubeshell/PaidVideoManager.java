/*
 * PaidVideoManager.java
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

import java.util.Hashtable;

/**
 * @author aftabhassan
 */
public class PaidVideoManager{
    Hashtable<String, PaidVideo> paidVideos;

    public PaidVideoManager() {
        paidVideos = new Hashtable<String, PaidVideo>();
    }

    public void addPaidVideo( String id, PaidVideo paidVideo ) {
        paidVideos.put( id, paidVideo );  
        
    }

    public PaidVideo findPaidVideo( String id ) {
        return paidVideos.get( id );
    }

    public PaidVideo removePaidVideo( String id ) {
        return paidVideos.remove( id );
    }
    
    public void setPrice(String id, int price)
    {
        paidVideos.get( id ).setPrice( price );
    }
}
