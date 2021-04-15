package academy.learnprogramming;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JTable Example");

        frame.setSize(300, 400);

        String [][]data = {

                {"101", "Jack", "670000"},
                {"102", "Jain", "780000"},
                {"101", "John", "700000"}

        };

        String []column = {"ID", "NAME", "SALARY"};

        JTable table = new JTable(data, column);

        table.setBounds(30, 40, 200, 300);
        frame.add(table);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
