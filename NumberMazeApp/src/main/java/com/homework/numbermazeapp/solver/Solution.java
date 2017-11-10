package com.homework.numbermazeapp.solver;

import java.io.Serializable;
import java.util.LinkedList;

public class Solution implements Cloneable, Serializable {

    private LinkedList<Direction> path;

    public Solution() {
        this.path = new LinkedList<Direction>();	
    }

    public LinkedList<Direction> getPath() {
        return path;
    }

    public void addDirection(Direction direction) {
        path.add(direction);
    }	

    public void removeLast() {
        path.removeLast();
    }	

    public String print() {
        return path.toString();
    }	
    
    @Override
    protected Solution clone() {
        try {
            Solution s = (Solution)super.clone(); //clone the Solution
            s.path = (LinkedList<Direction>)path.clone();
            return s; // return the clone
        } catch (CloneNotSupportedException e) {           
           throw new InternalError();
        }
    }

    public Integer getCount() {
        return path.size();
    }
    
       
}
