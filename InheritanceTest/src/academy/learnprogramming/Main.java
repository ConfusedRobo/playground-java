package academy.learnprogramming;

class Main extends Employee {

    int bonus = 10000;

    public static void main(String[] args) {

        Main p = new Main();

        System.out.println("Programmer salary is: " + p.salary);
        System.out.println("Bonus of Programmer is: " + p.bonus);

    }
}
