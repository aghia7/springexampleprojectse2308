package kz.aitu.springprojectexamplese2308.controllers;

import kz.aitu.springprojectexamplese2308.exceptions.UserNotFoundException;
import kz.aitu.springprojectexamplese2308.models.User;
import kz.aitu.springprojectexamplese2308.repositories.UserRepositoryInterface;
import kz.aitu.springprojectexamplese2308.services.interfaces.UserServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello SE-2308!";
    }

    @GetMapping("/")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getById(@PathVariable("user_id") int id) {
        try {
            User user = service.getById(id);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by_surname/{surname}")
    public List<User> getBySurname(@PathVariable String surname) {
        return service.getBySurname(surname);
    }

    @PostMapping("/")
    public User create(@RequestBody User user) {
        return service.create(user);
    }
}
