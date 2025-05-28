package Maze;

public class Maze3 extends Maze {
    @Override
    public void loadMaze() {
        System.out.println("""
                           ==================================================
                                           INVISIBLE MAZE LEVEL 3                 
                           ==================================================""");
        maze = new char[][] {
            {'#','#','#','#','#','#','#'},
            {'#','P',' ',' ',' ','#',' '},
            {'#',' ','#','#',' ',' ','#'},
            {'#','#',' ',' ','#',' ','#'},
            {'#',' ',' ','#',' ',' ','#'},
            {'#','#','#',' ',' ','#','#'},
            {'#','#',' ','#',' ','E','#'}
        };
        playerStartX = 1;
        playerStartY = 1;
        exitX = 6;
        exitY = 5;
    }
}
