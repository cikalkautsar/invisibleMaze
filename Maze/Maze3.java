/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cikalstudio.invisiblemaze;

public class Maze3 extends Maze {
    @Override
    public void loadMaze() {
        System.out.println("==================================================\n" +
"                INVISIBLE MAZE LEVEL 3                 \n" +
"==================================================");
        maze = new char[][] {
            {'#','#','#','#','#','#','#'},
            {'#','P',' ',' ',' ','#',' '},
            {'#',' ','#','#',' ','#','#'},
            {'#','#',' ',' ','#','#','#'},
            {'#',' ',' ','#',' ','#','#'},
            {'#','#','#',' ','#',' ','#'},
            {'#','#',' ','#','#','E','#'}
        };
        playerStartX = 1;
        playerStartY = 1;
        exitX = 6;
        exitY = 5;
    }
}
