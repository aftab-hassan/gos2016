/*
 * Video.java
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

import java.util.Date;

/**
 * @author aftabhassan
 */
public class PaidVideo extends Video {
    int price;
    
    /**
     * @param id
     * @param url
     * @param uploadDate
     */
    public PaidVideo( String id, String url, Date uploadDate, int price ) {
        super( id, url, uploadDate );
        this.price = price;
        // TODO Auto-generated constructor stub
    }
   
    @Override
    public String toString()
    {
        return this.id;
    }
    
    public void setPrice(int price)
    {
        this.price = price;
    }
}