package br.com.bibliotechApp.controllers;

import br.com.bibliotechApp.models.Book;
import br.com.bibliotechApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/v1")
public class BookController {

    @Autowired
    public BookService service;

    @GetMapping(value = "/{id}",
    produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public Book findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Book> findAll() {
        return service.findAll();
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Book create(@RequestBody Book book) {
        return service.create(book);
    }

    @PutMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Book update(@RequestBody Book book, @PathVariable("id") Long id) {
        return service.update(book, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
