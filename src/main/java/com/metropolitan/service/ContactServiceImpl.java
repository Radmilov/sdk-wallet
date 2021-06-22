package com.metropolitan.service;


import com.metropolitan.model.Contact;
import com.metropolitan.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public void save(Contact c) {
        contactRepository.save(c);
    }

    @Override
    public void delete(Contact c) {
        contactRepository.delete(c);
    }
}
