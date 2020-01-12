import java.util.InputMismatchException;
import java.util.Scanner;

//by Mihail Bachvarov <3
public class Tic_Tac_Toe {
    private static char[] create_board(int x, int y) {
        //creating the char array holding the X and O elements
        char[] board_arr = new char[x * y];
        for (int i = 0; i < board_arr.length; i++) {
            board_arr[i] = '_'; //Placing underscores[_] chars instead of empty array elements
        }
        return board_arr; //returning the array of board for later methods
    }

    private static void print_Board(char[] board_arr) {
        //drawing the board graphic with the array elements in it
        System.out.println();
        System.out.println(board_arr[0] + "|" + board_arr[1] + "|" + board_arr[2]);
        System.out.println(board_arr[3] + "|" + board_arr[4] + "|" + board_arr[5]);
        System.out.println(board_arr[6] + "|" + board_arr[7] + "|" + board_arr[8]);
        System.out.println();
    }

    private static void game_loop(char[] board_arr) {
        while (true) {
            //creating the user input objects
            Scanner usr1 = new Scanner(System.in);
            Scanner usr2 = new Scanner(System.in);
            System.out.print("Player 1-Choose a move:");
            //getting player 1 input
            try {
                int u1_input = usr1.nextInt();
                //checking the input
                while (true) {
                    if (board_arr[u1_input - 1] == ('_')) {
                        board_arr[u1_input - 1] = 'X';
                        break;
                    }
                    else {
                        System.out.println("Chose a different move");
                        //getting the input again only if there was already an element in the move the player chose
                        u1_input = usr1.nextInt();
                    }
                }
            }
            catch (InputMismatchException e){
                System.out.println("Next time please input a number - " + e );
                System.out.println();
                break;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Next time please input a number from 1 to 9 - " + e);
                System.out.println();
                break;
            }
            //creating the win conditions for player 1

            //horizontal
            if(board_arr[0]=='X' && board_arr[1]=='X'&&board_arr[2]=='X'||board_arr[3]=='X'&&board_arr[4]=='X'&&board_arr[5]=='X'|| board_arr[6]=='X'&&board_arr[7]=='X'&&board_arr[8]=='X'){
                print_Board(board_arr);
                System.out.println("Player 1 Wins!!!\n");
                break;
            }
            //vertical
            else if (board_arr[0]=='X'&&board_arr[3]=='X'&&board_arr[6]=='X'||board_arr[1]=='X'&&board_arr[4]=='X'&&board_arr[7]=='X'||board_arr[2]=='X'&&board_arr[5]=='X'&&board_arr[8]=='X'){
                print_Board(board_arr);
                System.out.println("Player 1 wins!!!\n");
                break;
            }
            //diagonal
            else if (board_arr[0]=='X'&&board_arr[4]=='X'&&board_arr[8]=='X'||board_arr[2]=='X'&&board_arr[4]=='X'&&board_arr[6]=='X'){
                print_Board(board_arr);
                System.out.println("Player 1 wins!!!\n");
                break;
            }
            print_Board(board_arr);
            if (board_arr[0]!='_'&&board_arr[1]!='_'&&board_arr[2]!='_'&&board_arr[3]!='_'&&board_arr[4]!='_'&&board_arr[5]!='_'&&board_arr[6]!='_'&&board_arr[7]!='_'&&board_arr[8]!='_'){
                System.out.println("It's a tie\n");
                break;
            }
            System.out.print("Player 2-Choose a move:");
            //getting input from player 2
            try {
                int u2_input = usr2.nextInt();
                while (true) {
                    if (board_arr[u2_input - 1] == ('_')) {
                        board_arr[u2_input - 1] = 'O';
                        break;
                    } else {
                        System.out.println("Chose a different move mate");
                        u2_input = usr2.nextInt();
                    }
                }
            }
            catch (InputMismatchException e){
                System.out.println("Next time please input a number - " + e );
                System.out.println();
                break;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Next time please input a number from 1 to 9 - " + e);
                System.out.println();
                break;
            }
            //creating the win condition for player 2

            //horizontal
            if(board_arr[0]=='O' && board_arr[1]=='O'&&board_arr[2]=='O'||board_arr[3]=='O'&&board_arr[4]=='O'&&board_arr[5]=='O'|| board_arr[6]=='O'&&board_arr[7]=='O'&&board_arr[8]=='O'){
                print_Board(board_arr);
                System.out.println("Player 2 Wins!!!\n");
                break;
            }
            //vertical
            else if (board_arr[0]=='O'&&board_arr[3]=='O'&&board_arr[6]=='O'||board_arr[1]=='O'&&board_arr[4]=='O'&&board_arr[7]=='O'||board_arr[2]=='O'&&board_arr[5]=='O'&&board_arr[8]=='O'){
                print_Board(board_arr);
                System.out.println("Player 2 wins!!!\n");
                break;
            }
            //diagonal
            else if (board_arr[0]=='O'&&board_arr[4]=='O'&&board_arr[8]=='O'||board_arr[2]=='O'&&board_arr[4]=='O'&&board_arr[6]=='O'){
                print_Board(board_arr);
                System.out.println("Player 2 wins!!!\n");
                break;
            }
            // creating the tie conditions
            print_Board(board_arr);
        }
    }

    public static void main(String[] args) {
        boolean is_running=true;
        Scanner obj_info_or_start = new Scanner(System.in);
        while(is_running){
            System.out.print("Type [info] for information about how to play or type [start] to start or [quit] to quit:");
            String input_info_or_start=obj_info_or_start.nextLine();
            switch (input_info_or_start){
                case "start":
                    System.out.println("Starting game...\n");
                    game_loop(create_board(3, 3));
                    break;
                case "info":
                    System.out.println("\nThe Game is player by 2 players which can chose to put an {X} or an {O} in the grid by inputting a number between 1 and 9.");
                    System.out.println("[1] being the upper left corner and [9] being the lower right and so on.");
                    System.out.println("The goal is to be the first to make a horizontal, vertical or diagonal line with your symbol(the {X} for the first player and {O} for second).\n");
                    break;
                case "quit":
                    System.out.println("Quiting game...\n");
                    is_running=false;
                    break;
                default:
                    System.out.println("Wrong input, Please try again\n");
                    break;
            }
        }
    }
}
