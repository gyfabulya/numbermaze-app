
package com.homework.numbermazeapp.model;

import com.homework.numbermazeapp.solver.Solution;
import com.homework.numbermazeapp.utils.CsvArrayConverter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class Puzzle implements Serializable {

    private Date recDate;
    private String mazeText;    
    private int[][] maze;    
    private int dim;  //dimension of maze
    private Collection<Solution> solutions;
    
 
    private Integer mazeDim;    

    public Puzzle(Date recDate, int[][] maze, int dim,
                    Collection<Solution> solutions) {
            super();
            this.recDate = recDate;
            this.maze = maze;
            this.dim = dim;
            this.solutions = solutions;
    }

    public Puzzle(){        
    }
    
    public boolean create() throws Exception {
        try {
            maze = CsvArrayConverter.convert(mazeText);
            
        }
        finally {
            
        }
            
        //1. create int[][] maze
        //2. solve();
        //3. print?
        return false;        
    }
    
    public Collection<Solution> solve(int n, int[][] maze){   
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

    public String getMazeText() {
        return mazeText;
    }

    public void setMazeText(String mazeText) {
        this.mazeText = mazeText;
    }

    public Integer getMazeDim() {
        return mazeDim;
    }

    public void setMazeDim(Integer mazeDim) {
        this.mazeDim = mazeDim;
    }
    
    
    
}
