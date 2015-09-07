package com.littleh.tictactoe;

import com.littleh.common.Menu;
import com.littleh.common.MenuCommand;

/**
 * Created by Dennis on 9/6/2015.
 */
public class Game extends Menu implements GridInterface{

    Grid grid;
    Mark currentMark;


    /**
     * Constructor takes int for the size of the game grid
     * @param gridSize grid size
     */
    public Game(int gridSize){
        super();
        currentMark = Mark.X;
        grid = new Grid(gridSize);

        setGameOptions();

    }


    /**
     * Adds options to the implemented Menu
     */
    private void setGameOptions(){

        int size = grid.getSize();
        Integer x=1;
        Integer y=1;

        String out="";
        for(x=1;x<=size;x++){

            for(y=1;y<=size;y++){
                final Integer x1 = x;
                final Integer y1 = y;
                out = x1.toString() + y1.toString();

                super.addOption(out, new MenuCommand(){
                            @Override
                            public void runCommand(){
                                if(grid.getGridMark(x1-1,y1-1).isBlank()) {
                                    grid.setGridMark(currentMark, x1 - 1, y1 - 1);
                                    switchTurn();
                                }else{
                                    System.out.println("Square is taken!");
                                }
                            }
                        }
                );
            }

        }

    }
    /**
     * startGame starts a new game
     */
    public void startGame(){
        boolean isWon=false;
        boolean isFull=false;
        grid.startNewGrid();
        while(!isWon && !isFull){
            printGreeting();
            printOptions();
            super.runMenu();
            isWon=isGameWon();
            isFull=isGridFull();
        }

        switchTurn();
        printGrid();
        System.out.println("");
        if(isWon){
            System.out.println(currentMark.toString() + "s Win!");
        }else if(isFull){
            System.out.println("Draw!");
        }

    }


    /**
     * Used to internally alternate between X's and O's for the turn
     */
    private void switchTurn(){
        if(currentMark == Mark.X){
            currentMark = Mark.O;
        }else if(currentMark == Mark.O){
            currentMark = Mark.X;
        }
    }

    /**
     * isGameWon
     * @return returns true if won criteria is met
     */
    public boolean isGameWon(){
        boolean winStatus=false;
        boolean verticalWin;
        boolean horizontalWin;
        boolean diagonalWin;
        int x;
        int y;
        Mark mark;

        for(x=0;x<=grid.getSize()-1;x++){
            verticalWin=true;
            for(y=0;y<=grid.getSize()-1;y++){
                mark = grid.getGridMark(x, y);
                if(grid.getGridMark(x, 0) != mark || mark.isBlank()){
                    verticalWin = false;
                }
            }
            if(verticalWin){
                winStatus=true;
                break;}
        }

        if(!winStatus){

            for(y=0;y<=grid.getSize()-1;y++){
                horizontalWin = true;
                for(x=0; x<=grid.getSize()-1;x++){

                    mark = grid.getGridMark(x, y);
                    if(grid.getGridMark(0, y) != mark || mark.isBlank()){
                        horizontalWin = false;
                    }
                }
                if(horizontalWin){
                    winStatus=true;
                    break;
                }

            }


        }

        if(!winStatus){
            y=0;
            diagonalWin = true;
            for(x=0;x<=grid.getSize()-1;x++){
                mark=grid.getGridMark(x, y);
                if(grid.getGridMark(0, 0) != mark || mark.isBlank()){
                    diagonalWin = false;
                }
                y++;
            }
            if(!diagonalWin){
                y=grid.getSize()-1;
                diagonalWin = true;
                for(x=0;x<=grid.getSize()-1;x++){
                    mark=grid.getGridMark(x, y);
                    if(grid.getGridMark(0, grid.getSize() - 1) != mark || mark.isBlank()){
                        diagonalWin = false;
                    }
                    y--;
                }
            }


            winStatus = diagonalWin;



        }


        return winStatus;

    }

    /**
     *
     * @return True if grid is full, false if not
     */
    public boolean isGridFull(){
        boolean isFull = true;
        int size = grid.getSize();
        int x;
        int y;

        for(x=0;x<=size-1;x++){
            for(y=0;y<=size-1;y++){
                if(grid.getGridMark(x,y).isBlank()){
                    isFull = false;
                }
                if(!isFull){
                    break;}
            }
            if(!isFull){
                break;
            }
        }



        return isFull;
    }


    /**
     * Prints greeting for the implemented menu
     */
    @Override
    public void printGreeting() {
        System.out.println("Tic Tac Toe:");
    }

    /**
     * Prints options for the implemented menu
     */
    @Override
    public void printOptions() {
        printGridKey();
        System.out.println("");
        printGrid();
        System.out.println(currentMark.toString() + "'s Turn.  Input square of choice");

    }

    /**
     * Implements from GridInterface
     */
    @Override
    public void printGrid() {
        int size = grid.getSize();
        int x=0;
        int y=0;
        String out="";
        for(x=0;x<=size-1;x++){
            out="|";
            for(y=0;y<=size-1;y++){
                out+=grid.getGridMark(x, y).toString() + " |";
            }
            System.out.println(out);

        }
    }

    /**
     * Implements method from GridInterface
     */
    @Override
    public void printGridKey() {
        int size = grid.getSize();
        Integer x=1;
        Integer y=1;
        String out="";
        for(x=1;x<=size;x++){
            out="|";
            for(y=1;y<=size;y++){
                out+= x.toString() + y.toString() + "|";
            }
            System.out.println(out);

        }
    }




}
