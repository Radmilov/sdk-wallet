package com.metropolitan.service;

import com.metropolitan.model.User;
import com.metropolitan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        userRepository.save(u);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User u) {
        userRepository.delete(u);
    }

    @Override
    public void sacuvajWallet(Long userId, Long walletId) {
        userRepository.sacuvajWallet(userId, walletId);
    }

    @Override
    public void sacuvajKontakt(Long userId, Long kontaktId) {
        userRepository.sacuvajKontakta(userId, kontaktId);
    }

    @Override
    public void sacuvajNote(Long userId, Long noteId) {
        userRepository.sacuvajNote(userId, noteId);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
