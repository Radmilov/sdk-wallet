package com.metropolitan.service;

import com.metropolitan.model.Network;
import com.metropolitan.repository.NetworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("networkService")
@RequiredArgsConstructor
public class NetworkServiceImpl implements NetworkService{

    @Autowired
    private NetworkRepository networkRepository;

    @Override
    public List<Network> findAll() {
        return networkRepository.findAll();
    }

    @Override
    public void save(Network n) {
        networkRepository.save(n);
    }
}
