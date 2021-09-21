/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.bullsandcows.servicelayer;

import com.sg.foundations.bullsandcows.data.BullsAndCowsDao;
import com.sg.foundations.bullsandcows.models.Game;
import com.sg.foundations.bullsandcows.models.Round;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author junha
 */
@Repository
public class BullsAndCowsServiceLayerImpl implements BullsAndCowsServiceLayer {
    
    private BullsAndCowsDao dao;
    
    public BullsAndCowsServiceLayerImpl(BullsAndCowsDao dao) {
        this.dao = dao;
    }
    
    
    
    @Override
    public int startGame() {
        return dao.startNewGame().getGameId();
    }

    @Override
    public Round guess(Round round) {
        dao.updateRound(round);
        String userGuess = round.getGuess();
        String answer = dao.getGameById(round.getGameId()).getAnswer();
        String matchStrings = matchStrings(answer, userGuess);
        
        if (matchStrings.equals("e:4:p:0")){
            dao.gameOver(round.getGameId());
        }
        
        round.setResult(matchStrings);
        return round;
    }

    @Override
    public Game getGameById(int gameId) {
        Game tempGame = dao.getGameById(gameId);
        if (tempGame.isGameOver() == false){
            tempGame.setAnswer("");
        };
        return tempGame;
    }

    @Override
    public List<Round> getRounds(int gameId) {
        return dao.ListAllRounds(gameId);
    }
    
    @Override
    public List<Game> getGames() {
       List<Game> tempList = new ArrayList<Game>(); 
       dao.ListAllGames().stream()
               .forEach(game -> { 
               if(game.isGameOver() == false) {game.setAnswer(""); tempList.add(game);}    });
       
       return tempList;
    }
    
    
    // Helper methid
    private String matchStrings(String answer, String guess) {
        int e = 0;
        int p = 0;
        for (int i = 0; i < 4; i++) {
            if (answer.charAt(i) == guess.charAt(i)  ) {
                e++;
            } else if (answer.indexOf(guess.charAt(i)) >= 0 ) {
                p++;
            }
        }
        String output = "e:" + String.valueOf(e) + ":p:" + String.valueOf(p);
        return output;
    }

    
}
