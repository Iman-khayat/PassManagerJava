package com.example.PasswordManager.Controllers;

import com.example.PasswordManager.Entities.Credential;
import com.example.PasswordManager.Repository.CredentialRepository;
import com.example.PasswordManager.Services.CredentialService;
import com.example.PasswordManager.Services.MasterPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api/credentials")
public class CredentialController {
 private CredentialRepository credentialRepository;
    @Autowired
    private CredentialService credentialService;
    private MasterPasswordService masterPasswordService;

    @Autowired
    public CredentialController(CredentialService credentialService){
        this.credentialService= credentialService;
    }

     @GetMapping("/Credential")
    public List<Credential> getAllCredential() {
        return credentialService.getAllCredentials();
    }
    public List<Credential> getAllCredentials() {
        return credentialRepository.findAll();
    }
    public Optional<Credential> getCredential(Long id) {
        return credentialRepository.findById(id);
    }
    public Credential updateCredential(Long id, Credential updatedCredential) {
        // Optional: Validation (e.g., ensure ID matches updated object)
        if (!id.equals(updatedCredential.getId())) {
            throw new IllegalArgumentException("ID in request path and credential object don't match");
        }

        // Handle encryption if needed (same logic as addCredential)
        String key = masterPasswordService.deriveKeyFromMasterPassword();
        //updatedCredential.setEncryptedPassword();

        // Save updated credential to database
        return credentialRepository.save(updatedCredential);
    }
    public void deleteCredential(Long id) {
        credentialRepository.deleteById(id);
    }





    // Implement other endpoints for retrieving Posting, deleting, and updating credentials
    // Use appropriate HTTP methods and handle security aspects
}

