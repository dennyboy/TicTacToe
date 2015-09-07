package com.littleh.tictactoe;

import java.util.Iterator;

/**
 * @author Denny
 *
 */
public class Grid {

Mark[][] marks;




int size;
    /**
     * Constructor sets size of the grid
      * @param size - how many rows and columns
     */
public Grid(int size){
    this.size = size;
    marks = new Mark[size][size];
    startNewGrid();
}


    /**
     * Sets all the marks on the grid to blank
      */
public void startNewGrid(){
    int x = 0;
    int y = 0;
    for(x=0; x<=size-1;x++){
        for(y=0; y<=size-1;y++){

            marks[x][y] = Mark.Blank;

        }

    }
}

    /**
     * Returns true or false based on whether the
     * mark is marked or not
     * @param x -int x coordinate
     * @param y - int y coordinate
     * @return true if marked
     */
public boolean isMarked(int x, int y){
    boolean marked=false;

    marked = !marks[x][y].isBlank();

    return marked;
}

    /**
     * Sets mark for spot on the grid
     * @param mark Mark
     * @param x X coordinate
     * @param y Y coordinate
     */
public void setGridMark(Mark mark, int x, int y){
    marks[x][y] = mark;
}

    /**
     * Gets grid mark based on x,y coordinate
     * @param x coordinate
     * @param y coordinate
     * @return Mark
     */
public Mark getGridMark(int x, int y){

    return marks[x][y];
}

    /**
     * @return int representing side of grid
     */
public int getSize(){
    return size;
}







}
