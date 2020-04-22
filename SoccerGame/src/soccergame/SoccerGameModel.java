package soccergame;

public class SoccerGameModel {

    public static String whoWon(String tf1N, String tf1S, String tf2N, String tf2S) {
        return (Integer.parseInt(tf1S) == Integer.parseInt(tf2S)) ? "TIED" : (Integer.parseInt(tf1S) > Integer.parseInt(tf2S)) ? "" + tf1N : "" + tf2N;
    }

    public static String gameScore(String tf1S, String tf2S) {
        return "Team 1 Score: " + (Integer.parseInt(tf1S)) + "  Team 2 Score: " + (Integer.parseInt(tf2S));
    }

    public static String goalsWonBy(String tf1S, String tf2S) {
        return (Integer.parseInt(tf1S) == Integer.parseInt(tf2S)) ? "The game was TIED" : (Integer.parseInt(tf1S) > Integer.parseInt(tf2S))
                ? "Team 1 won by " + (Integer.parseInt(tf1S) - (Integer.parseInt(tf2S))) + "goals!" : "Team 2 won by " + (Integer.parseInt(tf2S) - (Integer.parseInt(tf1S))) + "goals!";
    }

}
