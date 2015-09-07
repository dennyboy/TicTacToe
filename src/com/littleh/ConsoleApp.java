package com.littleh;

import com.littleh.common.MenuCommand;
import com.littleh.tictactoe.Game;
import com.littleh.tictactoe.MainMenu;

/**
 * Created by Dennis on 9/5/2015.
 */
public class ConsoleApp{

    Game game;
    MainMenu mainMenu;

    public static void main(String[] args){
        ConsoleApp consoleApp = new ConsoleApp();
    }

    public ConsoleApp(){

        setMainMenu();
        setGame(3);

        mainMenu.printGreeting();

        while(true) {
            mainMenu.printOptions();
            mainMenu.runMenu();
        }

    }


    public void setGame(int gridSize){
        game = new Game(gridSize);
    }

    public void startGame(){

            game.startGame();

    }


    public void setMainMenu(){
        mainMenu = new MainMenu();
        mainMenu.addOption("Start", new MenuCommand() {
            @Override
            public void runCommand() {

                startGame();
            }
        });
        mainMenu.addOption("Quit", new MenuCommand() {
            @Override
            public void runCommand() {

                System.exit(0);
            }
        });
    }











}


