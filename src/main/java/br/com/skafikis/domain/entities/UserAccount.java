package br.com.skafikis.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;


public class UserAccount {

    private final String id;

    private String name;
    private String email;
    private String document;
    private String accountNumber;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime disabledAt;

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public UserAccount(String name, String email, String document,  String accountNumber,
                       String password, LocalDateTime createdAt, LocalDateTime disabledAt) {

        this.id = generateId();
        this.name = name;
        this.email = email;
        this.document = document;
        this.accountNumber = accountNumber;
        this.password = password;
        this.createdAt = createdAt;
        this.disabledAt = disabledAt;

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (document == null || document.trim().isEmpty()) {
            throw new IllegalArgumentException("Document cannot be null or empty");
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (createdAt == null || createdAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Created at cannot be null or in the future");
        }
        if (disabledAt == null || disabledAt.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Disabled at cannot be null or in the future");
        }
    }

    public String getId() {
        return id;
    }

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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

}
