package com.metropolitan.service;

import com.metropolitan.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    void save(User u);

    void delete(User u);

    void sacuvajWallet(Long userId, Long walletId);

    void sacuvajKontakt(Long userId, long kontaktId);

    void sacuvajNote(Long userId, Long noteId);

    User findByEmail(String email);


}
