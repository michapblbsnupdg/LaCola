package com.skom.whoisthelast.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    
    private CustomerService customerService;
    
    @GetMapping
    public Flux<Customer> list() {
        return customerService.findAllCustomers();
    }
    
    @PostMapping
    public Mono<Void> createCustomer(@RequestBody Flux<Customer> customers) {
            return customerService.
                    createCustomer(customers);
    }
    
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Customer>> getCustomerById(@PathVariable(value = "id") String customerId) {
        return customerService.getCustomerById(customerId)
                .map(savedCustomer -> ResponseEntity.ok(savedCustomer))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
        
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Customer>> updateCostumer(@PathVariable(value = "id") String customerId,
                                                   @Valid @RequestBody Mono<Customer> customer) {
        return customerService.updateCustomer(customerId, customer)
                .map(updatedCustomer -> ResponseEntity.ok(updatedCustomer))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable(value = "id") String customerId) {
        return customerService.deleteCustomer(customerId)
                .map(deletedCustomer -> new ResponseEntity<Void>(HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build());
      
    }
}

