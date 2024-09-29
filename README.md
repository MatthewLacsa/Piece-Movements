This Java program simulates a simple board game with an 8x8 static game board. The game includes different types of pieces, each with distinct movement capabilities. The program is structured around the following classes:

GameDemo: is the main method and handles user input and runs the game.
Piece (Abstract): the base class for all pieces.
SlowPiece: can move 1 step left or right.
SlowFlexible: can move 1 step up or down.
FastPiece: can move left or right across any number of spaces within the board bounds.
FastFlexible: can move up or down across any number of spaces within the board bounds.
Board: represents the static 8x8 game board, has classes like createBoard where it creates the board based on the piece's position and moveBoard 
where it moves the board based on user's input as direction and position, lastly, displayBoard where it looks for the position's values and displays them as long as not null.
