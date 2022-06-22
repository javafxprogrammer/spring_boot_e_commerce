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
package com.javafxcoder.e_commerce.controller;

import com.javafxcoder.e_commerce.dto.CustomerDto;
import com.javafxcoder.e_commerce.service.CustomerService;
import com.javafxcoder.e_commerce.utility.ResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author javafxcoder
 */
@RestController
@RequestMapping(path = "e_commerce_api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) {
        System.out.println(customerDto);
        return customerService.createCustomer(customerDto);
    }

    @GetMapping(path = "select/phone/{phone}")
    public ResponseEntity<ResponseBody> selectCustomer(@PathVariable(name = "phone") String phoneNumber) {
        return customerService.selectCustomer(phoneNumber);
    }
    
    @GetMapping
    public ResponseEntity<?> selectAllCustomers(){
        return customerService.selectAllCustomers();
    }

    @DeleteMapping(path = "delete/phone/{phone}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "phone") String phone){
        return customerService.deleteCustomer(phone);
    }
    
}
