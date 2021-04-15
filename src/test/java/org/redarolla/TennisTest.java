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
    void givenScoreLove_whenScoresPoint_thenReturnFifteen(RunningScore currentScore, RunningScore expectedNewScore) throws RunningScoreException {

        RunningScore actualNewScore;
        actualNewScore = scorePoints(currentScore);

        assertThat(actualNewScore).isEqualTo(expectedNewScore);
    }

    static Stream<Arguments> provideCurrentScoreAndExpectedScore(){
       return  Stream.of(Arguments.of(LOVE, FIFTEEN),
                Arguments.of(FIFTEEN, THIRTY),
                Arguments.of(THIRTY, FORTY));
    }

    RunningScore scorePoints(RunningScore currentStore) throws RunningScoreException {
        switch (currentStore){
            case LOVE:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FORTY;
            default:
                throw new RunningScoreException("invalid value for enum : " + currentStore );
        }
    }
}
