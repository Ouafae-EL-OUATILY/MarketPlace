package com.madani.market_place.api;

import com.madani.market_place.model.Store;
import com.madani.market_place.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/add")
    public ResponseEntity<Store> addStore(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.add(store), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Store> updateStore(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.update(store), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        return new ResponseEntity<>(storeService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<Store>> getAllStores() {
        return new ResponseEntity<>(storeService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Long id) {
        storeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
