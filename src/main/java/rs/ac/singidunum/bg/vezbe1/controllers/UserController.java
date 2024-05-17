package rs.ac.singidunum.bg.vezbe1.controllers;


import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.bg.vezbe1.models.UserModel;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/korisnik")
public class UserController {
    private ArrayList<UserModel> korisnici;

    public UserController() {
        this.korisnici = new ArrayList<>();
    }
    @GetMapping("/findAll")
    public ArrayList<UserModel> findAll() {
        return this.korisnici;
    }

    @PostMapping("/save")
    public UserModel save(@RequestBody UserModel user) {
        this.korisnici.add(user);
        return user;
    }
}
