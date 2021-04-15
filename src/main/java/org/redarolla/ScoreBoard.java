package org.redarolla;

public class ScoreBoard {

    Player playerOne;
    Player playerTwo;

    public ScoreBoard(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String score() {
        if(this.playerOne.hasFortyPoints() && this.playerTwo.hasFortyPoints()){
            return "Deuce";
        }
        return this.playerOne.getPlayerScore().value()+" "+this.playerTwo.getPlayerScore().value();
    }

}
