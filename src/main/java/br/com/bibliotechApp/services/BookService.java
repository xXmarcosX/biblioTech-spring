package br.com.bibliotechApp.services;

import br.com.bibliotechApp.exception.ResourceNotFoundException;
import br.com.bibliotechApp.models.Book;
import br.com.bibliotechApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    public BookRepository repository;

    public Book findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para este ID"));
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public Book update(Book book, Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para este ID"));

        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setSynopsis(book.getSynopsis());
        entity.setReleaseDate(book.getReleaseDate());
        entity.setCategory(book.getCategory());

        return repository.save(entity);
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para este ID"));

        repository.delete(entity);
    }
}
