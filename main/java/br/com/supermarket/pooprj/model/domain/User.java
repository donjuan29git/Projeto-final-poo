package br.com.supermarket.pooprj.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long> {

    @NotBlank(message = "O nome é obrigatório.")
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    @Column(name = "email", nullable = false, length = 60, unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Column(name = "password", nullable = false)
    private String password;

    // Getters e Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
