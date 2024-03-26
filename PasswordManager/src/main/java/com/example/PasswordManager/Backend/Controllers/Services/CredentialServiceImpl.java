package com.example.PasswordManager.Services;


import com.example.PasswordManager.Entities.Credential;
import com.example.PasswordManager.Repository.CredentialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CredentialServiceImpl implements CredentialService {
     @Override
    public void addCredential(Credential credential) {

    }

    @Override
    public List<Credential> getAllCredentials() {
        return null;
    }

    @Override
    public void deleteCredential(Long id) {

    }

    @Override
    public Credential getCredential(Long id) {
        return null;
    }
}
