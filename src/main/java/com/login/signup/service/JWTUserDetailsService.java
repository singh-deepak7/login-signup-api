package com.login.signup.service;

import java.util.ArrayList;

import com.login.signup.model.UserManagement;
import com.login.signup.model.Users;
import com.login.signup.repository.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*if ("admin".equals(username)) {
            return new User("admin", "$2a$10$4jxSypRscWNFIYp5eU/dceOszto1FGvblTzqC5D.M3r8YIenfC1kq",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }*/
        System.out.println("- " + username);
        UserManagement user = userManagementRepository.findByEmail(username);
        System.out.println("-> " + user.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());

    }

    public UserManagement save(Users user) {
        UserManagement newUser = new UserManagement();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setActiveSw(true);
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userManagementRepository.save(newUser);
    }

}
