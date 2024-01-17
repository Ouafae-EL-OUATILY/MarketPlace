package com.madani.market_place.repository;

import com.madani.market_place.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store, Long> {
}
