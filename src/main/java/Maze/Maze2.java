package Maze;

public class Maze2 extends Maze {
    @Override
    public void loadMaze() {
        System.out.println("""
                           ==================================================
                                           INVISIBLE MAZE LEVEL 2                 
                           ==================================================""");
        maze = new char[][] {
            {'#', '#', '#', '#', '#'},
            {'#', 'P', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#'},
            {'#', '#', 'E', '#', '#'}
        };
        playerStartX = 1;
        playerStartY = 1;
        exitX = 4;
        exitY = 2;
    }
}