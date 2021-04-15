package com.timbuchalka;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var customer = new Customer("Tim", 54.96);
        var intList = new ArrayList<Integer>(3);

        customer.setBalance(12.18);
        out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (var index = 0; index < intList.size(); index++) out.println(index + ": " + intList.get(index));
        intList.add(1, 2);
        for (var index = 0; index < intList.size(); index++) out.println(index + ": " + intList.get(index));
    }
}
