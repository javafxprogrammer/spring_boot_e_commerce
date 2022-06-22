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
import com.javafxcoder.e_commerce.dto.ProductDto;
import com.javafxcoder.e_commerce.repository.ProductRepository;
import com.javafxcoder.e_commerce.utility.ResponseBody;
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
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private DtoConveter dtoConveter;

    public ResponseEntity<?> createProduct(ProductDto productDto) {
        return productRepository.save(dtoConveter.DtoToProduct(productDto)) != null
                ? new ResponseEntity(new ResponseBody<>(HttpStatus.CREATED.value(), "successfully created product"), HttpStatus.CREATED)
                : new ResponseEntity(new ResponseBody<>(HttpStatus.CONFLICT.value(), "failed to create product"), HttpStatus.CONFLICT);
    }

}
