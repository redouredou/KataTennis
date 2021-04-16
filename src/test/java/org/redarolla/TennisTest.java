package org.redarolla;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.redarolla.RunningScore.*;


class TennisTest
{
    static Player playerTestLove;
    static Player playerTestFifteen;
    static Player playerTestThirty;
    static Player playerTestForty;


    @BeforeAll
    static void init(){
        playerTestLove = new Player("playerTest", LOVE);
        playerTestFifteen = new Player("playerTest", FIFTEEN);
        playerTestThirty = new Player("playerTest", THIRTY);
        playerTestForty = new Player("playerTest", FORTY);

    }

    @ParameterizedTest(name = " method scoresPoint should return {1} when current point is {0} ")
    @MethodSource("provideCurrentScoreAndExpectedScore")
    void givenScoreInput_whenScoresPoint_thenReturnNewScore(RunningScore currentScore, RunningScore expectedNewScore) throws RunningScoreException {
        Player player = new Player("playerTest", currentScore);

        player.scorePoints();

        assertThat(player.getPlayerScore()).isEqualTo(expectedNewScore);
    }


    @ParameterizedTest(name = " method scores() should return the scoreboard {2} with player one {0} and player two {1} ")
    @MethodSource("providePlayersPointsAndExpectedScoreBoard")
    void givenCurrentPlayerPoints_whenDisplayScores_thenReturnScoreBoard(Player playerOne, Player playerTwo, String expectedScoreBoard) {
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo(expectedScoreBoard);
    }

    @Test
    void given_ScorePlayerOne_love_and_ScorePlayerTwo_Thirty_whenDisplayScores_thenReturnScoreResult_Love_Thirty()  {
        Player playerOne = new Player("player1", LOVE);
        Player playerTwo = new Player("player2", THIRTY);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("0 30");
    }

    @Test
    void given_ScorePlayerOne_Fifteen_and_ScorePlayerTwo_forty_whenDisplayScores_thenReturnScoreResult_fifteen_forty()  {
        Player playerOne = new Player("player1",FIFTEEN);
        Player playerTwo = new Player("player2",FORTY);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("15 40");
    }

    @Test
    void given_ScorePlayerOne_Forty_and_ScorePlayerTwo_Forty_whenDisplayScores_thenReturnScoreResult_Deuce()  {
        Player playerOne = new Player("player1", FORTY);
        Player playerTwo = new Player("player2", FORTY);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("Deuce");
    }

    @Test
    void given_ScorePlayerOne_Forty_and_ScorePlayerTwo_Forty_whenScorePoints_thenReturnScoreAdvantageForPlayerScored() throws RunningScoreException {
        Player playerOne = new Player("player1", FORTY);
        Player playerTwo = new Player("player2", FORTY);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        playerOne.scorePoints();

        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("Advantage 40");
    }

    @Test
    void given_ScorePlayerOne_Advantage_and_ScorePlayerTwo_Forty_whenScorePoints_by_playerTwo_thenPlayerOneLoseAdvantageAndReturnForty() throws RunningScoreException {
        Player playerOne = new Player("player1", ADVANTAGE);
        Player playerTwo = new Player("player2", FORTY);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        playerTwo.scorePoints();

        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("Deuce");
    }

    @Test
    void given_ScorePlayerOne_Advantage_and_ScorePlayerTwo_Forty_whenScorePoints_by_playerOne_thenPlayerOneWin() throws RunningScoreException {
        Player playerOne = new Player("player1", ADVANTAGE);
        Player playerTwo = new Player("player2", FORTY);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        playerOne.scorePoints();

        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("player1 is winner!");
    }

    @Test
    void given_ScorePlayerTwo_Advantage_and_ScorePlayerOne_Forty_whenScorePoints_by_playerTwo_thenPlayerTwoWin() throws RunningScoreException {
        Player playerOne = new Player("player1", FORTY);
        Player playerTwo = new Player("player2", ADVANTAGE);
        ScoreBoard scoreBoard = new ScoreBoard(playerOne, playerTwo);
        playerTwo.scorePoints();

        String scoreResult = scoreBoard.score();

        assertThat(scoreResult).isEqualTo("player2 is winner!");
    }



    static Stream<Arguments> provideCurrentScoreAndExpectedScore(){
       return  Stream.of(Arguments.of(LOVE, FIFTEEN),
                Arguments.of(FIFTEEN, THIRTY),
                Arguments.of(THIRTY, FORTY));
    }

    static Stream<Arguments> providePlayersPointsAndExpectedScoreBoard(){
        return  Stream.of(Arguments.of(playerTestLove, playerTestLove,"0 0"),
                Arguments.of(playerTestLove, playerTestFifteen,"0 15"),
                Arguments.of(playerTestFifteen, playerTestFifteen,"15 15"),
                Arguments.of(playerTestFifteen, playerTestThirty,"15 30"),
                Arguments.of(playerTestThirty, playerTestThirty,"30 30"),
                Arguments.of(playerTestThirty, playerTestForty,"30 40"),
                Arguments.of(playerTestForty, playerTestThirty,"40 30"));

    }

}
