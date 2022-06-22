package com.javafxcoder.e_commerce.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Invoice {

    @Id
    @SequenceGenerator(
            name = "invoice_id_sequence",
            sequenceName = "invoice_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_id_sequence")
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToMany
    @JoinTable(
            name = "product_invoice",
            joinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "product_bar_code", referencedColumnName = "bar_code")
    )
    private List<Product> products = new ArrayList<>();

}
