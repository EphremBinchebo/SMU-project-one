package com.company.MyLittleGame.controller;

import com.company.MyLittleGame.model.Tshirt;

import com.company.MyLittleGame.repository.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TshirtController {
    @Autowired
    private TshirtRepository tshirtRepository;
    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }
    @GetMapping("/tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tshirt getTshirtById(@PathVariable int id){
        Optional<Tshirt> returnVal = tshirtRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/tshirt/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color){
        List<Tshirt> returnVal = tshirtRepository.findTshirtByColor(color);
     return returnVal;
    }

    @GetMapping("/tshirt/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        List<Tshirt> returnVal = tshirtRepository.findTshirtBySize(size);
        return returnVal;
    }
    @GetMapping("/tshirt")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirt(){
        return tshirtRepository.findAll();
    }


    @PutMapping("/tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody Tshirt tshirt){
         tshirtRepository.save(tshirt);
    }
    @DeleteMapping("/tshirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id){
        tshirtRepository.deleteById(id);
    }

}