package com.shantanu;

import java.util.Scanner;

class atm {
    public int k=0;
    int[] money=new int[300];
    public int acc_no = 0;
    String[] username = new String[300];
    String[] password = new String[300];
    Scanner sc = new Scanner(System.in);

    atm() {
        System.out.println("Welcome to ATM machine");
    }
    boolean check_userinfo() {
        boolean ab=false;
        System.out.println("Enter username:");
        String a = sc.next();
        System.out.println("Enter password:");
        String b = sc.next();
        for (int i=0;i<300;i++){
            if (a.equals(username[i]) && b.equals(password[i])) {
                ab=true;
                acc_no=i;
            }
        }
        return ab;
    }
    void deposit_amount(int n) {
        money[acc_no] += n;
        System.out.println("The amount " + n + " is successfully deposited to your account");
    }

    void withdraw_cash(int n) {
        if (n > money[acc_no]) {
            System.out.println("Insufficient balance!.your account balance is:" + balance());
        }
        else {
            money[acc_no]-= n;
            System.out.println("Transaction successful!");
        }
    }

   int balance() {
       return money[acc_no];
    }

    void open_account() {
        System.out.println("Enter username");
        username[k] = sc.nextLine();
        System.out.println("Enter password");
        password[k] = sc.nextLine();
        System.out.println("Your account has been created!");
        acc_no=k;
        k += 1;
    }

    void All_accounts(){
        for (int i=0;i<k;i++){
        System.out.println("* Account number:"+i+"; username:"+username[i]+"; password:"+password[i]+"; balance:"+money[i]);
    }


    }
}


public class ATM_machine {
    public static void main(String[] args) {
        atm A1 = new atm();
        Scanner sc1 = new Scanner(System.in);
        boolean is_correct_details;


        while (true) {

                System.out.println("If already have account enter '0'\nTo make account enter '1'");
                int a = sc1.nextInt();

                if (a == 0) {
                    while (true) {
                        try {
                            is_correct_details = A1.check_userinfo();
                            if (is_correct_details) {
                                System.out.println("Login successful");
                                break;
                            } else {
                                System.out.println("enter correct username and password");
                            }
                        } catch (Exception e) {
                            System.out.println("Enter valid information!");
                        }
                    }
                } else if (a == 1) {
                    A1.open_account();
                } else {
                    System.out.println("Enter correct digit");
     }



        while (true) {
                System.out.println("""
                        
                        Enter '1' to check bank balance
                        Enter '2' to withdraw cash
                        Enter '3' to deposit amount
                        Enter '4' to know all present accounts.
                        Enter '5' to end the session""");
                int num1 = sc1.nextInt();
                if (num1 == 1) {
                    System.out.println("Your bank balance is " + A1.balance() + " RS");
                } else if (num1 == 2) {
                    {
                        System.out.println("Enter amount to withdraw:");
                        int withdraw_amount = sc1.nextInt();
                        A1.withdraw_cash(withdraw_amount);
                    }
                } else if (num1 == 3) {
                    System.out.println("Enter the amount to be deposited:");
                    int deposit_amount = sc1.nextInt();
                    A1.deposit_amount(deposit_amount);
                } else if (num1 == 4) {
                    A1.All_accounts();
                } else if (num1 == 5) {
                    break;
                }
       }

     //aim:better manage money of respective accounts.




        }

    }

}