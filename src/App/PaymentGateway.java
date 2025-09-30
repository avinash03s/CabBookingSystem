/*package App;

import java.util.Scanner;

public interface PaymentGateway {
   void processPayment(double amount);
   void getReceipt();
}
class CreditCardPayment implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $"+amount);
    }

    @Override
    public void getReceipt() {
        String amount = null;
        System.out.println("Receipt: Payment of $" + amount + " made via Credit Card.");
    }
}
class PayPalPayment implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $"+amount);
    }

    @Override
    public void getReceipt() {
        String amount=null;
        System.out.println("Receipt: Payment of $"+amount+"made via PayPal");
    }
}
class CryptoPayment implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of $"+amount);
    }

    @Override
    public void getReceipt() {
        String amount=null;
        System.out.println("Receipt: Payment of $"+amount+"made via CryptoPayment");
    }
}
class Checkout{
    void makePayment(PaymentGateway pg ,double amount){
        pg.processPayment(amount);
        pg.getReceipt();
    }
}
class Main1{
    public static void main(String[] args) {

        int chose = 0;

        Scanner sc=new Scanner(System.in);
        System.out.println("Choose Your Payment Method");
        System.out.println("--------------------------");
        System.out.println("1. CreditCardPayment");
        System.out.println("2. PayPalPayment");
        System.out.println("3. CryptoPayment");
        chose;
        chose=sc.nextInt();
        do {

            switch (chose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                default:
                    System.out.println("Please Choose Correct Payment Method");
            }
        }while (chose<4);
    }
}*/
