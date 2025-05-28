package Maze;

public class Maze1 extends Maze {
    @Override
    public void loadMaze() {
        System.out.println("""
                           ==================================================
                                           INVISIBLE MAZE LEVEL 1                 
                           ==================================================""");
        maze = new char[][] {
            {'#','#','#','#'},
            {'#','P',' ','#'},
            {'#',' ','#','#'},
            {'#','E','#','#'}
        };
        playerStartX = 1;
        playerStartY = 1;
        exitX = 3;
        exitY = 1;
    }
}
