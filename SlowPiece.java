//Full Name: Matthew Lacsa
//ID Number: B00957271
public class SlowPiece extends Piece {
    /*
     * Constructor: makes a new piece object of type Slow
     * @param name : name of piece
     * @param colour: colour of the piece
     * @param position: x and y coordinates of the piece
     */
    public SlowPiece(String name, String colour, int[] position) {
        super(name, colour, position);
    }
    /*
     * void move
     * @param direction : takes left or right as input
     */
    public void move(String direction) {
        if(direction.equals("left")) {
            super.position[0] -= 1;
        }
        if(direction.equals("right")) {
            super.position[0] += 1;
        }
    }
    //toString taken from super class with an S for slow
    public String toString () {
        return super.toString() + "S";
    }
}
