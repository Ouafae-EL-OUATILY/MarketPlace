package com.madani.market_place.service;

import com.madani.market_place.exception.StoreNotFoundException;
import com.madani.market_place.model.Store;
import com.madani.market_place.repository.StoreRepo;
import com.madani.market_place.service.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService implements BaseService<Store> {
    private final StoreRepo storeRepo;

    @Override
    public Store add(Store store) {
        return storeRepo.save(store);
    }

    @Override
    public Store update(Store store) {
        return storeRepo.save(store);
    }

    @Override
    public List<Store> findAll() {
        return storeRepo.findAll();
    }

    @Override
    public Store findById(Long id) {
        return storeRepo.findById(id)
                .orElseThrow( () -> new StoreNotFoundException("exception by id "+id+" not found") );
    }

    @Override
    public void delete(Long id) {
        storeRepo.deleteById(id);
    }
}
