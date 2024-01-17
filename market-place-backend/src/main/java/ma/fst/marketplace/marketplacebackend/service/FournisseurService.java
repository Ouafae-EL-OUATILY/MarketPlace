package com.madani.market_place.service;

import com.madani.market_place.exception.FournisseurNotFoundException;
import com.madani.market_place.model.Fournisseur;
import com.madani.market_place.repository.FournisseurRepo;
import com.madani.market_place.service.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FournisseurService implements BaseService<Fournisseur> {
    private final FournisseurRepo fournisseurRepo;

    @Override
    public Fournisseur add(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurRepo.findAll();
    }

    @Override
    public Fournisseur findById(Long id) {
        return fournisseurRepo.findById(id)
                .orElseThrow(() -> new FournisseurNotFoundException("fournisseur by id: "+id+" not found"));
    }

    @Override
    public void delete(Long id) {
        fournisseurRepo.deleteById(id);
    }
}
