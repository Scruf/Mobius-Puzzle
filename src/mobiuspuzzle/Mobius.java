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
    public ArrayList<Integer> getNeighbors(int config) {
       
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        if(range==1){
            neighbors.add(config);
            return neighbors;
        }
        else{
            int leftNeighbor = config-1;
            int rightNeighbor = config+1;
            neighbors.add(leftNeighbor);
            neighbors.add(rightNeighbor);
            return neighbors;
        }
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
