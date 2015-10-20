/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobiuspuzzle;

import java.util.ArrayList;

/**
 *
 * @author Egor Kozitski
 */

public  class Mobius implements Puzzle {
    public int goal=14;
    public int start=2;
    public int range=15;
     @Override
    public int getGoal() {
       return goal;
    }

    @Override
    public java.util.ArrayList<java.lang.Integer> getNeighbors(int config) {
       if(config<1)
           return null;
       if(config>range)
           return null;
       ArrayList<Integer> neighbor = new ArrayList<Integer>();
       if(config==range)
           neighbor.add(1);
       if(config==1)
           neighbor.add(range);
       else{
           int leftNeighbor = config-1;
           config=config+1;
           int rightNeighbor = config + 1;
           neighbor.add(leftNeighbor);
           neighbor.add(rightNeighbor);
        }
       return neighbor;
    }

    @Override
    public int getStart() {
        return start;
    }
    public static void main(String []args){
        Mobius mob =  new Mobius();
        Solver solve = new Solver();
        System.out.println(solve.solve(mob));
    }

   
}