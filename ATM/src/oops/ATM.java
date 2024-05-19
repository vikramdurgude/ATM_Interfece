
package oops;

import java.util.*;

public class ATM {
    public static void main(String[] args) {
        ATMop obj = new ATMop();
    }
}

class Data {
    int balance;
}

class ATMop {
    HashMap<Integer, Data> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    ATMop() {
        System.out.println("Welcome to our ATM");
        op();
    }

    public void op() {
        System.out.println("Enter valid pin");

        int pin = sc.nextInt();

        if (map.containsKey(pin)) {
            Data obj = map.get(pin);
            menu(obj);
        } else {
            System.out.println("Please create an account first");
            sc.nextLine(); // Consume newline character left by previous nextInt()
            System.out.println("Enter Name:");
            String setName = sc.nextLine(); // Read the name

            System.out.println("Set pin code (pin should be greater than 2 and less than 5 digits)");

            int setPin = sc.nextInt();

            Data obj = new Data();
            if (String.valueOf(setPin).length() < 5 && String.valueOf(setPin).length() > 2) {
                obj.balance = 0;
                map.put(setPin, obj);
                System.out.println("Account created successfully for " + setName);
                menu(obj);
            } else {
                System.out.println("Invalid pin, system terminated.");
            }
        }
    }

    // Rest of the code remains the same...

    public void menu(Data obj) {
        System.out.println("******************************************************************************");
        System.out.println("Enter your choice");

        System.out.println("1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");
        System.out.println("5. Check another account");
        System.out.println("Enter option choose");
        int x = sc.nextInt();

        if (x == 1) {
            check_balance(obj);
        } else if (x == 2) {
            withdraw(obj);
        } else if (x == 3) {
            deposit(obj);
        } else if (x == 4) {
            System.out.println("Thank you for using our ATM");
        } else if (x == 5) {
            op();
        } else {
            System.out.println("Enter a valid option");
            menu(obj);
        }
    }

    public void check_balance(Data obj) {
        System.out.println("Your current balance: " + obj.balance);
        System.out.println("***********");
        menu(obj);
    }

    public void deposit(Data obj) {
        System.out.println("Enter the amount: ");
        float d = sc.nextFloat();
        obj.balance += d;
        System.out.println("Amount deposited successfully ");
        System.out.println("*******");
        menu(obj);
    }

    public void withdraw(Data obj) {
        System.out.println("Enter the amount: ");
        float d = sc.nextFloat();
        if (d > obj.balance) {
            System.out.println("Insufficient balance");
            menu(obj);
        }
        obj.balance -= d;
        System.out.println("Amount withdrawn successfully ");
        System.out.println("******");
        menu(obj);
    }
}

