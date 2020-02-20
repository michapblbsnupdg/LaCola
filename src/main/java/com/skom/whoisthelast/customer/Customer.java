package com.skom.whoisthelast.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
    
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String dni;
    private String phone;
    
    public Customer(String firstname, String lastname, String dni, String phone) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.phone = phone;
    }
    
}
