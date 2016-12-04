package Graphs.minimummaximum_hops_between_2nodes;

import java.util.ArrayList;

/*
 * Vertex.java
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
public class Vertex {
   String name;
   boolean visited;
   ArrayList<Vertex> neighbors;
   
   public Vertex(String name)
   {
       this.name = name;
       this.visited = false;
       neighbors = new ArrayList<Vertex>();
   }
}
