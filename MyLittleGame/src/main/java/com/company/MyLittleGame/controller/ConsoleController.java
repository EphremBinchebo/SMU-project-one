package com.company.MyLittleGame.controller;

import com.company.MyLittleGame.model.Console;
import com.company.MyLittleGame.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsoleController {
    @Autowired
    private ConsoleRepository consoleRepository;
    @PostMapping("/console")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody Console console){
        return consoleRepository.save(console);
    }
    @GetMapping("/console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id){
        Optional<Console> returnVal = consoleRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/console/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer){
        List<Console> returnVal = consoleRepository.findConsoleByManufacturer(manufacturer);
       return returnVal;
    }
    @GetMapping("/console")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsole(){
        return consoleRepository.findAll();
    }

    @PutMapping("/console")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console){
        consoleRepository.save(console);
    }
    @DeleteMapping("/console/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id){
        consoleRepository.deleteById(id);
    }

}
