package com.metropolitan.controller;

import com.metropolitan.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebController {

    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private NetworkService networkService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private WalletService walletService;




}
