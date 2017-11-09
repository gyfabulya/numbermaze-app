
package com.homework.numbermazeapp.jsf;

import com.homework.numbermazeapp.beans.PuzzleBean;
import com.homework.numbermazeapp.model.Puzzle;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "puzzleController")
@SessionScoped
public class PuzzleController {
    
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

    public PuzzleBean getEjbPuzzleBean() {
        return ejbPuzzleBean;
    }
    
    public String prepareCreate() {
        puzzle = new Puzzle();
        return "Create";
    }        
    
    public String create() {
        try {
            getEjbPuzzleBean().createPuzzle(puzzle);
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources//Bundle").getString("CustomerCreated"));
            return prepareCreate();            
            
        } catch (Exception e) {
            // JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources//Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
 
            
        
    }
    
}
