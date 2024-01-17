package com.madani.market_place.api;

import com.madani.market_place.model.Fournisseur;
import com.madani.market_place.service.FournisseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisseur")
@RequiredArgsConstructor
public class FournisseurController {
    private final FournisseurService fournisseurService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Fournisseur>> getAllFournisseur() {
        return new ResponseEntity<>(fournisseurService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> getFournisseurById(@PathVariable("id") Long id) {
        Fournisseur fournisseur = fournisseurService.findById(id);
        return new ResponseEntity<>(fournisseur, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
        return new ResponseEntity<>(fournisseurService.add(fournisseur), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur) {
        return new ResponseEntity<>(fournisseurService.update(fournisseur), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFournisseurById(@PathVariable("id") Long id) {
        fournisseurService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
