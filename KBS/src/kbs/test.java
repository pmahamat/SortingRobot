/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbs;

/**
 *
 * @author Bram
 */
public class test {
    public static void main(String[] args) {
        Samenstelling samenstelling = new Samenstelling(0);
        Scherm scherm = new Scherm(samenstelling);
        System.out.println(samenstelling);
    }
}
