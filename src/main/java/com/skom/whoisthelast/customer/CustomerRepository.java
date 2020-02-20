package com.skom.whoisthelast.customer;


import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CustomerRepository extends ReactiveCrudRepository<Customer, String>,
        ReactiveQueryByExampleExecutor<Customer> {

}
