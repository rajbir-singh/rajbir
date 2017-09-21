package com.rajbir.core.repository;

import com.rajbir.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sony on 30-08-2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
    User save(User user);
    User findByUserId(String userId);
    List<User> findAll();
    List<User> findByNameContainingOrMobileContainingOrEmailContaining(String name, String mobile, String email);
}
