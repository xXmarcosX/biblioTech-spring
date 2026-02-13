package br.com.bibliotechApp.services;

import br.com.bibliotechApp.exception.ResourceNotFoundException;
import br.com.bibliotechApp.models.User;
import br.com.bibliotechApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado para este ID"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(User user, Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado para este ID"));

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setCpf(user.getCpf());
        entity.setPhoneNumber(user.getPhoneNumber());
        entity.setBirthday(user.getBirthday());

        return repository.save(entity);
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado para este ID"));

        repository.delete(entity);
    }
}
