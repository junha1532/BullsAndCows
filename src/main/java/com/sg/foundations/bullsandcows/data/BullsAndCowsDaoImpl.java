/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.bullsandcows.data;

import com.sg.foundations.bullsandcows.models.Game;
import com.sg.foundations.bullsandcows.models.Round;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Repository;

/**
 *
 * @author junha
 */
@Repository
public class BullsAndCowsDaoImpl implements BullsAndCowsDao {

    Map<Integer, Game> games = new HashMap<Integer, Game>();
    Map<Integer, ArrayList<Round>> rounds = new HashMap<Integer, ArrayList<Round>>();
    Random randomGen = new Random();

    @Override
    public List<Game> ListAllGames() {
        return new ArrayList<Game>(this.games.values());
    }

    @Override
    public Game getGameById(int gameId) {
        return this.games.get(gameId);
    }

    @Override
    public Game startNewGame() {
        String answer = "";

        while (answer.length() != 4) {
            String n = String.valueOf(randomGen.nextInt(10));
            if (!answer.contains(n)) {
                answer = answer + n;
            }
        }
        
        // Game Id = ListAllGames().size() + 1
        Game newGame = new Game(ListAllGames().size() + 1, answer);
        games.put(ListAllGames().size() + 1, newGame);
        
        // Index of round = Size of List of games 
        rounds.put(ListAllGames().size(), new ArrayList<Round>());
        
        return newGame;
    }

    @Override
    public Game gameOver(int gameId) {
        Game currGame = games.get(gameId);
        currGame.setGameOver(true);
        
        games.replace(gameId, currGame);
        
        return currGame;
    }
    
    @Override
    public List<Round> ListAllRounds(int gameId) {
        return rounds.get(gameId);
    }

    @Override
    public Round updateRound(Round round) {
        
        rounds.get(round.getGameId()).add(round);
        
        return round;
    }

}
