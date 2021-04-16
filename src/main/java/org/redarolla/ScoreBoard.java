package org.redarolla;

import static org.redarolla.RunningScore.*;

public class ScoreBoard {

    private final Player playerOne;
    private final Player playerTwo;

    public ScoreBoard(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public String score() {
        if(this.playerOne.hasAdvantage() && this.playerTwo.hasAdvantage()){
            this.playerOne.setPlayerScore(FORTY);
            this.playerTwo.setPlayerScore(FORTY);
        }
        if(this.playerOne.hasFortyPoints() && this.playerTwo.hasFortyPoints()){
            return DEUCE.value();
        }
        return this.playerOne.getPlayerScore().value()+" "+this.playerTwo.getPlayerScore().value();
    }

}
