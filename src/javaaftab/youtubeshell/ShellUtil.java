/*
 * shell.java
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
import java.util.Set;

/**
 * @author aftabhassan
 */
public class ShellUtil {

    VideoManager videoManager;
    UserManager userManager;
    PaidVideoManager paidVideoManager;
    VideoIdGenerator videoIdGenerator;
    UserIdGenerator userIdGenerator;
    PaidVideoIdGenerator paidVideoIdGenerator;

    public ShellUtil() {
        videoManager = new VideoManager();
        userManager = new UserManager();
        paidVideoManager = new PaidVideoManager();
        videoIdGenerator = new VideoIdGenerator();
        userIdGenerator = new UserIdGenerator();
        paidVideoIdGenerator = new PaidVideoIdGenerator();
    }

    /* Creating videos */
    public void populateVideos()
    {    
        System.out.println( "populating videos..." );
        for(int i = 0;i<10;i++)
        {
            Video video = new Video( videoIdGenerator.getId(), "url"+i, new Date() );
            videoManager.addVideo( video.id, video  );
            System.out.println( "Created "+video.id );
        }
    }
    
    /* Creating users */
    public void populateUsers()
    {
       
        System.out.println( "populating users..." );
        for(int i = 0;i<10;i++)
        {
            User user = new User( userIdGenerator.getId(), "firstname"+i, "lastname"+i, (int)(Math.random() * 100), "country"+i );
            userManager.addUser( user.id, user );
            System.out.println( "Created "+user.id );
        }
    }
    
    /* Creating paid videos */
    public void populatePaidVideos()
    {
        
        System.out.println( "populating paid videos..." );
        for(int i = 0;i<10;i++)
        {            
            PaidVideo paidVideo = new PaidVideo( paidVideoIdGenerator.getId(), "url"+i, new Date(), (int)(Math.random() * 100) );
            paidVideoManager.addPaidVideo( paidVideo.id, paidVideo );
            System.out.println( "Created " + paidVideo );
        }
    }
    
    /* Displaying all videos */
    public void displayVideos()
    {
       
        System.out.println( "Displaying videos..." );
        Set<String> videoids = videoManager.videos.keySet();
        for(String videoid : videoids)
            System.out.println( videoManager.videos.get( videoid ) );
    }
    
    /* Displaying all users */
    public void displayUsers()
    {
        
        System.out.println( "Displaying users..." );
        Set<String> userids = userManager.users.keySet();
        for(String userid : userids)
            System.out.println( userManager.users.get( userid ) );
    }
    
    /* Displaying paid videos */
    public void displayPaidVideos()
    {
        
        System.out.println( "Displaying paid videos..." );
        Set<String> paidvideosids = paidVideoManager.paidVideos.keySet();
        for( String paidvideoid : paidvideosids)
            System.out.println( paidVideoManager.paidVideos.get( paidvideoid ) );
    }
    
    /* When the shell does shellWatchVideo, two things need to happen 
     * 1. the video gets added to the user's watch history 
     * 2. the user gets added to the video's viewers */
    public void shellWatchVideo(String userid, String videoid)
    {
        User user = userManager.users.get(userid );
        Video video = videoManager.videos.get( videoid );
        
        user.watchVideo( video );
        video.addViewer( user );
    }
    
    public void shellWatchPaidVideo(String userid, String paidVideoId)
    {   
        User user = userManager.users.get(userid );
        PaidVideo paidVideo = paidVideoManager.paidVideos.get( paidVideoId );
        
        user.watchPaidVideo( paidVideo );
        paidVideo.addViewer( user );
    }
 
}
