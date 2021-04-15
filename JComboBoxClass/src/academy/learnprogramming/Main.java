package academy.learnprogramming;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("ComboBox Example");

        frame.setSize(400,500);

        String []countryList = {"India","Australia","USA","England","Thailand"};

        JComboBox<String> comboBox = new JComboBox<>(countryList);

        comboBox.setSelectedIndex(4);
        comboBox.setBounds(50, 50,90,20);
        frame.add(comboBox);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
