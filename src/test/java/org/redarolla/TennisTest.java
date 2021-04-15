package org.redarolla;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.redarolla.RunningScore.*;


class TennisTest
{

    @ParameterizedTest(name = " method scoresPoint should return {1} when current point is {0} ")
    @MethodSource("provideCurrentScoreAndExpectedScore")
    void givenScoreInput_whenScoresPoint_thenReturnNewScore(RunningScore currentScore, RunningScore expectedNewScore) throws RunningScoreException {
        Player player = new Player(currentScore);

        player.scorePoints(currentScore);

        assertThat(player.getPlayerScore()).isEqualTo(expectedNewScore);
    }

    static Stream<Arguments> provideCurrentScoreAndExpectedScore(){
       return  Stream.of(Arguments.of(LOVE, FIFTEEN),
                Arguments.of(FIFTEEN, THIRTY),
                Arguments.of(THIRTY, FORTY));
    }

}
