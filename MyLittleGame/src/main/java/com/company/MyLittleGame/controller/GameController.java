package com.company.MyLittleGame.controller;
import com.company.MyLittleGame.model.Game;

import com.company.MyLittleGame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;
    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game){
        return gameRepository.save(game);
    }
    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable int id){
        Optional<Game> returnVal = gameRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/game/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio){
        List<Game> returnVal = gameRepository.findGamesByStudio(studio);
       return returnVal;
    }
    @GetMapping("/game/esrbRating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByesrbRating(@PathVariable String esrbRating){
     List<Game> returnVal = gameRepository.findGamesByEsrbRating(esrbRating);
     return returnVal;
    }

    @GetMapping("/game/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String title){
      List<Game> returnVal = gameRepository.findGamesByTitle(title);
      return returnVal;
    }
    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGame(){
        return gameRepository.findAll();
    }


    @PutMapping("/game")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game){
         gameRepository.save(game);
    }
    @DeleteMapping("/game/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id){
        gameRepository.deleteById(id);
    }

}
