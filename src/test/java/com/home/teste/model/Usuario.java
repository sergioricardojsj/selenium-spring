package com.home.teste.model;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private Faker faker;

    public Usuario() {
        this.faker = new Faker(new Locale("pt-BR"));
        this.nome = faker.name().fullName();
        this.email = faker.internet().emailAddress();
        this.senha = faker.internet().ipV4Address();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}