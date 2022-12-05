/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restfulweb.springboot;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OS
 */
@RestController
public class controller {
    //menyatakan HashMap
    private static Map<String, Product> productRepo= new HashMap<>();
   static {
       //mengisi variabel Id dan Name
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      productRepo.put(almond.getId(), almond);
   }
   //membuat /products sebagai tempat id dan name
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   //membuat method post untuk memasukkan isi id dan nama baru
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
      //membuat logika ketika Id yang dimasukkan sudah terisi sebelumnya
      if(productRepo.containsKey(product.getId())){
          //ketika logika terpenuhi maka akan dikembalikan alert
          return new ResponseEntity<>("Product already exist",HttpStatus.NOT_ACCEPTABLE);
      }
      //membuat logika ketika Id yang dimasukkan belum terisi sebelumnya
      else{
          //ketika logika terpenuhi maka akan dikembalikan alert
        productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
       }
   }
   //membuat method PUT untuk mengupdate product yang telah ada
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
      //membuat logika ketika product belum dimasukkan maka akan memanggil class ProductNotFoundException yang akan mengembalikan alert
       if(!productRepo.containsKey(id))throw new ProductNotfoundException();
      //Menghapus Id yang telah ada
       productRepo.remove(id);
       //menyatakan isian baru Id
      product.setId(id);
      productRepo.put(id, product);
      //mengembalikan alert
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }

   //membuat method DELETE untuk menghapus id dan nama yang telah ada
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
       //membuat logika ketika product belum dimasukkan maka akan memanggil class ProductNotFoundException yang akan mengembalikan alert
      if(!productRepo.containsKey(id))throw new ProductNotfoundException();
      //menghapus id
      productRepo.remove(id);
      //mengembalikan alert
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
}
