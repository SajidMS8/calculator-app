import backend.CalculatorService;
import java.util.Scanner;

public class CalculatorUI {

    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Calculate");
            System.out.println("2. View History");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter expression: ");
                String exp = sc.nextLine();
                try {
                    double result = service.calculate(exp);
                    System.out.println("Result: " + result);
                } catch (Exception e) {
                    System.out.println("Invalid Expression");
                }
            } else if (choice == 2) {
                service.showHistory();
            } else {
                break;
            }
        }
        sc.close();
    }
}
