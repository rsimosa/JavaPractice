package tennisapp;
import java.util.Scanner;

public class Tennis{

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private int playerOneGameScore = 0;
    private int playerTwoGameScore = 0;
    private int currentSet = 1;
    private int setsWonPlayerOne = 0;
    private int setsWonPlayerTwo = 0;

    public Tennis() {
    }

    public void play() {
        if (getSetsWonPlayerOne() < 2 || getSetsWonPlayerTwo() < 2) {
            do {
                System.out.print("ENTER 1 IF PLAYER 1 WON THE POINT, 2 IF PLAYER 2 WON THE POINT OR 0 TO EXIT ");
                Scanner scan = new Scanner(System.in);
                int point = scan.nextInt();

                switch (point) {
                    case 1:
                        setPlayerOneScore();
                        System.out.println(getScore());
                        break;
                    case 2:
                        setPlayerTwoScore();
                        System.out.println(getScore());
                        break;
                    default:
                        System.exit(0);
                }

            } while (getCurrentSetWhileLoop() <= 3);

        } else {
            System.exit(0);
        }
    }

    public String getGameScore() {
        return "Player1 Games Won: " + playerOneGameScore + "\n"
                + "Player2 Games Won: " + playerTwoGameScore;
    }

    public String getCurrentSet() {
        return "Current Set \n    " + currentSet;
    }

    public int getCurrentSetWhileLoop() {
        return currentSet;
    }

    public String getSetsWon() {
        return "Player 1 Sets Won: " + setsWonPlayerOne + "\n"
                + "Player 2 Sets Won: " + setsWonPlayerTwo;
    }

    public int getSetsWonPlayerOne() {
        return setsWonPlayerOne;
    }

    public int getSetsWonPlayerTwo() {
        return setsWonPlayerTwo;
    }

    public String getScore() {
        if ((currentSet > 2) && (setsWonPlayerOne == 2 || setsWonPlayerTwo == 2)) {
            if (setsWonPlayerOne > setsWonPlayerTwo) {
                return "PLAYER ONE WON THE MATCH\n     MATCH IS OVER!";
            } else {
                return "PLAYER TWO WON THE MATCH\n     MATCH IS OVER!";
            }

        } else {

// EVALUATING IF PLAYER TWO HAS THE AD OR WON THE GAME OR WON THE SET
//evaluating point level
            if (playerTwoScore >= 4 && playerTwoScore > playerOneScore) {
// evaluating game level
                if ((playerTwoScore - playerOneScore) > 1) {
                    playerOneScore = 0;
                    playerTwoScore = 0;
                    playerTwoGameScore++;
//evaluating set level
                    if ((playerTwoGameScore >= 6) && (playerTwoGameScore - playerOneGameScore) > 1) {
                        currentSet++;
                        setsWonPlayerTwo++;
                        playerOneGameScore = 0;
                        playerTwoGameScore = 0;
                        playerOneScore = 0;
                        playerTwoScore = 0;
                        return "------------------------------------------------------------------\n"
                                + "         CURRENT SCORE               GAMES               SETS"
                                + "\n------------------------------------------------------------------\n"
                                + "PLAYER 1 " + getCurrentScore(playerOneScore) + "                       " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                                + "PLAYER 2 " + getCurrentScore(playerTwoScore) + "                       " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                                + "\n------------------------------------------------------------------\n";
                    }
                    return "------------------------------------------------------------------\n"
                            + "         CURRENT SCORE               GAMES               SETS"
                            + "\n------------------------------------------------------------------\n"
                            + "PLAYER 1 " + getCurrentScore(playerOneScore) + "                       " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                            + "PLAYER 2 " + getCurrentScore(playerTwoScore) + "                       " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                            + "\n------------------------------------------------------------------\n";
                }
                return "------------------------------------------------------------------\n"
                        + "         CURRENT SCORE               GAMES               SETS"
                        + "\n------------------------------------------------------------------\n"
                        + "PLAYER 1      --                      " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                        + "PLAYER 2      AD                      " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                        + "\n------------------------------------------------------------------\n";
            }
// EVALUATING IF TO CHECK IF PLAYER ONE HAS THE AD OR WON THE GAME OR WON SET
//evaluating point level
            if (playerOneScore >= 4 && playerOneScore > playerTwoScore) {
//evaluating game level
                if ((playerOneScore - playerTwoScore) > 1) {
                    playerOneScore = 0;
                    playerTwoScore = 0;
                    playerOneGameScore++;
//evaluating set level
                    if ((playerOneGameScore >= 6) && (playerOneGameScore - playerTwoGameScore) > 1) {
                        currentSet++;
                        setsWonPlayerOne++;
                        playerOneGameScore = 0;
                        playerTwoGameScore = 0;
                        playerOneScore = 0;
                        playerTwoScore = 0;
                        return "GAME SET PLAYER ONE\n"
                                + "------------------------------------------------------------------\n"
                                + "         CURRENT SCORE               GAMES               SETS"
                                + "\n------------------------------------------------------------------\n"
                                + "PLAYER 1 " + getCurrentScore(playerOneScore) + "                       " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                                + "PLAYER 2 " + getCurrentScore(playerTwoScore) + "                       " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                                + "\n------------------------------------------------------------------\n";
                    }
                    return "------------------------------------------------------------------\n"
                            + "         CURRENT SCORE               GAMES               SETS"
                            + "\n------------------------------------------------------------------\n"
                            + "PLAYER 1 " + getCurrentScore(playerOneScore) + "                       " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                            + "PLAYER 2 " + getCurrentScore(playerTwoScore) + "                       " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                            + "\n------------------------------------------------------------------\n";
                }
                return "------------------------------------------------------------------\n"
                        + "         CURRENT SCORE               GAMES               SETS"
                        + "\n------------------------------------------------------------------\n"
                        + "PLAYER 1      AD                      " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                        + "PLAYER 2      --                      " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                        + "\n------------------------------------------------------------------\n";
            }
            if (playerOneScore >= 3 && playerTwoScore == playerOneScore) {
                return "------------------------------------------------------------------\n"
                        + "         CURRENT SCORE               GAMES               SETS"
                        + "\n------------------------------------------------------------------\n"
                        + "PLAYER 1      DEUCE                      " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                        + "PLAYER 2      DEUCE                      " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                        + "\n------------------------------------------------------------------\n";
            }
        }
        return "------------------------------------------------------------------\n"
                + "         CURRENT SCORE               GAMES               SETS"
                + "\n------------------------------------------------------------------\n"
                + "PLAYER 1 " + getCurrentScore(playerOneScore) + "                       " + playerOneGameScore + "                  " + setsWonPlayerOne + "\n"
                + "PLAYER 2 " + getCurrentScore(playerTwoScore) + "                       " + playerTwoGameScore + "                  " + setsWonPlayerTwo
                + "\n------------------------------------------------------------------\n";
    }

    public void setPlayerOneScore() {
        playerOneScore++;
    }

    public void setPlayerTwoScore() {
        playerTwoScore++;
    }

    public String getCurrentScore(int score) {
        switch (score) {

            case 3:
                return "FORTY";
            case 2:
                return "THIRTY";
            case 1:
                return "FIFTEEN";
            case 0:
                return "LOVE";
        }
        return " - ";
    }
    
}
