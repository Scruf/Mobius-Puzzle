/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobiuspuzzle;

/**
 *
 * @author ekozi
 */
import java.util.ArrayList;
/**
 * Created by darren wickham on 10/26/15.
 */
public class Mobius implements Puzzle
{
    private int range;
    private int start;
    private int goal;

    public Mobius(int range, int start, int goal)
    {
        if(range > 0)
        {
            this.range = range;
        }
        else
        {
            System.err.println("Invalid Range");
        }
        if(start > 0)
        {
            this.start = start;
        }
        else
        {
            System.err.println("Invalid Start");
        }
        this.goal = goal;
    }

    public int getStart()
    {
        return start;
    }

    public int getRange()
    {
        return range;
    }

    public int getGoal()
    {
        return goal;
    }

    public ArrayList<java.lang.Integer> getNeighbors(int config)
    {
        ArrayList<Integer> neighbours = new ArrayList<>();

        if(config == 0)
        {
            neighbours.add(this.range-1);
            neighbours.add(1);
            return neighbours;
        }
        else if(config == range)
        {
            neighbours.add(range-2);
            neighbours.add(0);
            return neighbours;
        }
        else
        {
            neighbours.add(config - 1);
            neighbours.add(config+1);
            return neighbours;
        }
    }

    public static void main(String[] args)
    {
        Puzzle mobius = new Mobius(15, 2, 14);
        Solver solver = new Solver();
        ArrayList<Integer> result = new ArrayList<>();
        solver.solve(mobius);
        /*for (int i = 0; i < result.size(); i++)
        {
            System.out.println("Step " + i + ":" + result.get(i));
        }*/
    }


}