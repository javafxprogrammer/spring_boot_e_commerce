
package com.javafxcoder.e_commerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Location {
    
    @Id
    @SequenceGenerator(
            name = "location_id_sequence",
            sequenceName = "location_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "location_id_sequence")
    @Setter(AccessLevel.NONE)
    private Long id;
    private String country;
    private String city;
    private Float longitude;
    private Float latitude;

    public Location(String country, String city, Float longitude, Float latitude) {
        this.country = country;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
