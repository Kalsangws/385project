/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ha
 */
public class GeneratorTester {
    //GeneratorTester gt = new GeneratorTester();
    public static void main (String args[]) {
        Generator gr = new Generator();
        System.out.println("The one-time pad is: " + gr.getSaltString());
    }
}
