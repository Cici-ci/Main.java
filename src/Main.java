import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static  byte MONTHS_IN_YEAR = 12;
    final static  byte PERCENT = 100;
    public static void main(String[] args) {
        int principal = (int) readNumber("Enter the principal: ", 100, 10000);
        float annualInterest = (float) readNumber("Enter the Annual Interest Rate: ", 1, 10);
        int years = (int) readNumber("Enter the period: ", 1, 100);
        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    public static void printPaymentSchedule(int principal, float annualInterest, int years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month<= years *MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterest, years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static void printMortgage(int principal, float annualInterest, int years) {
        double mortgage=calculatorMortgage(principal, annualInterest, years);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage "+NumberFormat.getCurrencyInstance().format(mortgage));
    }

    static double readNumber (String prompt,double min, double max){
            Scanner scanner = new Scanner(System.in);
            double value;
            while (true) {
                System.out.print(prompt);
                value = scanner.nextFloat();
                if (value >= min && value <= max)
                    break;
                System.out.println("Enter a value between " + min + " and " + max);
            }
            return value;
        }
    public  static double calculateBalance(
            int principal,
            float annualInter,
            int years,
            short numberOfPaymentsMade){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyInterest = annualInter / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayment=years*MONTHS_IN_YEAR;

        double balance=principal*
                (Math.pow(1+monthlyInterest,numberOfPayment)
                        - Math.pow(1+monthlyInterest,numberOfPaymentsMade))
                /(Math.pow((1+monthlyInterest),numberOfPayment)-1);
        return balance;
    }

    public  static double calculatorMortgage(int principal,float annualInter,int years){

        float monthlyInterest = annualInter / MONTHS_IN_YEAR / PERCENT;
        int NumberOfPayment=years*MONTHS_IN_YEAR;
        double mortgage=principal*monthlyInterest*Math.pow((1+monthlyInterest),NumberOfPayment)/
                        (Math.pow((1+monthlyInterest),NumberOfPayment)-1);
        return mortgage;
        }


}





