import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) readNumber("Enter the principal:", 100, 10000);
        float annualInterest = (float) readNumber("Enter the Annual Interest Rate:", 1, 10);
        int years = (int) readNumber("Enter the period:", 1, 100);
        double mortgage=calculatorMortgage(principal,annualInterest,years);
        String mortgageFormatted= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage "+mortgageFormatted);

        double balance=calculatorBalance(principal,annualInterest,years);
        String balanceFormatted= NumberFormat.getCurrencyInstance().format(balance);
        System.out.println("balance "+balanceFormatted);
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

    public  static double calculatorMortgage(int principal,float annualInter,int years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyInterest = annualInter / MONTHS_IN_YEAR / PERCENT;
        int NumberOfPayment=years*MONTHS_IN_YEAR;
        double mortgage=principal*monthlyInterest*Math.pow((1+monthlyInterest),NumberOfPayment)/
                        (Math.pow((1+monthlyInterest),NumberOfPayment)-1);
        return mortgage;
        }

    public  static double calculatorBalance(int principal,float annualInter,int years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyInterest = annualInter / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayment=years*MONTHS_IN_YEAR;
        double p=principal* monthlyInterest
                *Math.pow((1+monthlyInterest),numberOfPayment)
                /(Math.pow((1+monthlyInterest),numberOfPayment)-1);;
        double balance=principal*
                (Math.pow((1+monthlyInterest),numberOfPayment) - Math.pow((1+monthlyInterest),p))
                /(Math.pow((1+monthlyInterest),numberOfPayment)-1);
        return balance;
    }
}





