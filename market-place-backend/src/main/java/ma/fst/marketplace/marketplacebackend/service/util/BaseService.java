package com.madani.market_place.service.util;

import java.util.List;

public interface BaseService<T> {
    T add(T t);
    T update(T t);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
}
