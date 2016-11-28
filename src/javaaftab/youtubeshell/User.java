/*
 * User.java
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

/**
 * @author aftabhassan
 */
public class User {
    String id;
    String firstname;
    String lastname;
    int age;
    String country;
    int subscribedtocount;
    ArrayList<User> subscibedtousers;
    int subscriberscount;
    ArrayList<User> subscribers;
    ArrayList<Video> history;
    ArrayList<Video> watchlater;
    ArrayList<PaidVideo> paidVideoHistory;
    int paid;

    /**
     * 
     */
    public User( String id, String firstname, String lastname, int age, String country ) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.country = country;
        this.subscribedtocount = 0;
        this.subscibedtousers = new ArrayList<User>();
        this.subscriberscount = 0;
        this.subscribers = new ArrayList<User>();
        this.history = new ArrayList<Video>();
        this.watchlater = new ArrayList<Video>();
        this.paidVideoHistory = new ArrayList<PaidVideo>();
        this.paid = 0;
    }

    public Video watchVideo( Video video ) {
        this.history.add( video );
        return video;
    }

    /* ask Bob */
//    public void watchPaidVideo(Video paidVideo)
//    {
//        this.history.add( paidVideo );
////        return paidVideo;
//    }
    
    public PaidVideo watchPaidVideo(PaidVideo paidVideo)
    {
        this.paidVideoHistory.add( paidVideo );
        return paidVideo;
    }
    
    public void deletehistory() {
        this.history.clear();
    }
    
    public void deletePaidVideoHistory() {
        this.paidVideoHistory.clear();
    }

    public Video addtowatchlater( Video video ) {
        this.watchlater.add( video );
        return video;
    }
    
    @Override
    public String toString()
    {
        return this.id;
    }
}
