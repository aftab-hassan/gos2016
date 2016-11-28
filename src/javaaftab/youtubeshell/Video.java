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

import java.util.ArrayList;
import java.util.Date;

/**
 * @author aftabhassan
 */
public class Video {
    String id;
    String url;
    int likes;
    int disklikes;
    Date uploadDate;
    ArrayList<User> viewers;
 
    /**
    * 
    */
    public Video( String id, String url, Date uploadDate ) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.url = url;
        this.likes = 0;
        this.disklikes = 0;
        this.uploadDate = uploadDate;
        viewers = new ArrayList<>();
    }
    
    public void addViewer(User user)
    {
        this.viewers.add( user );
    }
    
    @Override
    public String toString()
    {
        return this.id;
    }
}