package com.madani.market_place.service;

import com.madani.market_place.exception.ClientNotFoundException;
import com.madani.market_place.model.Client;
import com.madani.market_place.repository.UserRepo;
import com.madani.market_place.service.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor //Client Service
public class UserService implements BaseService<Client> {
    private final UserRepo userRepo;

    @Override
    public Client add(Client client) {
        return userRepo.save(client);
    }

    @Override
    public Client update(Client client) {
        return userRepo.save(client);
    }

    @Override
    public List<Client> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Client findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client by id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public UserDetails getByMail(String mail) {
        return userRepo.findByMail(mail)
                .orElseThrow(() -> new EntityNotFoundException("user by mail " + mail + " not found"));
    }
}
