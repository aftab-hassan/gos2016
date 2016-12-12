package DP.DictionaryStringproblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/*
 * LongestWordMadeOfOthersInTheList.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

/**
 * @author aftabhassan
 *
 */
public class TODO_LongestWordMadeOfOthersInTheList_CTCI187 {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        ArrayList<String> list = new ArrayList<String>(Arrays.asList( "godfatherhoods","godfathers","godfather","father","hood","god" ));
        
        TODO_LongestWordMadeOfOthersInTheList_CTCI187 obj = new TODO_LongestWordMadeOfOthersInTheList_CTCI187();
        System.out.println( obj.longestWord( list ) );
    }
    
    public String longestWord(ArrayList<String> list)
    {
        Hashtable<String, Boolean> dictionary = new Hashtable<>();
        for(String str : list)
            dictionary.put(str, true);

        /* going in descending order */
        for(String str : list)
        {
            if(isFormable( str, dictionary, true ))
                return str;
        }
        
        return "NotPossible";
    }
    
    public boolean isFormable(String str, Hashtable<String, Boolean> dictionary, boolean isOriginalWord)
    {
        if(dictionary.containsKey(str) && !isOriginalWord)
            return true;

        for(int i = 1;i<str.length();i++)
        {
            if(dictionary.containsKey(str.substring(0, i)) && isFormable(str.substring(i, str.length()), dictionary, false))
                return true;
        }

        return false;
    }

    
}
