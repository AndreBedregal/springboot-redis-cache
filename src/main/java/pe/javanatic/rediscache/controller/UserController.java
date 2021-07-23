package pe.javanatic.rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.javanatic.rediscache.model.User;
import pe.javanatic.rediscache.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        user.setId(UUID.randomUUID());
        User save = userService.save(user);
        return new ResponseEntity<>(save.getId().toString(), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> saveUser(@PathVariable UUID id, @RequestBody User user) {
        user.setId(id);
        User save = userService.save(user);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> saveUser(@PathVariable UUID id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        User user = userService.findById(id);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

}
