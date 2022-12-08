package se.lexicon.exceptions.workshop.fileIO;

import java.util.List;

public class DuplicateNameException extends Exception{
    private Integer errorCode;


    public DuplicateNameException(String message, String messageValue){
        super(message);
        this.errorCode = errorCode;
    }
    public Integer getErrorCode(){
        return errorCode;
    }

}
