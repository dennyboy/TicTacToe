package com.littleh.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Denny
 * Class is intended to make menus quick to implement
 * for console applications.
 */
abstract public class Menu {
    abstract public void printGreeting();
    abstract public void printOptions();

    List<String> options;
    List<MenuCommand> menuCommands;

    public Menu(){
            options = new ArrayList<String>();
            menuCommands = new ArrayList<MenuCommand>();
        }

        /**
         * addOption adds commands to menu with a similar syntax to <br>
         * Swing events
         *
         *
         * @param definition - String for text to explain the option
         * @param menuCommand - Passed by functional interface
         *
         * *********************************************************<br>
         *  Example:<br>
         *
         *  addOption("Print Hello World", new MenuCommand(){<br>
         *          System.out.println("Hello World!");<br>
         *              });<br>
         ***********************************************************<br>
         */
    public void addOption(String definition, MenuCommand menuCommand){
        options.add(definition);
        menuCommands.add(menuCommand);

    }
        /**
         * addOption adds commands to menu with a similar syntax to<br>
         * Swing events<br>
         *
         * @param option - int indicating key for command
         * @param definition - String indicating text to explain the option
         * @param menuCommand - MenuCommand passed by functional interface
         *
         * *********************************************************<br>
         *  Example:<br>
         *<br>
         *  addOption(0, "Print Hello World", new MenuCommand(){<br>
         *          System.out.println("Hello World!");<br>
         *              });<br>
         ***********************************************************<br>
         */
    public void addOption(int option, String definition, MenuCommand menuCommand){
        options.add(option, definition);
        menuCommands.add(option, menuCommand);
    }

    /**

     * @param definition String representing command description
     * @return returns key based on String definition
     */
    public int getKey(String definition){
        return options.indexOf(definition);
    }

    /**
     * @param menuCommand MenuCommand object
     * @return returns key based on MenuCommand menuCommand
     */
    public int getKey(MenuCommand menuCommand){
        return menuCommands.indexOf(menuCommand);
    }

    /**
     * Removes MenuCommand based on String definition
     * @param definition String representing command description
     */
    public void removeOption(String definition){
        removeOption(options.indexOf(definition));
    }

    /**
     * Removes MenuCommand based on MenuCommand
     * @param menuCommand MenuCommand object
     */
    public void removeOption(MenuCommand menuCommand){
        int key = getKey(menuCommand);
        removeOption(key);
    }

    /**
     * Removes MenuCommand based on int
     * @param option int representing key for command
     */
    public void removeOption(int option){
        options.remove(option);
        menuCommands.remove(option);
    }

    /**
     * runCommand runs command based on option int
     * @param option int representing key for command
     * @return boolean based on success of command
     */
    public boolean runCommand(int option){
        boolean success = true;
        try {
            menuCommands.get(option).runCommand();
        }catch(Exception e){
            success=false;}
        return success;
    }

    /**
     * runCommand runs command based on String definition
     * @param definition String representing descrption of command
     * @return boolean based on success of command
     */
    public boolean runCommand(String definition){

        boolean success = true;
        try {
            menuCommands.get(options.indexOf(definition)).runCommand();
        }catch(Exception e){success=false;}
        return success;
    }

    /**
     * Runs the menu, waits for selection and returns boolean based on success
     * of the operation
     * @return True if success
     */
    public boolean runMenu(){
        boolean success = true;
        Scanner scanner;
        scanner = new Scanner(System.in);
        try{
            int choice1=-1;

            if(scanner.hasNextInt()){
                    choice1 = scanner.nextInt();
                    if(!runCommand(choice1)){
                        String choice2 = String.valueOf(choice1);
                        runCommand(choice2);
                    }

            }else{
                String choice3;
                choice3 = scanner.nextLine();
                runCommand(choice3);

            }

        }catch(Exception e){

            success = false;
        }


        return success;
    }


    /**
     * @param option int representing key of command
     * @return True if valid, false if not valid
     */
    public boolean isCommandValid(int option){
        boolean valid = true;
        try{
            String s = options.get(option);
        }catch(Exception e){valid = false;}
        return valid;
    }

    /**
     * @return List of options
     */
    public List<String> getOptions(){
        return options;
    }

}
