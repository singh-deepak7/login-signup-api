package com.login.signup.repository;

import com.login.signup.model.UserManagement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends CrudRepository<UserManagement, Integer> {
    UserManagement findByEmail(String email);
}
