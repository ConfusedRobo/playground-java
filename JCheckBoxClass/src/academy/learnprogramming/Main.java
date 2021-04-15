package academy.learnprogramming;

import javax.swing.*;

public class Main {

        public static void main(String[] args) {

            JFrame frame = new JFrame("CheckBox Example");
            frame.setSize(400,400);

            JCheckBox checkBox1 = new JCheckBox("C++");

            checkBox1.setBounds(100,100, 50,50);
            frame.add(checkBox1);

            JCheckBox checkBox2 = new JCheckBox("Java", true);

            checkBox2.setBounds(100,150, 50,50);
            frame.add(checkBox2);

            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }

}
