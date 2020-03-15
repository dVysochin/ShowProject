package com.example.showproject.archiver.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

@ControllerAdvice
public class ArchiverAdviceController extends ModelAndViewMethodReturnValueHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }
}
