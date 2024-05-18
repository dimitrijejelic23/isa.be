package rs.ac.singidunum.bg.vezbe1.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.bg.vezbe1.entities.User;
import rs.ac.singidunum.bg.vezbe1.mappers.UserMapper;
import rs.ac.singidunum.bg.vezbe1.models.UserModel;
import rs.ac.singidunum.bg.vezbe1.models.UserPageModel;
import rs.ac.singidunum.bg.vezbe1.repositories.IUserRepository;

import java.util.List;


@RestController
@RequestMapping("/api/korisnik")
@RequiredArgsConstructor
public class UserController {
    private final IUserRepository userRepository;

    @CrossOrigin("*")
    @GetMapping("/findAll")
    public List<UserModel> findAll() {
        return UserMapper.toModelList(this.userRepository.findAll());
    }

    @CrossOrigin("*")
    @GetMapping("/findAllPaged")
    public UserPageModel findAllPaged(@RequestParam(name = "pageNumber") Integer pageNumber, @RequestParam(name = "pageSize") Integer pageSize) {
        return UserMapper.toModelPagedList(this.userRepository.findAll(PageRequest.of(pageNumber, pageSize)));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid UserModel user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            this.userRepository.save(UserMapper.toEntity(user));
            return new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
        }
    }
}
