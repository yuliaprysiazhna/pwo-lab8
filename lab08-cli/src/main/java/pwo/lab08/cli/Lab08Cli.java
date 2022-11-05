/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pwo.lab08.cli;

import pwo.lab08.engine.Engine;

public class Lab08Cli {

    public static final String APP_NAME = "Lab08 CLI Application ";

    public static void main(String[] args) {
        System.out.println(APP_NAME + Engine.getVersion());
    }
}
