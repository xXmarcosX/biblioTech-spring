package br.com.bibliotechApp.services;

import br.com.bibliotechApp.data.dto.UserDTO;
import br.com.bibliotechApp.exception.ResourceNotFoundException;
import br.com.bibliotechApp.mapper.ObjectMapper;
import br.com.bibliotechApp.models.User;
import br.com.bibliotechApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public UserDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado para este ID"));

        return ObjectMapper.parseObject(entity, UserDTO.class);
    }

    public List<UserDTO> findAll() {
        return ObjectMapper.parseObjectList(repository.findAll(), UserDTO.class);
    }

    public UserDTO create(User user) {
        return ObjectMapper.parseObject(repository.save(user), UserDTO.class);
    }

    public UserDTO update(User user, Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado para este ID"));

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setCpf(user.getCpf());
        entity.setPhoneNumber(user.getPhoneNumber());
        entity.setBirthday(user.getBirthday());

        return ObjectMapper.parseObject(repository.save(entity), UserDTO.class);
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado para este ID"));

        repository.delete(entity);
    }
}
