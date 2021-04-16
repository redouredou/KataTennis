package org.redarolla;

import static org.redarolla.RunningScore.*;

public class ScoreBoard {

    private final Player playerOne;
    private final Player playerTwo;

    public ScoreBoard(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String score() {
        if(this.playerOne.hasFortyPoints() && this.playerTwo.hasFortyPoints()){
            return DEUCE.value();
        }
        return this.playerOne.getPlayerScore().value()+" "+this.playerTwo.getPlayerScore().value();
    }

}
