/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.learningjava;

/**
 *
 * @author never
 */
public class LearningJava {

    public static void main(String[] args) {
        
        int a = 5;
        char b = 'c';
        long c = 400;
        double d = 3.2;
        
        String name = "Xavier";
        System.out.println(name);
        
        
        System.out.println("Hello World!");
        takeASlice(name, 2);
    }
    
    public static void addExclimationPoint(String s){
        System.out.println(s + "!");
    }
    
    public static void takeASlice (String s, int i) {
        System.out.println(String.format("The %o letter in %s is %s", i+1, s, s.charAt(i)));
    }
}
