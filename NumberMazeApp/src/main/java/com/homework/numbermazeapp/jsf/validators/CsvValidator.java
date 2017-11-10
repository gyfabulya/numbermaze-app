package com.homework.numbermazeapp.jsf.validators;

import com.homework.numbermazeapp.utils.CsvArrayConverter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CsvValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext,
            UIComponent uIComponent, Object value) throws ValidatorException {
        
        try {   
            
            CsvArrayConverter.convert((String) value);
            
        } catch (Exception e) {
            FacesMessage facesMessage =
                new FacesMessage(" Nem érvényes szám-labirintus CSV formátum!");

            throw new ValidatorException(facesMessage);
        }   
    }
    
}
