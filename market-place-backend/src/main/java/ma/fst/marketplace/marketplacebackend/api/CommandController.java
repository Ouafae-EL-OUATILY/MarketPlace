package com.madani.market_place.api;

import com.madani.market_place.model.Command;
import com.madani.market_place.service.CommandService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/command")
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService;

    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Command> addCommand(@RequestBody Command command) {
        return new ResponseEntity<>(commandService.add(command), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Command> updateCommand(@RequestBody Command command) {
        return new ResponseEntity<>(commandService.update(command), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Command> getCommand(@PathVariable Long id) {
        return new ResponseEntity<>(commandService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<Command>> getAllCommands() {
        return new ResponseEntity<>(commandService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommand(@PathVariable Long id) {
        commandService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
