package com.metropolitan.service;


import com.metropolitan.model.Wallet;
import com.metropolitan.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("walletService")
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void save(Wallet w) {
        walletRepository.save(w);
    }

    @Override
    public Wallet findById(Long id) {
        return walletRepository.findById(id).get();
    }

    @Override
    public void update(Wallet w) {
        walletRepository.saveAndFlush(w);
    }

    @Override
    public void delete(Wallet w) {
        walletRepository.delete(w);
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }
}
