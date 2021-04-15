package org.redarolla;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TennisTest
{

    @ParameterizedTest(name = " method scoresPoint should return {1} when current point is {0} ")
    @MethodSource("provideCurrentScoreAndExpectedScore")
    void givenScoreLove_whenScoresPoint_thenReturnFifteen(String currentScore, String expectedNewScore)
    {
        String actualNewScore = scorePoints(currentScore);
        assertThat(actualNewScore).isEqualTo(expectedNewScore);
    }

    static Stream<Arguments> provideCurrentScoreAndExpectedScore(){
       return  Stream.of(Arguments.of("Love", "Fifteen"),
                Arguments.of("Fifteen", "Thirty"),
                Arguments.of("Thirty", "Forty"));
    }

    String scorePoints(String currentStore){
        if(currentStore.equals("Love")) return "Fifteen";
        if(currentStore.equals("Fifteen")) return "Thirty";
        if(currentStore.equals("Thirty")) return "Forty";
        return null;
    }
}
