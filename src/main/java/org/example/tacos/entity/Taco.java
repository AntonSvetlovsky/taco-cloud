package org.example.tacos.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdAt")
    private Date createdAt;

    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredient;

    @PrePersist
    public void createdAt() {
        this.createdAt = new Date();
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredient.add(ingredient);
    }
}
