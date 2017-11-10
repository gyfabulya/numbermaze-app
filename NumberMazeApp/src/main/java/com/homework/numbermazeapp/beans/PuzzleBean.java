package com.homework.numbermazeapp.beans;

import com.homework.numbermazeapp.model.Puzzle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/*
 * Puzzle cache
 */    

@Singleton
public class PuzzleBean implements Serializable {
    
    private static final Logger LOGGER = Logger.getLogger(PuzzleBean.class.getName());       
    
    private List<Puzzle> puzzles = new ArrayList<Puzzle>();
        
    public PuzzleBean(){
    }    

    @Lock(LockType.READ)
    public List<Puzzle> getPuzzles() {
        return puzzles;
    }
    
    @Lock(LockType.WRITE)   
    public void createPuzzle(Puzzle puzzle) throws Exception{ 
        if (puzzle.create()){
            puzzles.add(puzzle);       
            LOGGER.log( Level.INFO, "New puzzle added to Puzzles List. Date added {0}",  puzzle.getRecDate());
        }           
    }
}
