package com.homework.numbermazeapp.jsf;

import com.homework.numbermazeapp.beans.PuzzleBean;
import com.homework.numbermazeapp.model.Puzzle;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "puzzleController")
@SessionScoped
public class PuzzleController implements Serializable {
    
    private static final Logger LOGGER = Logger.getLogger(PuzzleController.class.getName());   
    
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
                
    public PuzzleBean getEjbPuzzleBean() {
        if (ejbPuzzleBean == null) {
            ejbPuzzleBean = new PuzzleBean();
        }
       return ejbPuzzleBean;      
    }
    
    public String prepareCreate() {        
        puzzle = new Puzzle();
        return "";
    }        
    
    public String create() {
        try {            
            getEjbPuzzleBean().createPuzzle(puzzle);
            addSuccessMessage("Megoldások: " + puzzle.getAllSolutions());
            LOGGER.log( Level.INFO, "Puzzle solved Date: {0} ", puzzle.getRecDate());
            return prepareCreate();            
            
        } catch (Exception e) {
            addErrorMessage("Nem érvényes szám-labirintus CSV formátum!");
            LOGGER.log( Level.WARNING, e.toString(), e );
            return null;
        }                     
    }
    
    public List<Puzzle> getPuzzles() {
        return getEjbPuzzleBean().getPuzzles();
    }    
    
    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }  
    
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
}
