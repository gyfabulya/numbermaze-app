package com.homework.numbermazeapp.solver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MazeSolver {
    
    private static final Logger LOGGER = Logger.getLogger(MazeSolver.class.getName());  
	
    private int dim; // dimension of maze
    private ArrayList<Solution> solutions;
    
    public MazeSolver(){  
    }
    
    private void logPath(LinkedList<Position<Integer, Integer>> path) {  
        for (Position<Integer, Integer> position : path) {
          LOGGER.log( Level.INFO, "Path x: {0} ", position.getRow());
          LOGGER.log( Level.INFO, "Path y: {0}  -> ", position.getCol());
        }
    }

    // is a valid position or not.
    private  boolean isValid(TreeSet<Position<Integer, Integer>> visited, 
            Position<Integer, Integer> pos){		
        return (pos.getRow() >= 0) && (pos.getRow() < this.dim) &&
                   (pos.getCol() >= 0) && (pos.getCol() < this.dim) && 
                   !visited.contains(pos);		
    }
	 	
		
    private void findPathInMazeUtil(int[][] maze, LinkedList<Position<Integer, Integer>> path,
                    Solution solution, TreeSet<Position<Integer, Integer>> visited, 
                    Position<Integer, Integer> curr) {
        
        // If we have reached the target position.        
        if (curr.getRow() == this.dim-1  && curr.getCol() == this.dim-1 ){
            logPath(path);            
            this.solutions.add(solution.clone());        
            return;
        }

        // go each direction
        for (Direction direction : Direction.values()) {
            // get value of current position
            int n = maze[curr.getRow()][curr.getCol()];

            // We can move dim positions in either of 4 directions
            int x = curr.getRow() + direction.getX() * n;
            int y = curr.getCol() + direction.getY() * n;

            Position<Integer, Integer> next = new Position<Integer, Integer>(x,y);

            if (isValid(visited, next))
            {
                // mark position as visited
                visited.add(next);	        

                // add position to current path
                path.add(next);

                // add position to solution
                solution.addDirection(direction);

                // recuse for next position
                findPathInMazeUtil(maze, path, solution, visited, next);

                // backtrack:
                // remove position from current path and solution 
                path.removeLast();                               
                solution.removeLast();		        
                visited.remove(next);
            }
        }
    }
		
    public ArrayList<Solution> findPathInMaze(int[][] maze) {
        
        this.dim = maze.length;
        
        // list to store complete path	
        LinkedList<Position<Integer, Integer>> path = 
            new LinkedList<Position<Integer, Integer>>();	

        // to store solution of positions
        Solution solution = new Solution();
        
        // to store all solution of maze
        this.solutions = new ArrayList<Solution>();

        // to store positions already visited in current path
        TreeSet<Position<Integer, Integer>> visited = new TreeSet<Position<Integer, Integer>>() ;

        // Start position
        int x = 0;
        int y = 0;

        Position<Integer, Integer> pos = new Position<Integer, Integer>(x, y);	

        // mark position as visited
        visited.add(pos);

        // add position to current path
        path.add(pos);

        findPathInMazeUtil(maze, path, solution, visited, pos);
        
        return solutions;
        
    }	
    
    public int getDim() {
        return dim;
    }
    
    public void setDim(int dim) {
        this.dim = dim;
    }    
        
    public ArrayList<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Solution> solutions) {
        this.solutions = solutions;
    }    

}
