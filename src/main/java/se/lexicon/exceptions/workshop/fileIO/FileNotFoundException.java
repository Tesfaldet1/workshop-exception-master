package se.lexicon.exceptions.workshop.fileIO;

public class FileNotFoundException extends Exception{
    private Integer errorCode;

    public FileNotFoundException(String message, String messageValue){
        super(message);
        this.errorCode = errorCode;
    }
    public Integer getErrorCode(){
        return errorCode;
    }
}
