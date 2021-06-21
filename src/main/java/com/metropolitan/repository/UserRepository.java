package com.metropolitan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.metropolitan.model.User;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sacuvani_walleti (id, wallet_id) VALUES (?1, ?2)", nativeQuery = true)
    void sacuvajWallet(Long studentId, Long kontaktId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sacuvani_kontakti (id, contact_id) VALUES (?1, ?2)", nativeQuery = true)
    void sacuvajKontakta(Long studentId, Long contact_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sacuvani_notesi (id, note_id) VALUES (?1, ?2)", nativeQuery = true)
    void sacuvajNote(Long studentId, Long kontaktId);

    User findByEmail(String email);

}
