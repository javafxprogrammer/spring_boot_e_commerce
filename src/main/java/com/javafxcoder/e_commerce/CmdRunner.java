package com.javafxcoder.e_commerce;

import com.javafxcoder.e_commerce.dto.CustomerDto;
import com.javafxcoder.e_commerce.dto.DtoConveter;
import com.javafxcoder.e_commerce.model.Account;
import com.javafxcoder.e_commerce.model.Customer;
import com.javafxcoder.e_commerce.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class CmdRunner {

//    @Autowired
//    private DtoConveter dtoConveter;
//
//    @Bean
//    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
//        return (var args) -> {
//            {"firstName":"Randy", "lastName":"Fredy", "PhoneNumber":"26095000111", {250}}
//            Account account = new Account();
//            account.setBalance(250D);
//            CustomerDto customerDto = new CustomerDto("Randy", "Fredy", "26095000111", account);
//            
//            Customer customer = dtoConveter.DtoToCustomer(customerDto);
//            account.setCustomer(customer);
//            customerRepository.save(customer);
//            Customer james = new Customer();
//            Account account = new Account();

//        };
//    }
}
