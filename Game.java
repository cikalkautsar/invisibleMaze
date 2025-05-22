package com.cikalstudio.invisiblemaze;
import java.util.Scanner;

public class Game {
    private Player player;
    private Maze currentMaze;
    private int lives = 3;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=========================================================================\n" +
"\n" +
"  ___ _   ___     _____ ____ ___ ____  _     _____ \n" +
" |_ _| \\ | \\ \\   / /_ _/ ___|_ _| __ )| |   | ____|\n" +
"  | ||  \\| |\\ \\ / / | |\\___ \\| ||  _ \\| |   |  _|  \n" +
"  | || |\\  | \\ V /  | | ___) | || |_) | |___| |___ \n" +
" |___|_| \\_|_ \\_/ _|___|____/___|____/|_____|_____|\n" +
" |  \\/  |  / \\   |__  / ____|                      \n" +
" | |\\/| | / _ \\    / /|  _|                        \n" +
" | |  | |/ ___ \\  / /_| |___                       \n" +
" |_|  |_/_/   \\_\\/____|_____|                      \n" +
"                                                   \n" +
"\n" +
"Hello, Champions! Are you ready to take on the memorization challenge?\n" +
"=========================================================================="
                + ""
                + "\nInvisible Maze is a maze-based adventure game where players must navigate paths that are hidden from view.\nAt the beginning of the game, players are given a short amount of time to see the original map.\nAfter that, the maze becomes invisible, and players must rely on memory to find the correct path with a limited number of moves.\n" +
"" +
"This game challenges the player's memory, focus, and strategy as they progress through increasingly difficult levels.");
        System.out.print("\nInput your name: ");
        String name = scanner.nextLine();

        while (true) {
            System.out.print("Are you ready? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                break; // lanjut ke game
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("Let's see the game instructions"
                        + "==================================================\n" +
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
                // akan tanya lagi di loop berikutnya
            } else {
                System.out.println("Invalid input! please answer Y or N.");
            }
        }

        lives = 3;  // Reset nyawa sebelum mulai level 1
        playLevel(new Maze1());

        if (lives > 0) {
            lives = 3; // Reset nyawa sebelum level 2
            playLevel(new Maze2());
        }

        if (lives > 0) {
            lives = 3; // Reset nyawa sebelum level 3
            playLevel(new Maze3());
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

        // Tampilkan maze asli 10 detik
        currentMaze.displayFullMaze();
        try {
            for (int i = 10; i > 0; i--) {
                System.out.print("\rRemember This Maze... " + i + " Seconds left");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Ignore
        }

        System.out.println("\nTime's up! The Maze is hidden!\n" +
"\n" +
"!!You are strictly prohibited from scrolling up!!");

        while (true) {
            System.out.println("\nLives: " + "*".repeat(lives));
            currentMaze.displayHiddenMaze(player);

            System.out.print(">> Input (WASD): ");
            char move = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline

            int nextX = player.getX();
            int nextY = player.getY();

            switch (Character.toUpperCase(move)) {
                case 'W': nextX--; break;
                case 'S': nextX++; break;
                case 'A': nextY--; break;
                case 'D': nextY++; break;
                default:
                    System.out.println("Invalid input.");
                    continue;
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
