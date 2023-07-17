package rest.webservices.webservices.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.webservices.webservices.entities.User;
import rest.webservices.webservices.repository.UserDao;

import java.util.List;

@RestController
public class UserResource {
    private UserDao userDao;

    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/users")
    public List<User> findAll() {
        return userDao.findAll();
    }


    @GetMapping(path = "/users/{id}")
    public User getOne(@PathVariable int id) {
        User user = userDao.getOne(id);

        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        return user;
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteOne(@PathVariable int id) {
        userDao.deleteOne(id);
    }

    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user) {
        userDao.save(user);
    }
}
