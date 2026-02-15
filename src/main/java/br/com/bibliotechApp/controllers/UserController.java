package br.com.bibliotechApp.controllers;

import br.com.bibliotechApp.data.dto.UserDTO;
import br.com.bibliotechApp.models.User;
import br.com.bibliotechApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/v1")
public class UserController {

    @Autowired
    public UserService service;

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public UserDTO create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody User user, @PathVariable("id") Long id) {
        return service.update(user, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
