package com.madani.market_place.service;

import com.madani.market_place.exception.CommandNotFoundException;
import com.madani.market_place.model.Command;
import com.madani.market_place.repository.CommandRepo;
import com.madani.market_place.service.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandService implements BaseService<Command> {
    private final CommandRepo commandRepo;

    @Override
    public Command add(Command command) {
        command.setDateCommand(LocalDate.now());
        return commandRepo.save(command);
    }

    @Override
    public Command update(Command command) {
        return commandRepo.save(command);
    }

    @Override
    public List<Command> findAll() {
        return commandRepo.findAll();
    }

    @Override
    public Command findById(Long id) {
        return commandRepo.findById(id)
                .orElseThrow(() -> new CommandNotFoundException("command by id "+id+" not found"));
    }

    @Override
    public void delete(Long id) {
        commandRepo.deleteById(id);
    }
}
