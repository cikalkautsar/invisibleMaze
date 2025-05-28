package Maze;

public abstract class Maze {
    protected char[][] maze;
    protected int playerStartX;
    protected int playerStartY;
    protected int exitX;
    protected int exitY;

    public abstract void loadMaze(); 

    public void displayFullMaze() {
        System.out.println("=== WELCOME TO THE MAZE ===");
        for (char[] row : maze) {
            for (char cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }

    public void displayHiddenMaze(Player player) {
        System.out.println("+------ FIND WAYS TO EXIT ------+");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i == player.getX() && j == player.getY()) {
                    System.out.print("P ");
                } else if (i == exitX && j == exitY) {
                    System.out.print("E ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public boolean isWall(int x, int y) {
        return maze[x][y] == '#';
    }

    public boolean isExit(int x, int y) {
        return x == exitX && y == exitY;
    }

    public int getPlayerStartX() { return playerStartX; }
    public int getPlayerStartY() { return playerStartY; }
}
