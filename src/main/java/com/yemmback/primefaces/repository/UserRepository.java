package com.yemmback.primefaces.repository;

import com.yemmback.primefaces.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
   /* Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    Optional<User> findbyUser(String token);

    void findbyUser(User user);*/
}
