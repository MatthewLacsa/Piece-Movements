//Full Name: Matthew Lacsa
//ID Number: B00957271
/*
 * Super class
 * Abstract
 */
public abstract class Piece {
    //instance variables
    protected String name;
    protected String colour;
    protected int[] position = new int[2];
    /*
     * Constructor: makes a new piece object
     * abstract class: constructor has to be made by other subclasses
     * @param name : name of piece
     * @param colour: colour of the piece
     * @param position: x and y coordinates of the piece
     */
    public Piece(String name, String colour, int[] position) {
        this.name = name;
        this.colour = colour;
        this.position = position;
    }
    //getters
    public String getName() {
        return this.name;
    }
    public String getColour() {
        return this.colour;
    }
    public int[] getPosition() {
        return this.position;
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    //toString: returns the object name and colour
    public String toString() {
        return name + colour;
    }
}
