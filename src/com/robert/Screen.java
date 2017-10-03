/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
class Screen {
    private final Scanner scanner = new Scanner(System.in);
    String getString() {
         return scanner.nextLine();
    }

    void print(String msg) {
        System.out.println(msg);
    }

    boolean isYes() {
        while (true) {
            String answer = scanner.nextLine().toUpperCase();
            switch (answer) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Answer Y or N");
                    break;
            }
        }
    }
    
}
