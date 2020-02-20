package com.skom.whoisthelast.line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/line")
public class LineController {
    
    @Autowired
    private LineService lineservice;
    
    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "Hello World!";
    }
}
