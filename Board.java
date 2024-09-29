//Full Name: Matthew Lacsa
//ID Number: B00957271
public class Board {
    //static gameBoard so there's only one instance shared throughout the program
    private static Piece[][] gameBoard = new Piece[8][8];
    //Empty Constructor
    public Board() {

    }
    /*
     *method addPiece: adds a piece to the board
     * @param p: adds a piece of type any Piece to the gameBoard
     */
    public static void addPiece(Piece p){
        //checks if the location the piece is supposed to be in is empty
        if (gameBoard[p.getPosition()[1]][p.getPosition()[0]] == null) {
            gameBoard[p.getPosition()[1]][p.getPosition()[0]] = p; //replaces the empty spot with p
        } else {
            System.out.println("Not a valid location"); //if not empty, it is not valid location
        }

    }
    /*
     * method movePiece: moves the piece across the board depending on move and distance
     * @param p: piece on the board to be moved
     * @param x: current x location of the piece
     * @param y: current y location of the piece
     * @param distance: how many moves to be made
     */
    public static void movePiece(Piece p, int x, int y, String move, int distance) {
        //checks if there is a piece inside the location to be moved
       if(gameBoard[y][x] != null) {
           //checks if FastFlexible and is inside bounds
            if (p instanceof FastFlexible  && ((move.equals("down") && (y+distance) <= 7)  || (move.equals("up")&& (y-distance) >= 0))) {
                ((FastFlexible) p).move(move, distance); //calls the move method of object
                gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
                gameBoard[y][x] = null; //old position back to empty
                System.out.println("Piece at " + "(" + x + "," + y +")" + " moved " + move + " by " + distance + " spaces"); //prints the move taken

                //checks if FastPiece and is inside bounds
            } else if(p instanceof FastPiece && ((move.equals("right") && (x+distance) <= 7)  || (move.equals("left")&& (x-distance) >= 0))){
                ((FastPiece) p).move(move, distance); //calls the move method of object
                gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
                gameBoard[y][x] = null; //old position back to empty
                System.out.println("Piece at " + "(" + x + "," + y +")" + " moved " + move + " by " + distance + " spaces"); //prints the move taken

                //checks if SlowFlexible and is inside bounds
            } else if(p instanceof SlowFlexible && ((move.equals("down")&&(y+1) <= 7)  || (move.equals("up")&& (y-1) >= 0))
                        && (distance ==1)) {
               ((SlowFlexible)p).move(move); //calls the move method of object
               gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
               gameBoard[y][x] = null; //old position back to empty
               System.out.println("Piece at " + "(" + x + "," + y +")" + " moved " + move + " by " + 1 + " space"); //prints the move taken

               //checks if SlowPiece and is inside bounds
           } else if(p instanceof SlowPiece && ((move.equals("right")&&(x+1) <= 7)  || (move.equals("left")&& (x-1) >= 0))
                    && (distance == 1)) {
               ((SlowPiece) p).move(move); //calls the move method of object
               gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
               gameBoard[y][x] = null; //old position back to empty
               System.out.println("Piece at " + "(" + x + "," + y + ")" + " moved " + move + " by " + 1 + " space"); //prints the move taken
           } else { //if not one of the conditions are met, then it is an invalid move
                System.out.println("Invalid");
            }
        }
    }
    /*
     * method movePiece: overloaded method and moves the piece
     * across the board depending on move and distance
     * @param p: piece on the board to be moved
     * @param x: current x location of the piece
     * @param y: current y location of the piece
     */
    public static void movePiece(Piece p, int x, int y, String move) {
        //checks if there is a piece in the location to be moved
        if(gameBoard[y][x] != null) {
            //checks if flexible movements are inside bounds
            boolean flex = (move.equals("down") && (y + 1) <= 7) || (move.equals("up") && (y - 1) >= 0);
            //checks if SlowFlexible and is inside bounds
            if(p instanceof SlowFlexible && flex) {
                ((SlowFlexible)p).move(move); //calls the move method of object
                gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
                gameBoard[y][x] = null; //old position back to empty
                System.out.println("Piece at " + "(" + x + "," + y +")" + " moved " + move + " by " + 1 + " space"); //prints the move taken

            } else {
                //checks if default movements are inside bounds
                boolean norm = (move.equals("right") && (x + 1) <= 7) || (move.equals("left") && (x - 1) >= 0);
                //checks if SlowPiece and is inside bounds
                if(p instanceof SlowPiece && norm) {
                    ((SlowPiece) p).move(move); //calls the move method of object
                    gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
                    gameBoard[y][x] = null; //old position back to empty
                    System.out.println("Piece at " + "(" + x + "," + y + ")" + " moved " + move + " by " + 1 + " space"); //prints the move taken

                    //checks if FastFlexible and is inside bounds
                } else if (p instanceof FastFlexible && flex) {
                    ((FastFlexible) p).move(move, 1); //calls the move method of object
                    gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
                    gameBoard[y][x] = null; //old position back to empty
                    System.out.println("Piece at " + "(" + x + "," + y +")" + " moved " + move + " by " + 1 + " space"); //prints the move taken

                    //checks if FastPiece and is inside bounds
                } else if(p instanceof FastPiece && norm){
                    ((FastPiece) p).move(move, 1); //calls the move method of object
                    gameBoard[p.getPosition()[1]][p.getPosition()[0]] = gameBoard[y][x]; //new position taken by moved piece
                    gameBoard[y][x] = null; //old position back to empty
                    System.out.println("Piece at " + "(" + x + "," + y +")" + " moved " + move + " by " + 1 + " space"); //prints the move taken
                }  else { //if not one of the conditions are met, then it is an invalid move
                    System.out.println("Invalid");
                }
            }
        }
    }
    //method displayBoard: displays the board pieces 1 by 1
    public static void displayBoard() {
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j <gameBoard[i].length; j++) {
                //if the spot is empty just print -
                if(gameBoard[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(gameBoard[i][j] + " "); //print piece
                }
            }
            System.out.println();
        }
    }
}
