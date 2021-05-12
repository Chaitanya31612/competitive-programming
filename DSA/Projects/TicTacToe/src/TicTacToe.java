import java.util.Scanner;

public class TicTacToe {

    private Player player1, player2;
    private Board board;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startGame();
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        // Player input
        player1 = takeInput(1);
        player2 = takeInput(2);
        while(player2.getSymbol() == player1.getSymbol()) {
            System.out.println("Symbol taken! Choose Another Symbol!");
            char symbol = sc.next().charAt(0);
            player2.setSymbol(symbol);
        }

        // create board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        // conduct
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE || status == Board.INVALID) {
            if(player1Turn) {
                System.out.println("Player 1 - " + player1.getName() + "'s turn ");
                System.out.println("Enter x and y coordinates");
                int x = sc.nextInt();
                int y = sc.nextInt();

                status = board.move(player1.getSymbol(), x, y);
                if(status == Board.INVALID) {
                    System.out.println("Invalid Move !! Try Again !!");
                    continue;
                }
                player1Turn = false;
                board.print();

            } else {
                System.out.println("Player 2 - " + player2.getName() + "'s turn ");
                System.out.println("Enter x and y coordinates");
                int x = sc.nextInt();
                int y = sc.nextInt();

                status = board.move(player2.getSymbol(), x, y);
                if(status == Board.INVALID) {
                    System.out.println("Invalid Move !! Try Again !!");
                    continue;
                }
                player1Turn = true;
                board.print();
            }
        }

        if(status == Board.PLAYER_1_WIN) {
            System.out.println("Player 1 " + player1.getName() + " wins!!");
        } else if(status == Board.PLAYER_2_WIN) {
            System.out.println("Player 1 " + player1.getName() + " wins!!");
        } else {
            System.out.println("Draw!!");
        }
    }

    private Player takeInput(int num) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player " + num + " name: ");
        String name = sc.nextLine();
        System.out.println("Enter player " + num + " Symbol: ");
        char symbol = sc.next().charAt(0);

        Player player = new Player(name, symbol);

        return player;
    }
}
