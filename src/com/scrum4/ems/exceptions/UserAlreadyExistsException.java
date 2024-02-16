package com.scrum4.ems.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String s){
        super(s);
    }

}
