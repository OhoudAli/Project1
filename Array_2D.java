// A simple program to demonstrate
// Tic-Tac-Toe Game.
import java.util.*;

public class Array_2D {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] GameBoard = resetBoard();


        PrintGameBoard(GameBoard);
        System.out.println("WELCOME TO MY TIC TAC TOE GAME  !");
        int user_position = 0;
        int computer_position = 0;
        int rounds = 0;
        String User_choose_symbol = "";
        String computer_choose_symbol = "";
        int countUserWins = 0;
        int countComputerWins = 0;
        Random random_numbers = new Random();

        while (rounds != 1 && rounds != 3) {
            System.out.println("How many rounds do you prefer to play 1 or 3?");
            rounds = input.nextInt();
        }

        for (int round = 1; round <= rounds; round++) {
            System.out.println("****** Round " + round + " ******");

            GameBoard = resetBoard();
            PrintGameBoard(GameBoard);


            if (round == 2) {

                computer_choose_symbol = random_numbers.nextBoolean() ? "X" : "O";
                User_choose_symbol = computer_choose_symbol.equals("X") ? "O" : "X";
                System.out.println("Computer has chosen: " + computer_choose_symbol);
            } else {

                while (!User_choose_symbol.equals("X") && !User_choose_symbol.equals("O")) {
                    System.out.println("Do you want to play with X or O?");
                    User_choose_symbol = input.next().toUpperCase();
                }
                computer_choose_symbol = User_choose_symbol.equals("X") ? "O" : "X";
            }

            System.out.println("You are " + User_choose_symbol + ", Computer is: " + computer_choose_symbol);


            boolean isPlayerTurn = random_numbers.nextBoolean();
            if (isPlayerTurn) {
                System.out.println("You start first!");
            } else {
                System.out.println("Computer starts first!");
            }
//            isPlayerTurn = !isPlayerTurn;

            while (true) {
                if (isPlayerTurn) {
                   // System.out.println("You start first!");
                    do {
                        System.out.println("Enter your placement 1 - 9 :");
                        user_position = input.nextInt();
                    } while (!EmptyPosition(GameBoard, user_position));

                    Positions_On_Boards(GameBoard, user_position, "player", User_choose_symbol, computer_choose_symbol);
                    PrintGameBoard(GameBoard);

                    if (Who_Win(GameBoard, User_choose_symbol)) {
                        System.out.println("You Win, Congratulations! 🎉");
                        countUserWins++;
                        break;
                    }
                } else {
                   // System.out.println("Computer starts first!");
                    do {
                        computer_position = random_numbers.nextInt(9) + 1;
                    } while (!EmptyPosition(GameBoard, computer_position));

                    System.out.println("Computer's turn:");
                    Positions_On_Boards(GameBoard, computer_position, "cpu", User_choose_symbol, computer_choose_symbol);
                    PrintGameBoard(GameBoard);

                    if (Who_Win(GameBoard, computer_choose_symbol)) {
                        System.out.println("Computer wins! 🎉");
                        countComputerWins++;
                        break;
                    }
                }

                if (NoPostion(GameBoard)) {
                    System.out.println("Full Board, no winner");
                    break;
                }

                isPlayerTurn = !isPlayerTurn;
            } System.out.println("You win :" + countUserWins + " - " + countComputerWins + " Computer");


            if (rounds == 3) {
                if (countUserWins == 2) {
                    System.out.println("You won 2 rounds! You are our winner! 🏆");
                    return;
                } else if (countComputerWins == 2) {
                    System.out.println("Computer won 2 rounds! Computer is the winner 🏆");
                    return;
                }
            }
        }

        if (countUserWins > countComputerWins) {
            System.out.println("You are the winner ! 🏆");
        } else if (countComputerWins > countUserWins) {
            System.out.println("Computer is the winner! 🏆");
        } else {
            System.out.println("No winner...");
        }
    }


    public static boolean Who_Win(String[][] GameBoard, String symbol) {
        if ((GameBoard[0][0].equals("  " + symbol + "  ") && GameBoard[0][2].equals("  " + symbol + "  ") && GameBoard[0][4].equals("  " + symbol + "  "))
                || (GameBoard[2][0].equals("  " + symbol + "  ") && GameBoard[2][2].equals("  " + symbol + "  ") && GameBoard[2][4].equals("  " + symbol + "  "))
                || (GameBoard[4][0].equals("  " + symbol + "  ") && GameBoard[4][2].equals("  " + symbol + "  ") && GameBoard[4][4].equals("  " + symbol + "  "))) {
            return true;
        }
        if ((GameBoard[0][0].equals("  " + symbol + "  ") && GameBoard[2][0].equals("  " + symbol + "  ") && GameBoard[4][0].equals("  " + symbol + "  "))
                || (GameBoard[0][2].equals("  " + symbol + "  ") && GameBoard[2][2].equals("  " + symbol + "  ") && GameBoard[4][2].equals("  " + symbol + "  "))
                || (GameBoard[0][4].equals("  " + symbol + "  ") && GameBoard[2][4].equals("  " + symbol + "  ") && GameBoard[4][4].equals("  " + symbol + "  "))) {
            return true;
        }
        if ((GameBoard[0][0].equals("  " + symbol + "  ") && GameBoard[2][2].equals("  " + symbol + "  ") && GameBoard[4][4].equals("  " + symbol + "  "))
                || (GameBoard[0][4].equals("  " + symbol + "  ") && GameBoard[2][2].equals("  " + symbol + "  ") && GameBoard[4][0].equals("  " + symbol + "  "))
        ) {
            return true;

        }
        return false;
    }

    public static boolean EmptyPosition(String[][] GameBoard, int user_position) {
        switch (user_position) {
            case 1:
                return GameBoard[0][0].contains(" 1 ");

            case 2:
                return GameBoard[0][2].contains(" 2 ");

            case 3:
                return GameBoard[0][4].contains(" 3 ");

            case 4:
                return GameBoard[2][0].contains(" 4 ");

            case 5:
                return GameBoard[2][2].contains(" 5 ");

            case 6:
                return GameBoard[2][4].contains(" 6 ");

            case 7:
                return GameBoard[4][0].contains(" 7 ");

            case 8:
                return GameBoard[4][2].contains(" 8 ");

            case 9:
                return GameBoard[4][4].contains(" 9 ");

            default:
                return false;


        }
    }

    public static void Positions_On_Boards(String[][] GameBoard, int user_position, String user, String User_choose_symbol, String Computer_choose_symbol) {
        String symbol = " ";
        if (user.equals("player")) {
            symbol = User_choose_symbol;
        } else if (user.equals("cpu")) {
            symbol = Computer_choose_symbol;
        } else
            System.out.println("Invalid enter try X or O ");

        switch (user_position) {
            case 1:
                GameBoard[0][0] = "  " +symbol+ "  ";
                break;
            case 2:
                GameBoard[0][2] = "  " +symbol+ "  ";
                break;
            case 3:
                GameBoard[0][4] = "  " +symbol+ "  ";
                break;
            case 4:
                GameBoard[2][0] = "  " +symbol+ "  ";
                break;
            case 5:
                GameBoard[2][2] = "  " + symbol + "  ";
                break;
            case 6:
                GameBoard[2][4] = "  " + symbol + "  ";
                break;
            case 7:
                GameBoard[4][0] = "  " + symbol + "  ";
                break;
            case 8:
                GameBoard[4][2] = "  " + symbol + "  ";
                break;
            case 9:
                GameBoard[4][4] = "  " + symbol + "  ";
                break;
        }
//        PrintGameBoard(GameBoard);
    }

    public static boolean NoPostion(String[][] GameBoard) {
        for (int i = 1; i <= 9; i++) {
            if (EmptyPosition(GameBoard, i)) {
                return false;
            }
        }
        return true;
    }

    public static String[][] resetBoard() {
        return new String[][]{
                {"  1  ", "|", "  2  ", "|", " 3 "},
                {"****************"},
                {"  4  ", "|", "  5  ", "|", " 6 "},
                {"****************"},
                {"  7  ", "|", "  8  ", "|", " 9 "}
        };
    }

public static void PrintGameBoard (String[][]GameBoard) {
    for (String[] row : GameBoard) {
        for (String r : row) {
            System.out.print(r);
        }
        System.out.println();
    }
}
}
