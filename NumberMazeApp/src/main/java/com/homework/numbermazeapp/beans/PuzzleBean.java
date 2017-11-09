package com.homework.numbermazeapp.beans;

import com.homework.numbermazeapp.model.Puzzle;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/*
 * Puzzle cache
 */    

@Singleton
@Startup
public class PuzzleBean {
    
    private List<Puzzle> puzzles = new ArrayList<Puzzle>();
        
    public PuzzleBean(){
    }    

    @Lock(LockType.READ)
    public List<Puzzle> getPuzzles() {
        return puzzles;
    }
    
    @Lock(LockType.WRITE)   
    public void createPuzzle(Puzzle puzzle){
        if (puzzle.create()){
            puzzles.add(puzzle);       
        }
    }    
   
}
