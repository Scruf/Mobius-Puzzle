/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobiuspuzzle;

import java.util.ArrayList;

/**
 *
 * @author ekozi
 */
public class Solver {
    public ArrayList<Integer> solve(Puzzle puzzle){
       ArrayList<ArrayList<Integer>> queue = new  ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> element = new ArrayList<Integer>(1);
       element.add(puzzle.getStart());
       queue.add(element);
    
       boolean found = false;
       if(puzzle.getStart()==puzzle.getGoal())
           found=true;
       while(!queue.isEmpty() && !found){
       
           element=queue.get(0);
           queue.remove(0);
        
           for(Integer i : puzzle.getNeighbors(element.get(element.size()-1))){
               System.out.println(i);
               ArrayList<Integer> nextConfig = new ArrayList(element);
               nextConfig.add(i);
               if(nextConfig.get(0)==puzzle.getGoal()){
                   element=nextConfig;
                   found=true;
                   break;
               }
               else{
                   element.add(nextConfig.get(0)); 
               }
           }
           
       }
       if(found)
           return element;
       else
           return null;
    }
}
