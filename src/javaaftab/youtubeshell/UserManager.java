/*
 * UserManager.java
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
public class UserManager {
    Hashtable<String, User> users;

    /**
     * 
     */
    public UserManager() {
        // TODO Auto-generated constructor stub
        users = new Hashtable<String, User>();
    }

    public User removeUser( String id ) {
        return users.remove( id );
    }

    public User addUser( String id, User user ) {
        
        users.put( id, user );// I'm able to access the user's id although this is a different class

        return user;
    }

    public User findUser( String id ) {
        User user = users.get( id );
        return user;
    }
}
