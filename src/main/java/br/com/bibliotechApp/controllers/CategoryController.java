package br.com.bibliotechApp.controllers;

import br.com.bibliotechApp.models.Category;
import br.com.bibliotechApp.models.Category;
import br.com.bibliotechApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/v1")
public class CategoryController {

    @Autowired
    public CategoryService service;

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Category create(@RequestBody Category Category) {
        return service.create(Category);
    }

    @PutMapping("/{id}")
    public Category update(@RequestBody Category Category, @PathVariable("id") Long id) {
        return service.update(Category, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
