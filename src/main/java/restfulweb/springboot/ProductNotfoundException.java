/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restfulweb.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author OS
 */
class ProductNotfoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    //mengambil fungsi method PUT lalu mengembalikan ProductNotFoundException
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct() { 
    throw new ProductNotfoundException();
    }
    //mengambil fungsi method DELETE lalu mengembalikan ProductNotFoundException
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(){
        throw new ProductNotfoundException();
    }
    
    
    
}
