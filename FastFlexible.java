//Full Name: Matthew Lacsa
//ID Number: B00957271
public class FastFlexible extends FastPiece{
    /*
     * Constructor: makes a new piece object of type FastFlexible
     * @param name : name of piece
     * @param colour: colour of the piece
     * @param position: x and y coordinates of the piece
     */
    public FastFlexible(String name, String colour, int[] position) {
        super(name, colour, position);
    }
    /*
     * void move
     * @param direction : takes up or down as input
     * @param n : positions moved
     */
    public void move(String direction, int n) {
        if(direction.equals("up")) {
            super.position[1] -= n;
        }
        if(direction.equals("down")) {
            super.position[1] += n;
        }
    }
    //toString taken from super class with an extra F for flexible
    public String toString () {
        return super.toString() + "F";
    }
}
