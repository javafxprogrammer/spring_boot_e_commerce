package com.javafxcoder.e_commerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence")
    @Setter(AccessLevel.NONE)
    private Long bar_code;

    @Column(nullable = false, unique = true)
    private String name;

//    @ManyToOne
//    @JoinTable(
//            name = "product_invoice",
//            joinColumns = @JoinColumn(name = "product_bar_code", referencedColumnName = "bar_code"),
//            inverseJoinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id")            
//    )
//    private Invoice invoice;

}
