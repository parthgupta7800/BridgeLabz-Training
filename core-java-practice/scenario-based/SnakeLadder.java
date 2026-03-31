public class SnakeLadder {
    static final int WINNING_POSITION = 100;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    public static void main(String[] args) {
        System.out.println("Snake and Ladder Game Started");
        // UC 1
        int player1Position = startPosition();
        int player2Position = startPosition();
        int diceCount = 0;
        boolean isPlayerOneTurn = true;
        // UC 7 
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            int dice = rollDice();          // UC 2
            diceCount++;
            if (isPlayerOneTurn) {
                System.out.println("Player 1 rolled: " + dice);
                player1Position = checkOption(player1Position, dice); // UC 3
                System.out.println("Player 1 position: " + player1Position);
            } else {
                System.out.println("Player 2 rolled: " + dice);
                player2Position = checkOption(player2Position, dice);
                System.out.println("Player 2 position: " + player2Position);
            }
            // Extra turn only if Ladder
            if (!isLadderTurn()) {
                isPlayerOneTurn = !isPlayerOneTurn;
            }
        }
        // UC 6
        declareWinner(player1Position, player2Position, diceCount);
    }
    // UC 1 
    static int startPosition() {
        return 0;
    }
    // UC 2 
    static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
    // UC 3
    static int checkOption(int position, int dice) {
        int option = (int) (Math.random() * 3);
        switch (option) {
            case NO_PLAY:
                System.out.println("Option: No Play");
                break;
            case LADDER:
                System.out.println("Option: Ladder");
                position += dice;
                break;
            case SNAKE:
                System.out.println("Option: Snake");
                position -= dice;
                break;
        }
        // UC 4
        position = checkBelowZero(position);
        // UC 5
        position = checkWinningPosition(position, dice);
        return position;
    }
    // UC 4
    static int checkBelowZero(int position) {
        if (position < 0) {
            return 0;
        }
        return position;
    }
    // UC 5
    static int checkWinningPosition(int position, int dice) {
        if (position > WINNING_POSITION) {
            return position - dice;
        }
        return position;
    }
    // UC 6
    static void declareWinner(int p1, int p2, int diceCount) {
        if (p1 == WINNING_POSITION) {
            System.out.println("Player 1 WON the game");
        } else {
            System.out.println("Player 2 WON the game");
        }
        System.out.println("Total Dice Rolls: " + diceCount);
    }
    // UC 7
    static boolean isLadderTurn() {
        int option = (int) (Math.random() * 3);
        return option == LADDER;
    }
}
