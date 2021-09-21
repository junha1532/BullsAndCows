/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.bullsandcows.models;

import java.util.Objects;

/**
 *
 * @author junha
 */
public class Game {
    private int gameId;
    private String answer;
    private boolean gameOver;

    public Game(int gameId, String answer) {
        this.gameId = gameId;
        this.answer = answer;
        this.gameOver = false;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.gameId;
        hash = 67 * hash + Objects.hashCode(this.answer);
        hash = 67 * hash + (this.gameOver ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.gameOver != other.gameOver) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", answer=" + answer + ", gameOver=" + gameOver + '}';
    }

    
}
