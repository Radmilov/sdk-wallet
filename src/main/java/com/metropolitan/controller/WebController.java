package com.metropolitan.controller;

import com.metropolitan.model.Contact;
import com.metropolitan.model.Note;
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

    @RequestMapping(value={"/index", "/"}, method=RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("user", userService.findByEmail(auth.getName()));
        modelAndView.addObject("wallets", walletService.findAll());
        modelAndView.addObject("wallet", new Wallet());
        modelAndView.addObject("contacts", contactService.findAll());
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("notes", noteService.findAll());
        modelAndView.addObject("note", new Note());

        return modelAndView;
    }

    @RequestMapping(value="/addWallet", method=RequestMethod.POST)
    public ModelAndView saveWallet(@Valid Wallet wallet, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        if (bindingResult.hasErrors()) {
            model.addAttribute("wallet", wallet);
        } else {
            walletService.save(wallet);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByEmail(auth.getName());
            userService.sacuvajWallet(user.getId(), wallet.getId());
            model.addAttribute("wallet", new Wallet());
        }
        modelAndView.addObject("wallets", walletService.findAll());
        modelAndView.addObject("wallet", new Wallet());
        modelAndView.addObject("contacts", contactService.findAll());
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("notes", noteService.findAll());
        modelAndView.addObject("note", new Note());

        return modelAndView;
    }

    @RequestMapping(value="/addContact", method=RequestMethod.POST)
    public ModelAndView saveContact(@Valid Contact contact, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("contact", contact);
        } else {
            contactService.save(contact);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByEmail(auth.getName());
            userService.sacuvajKontakt(user.getId(), contact.getId());
            modelAndView.addObject("contact", new Contact());
        }
        modelAndView.addObject("wallets", walletService.findAll());
        modelAndView.addObject("wallet", new Wallet());
        modelAndView.addObject("contacts", contactService.findAll());
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("notes", noteService.findAll());
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @RequestMapping(value="/addNote", method=RequestMethod.POST)
    public ModelAndView saveNote(@Valid Note note, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("note", note);
        } else {
            noteService.save(note);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByEmail(auth.getName());
            userService.sacuvajNote(user.getId(), note.getId());
            modelAndView.addObject("note", new Note());
        }
        modelAndView.addObject("wallets", walletService.findAll());
        modelAndView.addObject("wallet", new Wallet());
        modelAndView.addObject("contacts", contactService.findAll());
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("notes", noteService.findAll());
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

}
