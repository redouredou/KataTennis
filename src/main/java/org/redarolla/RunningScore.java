package org.redarolla;

public enum RunningScore {
    LOVE("0"),FIFTEEN("15"),THIRTY("30"),FORTY("40");

    String points;

    RunningScore(String points){
        this.points = points;
    }
}
