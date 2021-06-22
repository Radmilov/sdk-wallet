package com.metropolitan.controller;


import com.metropolitan.model.User;
import com.metropolitan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/user")
public class RestController {

    @Autowired
    private UserService userService;

    RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<com.metropolitan.model.User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        com.metropolitan.model.User entity = userService.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User entity) {
        userService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<com.metropolitan.model.User> edit(@PathVariable("id") java.lang.Long id, @RequestBody com.metropolitan.model.User entity) {
        if (Objects.equals(id, entity.getId())) {
            userService.save(entity);
            return ResponseEntity.ok(entity);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@PathVariable("id") java.lang.Long id) {
        com.metropolitan.model.User entity = userService.findById(id);
        if (entity != null) {
            userService.delete(userService.findById(id));
            return ResponseEntity.ok(entity);
        }
        return ResponseEntity.notFound().build();
    }
}
