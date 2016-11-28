/*
 * InheritanceDriver.java
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
 */
public class InheritanceDriver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        Mercedes mercedes = new Mercedes();

        /*
         * As soon as you use the word extends, the base class (and it's objects) can start using the members of the
         * super class like it was it's own
         */
        System.out.println( "wheels == " + mercedes.wheels );

        System.out.println( "color == " + mercedes.color );
        System.out.println( "topspeed == " + mercedes.topspeed );

        /* base class takes precedence over the super class if there is a member of the same name */
        System.out.println( "seats == " + mercedes.seats );

        /* if you want a variable/method from the super class, have to mention that in the base class */
        System.out.println( "seats == " + mercedes.getCarseats() );

        /*
         * Example of Multi-level inheritance. Nearest to farthest. If the definition of a method is not found in the
         * RedMercedes class, it looks for it in the Mercedes class, and if it doesn't find it again there, it looks for
         * it in the Mercedes class
         */
        RedMercedes redMercedes = new RedMercedes();
        redMercedes.display();

        /* A base class can access protected members of Super class */
        GreenMercedes greenMercedes = new GreenMercedes();
        System.out.println( "Printing owner" );
        System.out.println( greenMercedes.getOwner());

        /* A base class cannot access private members of super class */
        // System.out.println( greenMercedes.unlockcode );
        
        /* Trying to override a final method - Cannot override the final method from Car */
       mercedes.myFinalMethod();    
       
       /* Using super inside a base class, to print whatever the super class was printing, plus adding the extra fields
        * that belong to the base class*/
       mercedes.displayFields();
    }

}

class Car {
    int wheels;
    int seats;

    public Car() {
        this.wheels = 4;
        this.seats = 4;
    }

    public void display() {
        System.out.println( "inside Car class" );
    }
    
    public final void myFinalMethod()
    {
        System.out.println( "inside a final method" );
    }
    
    public void displayFields()
    {
        System.out.println( "wheels == "+wheels +",seats == " + seats );
    }
}

class Mercedes extends Car {
    String color;
    int topspeed;
    int seats;
    private String unlockcode;
    protected String owner;

    public Mercedes() {
        this.color = "blue";
        this.topspeed = 200;
        this.seats = 2;
        this.owner = "iamtheowner";
    }

    public int getCarseats() {
        return super.seats;
    }

    // public void display() {
    // System.out.println( "inside Mercedes class" );
    // }
        
//    @Override
//    public void myFinalMethod()
//    {
//        
//    }
    
    @Override
    public void displayFields()
    {
        super.displayFields();
        System.out.println( "color == " +color +",topspeed == " + topspeed+",owner == " + owner );
    }
}

class RedMercedes extends Mercedes {
    String color;

    public RedMercedes() {
        this.color = "red";
    }

    // public void display() {
    // System.out.println( "inside RedMercedes class" );
    // }
}

class GreenMercedes extends Mercedes {
    String color;

    public GreenMercedes() {
        this.color = "green";
    }

    // public String getunlockcode() {
    // return unlockcode;
    // }

    public String getOwner() {
        return owner;
    }
    // public void display() {
    // System.out.println( "inside GreenMercedes class" );
    // }
}
