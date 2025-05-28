package com.cikalstudio.invisiblemaze;

public class Maze1 extends Maze { //extends ini inheritance
    @Override //Turunan dari Abstrak maze
    public void loadMaze() {
        System.out.println("==================================================\n" +
"                INVISIBLE MAZE LEVEL 1                 \n" +
"==================================================");
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
