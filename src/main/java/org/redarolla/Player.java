package org.redarolla;

import java.util.Objects;

import static org.redarolla.RunningScore.*;

public class Player {
    RunningScore playerScore;

    public Player(RunningScore playerScore){
        this.playerScore = playerScore;
    }

    public RunningScore getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(RunningScore playerScore) {
        this.playerScore = playerScore;
    }

    void scorePoints(RunningScore currentStore) throws RunningScoreException {
        switch (currentStore){
            case LOVE:
                setPlayerScore(FIFTEEN);
                break;
            case FIFTEEN:
                setPlayerScore(THIRTY);
                break;
            case THIRTY:
                setPlayerScore(FORTY);
                break;
            default:
                throw new RunningScoreException("invalid value for enum : " + currentStore );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerScore == player.playerScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerScore);
    }
}
