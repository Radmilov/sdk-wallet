package com.metropolitan.service;

import com.metropolitan.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact findById(Long id);

    void save(Contact c);

    void delete(Contact c);
}
