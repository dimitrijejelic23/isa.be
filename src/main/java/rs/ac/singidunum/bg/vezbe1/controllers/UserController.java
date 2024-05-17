package rs.ac.singidunum.bg.vezbe1.controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<?> save(@RequestBody @Valid UserModel user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            this.korisnici.add(user);
            return new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
        }
    }
}
