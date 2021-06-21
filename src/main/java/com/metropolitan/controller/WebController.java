package com.metropolitan.controller;

import com.metropolitan.model.User;
import com.metropolitan.model.Wallet;
import com.metropolitan.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject(user);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView noviUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.toString());
        User newUser = userService.findByEmail(user.getEmail());
        if (newUser != null) {
            bindingResult.rejectValue("email", "error.user", "Uneta e-mail adresa vec postoji u sistemu fakulteta.");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            userService.save(user);
            modelAndView.addObject("registerResult", "Registracija uspesna. Kliknite ovde da predjete na login formu.");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("wallets", walletService.findAll());
        modelAndView.addObject("wallet", new Wallet());
        return modelAndView;
    }

    @RequestMapping(value="/index", method=RequestMethod.POST)
    public String saveMember(@Valid Wallet wallet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("wallet", wallet);
        } else {
            walletService.save(wallet);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByEmail(auth.getName());
            userService.sacuvajWallet(user.getId(), wallet.getId());
            model.addAttribute("wallet", new Wallet());
        }
        model.addAttribute("wallets", walletService.findAll());

        return "index";
    }

}
