package br.com.supermarket.pooprj.model;

public class Product {

    private Long id;
    private String name;
    private Long quantity;
    private Float value;

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getValue() {
        return value;
    }
    public void setValue(Float value) {
        this.value = value;
        }
        @Override
    public String toString() {
        return "Produto: " + name +
            ", Quantidade: " + quantity +
            ", Valor: R$ " + value;
    }
}
