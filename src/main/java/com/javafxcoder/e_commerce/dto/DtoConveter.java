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
package com.javafxcoder.e_commerce.dto;

import com.javafxcoder.e_commerce.model.Customer;
import com.javafxcoder.e_commerce.model.Product;
import com.javafxcoder.e_commerce.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author javafxcoder
 */
@Component
public class DtoConveter {

    public CustomerDto customerToDto(Customer customer) {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return new ModelMapper().map(customer, CustomerDto.class);
    }

    public List<CustomerDto> customersToDtos(List<Customer> customers) {
        return customers
                .stream()
                .map(customer -> new ModelMapper().map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    public Customer DtoToCustomer(CustomerDto customerDto) {
        return new ModelMapper().map(customerDto, Customer.class);
    }

    public TransactionDto TransactionToDto(Transaction transaction) {
        return new ModelMapper().map(transaction, TransactionDto.class);
    }

    public Transaction DtoToTransaction(TransactionDto transactionDto) {
        return new ModelMapper().map(transactionDto, Transaction.class);
    }

    public ProductDto ProductToDto(Product product) {
        return new ModelMapper().map(product, ProductDto.class);
    }

    public Product DtoToProduct(ProductDto productDto) {
        return new ModelMapper().map(productDto, Product.class);
    }

}
