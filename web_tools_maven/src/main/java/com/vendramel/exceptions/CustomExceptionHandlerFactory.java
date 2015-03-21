package com.vendramel.exceptions;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;
 
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
    private ExceptionHandlerFactory parent;
 
    public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }
 
//    @Override
//    public ExceptionHandler getExceptionHandler() {
//       ExceptionHandler handler = new CustomExceptionHandlerFactory(parent.getExceptionHandler());
//        return handler;
//    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}