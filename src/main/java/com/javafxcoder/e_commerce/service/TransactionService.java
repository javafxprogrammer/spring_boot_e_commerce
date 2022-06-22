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

import com.javafxcoder.e_commerce.dto.DtoConveter;
import com.javafxcoder.e_commerce.dto.TransactionDto;
import com.javafxcoder.e_commerce.model.Product;
import com.javafxcoder.e_commerce.repository.CustomerRepository;
import com.javafxcoder.e_commerce.repository.ProductRepository;
import com.javafxcoder.e_commerce.repository.TransactionRepository;
import com.javafxcoder.e_commerce.utility.ResponseBody;
import java.util.ArrayList;
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
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository CustomerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DtoConveter dtoConveter;

    public ResponseEntity<?> createTransaction(TransactionDto transactionDto) {

        CustomerRepository
                .findById(transactionDto.getCustomer().getId())
                .ifPresent(customer -> transactionDto.setCustomer(customer));

        List<Product> products = transactionDto.getInvoice().getProducts();
        List<Product> productsFound = new ArrayList<>();
        List<Product> productsNotFound = new ArrayList<>();

        for (Product product : products) {
            Optional<Product> productOptional = productRepository.findByName(product.getName());
            productOptional.ifPresent(productsFound::add);
            if (!productOptional.isPresent()) {
                productsNotFound.add(product);
            }
        }

        if (!productsNotFound.isEmpty() || products.isEmpty()) {
            return new ResponseEntity(
                    new ResponseBody<>(HttpStatus.BAD_REQUEST.value(), "products dont exist : "+productsNotFound.toString()),
                    HttpStatus.BAD_REQUEST);
        }

        transactionDto.getInvoice().setProducts(productsFound);

        return transactionRepository.save(dtoConveter.DtoToTransaction(transactionDto)) != null
                ? new ResponseEntity<>(new ResponseBody<>(HttpStatus.CREATED.value(), "successfully created transaction"), HttpStatus.CREATED)
                : new ResponseEntity(new ResponseBody<>(HttpStatus.CONFLICT.value(), "failed to create transaction"), HttpStatus.CONFLICT);
    }
}
