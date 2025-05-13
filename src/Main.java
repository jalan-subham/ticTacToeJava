import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Annual Interest Rate: ");
        double rate = scanner.nextDouble();
        System.out.print("Time Period (in years): ");
        int time = scanner.nextInt();
        double amount = principal * rate * time / 100;
        System.out.println("Your Interest amount is " + NumberFormat.getCurrencyInstance().format(amount));



    }
}
