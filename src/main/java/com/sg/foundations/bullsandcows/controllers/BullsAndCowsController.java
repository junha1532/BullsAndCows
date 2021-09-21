/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.bullsandcows.controllers;

import com.sg.foundations.bullsandcows.models.Game;
import com.sg.foundations.bullsandcows.models.Round;
import com.sg.foundations.bullsandcows.servicelayer.BullsAndCowsServiceLayer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author junha
 */
@RestController
@RequestMapping("/api/bullsandcows")
public class BullsAndCowsController {
    
    private final BullsAndCowsServiceLayer serviceLayer;

    public BullsAndCowsController(BullsAndCowsServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }
    
    @PostMapping("/begin")
    public int startGame() {
        return serviceLayer.startGame();
    }

    @PostMapping("/guess")
    public Round guess(@RequestBody Round round) {
        return serviceLayer.guess(round);
    }
    
    @GetMapping("/game")
    public List<Game> all() {
        return serviceLayer.getGames();
    } 
    
    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable int id) {
        return serviceLayer.getGameById(id);
    } 

    @GetMapping("/rounds/{gameId}")
    public List<Round> allRounds(@PathVariable int gameId) {
        return serviceLayer.getRounds(gameId);
    }
    
}
