package com.homework.numbermazeapp.model;

import com.homework.numbermazeapp.solver.MazeSolver;
import com.homework.numbermazeapp.solver.Solution;
import com.homework.numbermazeapp.utils.CsvArrayConverter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Puzzle implements Serializable{

    private Date recDate;
    private String mazeText;    
    private int[][] maze;    
    private ArrayList<Solution> solutions;
    private int countSolutions = 0; 
    private String allSolutions;
    private String shortSolution;


    public Puzzle(){  
        super();
    }
        
    public boolean create() throws Exception {
        try {     
            this.recDate = new Date();  
            CsvArrayConverter csvArrayConverter = new CsvArrayConverter();
            this.maze = csvArrayConverter.convert(mazeText);   
            MazeSolver mazeSolver = new MazeSolver();
            this.solutions = mazeSolver.findPathInMaze(maze);            
            setFields();            
        }
        finally {
           return true; 
        }                
    }
                 
    public void setFields(){
        this.countSolutions = this.solutions.size();
        
        ArrayList<String> allList = new ArrayList<String>();
        
        if (this.countSolutions < 1 ) {
           this.allSolutions = "Nincs megoldás";
        } else {        
            int minCount = Integer.MAX_VALUE;
            
            for (int i = 0; i < this.solutions.size(); i++) {
                
                if (this.solutions.get(i) != null ) {
                    
                    allList.add(this.solutions.get(i).print() + "  ");
                    if(this.solutions.get(i).getCount() < minCount) {
                        minCount = this.solutions.get(i).getCount();
                        this.shortSolution = this.solutions.get(i).print();
                    } 
                }
            }   
            
            this.setAllSolutions(allList.toString());
        }
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
    
    public ArrayList<Solution> getSolutions() {
            return solutions;
    }
    
    public void setSolutions(ArrayList<Solution> solutions) {
            this.solutions = solutions;
    }	

    public String getMazeText() {
        return mazeText;
    }

    public void setMazeText(String mazeText) {
        this.mazeText = mazeText;
    }

    public int getCountSolutions() {
        return countSolutions;
    }

    public void setCountSolutions(int countSolutions) {
        this.countSolutions = countSolutions;
    }

    public String getAllSolutions() {
        return allSolutions;
    }

    public void setAllSolutions(String allSolutions) {
        this.allSolutions = allSolutions;
    }

    public String getShortSolution() {
        return shortSolution;
    }

    public void setShortSolution(String shortSolution) {
        this.shortSolution = shortSolution;
    }
                  
}
