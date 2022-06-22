
package com.javafxcoder.e_commerce.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_id_sequence",
            sequenceName = "transaction_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_id_sequence")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime date_time;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "location_id",
            referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "invoice_id",
            referencedColumnName = "id",
            nullable = false)
    private Invoice invoice;

    public Transaction(Double amount, Customer customer, Location location, Invoice invoice) {
        this.amount = amount;
        this.customer = customer;
        this.location = location;
        this.invoice = invoice;
    }

}
