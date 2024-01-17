package com.madani.market_place.api;

import com.madani.market_place.model.Client;
import com.madani.market_place.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(userService.add(client), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        return new ResponseEntity<>(userService.update(client), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
