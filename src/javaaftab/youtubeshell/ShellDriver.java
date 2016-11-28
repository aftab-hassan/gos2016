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

/* Naming Convention
 * class names - all individual words capitalized
 * object      - first letter always small, subsequent individual words capitalized 
 * 
 * Examples
 * class Hello
 * class HelloDriver
 * 
 * public void fun
 * public void funTest
 * 
 * Animal animal = new Animal();
 * Animal newAnimal = new Animal();
 * */

    
/**
 * @author aftabhassan
 */
public class ShellDriver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        ShellUtil shell = new ShellUtil();
        
        /* populate to have something to begin with */
        shell.populateVideos();
        shell.populateUsers();
        shell.populatePaidVideos();
        
        /* display contents populated so far */
        shell.displayVideos();
        shell.displayUsers();
        shell.displayPaidVideos();
        
        /* user1 watches video 5,6,7*/
        shell.shellWatchVideo( "U_1", "V_1" );
        shell.shellWatchVideo( "U_1", "V_5" );
        shell.shellWatchVideo( "U_1", "V_8" );
        System.out.println( shell.userManager.users.get( "U_1" ).history );
        
        /* adding a user named "foo" */
        System.out.println( "Adding a user called foo" );
        shell.userManager.addUser( "U_foo", new User( "U_foo", "fooFirstNname", "fooLastName", 45, "fooLand" ) );
        shell.displayUsers();
        
        /* adding a new video */
        System.out.println( "Adding a video called V_lambda" );
        shell.videoManager.addVideo( "V_lambda", new Video( "V_lambda", "https://www.youtube.com/watch?v=a450CqNXFgs", new Date() ) );
        shell.displayVideos();
        
        /* deleting a user */
        System.out.println( "Removing a user called U_7" );
        shell.userManager.removeUser( "U_7" );
        shell.displayUsers();
        
        /* deleting a video */
        System.out.println( "Removing a video called V_4" );
        shell.videoManager.removeVideo( "V_4" );
        shell.displayVideos();
    }
}
