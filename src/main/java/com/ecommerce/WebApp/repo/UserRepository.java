package com.ecommerce.WebApp.repo;

import com.ecommerce.WebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if a user exists by email OR mobile
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END " +
            "FROM User u WHERE u.email = :value OR u.mobile = :value")
    boolean existsByEmailOrMobile(@Param("value") String value);

    // Find a user by email OR mobile
    @Query("SELECT u FROM User u WHERE u.email = :value OR u.mobile = :value")
    Optional<User> findByEmailOrMobile(@Param("value") String value);
}
