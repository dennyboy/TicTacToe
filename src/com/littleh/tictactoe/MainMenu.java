package com.littleh.tictactoe;
import com.littleh.common.Menu;

import java.util.Iterator;

/**
 * Created by Dennis on 9/6/2015.
 */

    public class MainMenu extends Menu {


        /**
         * Implements abstract method from Menu
         */
        @Override
        public void printGreeting() {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("A LittleH Production");

            System.out.println("");
        }

        /**
         * Implements abstract method from Menu
         */
        @Override
        public void printOptions() {
            Iterator<String> iterator = getOptions().iterator();

            System.out.println("Options:");
            System.out.println("********************************");

            while(iterator.hasNext()){
                String option = iterator.next();
                System.out.println(getKey(option) + ": " + option);
            }
            System.out.println("********************************");

            System.out.println("Input Option Number...");

        }
    }

