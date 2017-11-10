
package com.homework.numbermazeapp.jsf;

import com.homework.numbermazeapp.beans.PuzzleBean;
import com.homework.numbermazeapp.model.Puzzle;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

//@Named(value = "puzzleController")
//@RequestScoped
@ManagedBean(name = "puzzleController")
@SessionScoped
public class PuzzleController implements Serializable {
    
    private String mazeText;

    private Puzzle puzzle;
    
    @EJB
    private PuzzleBean ejbPuzzleBean;
       
        
    public PuzzleController() {
    }
    
    public Puzzle getPuzzle() {
        if (puzzle == null) {
            puzzle = new Puzzle();
        }
        return puzzle;
    }    

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setEjbPuzzleBean(PuzzleBean ejbPuzzleBean) {
        this.ejbPuzzleBean = ejbPuzzleBean;
    }
                
    public String getMazeText() {
        return mazeText;        
    }

    public void setMazeText(String mazeText) {
        this.mazeText = mazeText;
    }

    public PuzzleBean getEjbPuzzleBean() {
        return ejbPuzzleBean;
    }
    
    public String prepareCreate() {
        //puzzle = new Puzzle();
        return "Create";
    }        
    
    public String create() {
        try {
            puzzle.setMazeText(mazeText);
            getEjbPuzzleBean().createPuzzle(puzzle);
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources//Bundle").getString("CustomerCreated"));
            return prepareCreate();            
            
        } catch (Exception e) {
            // JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources//Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
 
            
        
    }
    
}
