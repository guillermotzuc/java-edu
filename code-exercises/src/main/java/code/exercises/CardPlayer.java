package code.exercises;

import java.io.*;




class CardPlayer {

    CardPlayer() { System.out.print("c"); }

    public static void main(String[] args) {
        Long x = 42L;

        Long y = 44L;

        System.out.print(" " + 7 + 2 + " ");

        System.out.print(foo() + x + 5 + " ");

        System.out.println(x + y + foo());
    }
    static String foo() { return "foo"; }
}
