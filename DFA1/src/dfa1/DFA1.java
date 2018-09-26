/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa1;

import java.util.ArrayList;
import java.util.Scanner;

public class DFA1 {

    public static void main(String[] args) {

        String input="";
        Scanner reader = new Scanner(System.in);        

        System.out.println("Enter the check amount:");
        input = reader.next();
        DFAScanner dfa = new DFAScanner(input);
     
    }
    
}
