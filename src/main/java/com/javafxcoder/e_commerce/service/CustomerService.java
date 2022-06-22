/*
 * The MIT License
 *
 * Copyright 2022 javafxcoder.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.javafxcoder.e_commerce.service;

import com.javafxcoder.e_commerce.dto.CustomerDto;
import com.javafxcoder.e_commerce.dto.DtoConveter;
import com.javafxcoder.e_commerce.model.Customer;
import com.javafxcoder.e_commerce.repository.CustomerRepository;
import com.javafxcoder.e_commerce.utility.ResponseBody;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author javafxcoder
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DtoConveter dtoConveter;

    public ResponseEntity<?> createCustomer(CustomerDto customerDto) {
        Customer customer = dtoConveter.DtoToCustomer(customerDto);
        return customerRepository.save(customer) != null
                ? new ResponseEntity(new ResponseBody<>(HttpStatus.CREATED.value(), "successfully created customer"), HttpStatus.CREATED)
                : new ResponseEntity(new ResponseBody<>(HttpStatus.CONFLICT.value(), "failed to create customer"), HttpStatus.CONFLICT);
    }

    public ResponseEntity<ResponseBody> selectCustomer(String phoneNumber) {
        Optional<Customer> customerOptional = customerRepository.findByPhoneNumber(phoneNumber);
        if (customerOptional.isPresent()) {
            CustomerDto customerDto = dtoConveter.customerToDto(customerOptional.get());
            return new ResponseEntity(new ResponseBody<>(HttpStatus.OK.value(), customerDto), HttpStatus.OK);
        }
        return new ResponseEntity(new ResponseBody<>(HttpStatus.OK.value(), new CustomerDto()), HttpStatus.OK);
    }

    public ResponseEntity<?> selectAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customersToDtos = dtoConveter.customersToDtos(customers);
        return new ResponseEntity(new ResponseBody<>(HttpStatus.OK.value(), customersToDtos), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCustomer(String phone) {
        Boolean isDeleted = false;
        if(customerRepository.deleteByPhoneNumber(phone)>0){
            isDeleted = true;
        }
        return isDeleted
                ? new ResponseEntity<>(new ResponseBody<>(HttpStatus.OK.value(), "delete successful"), HttpStatus.OK)
                : new ResponseEntity<>(new ResponseBody<>(HttpStatus.OK.value(), "delete failed, because no records exit"), HttpStatus.OK);
    }
}
