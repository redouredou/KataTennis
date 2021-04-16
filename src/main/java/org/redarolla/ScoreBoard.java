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
        if(this.playerOne.has(ADVANTAGE) && this.playerTwo.has(ADVANTAGE)){
            this.playerOne.setPlayerScore(FORTY);
            this.playerTwo.setPlayerScore(FORTY);
        }
        if(this.playerOne.has(FORTY) && this.playerTwo.has(FORTY)){
            return DEUCE.value();
        }
        if(this.playerOne.has(WON)){
            return playerOne.getName()+" is winner!";
        }
        if(this.playerTwo.has(WON)){
            return playerTwo.getName()+" is winner!";
        }
        return this.playerOne.getPlayerScoreValue()+" "+this.playerTwo.getPlayerScoreValue();
    }

}
