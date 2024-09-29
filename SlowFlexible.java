//Full Name: Matthew Lacsa
//ID Number: B00957271
public class SlowFlexible extends SlowPiece {
    /*
     * Constructor: makes a new piece object of type SlowFlexible
     * @param name : name of piece
     * @param colour: colour of the piece
     * @param position: x and y coordinates of the piece
     */
    public SlowFlexible(String name, String colour, int[] position) {
        super(name, colour, position);
    }
    /*
     * void move
     * @param direction : takes up or down as input
     */
    public void move(String direction) {
        if (direction.equals("up")) {
            super.position[1] -= 1;
        }
        if (direction.equals("down")) {
            super.position[1] += 1;
        }

    }
    //toString taken from super class with an extra F for flexible
    public String toString () {
        return super.toString() + "F";
    }
}
