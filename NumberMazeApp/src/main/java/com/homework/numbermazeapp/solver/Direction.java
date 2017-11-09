package com.homework.numbermazeapp.solver;

public enum Direction {
	
    LE   ( 1,  0),
    JOBB ( 0,  1),
    FEL  (-1,  0),
    BAL  ( 0, -1);
				
    private final int x;   // row
    private final int y;   // column
		
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
				     	
}

