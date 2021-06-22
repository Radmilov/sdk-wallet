package com.metropolitan.service;

import com.metropolitan.model.Wallet;

import java.util.List;

public interface WalletService {

    void save(Wallet w);

    List<Wallet> findAll();

    Wallet findById(Long id);

    void update(Wallet w);

    void delete(Wallet w);


}
