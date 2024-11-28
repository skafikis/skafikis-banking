package br.com.skafikis.dto;

import java.time.LocalDateTime;

public class UserAccountDTO {

    private final String id;

    private String name;
    private String email;
    private String document;
    private String accountNumber;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime disabledAt;

    public UserAccountDTO(String id, String name, String email, String document, String accountNumber,
                          String password, LocalDateTime createdAt, LocalDateTime disabledAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
        this.accountNumber = accountNumber;
        this.password = password;
        this.createdAt = createdAt;
        this.disabledAt = disabledAt;
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
