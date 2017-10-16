import java.util.Random;

abstract public class ConnectPlayer {
    public static final char PLAYER1_PIECE = '+';
    public static final char PLAYER2_PIECE = 'O';
    public static String currentPlayer = "Player 1";

    char playerPiece;
    int playerNumber;
    String playerType;
    public String getPlayerType() {
        if(playerType.equals("human"))
            return "human";
        else if(playerType.equals("comp"))
            return "comp";
        return "";

    }
    public char getPlayerPiece() {
        return  playerPiece;
    }
    public static int getPlayerNumber() {

        if(currentPlayer.equals("Player 1")) {
            return 1;
        }
        else
            return 2;
    }
    public static String getPlayerName() {

        if(currentPlayer.equals("Player 1")) {
            return "Player 1";
        }
        else
            return "Player 2";
    }

    public static void changeCurrentPlayer() {
        if(currentPlayer.equals("Player 1")) {
            currentPlayer = "Player 2";
        }
        else
            currentPlayer = "Player 1";
    }
    public int getRandomMove() {
        Random rand = new Random();
        int n = rand.nextInt(7);
        return n;
    }

}
