package com.bashaev.cata.fetchjs.service;


import com.bashaev.cata.fetchjs.model.User;
import com.bashaev.cata.fetchjs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Рустам
 */

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getOne(Long id) {
        return userRepository.findById(id);
    }

//    @Override
//    public User getOne(Long id) {
//        User user = null;
//        Optional<User> us = userRepository.findById(id);
//        if(us.isPresent()){
//            user = us.get();
//        }
//        return user;
//    }

    @Override
    public void addNew(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        if(!user.getPassword().equals(userRepository.findUserById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeUserById(Long id){
        userRepository.removeUserById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }
}
