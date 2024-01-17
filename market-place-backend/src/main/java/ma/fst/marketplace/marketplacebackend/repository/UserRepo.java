package com.madani.market_place.repository;

import com.madani.market_place.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Client, Long> {
    Optional<Client>  findByMail(String mail);
}
