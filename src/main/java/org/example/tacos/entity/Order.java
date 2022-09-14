package org.example.tacos.entity;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Name is required")
    @Column(name = "DELIVERY_NAME")
    private String name;

    @NotBlank(message = "Street is required")
    @Column(name = "DELIVERY_STREET")
    private String street;

    @NotBlank(message = "City is required")
    @Column(name = "DELIVERY_CITY")
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "DELIVERY_STATE")
    private String state;

    @NotBlank(message = "Zip is required")
    @Column(name = "DELIVERY_ZIP")
    private String zip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[1-2])([\\/])([0-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(name = "CC_CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco taco) {
        this.tacos.add(taco);
    }

    @PrePersist
    public void placedAt() {
        this.placedAt = new Date();
    }
}
