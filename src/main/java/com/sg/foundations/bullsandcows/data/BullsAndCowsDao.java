/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.bullsandcows.data;

import com.sg.foundations.bullsandcows.models.Game;
import com.sg.foundations.bullsandcows.models.Round;
import java.util.List;

/**
 *
 * @author junha
 */
public interface BullsAndCowsDao {
    List<Game> ListAllGames();
    Game getGameById(int gameId);
    Game startNewGame();
    Game gameOver(int gameId);
    List<Round> ListAllRounds(int gameId);
    Round updateRound(Round round);    
}
