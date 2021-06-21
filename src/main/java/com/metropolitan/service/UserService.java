package com.metropolitan.service;

import com.metropolitan.model.User;

public interface UserService {

    User findById(Long id);

    void save(User u);

    void sacuvajWallet(Long userId, Long walletId);

    void sacuvajKontakt(Long userId, long kontaktId);

    void sacuvajNote(Long userId, Long noteId);

    User findByEmail(String email);


}
