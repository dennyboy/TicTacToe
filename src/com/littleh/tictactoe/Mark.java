package com.littleh.tictactoe;

/**
 * Marks are used to mark the grid Os and Xs
 */
public enum Mark {

        X ("X"), O ("O"), Blank ("-");
        String mark;
        String location;
        Mark(String mark){
            this.mark = mark;
        }

        public boolean isBlank(){
            if(this == Mark.Blank){
               return true;
            }else{
                return false;
            }
        }

        @Override
        public String toString(){
            return this.mark;
        }

}
