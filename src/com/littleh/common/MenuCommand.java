package com.littleh.common;

/**
 * Functional interface for passing methods
 * and running them.  This works well with the
 * menu as you can tie a function to an option
 *
 * Look at comments in Console Menu for implementation
 *
 */
public interface MenuCommand {
    public void runCommand();
}
