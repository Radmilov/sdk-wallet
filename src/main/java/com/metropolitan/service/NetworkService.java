package com.metropolitan.service;

import com.metropolitan.model.Network;

import java.util.List;

public interface NetworkService {

    List<Network> findAll();

    void save(Network n);
}
