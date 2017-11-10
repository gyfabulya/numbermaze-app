package com.homework.numbermazeapp.jsf.validators;

import com.homework.numbermazeapp.utils.CsvArrayConverter;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CsvValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext,
            UIComponent uIComponent, Object value) throws ValidatorException {
        
        try {   
            CsvArrayConverter csvArrayConverter = new CsvArrayConverter();
            csvArrayConverter.convert((String) value);
            
        } catch (Exception e) {
            String msg = "Nem érvényes szám-labirintus CSV formátum!";
            FacesMessage facesMessage =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg );

            throw new ValidatorException(facesMessage);
        }   
    }
    
}
