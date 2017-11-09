package com.homework.numbermazeapp.solver;

import java.util.LinkedList;

public class Solution {

    private LinkedList<Direction> path;

    public Solution() {
        super();
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

}
