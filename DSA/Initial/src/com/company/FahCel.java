package com.company;

import java.util.Scanner;

public class FahCel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fah = sc.nextDouble();
        double cel = 5 * (fah - 32) / 9;
        System.out.println(cel);
    }
}
