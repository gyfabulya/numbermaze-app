
package com.homework.numbermazeapp.model;

import com.homework.numbermazeapp.solver.Solution;
import java.util.Collection;
import java.util.Date;


public class Puzzle {

    private Date recDate;
    private int[][] maze;    
    private int dim;  //dimension of maze
    private Collection<Solution> solutions;

    public Puzzle(Date recDate, int[][] maze, int dim,
                    Collection<Solution> solutions) {
            super();
            this.recDate = recDate;
            this.maze = maze;
            this.dim = dim;
            this.solutions = solutions;
    }
    
    public boolean createPuzzle(int n, String mazeText){
        //1. create int[][] maze
        //2. solvePuzzle();
        //3. print?
        return false;        
    }
    
    public Collection<Solution> solvePuzzle(int n, int[][] maze){   
        //1. set  MazeSolver.N = n.
        //2. call MazeSolver.findPathInMaze(maze) 
        return null;
    }    
    
    
    public Date getRecDate() {
            return recDate;
    }
    
    public void setRecDate(Date recDate) {
            this.recDate = recDate;
    }
    
    public int[][] getMaze() {
            return maze;
    }
    
    public void setMaze(int[][] maze) {
            this.maze = maze;
    }
    
    public int getDim() {
            return dim;
    }
    
    public void setDim(int dim) {
            this.dim = dim;
    }
    
    public Collection<Solution> getSolutions() {
            return solutions;
    }
    
    public void setSolutions(Collection<Solution> solutions) {
            this.solutions = solutions;
    }	
    
}
