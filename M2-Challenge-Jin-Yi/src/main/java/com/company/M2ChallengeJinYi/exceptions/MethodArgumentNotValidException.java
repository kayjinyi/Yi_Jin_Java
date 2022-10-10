package com.company.M2ChallengeJinYi.exceptions;

public class MethodArgumentNotValidException extends RuntimeException{
    public MethodArgumentNotValidException(){
        super();
    }
    public MethodArgumentNotValidException(String msg){
        super(msg);
    }
}
