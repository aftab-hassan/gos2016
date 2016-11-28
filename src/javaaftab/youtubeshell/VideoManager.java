/*
 * VideoManager.java
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
public class VideoManager {
    Hashtable<String, Video> videos;

    public VideoManager() {
        videos = new Hashtable<String, Video>();
    }

    public Video addVideo( String id, Video video ) {
        videos.put( id, video );
        return video;
    }

    public Video findVideo( String id ) {
        return videos.get( id );
    }

    public Video removeVideo( String id ) {
        return videos.remove( id );
    }
}
