package com.metropolitan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.metropolitan.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
