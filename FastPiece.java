//Full Name: Matthew Lacsa
//ID Number: B00957271
public class FastPiece extends Piece{
    /*
     * Constructor: makes a new piece object of type Fast
     * @param name : name of piece
     * @param colour: colour of the piece
     * @param position: x and y coordinates of the piece
     */
    public FastPiece(String name, String colour, int[] position) {
        super(name, colour, position);
    }
    /*
     * void move
     * @param direction : takes right or left as input
     * @param n : positions moved
     */
    public void move(String direction, int n) {
        if(direction.equals("right")) {
            super.position[0] += n;
        }
        if(direction.equals("left")) {
            super.position[0] -= n;
        }
    }
    //toString taken from super class with an F for fast
    public String toString () {
        return super.toString() + "F";
    }
}
