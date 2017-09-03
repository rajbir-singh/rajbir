package com.rajbir.core.repository;

import com.rajbir.core.domain.User;

/**
 * Created by Sony on 30-08-2017.
 */
public interface UserRepository {
    User save(User user);
    User findById(String userId);
}
