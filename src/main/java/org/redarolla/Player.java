package org.redarolla;

import java.util.Objects;

import static org.redarolla.RunningScore.*;

public class Player {
    private String name;
    private RunningScore playerScore;

    public Player(String name, RunningScore playerScore){
        this.name = name;
        this.playerScore = playerScore;
    }

    public RunningScore getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(RunningScore playerScore) {
        this.playerScore = playerScore;
    }

    void scorePoints() throws RunningScoreException {
        switch (this.playerScore){
            case LOVE:
                setPlayerScore(FIFTEEN);
                break;
            case FIFTEEN:
                setPlayerScore(THIRTY);
                break;
            case THIRTY:
                setPlayerScore(FORTY);
                break;
            case FORTY:
                setPlayerScore(ADVANTAGE);
                break;
            case ADVANTAGE:
                setPlayerScore(WON);
                break;
            default:
                throw new RunningScoreException("Forbidden value for enum : " + this.playerScore );
        }
    }

    boolean has(RunningScore lookUpScore){
        return this.getPlayerScore().equals(lookUpScore);
    }

    String getPlayerScoreValue(){
        return this.getPlayerScore().value();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerScore == player.playerScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerScore=" + playerScore +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerScore);
    }
}
