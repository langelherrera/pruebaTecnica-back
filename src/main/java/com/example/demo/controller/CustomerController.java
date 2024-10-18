package com.example.demo.controller;

import com.example.demo.dto.Customer;
import com.example.demo.dto.CustomerQuery;
import com.example.demo.dto.Response;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> getCustomer(@RequestBody CustomerQuery customerQuery){
       try {
           String type = customerQuery.getType();
           String document=customerQuery.getId();


           if(!type.equals("P") && !type.equals("C")){
               Response response =new Response(400,"tipo de documento invalido. Solo 'C' y 'P' están permitidos");
               return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
           }

           if(document==null || document.isEmpty()){
               Response response =new Response(400,"El número de documento es requerido");
               return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
           }

           if (document.equals("23445322") && type.equals("C")){
               Customer customer =customerService.findCustomer();
               return new ResponseEntity<>(customer, HttpStatus.OK);
           }else {
               Response response = new Response(404,"El cliente con tipo de identificación ".concat(type + " con numero de identificación ").concat(document +" NO fue encontrado"));
               return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
           }

       }catch (Exception e){

           Response response = new Response(500,e.toString());
           return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
       }







    }

}
