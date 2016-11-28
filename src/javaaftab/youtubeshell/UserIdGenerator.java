/*
 * UserIdGenerator.java
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

/**
 * @author aftabhassan
 *
 */
public class UserIdGenerator extends IdGenerator {
    
    @Override
    public String getId()
    {
        return "U_" + super.getId();
    }
}
