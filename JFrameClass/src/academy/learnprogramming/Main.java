package academy.learnprogramming;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JFrame Test");           /*Declaring and initializing a object from JFrame class*/
        frame.setSize(400,400);                    /*Size of Frame i.e. measured by WIDTH and HEIGHT and unit is pixels*/

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    /*Terminates process on clicking the close button*/

        frame.setVisible(true);                                  /*Makes the Frame visible*/

    }
}
