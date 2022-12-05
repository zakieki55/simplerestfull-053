/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restfulweb.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author OS
 */
@ControllerAdvice
public class exceptionController {
    private static final long serialVersionUID = 1L;
    
    //menghubungkan class ProductNotFoundException
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception){
    //mengembalikan alert
    return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
    
}
