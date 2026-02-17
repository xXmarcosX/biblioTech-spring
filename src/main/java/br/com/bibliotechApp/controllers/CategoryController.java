package br.com.bibliotechApp.controllers;

import br.com.bibliotechApp.models.Category;
import br.com.bibliotechApp.models.Category;
import br.com.bibliotechApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/v1")
public class CategoryController {

    @Autowired
    public CategoryService service;

    @GetMapping(
            value =  "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Category findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Category> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Category create(@RequestBody Category Category) {
        return service.create(Category);
    }

    @PutMapping(value = "/{id}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Category update(@RequestBody Category Category, @PathVariable("id") Long id) {
        return service.update(Category, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
