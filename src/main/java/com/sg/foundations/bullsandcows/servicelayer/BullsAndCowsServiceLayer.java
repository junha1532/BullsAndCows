/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.bullsandcows.servicelayer;

import com.sg.foundations.bullsandcows.models.Game;
import com.sg.foundations.bullsandcows.models.Round;
import java.util.List;

/**
 *
 * @author junha
 */
public interface BullsAndCowsServiceLayer {
    int startGame();
    Round guess(Round round);
    Game getGameById(int gameId);
    List<Round> getRounds(int gameId);
    List<Game> getGames();
}
