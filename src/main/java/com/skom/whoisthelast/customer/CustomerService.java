package com.skom.whoisthelast.customer;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    public Flux<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Mono<Void> createCustomer(Flux<Customer> customers) {
        return customers.flatMap(customerRepository::save).then();
    }
    
    public Mono<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }
    
    public Mono<Customer> updateCustomer(String customerId, Mono<Customer> customer) {
        return getCustomerById(customerId)
            .flatMap(
                updatedCustomer -> customer.flatMap(
                    oldCustomer -> {
                        updatedCustomer.setFirstname(oldCustomer.getFirstname());
                        updatedCustomer.setLastname(oldCustomer.getLastname());
                        updatedCustomer.setDni(oldCustomer.getDni());
                        updatedCustomer.setPhone(oldCustomer.getPhone());
                        return customerRepository.save(updatedCustomer);
                    }
                )
        );
    }
    
    public Mono<Customer> deleteCustomer(final String id) {
        final Mono<Customer> customer = getCustomerById(id);
        if (Objects.isNull(customer)) {
            return Mono.empty();
        }
        return customer.switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(
                        customerToBeDeleted -> customerRepository
                                .delete(customerToBeDeleted)
                                .then(Mono.just(customerToBeDeleted))
                );
    }

}
