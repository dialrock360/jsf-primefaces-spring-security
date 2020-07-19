package com.codenotfound.primefaces.service;

import com.primestap.primefaces.model.ConfirmationToken;
import com.primestap.primefaces.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public
class ConfirmationTokenService {
     @Autowired
    private  static ConfirmationTokenRepository confirmationTokenRepository;

     public static void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);

    }


    public static void deleteConfirmationToken(Long id){

        confirmationTokenRepository.deleteById(id);
    }

    public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {
         return confirmationTokenRepository.findByToken(token);
    }
}