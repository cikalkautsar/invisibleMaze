package com.cikalstudio.invisiblemaze;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private Player player;
    private Maze currentMaze;
    private int lives = 3;
    //scanner input
    private Scanner scanner = new Scanner(System.in);
    //Array untuk riwayat langkah player
    private ArrayList<String> moveHistory = new ArrayList<>();

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

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
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("Let's see the game instructions\n" +
                    "==================================================\n" +
                    "                    GAME INSTRUCTIONS                \n" +
                    "==================================================\n" +
                    "\n" +
                    "- You will have 10 seconds to memorize the maze map.\n" +
                    "- '#' represents walls, 'P' is the player's starting position, and 'E' is the exit.\n" +
                    "- After 10 seconds, the original map will be hidden.\n" +
                    "- Only your position (P), the exit (E), and dots '.' for unseen areas will be displayed.\n" +
                    "- Use the W (up), A (left), S (down), and D (right) keys to move.\n" +
                    "- If you hit a wall, you lose 1 life. You have 3 lives in total.\n" +
                    "- Find your way to the exit before you run out of lives!");
            } else {
                System.out.println("Invalid input! please answer Y or N.");
            }
        }

        lives = 3;
        playLevel(new Maze1());

        if (lives > 0 && confirmNextLevel(1)) {
            lives = 3;
            playLevel(new Maze2());
        } else if (lives > 0) {
            System.out.println("Thanks for playing!");
            return;
        }

        if (lives > 0 && confirmNextLevel(2)) {
            lives = 3;
            playLevel(new Maze3());
        } else if (lives > 0) {
            System.out.println("Thanks for playing!");
            return;
        }

        if (lives > 0) {
            System.out.println("CONGRATULATIONS! You have successfully completed all levels!");
        } else {
            System.out.println("Game Over! :( ");
        }
    }

    private void playLevel(Maze maze) {
        maze.loadMaze();
        currentMaze = maze;
        player = new Player(maze.getPlayerStartX(), maze.getPlayerStartY());
        moveHistory.clear();

        currentMaze.displayFullMaze();
        try {
            for (int i = 10; i > 0; i--) {
                System.out.print("\rRemember This Maze... " + i + " Seconds left");
                 // \r itu buat balikin cursor ke awal baris supaya tulisan countdown update di tempat yang sama
                Thread.sleep(1000); //delay nya 1000milidetik = 1 detik
            }
        } catch (InterruptedException e) {
            // try-catch diperlukan karena Thread.sleep() bisa menyebabkan error jika thread dihentikan secara paksa
            //tapi di sini error tersebut diabaikan.
        }

        System.out.println("\nTime's up! The Maze is hidden!");
        System.out.println("\n".repeat(400)); //ini spasi biar map asli ga keliahatan
        System.out.println("\"!!You are strictly prohibited from scrolling up!!\n");

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

            // Simpan langkah ke moveHistory
            moveHistory.add(String.valueOf(Character.toUpperCase(move))); //toUpperCase itu fungsi buat mengubah huruf kecil jadi huruf besar (ga sensitive case)
            
            //kalau ada objek yg manggil pake . contohnya currentmaze.isWall atau player.setPosition itu namanya Method invocation : tindakan memanggil method (fungsi) dari objek
            if (currentMaze.isWall(nextX, nextY)) {
                System.out.println("You hit a wall! Lose life.");
                lives--;
            } else {
                player.setPosition(nextX, nextY);
                if (currentMaze.isExit(nextX, nextY)) {
                    System.out.println("You found the way out!");
                    // Tampilkan history
                    System.out.println("Here are your steps for this level:");
                    System.out.println(String.join(" -> ", moveHistory));
                    break;
                }
            }

            if (lives == 0) {
                System.out.println("You're out of lives!");
                break;
            }
        }
    }

    private boolean confirmNextLevel(int level) {
        System.out.print("\nYou completed Level " + level + "! Do you want to continue to Level " + (level + 1) + "? (Y/N): ");
        String next = scanner.nextLine();
        return next.equalsIgnoreCase("Y");
    }
}
