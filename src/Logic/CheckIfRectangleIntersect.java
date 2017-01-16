/*
 * CheckIfRectangleIntersect.java
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
package Logic;

public class CheckIfRectangleIntersect {

    /**
     * @param args
     */
    /*
     * http://www.geeksforgeeks.org/find-two-rectangles-overlap/
     * https://www.dropbox.com/home/screenshots?preview=rectangleoverlap.jpg
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        Point l1 = new Point( 0, 10 );
        Point r1 = new Point( 10, 0 );
        Point l2 = new Point( 5, 5 );
        Point r2 = new Point( 15, 10 );
        
        CheckIfRectangleIntersect obj = new CheckIfRectangleIntersect();
        if (obj.doOverlap(l1, r1, l2, r2))
            System.out.println( "overlap" );
        else
            System.out.println( "no overlap" );
    }

    /*
     * point1
     *  -------------
     *  |           |
     *  -------------
     *              point2    
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
    {
        if (r1.x < l2.x || r2.x < l1.x )
            return false;
        
        if (l1.y < r2.y || l2.y < r1.y)
            return false;
            
        return true;
    }
}

class Point
{
    int x;
    int y;
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}