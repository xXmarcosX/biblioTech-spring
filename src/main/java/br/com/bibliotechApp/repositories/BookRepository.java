package br.com.bibliotechApp.repositories;

import br.com.bibliotechApp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
