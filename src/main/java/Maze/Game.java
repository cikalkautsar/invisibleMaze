package Maze;

import java.util.Scanner;

public class Game {
    private Player player;
    private Maze currentMaze;
    private int lives = 3;
    private final Scanner scanner = new Scanner(System.in);

    private void hideQuestionWithSpaces() {
        System.out.print("\n".repeat(500));
    }

    public void start() {
        System.out.println("""
                           =========================================================================
                           
                             ___ _   ___     _____ ____ ___ ____  _     _____ 
                            |_ _| \\ | \\ \\   / /_ _/ ___|_ _| __ )| |   | ____|
                             | ||  \\| |\\ \\ / / | |\\___ \\| ||  _ \\| |   |  _|  
                             | || |\\  | \\ V /  | | ___) | || |_) | |___| |___ 
                            |___|_| \\_|_ \\_/ _|___|____/___|____/|_____|_____|
                            |  \\/  |  / \\   |__  / ____|                      
                            | |\\/| | / _ \\    / /|  _|                        
                            | |  | |/ ___ \\  / /_| |___                       
                            |_|  |_/_/   \\_\\/____|_____|                      
                                                                               
                           Hello, Champions! Are you ready to take on the memorization challenge?
                           ==========================================================================  
                           Invisible Maze is a maze-based adventure game where players must navigate paths that are hidden from view.
                           At the beginning of the game, players are given a short amount of time to see the original map.
                           After that, the maze becomes invisible, and players must rely on memory to find the correct path with a limited number of moves.
                           This game challenges the player's memory, focus, and strategy as they progress through increasingly difficult levels.""");
        System.out.print("\nInput your name: ");
        String name = scanner.nextLine();

        System.out.println("(Press Y to play now, or N to read the instructions))");

    while (true) {
        System.out.print("Are you ready? (Y/N): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            break; // langsung main
        } else if (choice.equalsIgnoreCase("N")) {
            System.out.println("You chose not to start yet. Please review the rules below:");
            System.out.println("==================================================\n" +
                               "                    GAME INSTRUCTIONS                \n" +
                               "==================================================\n" +
                               "\n" +
                               "- You will have 30 seconds to memorize the maze map.\n" +
                               "- '#' represents walls, 'P' is the player's starting position, and 'E' is the exit.\n" +
                               "- After 30 seconds, the original map will be hidden.\n" +
                               "- Only your position (P), the exit (E), and dots '.' for unseen areas will be displayed.\n" +
                               "- Use the W (up), A (left), S (down), and D (right) keys to move.\n" +
                               "- If you hit a wall, you lose 1 life. You have 3 lives in total.\n" +
                               "- Find your way to the exit before you run out of lives!");
                          
            System.out.println("So wanna try now? (Y/N)");
        } else {
            System.out.println("Invalid input! please answer Y or N.");
        }
    }

        lives = 3;  
        playLevel(new Maze1());

        if (lives > 0) {
            System.out.print("Level 2 awaits -- press Y to continue or N to exit: ");
            String cont2 = scanner.nextLine();
            if (cont2.equalsIgnoreCase("Y")) {
                lives = 3; 
                playLevel(new Maze2());
            } else {
                System.out.println("You chose to stop at Level 1. Thank you for playing!");
                return;
            }
        }

        if (lives > 0) {
            System.out.print("Level 3 awaits -- press Y to continue or N to exit: ");
            String cont3 = scanner.nextLine();
            if (cont3.equalsIgnoreCase("Y")) {
                lives = 3; 
                playLevel(new Maze3());
            } else {
                System.out.println("You chose to stop at Level 2. Thank you for playing!");
                return;
            }
        }

        if (lives > 0) {
            System.out.println("🎉 CONGRATULATIONS! You have successfully completed all levels!");
        } else {
            System.out.println("😢 Game Over!");
        }
    }

    private void playLevel(Maze maze) {
        maze.loadMaze();
        currentMaze = maze;
        player = new Player(maze.getPlayerStartX(), maze.getPlayerStartY());

        currentMaze.displayFullMaze();
        try {
            for (int i = 10; i > 0; i--) {
                System.out.print("\rRemember This Maze... " + i + " Seconds left");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }

        hideQuestionWithSpaces();

        System.out.println("""
                           
                           Time's up! The Maze is hidden!
                           
                           !!You are strictly prohibited from scrolling up!!""");

        while (true) {
            System.out.println("\nLives: " + "*".repeat(lives));
            currentMaze.displayHiddenMaze(player);

            System.out.print(">> Input (WASD): ");
            char move = scanner.next().charAt(0);
            scanner.nextLine(); 

            int nextX = player.getX();
            int nextY = player.getY();

            switch (Character.toUpperCase(move)) {
                case 'W' -> nextX--;
                case 'S' -> nextX++;
                case 'A' -> nextY--;
                case 'D' -> nextY++;
                default -> {
                    System.out.println("Invalid input.");
                    continue;
                }
            }

            if (currentMaze.isWall(nextX, nextY)) {
                System.out.println("You hit a wall! Lose life.");
                lives--;
            } else {
                player.setPosition(nextX, nextY);
                if (currentMaze.isExit(nextX, nextY)) {
                    System.out.println("You found the way out!");
                    break;
                }
            }

            if (lives == 0) {
                System.out.println("You're out of lives!");
                break;
            }
        }
    }
}
