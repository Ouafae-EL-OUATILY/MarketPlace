package com.madani.market_place.repository;

import com.madani.market_place.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepo extends JpaRepository<Command, Long> {
}
