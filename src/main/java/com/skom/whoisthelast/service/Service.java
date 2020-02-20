package com.skom.whoisthelast.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    
    @Id
    private String id;
    
    private String name;
    
    private Boolean isOpen;
    
    private Time openAt;
    
    private Time closeAt;
}
