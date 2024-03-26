package com.example.PasswordManager.Services;

import com.example.PasswordManager.Entities.Credential;
import com.example.PasswordManager.Repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CredentialService {

    void addCredential(Credential credential);

    List<Credential> getAllCredentials();

    void deleteCredential(Long id);

    Credential getCredential(Long id);
}
