package com.isikenes.mvcsecurity.service;

import com.isikenes.mvcsecurity.entity.Authority;
import com.isikenes.mvcsecurity.entity.User;
import com.isikenes.mvcsecurity.repository.AuthorityRepository;
import com.isikenes.mvcsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.encoder = encoder;
    }

    @Transactional
    public void registerUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(1);
        userRepository.save(user);

        Authority authority = new Authority(user.getUsername(), "ROLE_student");
        authorityRepository.save(authority);
    }
}
