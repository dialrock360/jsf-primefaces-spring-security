package com.yemmback.primefaces.repository;

import com.yemmback.primefaces.model.ConfirmationToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {
 @Query("SELECT u FROM ConfirmationToken u WHERE u.token = ?1")
 Optional<ConfirmationToken> findByToken(String token);

}