package ru.scratty.bostongene2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.scratty.bostongene2.entity.User;
import ru.scratty.bostongene2.repository.UserRepository;

import java.util.Date;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public @ResponseBody User getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    @PostMapping("/user")
    public @ResponseBody User addUser(
            @RequestParam(name = "first_name") String firstName,
            @RequestParam(name = "last_name") String lastName,
            @RequestParam(name = "date_of_birth") Long dateOfBirth,
            @RequestParam String email,
            @RequestParam String password) {

        User user = new User(firstName, lastName, new Date(dateOfBirth), email, passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    @DeleteMapping("/user")
    public @ResponseBody boolean deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);

        return true;
    }
}
