package com.madani.market_place.service;

import com.madani.market_place.exception.CategoryNotFoundException;
import com.madani.market_place.model.Category;
import com.madani.market_place.repository.CategoryRepo;
import com.madani.market_place.service.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements BaseService<Category> {
    private final CategoryRepo categoryRepo;
    @Override
    public Category add(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("category by id "+id+" not found"));
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
