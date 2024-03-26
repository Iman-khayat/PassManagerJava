package com.example.PasswordManager.Repository;

import com.example.PasswordManager.Entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository
        extends JpaRepository<Credential, Long> {
}

