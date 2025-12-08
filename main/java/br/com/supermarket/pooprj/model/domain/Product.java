package br.com.supermarket.pooprj.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;



@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class Product extends AbstractEntity<Long> {

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Column(name = "product_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Float value;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // GETTERS E SETTERS
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getValue() { return value; }
    public void setValue(Float value) { this.value = value; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}