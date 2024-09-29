//Full Name: Matthew Lacsa
//ID Number: B00957271

import java.util.*;

public class GameDemo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String command = "";  //takes in first input and outside loop to check if "exit"
        ArrayList<Piece> pieces = new ArrayList<>(); //ArrayList of objects to take in multiple pieces
        //Loop keeps going until the user types exit as command
        while(!command.equals("exit")) {
            System.out.println("Enter a command (type help for details): ");
            //takes first command after it loops back to beginning
            command = in.nextLine();
            //input line to take create or move and input that comes after
            String[] create = command.split(" ", 5);
            //checks which command is being made, create or move
            String commandMade = create[0];
            //checks for a fast piece or flexible versions
            String type = "";
            /*
             * switch-case
             * takes first element and checks if its create or move
             * case "create" makes a new Piece object
             * case "move" moves the board pieces using static methods
             */
            switch(create[0]) {
                case "create":
                    int x = Integer.parseInt(create[1]);
                    int y = Integer.parseInt(create[2]);
                    if(create.length > 3) { //checks if it's a certain type if not, default to slowPiece
                        type = create[3];
                    }
                    System.out.println("Enter a Name for your new Piece: ");
                    String name = in.nextLine();
                    System.out.println("Enter a Colour for your new Piece: ");
                    String colour = in.nextLine();
                    /*
                     * each if statement below makes a new object
                     * depending on type
                     * and then gets added to the board with static method addPiece()
                     */
                    if (type.equals("fast")) {
                        if (create.length > 4 && create[4].equals("flexible")) { //checks if input is 5 words and if its flexible
                            pieces.add(new FastFlexible(name, colour, new int[]{x, y}));
                            Board.addPiece(pieces.get(pieces.size()-1));
                        } else { //if not 5 words input, default to FastPiece
                            pieces.add(new FastPiece(name, colour, new int[]{x, y}));
                            Board.addPiece(pieces.get(pieces.size()-1));
                        }
                    }else if (create.length > 3 && create[3].equals("flexible")) { //checks for 4 inputs and if its flexible
                            pieces.add(new SlowFlexible(name, colour, new int[]{x, y}));
                            Board.addPiece(pieces.get(pieces.size()-1));
                        } else { //if not, defaults to a slowPiece
                            pieces.add(new SlowPiece(name, colour, new int[]{x, y}));
                            Board.addPiece(pieces.get(pieces.size()-1));
                        }
                    break;
                //moves the piece depending on direction given
                case "move":
                    int xm = Integer.parseInt(create[1]);
                    int ym = Integer.parseInt(create[2]);
                    if(create.length == 3) { //checks if there is no direction given
                        System.out.println("Error: No direction");
                    }
                    else{
                        String direction = create[3];
                        Piece movedPiece = null; //placeholder to what would be moved
                        //searches for the piece the user is looking for
                        for (Piece piece : pieces) {
                            if (piece.getPosition()[0] == xm && piece.getPosition()[1] == ym) {
                                movedPiece = piece; //placeholder becomes the piece found in ArrayList
                            }
                        }
                        if(movedPiece != null) { //checks if the movedPiece found is not empty
                            if (create.length > 4) { //if there are 5 inputs it defaults to movePiece method with 5 inputs
                                int places = Integer.parseInt(create[4]);
                                Board.movePiece(movedPiece, xm, ym, direction, places); //move piece to position given
                            } else { //if there are 4 inputs it goes to the overloaded method with 4 inputs
                                Board.movePiece(movedPiece, xm, ym, direction); //move piece to position given
                            }
                        } else { //if its null, it prints no piece found
                            System.out.println("No piece found at: " + "(" + xm + "," + ym + ")");
                        }
                    }
                    break;
            }

            //calls static method displayboard() from class Board
            if(command.equals("print")) {
                Board.displayBoard();
            }
            //display possible commands
            if(command.equals("help")) {
                System.out.println("Possible commands are as follows:\n" +
                            "create location [fast][flexible]: Creates a new piece.\n" +
                            "move location direction [spaces]: Moves a piece.\n" +
                            "print: Displays the board.\n" +
                            "help: Displays help.\n" +
                            "exit: Exits the program.\n");
            }
            if(command.equals("exit")){
                System.out.println("Done.");
            }
        }
    }
}
