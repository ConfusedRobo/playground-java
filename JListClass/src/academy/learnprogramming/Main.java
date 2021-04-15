package academy.learnprogramming;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JList Example");

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();

        defaultListModel.addElement("Item1");
        defaultListModel.addElement("Item2");
        defaultListModel.addElement("Item3");
        defaultListModel.addElement("Item4");

        JList<String> list = new JList<>(defaultListModel);

        list.setBounds(100,100, 75,75);
        frame.add(list);

    }
}
