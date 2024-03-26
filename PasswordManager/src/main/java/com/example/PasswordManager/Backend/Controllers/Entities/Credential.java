package com.example.PasswordManager.Entities;

import jakarta.persistence.*;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;

@Entity
@Table(name = "credentials")
public class Credential {
    @Id
    @SequenceGenerator(
            name = "credentials_sequence",
            sequenceName = "credentials_sequence",
            allocationSize = 5
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "credentials_sequence")
    private Long id;

    private String website;
    private String username;
    private String password;


    @Column(nullable = false)
    private String encryptedPassword;

    // Getters and Setters

    public Credential() {
    }

    public Credential(Long id, String website, String username, String encryptedPassword) {
        this.id = id;
        this.website = website;
        this.username = username;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
    }

    public Credential(String website, String username, String encryptedPassword) {
        this.website = website;
        this.username = username;
        this.password=password;
        this.encryptedPassword = encryptedPassword;
    }

    public Long getId() {
        return id;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEncryptedPassword(String password) {
         if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Derive a secure key from the master password using a strong KDF (e.g., PBKDF2 with a high number of iterations)

        // Encrypt the password using a robust algorithm like AES/CBC/PKCS7Padding with a secure initialization vector (IV)
        try {
           // this.encryptedPassword = Encryption.DES(getPassword().toString());
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting password", e); // Or handle encryption exceptions more gracefully (e.g., logging)
        }
    }
}
