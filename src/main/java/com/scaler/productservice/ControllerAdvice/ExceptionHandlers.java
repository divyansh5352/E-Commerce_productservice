package com.scaler.productservice.ControllerAdvice;

import com.scaler.productservice.DTO.ArrithmaticExceptionDTO;
import com.scaler.productservice.DTO.ExceptionDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArrithmaticExceptionDTO>catchexception(){

        ArrithmaticExceptionDTO arrithmaticExceptionDTO = new ArrithmaticExceptionDTO();
        arrithmaticExceptionDTO.setMessage("some arrithmatic exception");

        return new ResponseEntity<>(arrithmaticExceptionDTO, HttpStatus.OK);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handelProductNotExistException(ProductNotFoundException exception){

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setDetails(null);

        return new ResponseEntity<>(exceptionDTO,HttpStatus.OK);
    }
}
