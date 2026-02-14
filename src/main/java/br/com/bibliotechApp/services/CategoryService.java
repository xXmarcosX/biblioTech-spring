package br.com.bibliotechApp.services;

import br.com.bibliotechApp.exception.ResourceNotFoundException;
import br.com.bibliotechApp.models.Book;
import br.com.bibliotechApp.models.Category;
import br.com.bibliotechApp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository repository;

    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrada para este ID"));
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category update(Category category, Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrado para este ID"));

        entity.setName(category.getName());

        return repository.save(entity);
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para este ID"));

        repository.delete(entity);
    }
}
