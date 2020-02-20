package com.skom.whoisthelast.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    
    @Id
    private String id;
    
    private String firstname;
    
    private String lastname;
    
    private String dni;
    
    private String phone;
}
